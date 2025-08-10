package com.example.lost_and_found.service;

import com.example.lost_and_found.dao.dto.FoundUnfinishedDto;
import com.example.lost_and_found.dao.entity.FoundUnfinished;
import com.example.lost_and_found.dao.mapper.FoundUnfinishedMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  用于返回失物详情的业务类
 */
@Service
@Slf4j
public class ItemDetailService {
    private final FoundUnfinishedMapper FoundUnfinishedMapper;

    @Autowired
    public ItemDetailService(FoundUnfinishedMapper id){
        FoundUnfinishedMapper = id;
    }
    /**
     * 用于返回未完成的失物招领
     */
    public FoundUnfinishedDto foundUnfinishedDetail(Long id){
        FoundUnfinished foundUnfinished = FoundUnfinishedMapper.selectById(id);
        log.info("foundUnfinishedDetail()");

        return null;
    }
}
class Test {
    public static void main(String[] args) {
        return;
    }
}