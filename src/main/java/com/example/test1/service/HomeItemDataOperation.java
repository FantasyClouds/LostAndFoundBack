package com.example.test1.service;

import com.example.test1.dao.entity.FoundUnfinished;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomeItemDataOperation {
    public List<FoundUnfinished> searchFoundFinished(){
        List<FoundUnfinished> foundFinished = new ArrayList<>();
        // TODO: 调用Dao层，实现数据库查询逻辑


        return foundFinished;
    }

}
