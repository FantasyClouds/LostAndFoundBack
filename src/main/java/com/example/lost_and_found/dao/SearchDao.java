package com.example.lost_and_found.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.lost_and_found.dao.entity.FoundUnfinished;
import com.example.lost_and_found.dao.mapper.FoundUnfinishedMapper;
import com.example.lost_and_found.util.ItemColor;
import com.example.lost_and_found.util.ItemType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * 搜索Dao
 *
 * 实现了 Dao 层的查询逻辑，使用 MyBatis-Plus 的 QueryWrapper 构建动态查询条件
 * 处理了各种查询参数的判空和条件拼接
 * 实现了 "排除已展示 ID" 的功能，符合需求中 "确保新数据与旧数据不同" 的要求
 * 限制了返回结果数量为 6 条，符合每次返回 6 个失物数据的需求
 * 按发布时间倒序排列，优先展示最新数据
 */
@Repository
@Slf4j
public class SearchDao {
    private final FoundUnfinishedMapper foundUnfinishedMapper;

    /**
     * 依赖注入FoundUnfinishedMapper
     */
    @Autowired
    public SearchDao(FoundUnfinishedMapper foundUnfinishedMapper) {
        this.foundUnfinishedMapper = foundUnfinishedMapper;
    }

    /**
     * 用于搜索失物招领信息，和Service层的searchFoundUnfinished()方法对应
     * @param name 物品名称
     * @param type 物品类型
     * @param color 物品颜色
     * @param location 地点
     * @param showed_ids 已展示的ID列表
     * @return 符合条件的未完成失物招领列表
     */
    public List<FoundUnfinished> search(
            String name,
            ItemType type,
            ItemColor color,
            String location,
            List<Long> showed_ids
    ) {
        log.info("search()");
        QueryWrapper<FoundUnfinished> queryWrapper = new QueryWrapper<>();
        // TODO: 实现搜索逻辑，注意判空，全空时返回全部信息
        // TODO: 同时注意showed_ids的处理。showed_ids表示前端已经展示过的失物招领信息的id，需要排除掉。
        // TODO: 与数据库的查找功能请调用Mapper。


        // 条件查询：名称模糊匹配
        if (name != null && !name.trim().isEmpty()) {
            queryWrapper.like("found_unfinished_name", name.trim());
        }

        // 条件查询：类型精确匹配
        if (type != null) {
            queryWrapper.eq("found_unfinished_category", type);
        }

        // 条件查询：地点模糊匹配
        if (location != null && !location.trim().isEmpty()) {
            queryWrapper.like("found_unfinished_location", location.trim());
        }

        // 排除已展示的ID
        if (showed_ids != null && !showed_ids.isEmpty()) {
            queryWrapper.notIn("found_unfinished_id", showed_ids);
        }

        // 按发布时间倒序排列，确保最新的在前
        queryWrapper.orderByDesc("found_unfinished_publish_time");

        //最多返回6条数据
        queryWrapper.last("LIMIT 6");

        List<FoundUnfinished> result = foundUnfinishedMapper.selectList(queryWrapper);

         // 处理空结果集（没有查询到数据时）
        if (result == null || result.isEmpty()) {
            log.info("没有查询到符合条件的失物招领信息");
            return new ArrayList<>(); // 返回空集合而非null，便于上层统一处理
        }

        return result;
    }
}