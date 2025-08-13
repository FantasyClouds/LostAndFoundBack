package com.example.lost_and_found.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.lost_and_found.dao.entity.FoundUnfinished;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 访问未领取失物的 Mapper 接口
 */
@Mapper
public interface FoundUnfinishedMapper extends BaseMapper<FoundUnfinished> {

}
