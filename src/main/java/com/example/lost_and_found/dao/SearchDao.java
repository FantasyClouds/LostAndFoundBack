package com.example.lost_and_found.dao;

import com.example.lost_and_found.dao.entity.FoundUnfinished;
import com.example.lost_and_found.util.ItemColor;
import com.example.lost_and_found.util.ItemType;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 搜索Dao
 */
@Slf4j
public class SearchDao {
    /**
     * 用于搜索失物招领信息，和Controller层的searchFoundUnfinished()方法对应
     * @return List<FoundUnfinished>
     */
    public List<FoundUnfinished> search(
            String name,
            ItemType type,
            ItemColor color,
            String location,
            List<Long> showed_ids
    ) {
        log.info("search()");
        List<FoundUnfinished> result = new ArrayList<>();
        // TODO: 实现搜索逻辑，注意判空，全空时返回全部信息
        // TODO: 同时注意showed_ids的处理。showed_ids表示前端已经展示过的失物招领信息的id，需要排除掉。
        // TODO: 与数据库的查找功能请调用Mapper。


        return result;
    }
}
