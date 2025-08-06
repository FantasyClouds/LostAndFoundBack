package com.example.lost_and_found.util;
import com.example.lost_and_found.exception.IdGenerationException;
import org.springframework.data.redis.core.RedisTemplate;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

/**
 * 结构化数字ID生成器
 *
 * <p>ID结构（64位Long）：
 * <pre>
 * 0 00000000000000 0000000 000000000000
 * │      │        │       └─ 12位序列号（4096个/天/类型）
 * │      │        └─ 7位物品类型（128种分类）
 * │      └─ 14位天数（覆盖44年）
 * └─ 符号位固定为0
 * </pre>
 */
public class IdGenerator {
    // region 配置参数
    private final LocalDate epochDate;
    private final int dayOffset;
    private final RedisTemplate<String, Long> redisTemplate;
    // endregion

    // region 位域配置
    private static final int DAY_BITS = 14;
    private static final int TYPE_BITS = 7;
    private static final int SEQ_BITS = 12;
    private static final long MAX_DAYS = (1L << DAY_BITS) - 1;
    private static final int MAX_TYPE = (1 << TYPE_BITS) - 1;
    private static final long MAX_SEQ = (1L << SEQ_BITS) - 1;
    // endregion

    /**
     * 构造函数
     * @param epochDate      基准日期（从该日期开始计算天数）
     * @param dayOffset      天数偏移量（保证ID≥1e9）
     * @param redisTemplate  Redis操作模板
     */
    public IdGenerator(LocalDate epochDate,
                                 int dayOffset,
                                 RedisTemplate<String, Long> redisTemplate) {
        this.epochDate = epochDate;
        this.dayOffset = dayOffset;
        this.redisTemplate = redisTemplate;
    }

    /**
     * 生成下一个ID
     * @param itemType 物品类型（0-127）
     * @return 结构化数字ID
     * @throws IdGenerationException 当天序列号耗尽或日期溢出时抛出
     */
    public long nextId(ItemType itemType) throws IdGenerationException {
        validateType(itemType);

        long currentDays = calculateCurrentDays();
        long sequence = getDailySequence(currentDays, itemType);

        return composeId(currentDays, itemType, sequence);
    }

    // region 核心逻辑
    private long calculateCurrentDays() throws IdGenerationException {
        long realDays = ChronoUnit.DAYS.between(epochDate, LocalDate.now());
        long storedDays = dayOffset + realDays;

        if (storedDays > MAX_DAYS) {
            throw new IdGenerationException("日期超出可编码范围，当前天数：" + storedDays);
        }
        return storedDays;
    }

    private long getDailySequence(long days, ItemType type) throws IdGenerationException {
        String redisKey = buildRedisKey(days, type);

        Long seq = redisTemplate.opsForValue().increment(redisKey);
        if (seq == null) {
            handleRedisFailure(redisKey);
            seq = redisTemplate.opsForValue().increment(redisKey);
            if (seq == null) throw new IdGenerationException("Redis序列号获取失败");
        }

        if (seq > MAX_SEQ) {
            resetSequenceCounter(redisKey);
            throw new IdGenerationException("当天类型序列号耗尽，type=" + type);
        }
        return seq;
    }

    private long composeId(long days, ItemType type, long sequence) {
        return (days << (TYPE_BITS + SEQ_BITS))
                | ((type.getCode() & MAX_TYPE) << SEQ_BITS)
                | (sequence & MAX_SEQ);
    }
    // endregion

    // region 辅助方法
    private void validateType(ItemType type) {
        if (type.getCode() < 0 || type.getCode() > MAX_TYPE) {
            throw new IllegalArgumentException("物品类型超出范围，允许值：0-" + MAX_TYPE);
        }
    }

    private String buildRedisKey(long days, ItemType type) {
        return String.format("id:seq:%d:%d", days, type.getCode());
    }

    private void handleRedisFailure(String key) {
        // 双重检查锁处理缓存雪崩
        synchronized (this) {
            if (Boolean.TRUE.equals(redisTemplate.hasKey(key))) return;
            redisTemplate.opsForValue().setIfAbsent(key, 0L, 48, TimeUnit.HOURS);
        }
    }

    private void resetSequenceCounter(String key) {
        redisTemplate.delete(key);
        redisTemplate.opsForValue().setIfAbsent(key, 0L, 48, TimeUnit.HOURS);
    }
    // endregion

    // region 解析工具

    /**
     * 解析日期
     */
    public static LocalDate parseDate(long id, LocalDate epochDate, int dayOffset) {
        long storedDays = id >> (TYPE_BITS + SEQ_BITS);
        long realDays = storedDays - dayOffset;
        return epochDate.plusDays(realDays);
    }

    /**
     * 解析物品类型
     */
    public static int parseType(long id) {
        return (int) ((id >> SEQ_BITS) & MAX_TYPE);
    }

    /**
     * 解析序列号
     */
    public static long parseSequence(long id) {
        return id & MAX_SEQ;
    }

    /**
     * 获取ID的位域长度
     */
    public static int getTypeBits(){
        return TYPE_BITS;
    }

    /**
     * 获取ID的位域长度
     */
    public static int getSeqBits(){
        return SEQ_BITS;
    }
}
