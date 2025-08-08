package com.example.lost_and_found.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.lost_and_found.dao.entity.ItemColorConnect;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 访问颜色关联表的接口
 */
@Mapper
public interface ItemColorMapper extends BaseMapper<ItemColorConnect> {

    // 自定义批量插入方法
    @Insert("<script>" +
            "INSERT INTO item_colors (item_id, color_id) VALUES " +
            "<foreach collection='list' item='item' separator=','>" +
            "(#{item.itemId}, #{item.colorId})" +
            "</foreach>" +
            "</script>")
    void batchInsert(@Param("list") List<ItemColorConnect> relations);
}
