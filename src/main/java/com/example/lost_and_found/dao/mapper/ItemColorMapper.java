package com.example.lost_and_found.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.lost_and_found.dao.entity.Color;
import com.example.lost_and_found.dao.entity.ItemColorConnect;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 访问颜色关联表的接口
 */
@Mapper
public interface ItemColorMapper extends BaseMapper<ItemColorConnect> {

    /**
     * 批量插入颜色关联表
     * @param relations
     */
    @Insert("<script>" +
            "INSERT INTO item_colors (item_id, color_id) VALUES " +
            "<foreach collection='list' item='item' separator=','>" +
            "(#{item.itemId}, #{item.colorId})" +
            "</foreach>" +
            "</script>")
    void batchInsert(@Param("list") List<ItemColorConnect> relations);

    /**
     * 根据item_id查找颜色关联表
     */
    @Select("SELECT c.* FROM colors c " +
            "INNER JOIN item_colors ic ON c.id = ic.color_id " +
            "WHERE ic.item_id = #{itemId}")
    List<Color> findColorsByItemId(@Param("itemId") Long itemId);

}
