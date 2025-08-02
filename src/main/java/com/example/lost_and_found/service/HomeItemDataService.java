package com.example.lost_and_found.service;

import com.example.lost_and_found.dao.entity.FoundUnfinished;
import com.example.lost_and_found.util.ItemColor;
import com.example.lost_and_found.util.ItemType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * 专门用于处理首页失物信息的业务逻辑
 * 包括不同种类的失物查找等。
 */
@Service
@Slf4j
public class HomeItemDataService {
    /**
     * 用于搜索失物招领信息，和Controller层的searchFoundUnfinished()方法对应
     * @return List<FoundUnfinished>
     */
    public List<FoundUnfinished> searchFoundUnfinished(
            String name,
            ItemType type,
            ItemColor color,
            String location,
            List<Long> showed_ids
    ){
        log.info("searchFoundFinished()");
        List<FoundUnfinished> foundFinished = new ArrayList<>();
        // TODO: 调用Dao层，实现数据库查询逻辑



        return foundFinished;
    }

}
