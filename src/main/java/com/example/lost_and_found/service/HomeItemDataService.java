package com.example.lost_and_found.service;

import com.example.lost_and_found.dao.SearchDao;
import com.example.lost_and_found.dao.dto.FoundUnfinishedSearchDto;
import com.example.lost_and_found.dao.dto.ItemDto;
import com.example.lost_and_found.dao.entity.FoundUnfinished;
import com.example.lost_and_found.util.LocationString;
import com.example.lost_and_found.util.Response;
import com.example.lost_and_found.util.ResponseCrud;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 专门用于处理首页失物信息的业务逻辑
 * 包括不同种类的失物查找等。
 *
 * 修改说明：
 * 新增了SearchDao的依赖注入，符合工程规范中的显式构造方法注入要求
 * 方法参数改为接收FoundUnfinishedSearchDto对象，更符合面向对象设计
 * 实现了与 Dao 层的交互，添加了数据转换逻辑（Entity→Dto）
 * 增加了响应对象的构建逻辑，使用Response和ResponseCrud封装返回结果
 * 完善了日志记录，确保方法第一句为日志输出
 */
@Service
@Slf4j
public class HomeItemDataService {
    private final SearchDao searchDao;

    /**
     * 依赖注入SearchDao
     */
    @Autowired
    public HomeItemDataService(SearchDao searchDao) {
        this.searchDao = searchDao;
    }


    /**
     * 用于搜索失物招领信息，和Controller层的searchFoundUnfinished()方法对应
     * 将查询结果转换为ItemDto并封装成响应对象
     */
    public Response<ResponseCrud<ItemDto>> searchFoundUnfinished(
            FoundUnfinishedSearchDto searchDto
    ) {
        log.info("searchFoundUnfinished()");

        // TODO: 调用Dao层，实现数据库查询逻辑
        // 调用Dao层查询数据，参数过长时换行处理
        List<FoundUnfinished> foundUnfinishedList = searchDao.search(
                searchDto.getName(),
                searchDto.getItemType(),
                searchDto.getColors() != null && !searchDto.getColors().isEmpty()
                        ? searchDto.getColors().get(0)
                        : null,
                searchDto.getLocation() != null
                        ? new LocationString(searchDto.getLocation(), searchDto.getLocation_detail()).getString()
                        : null,
                searchDto.getShowed_ids()
        );

        // 转换为ItemDto列表
        List<ItemDto> itemDtoList = convertToItemDtoList(foundUnfinishedList);

        // 构建响应对象
        ResponseCrud<ItemDto> responseCrud = new ResponseCrud<>();
        responseCrud.setRows(itemDtoList);
        responseCrud.setCount(itemDtoList.size());

        Response<ResponseCrud<ItemDto>> response = new Response<>();
        response.setData(responseCrud);
        response.setMsg("查询成功");

        return response;
    }

    /**
     * 将FoundUnfinished实体列表转换为ItemDto列表
     */
    private List<ItemDto> convertToItemDtoList(List<FoundUnfinished> foundUnfinishedList) {
        if (foundUnfinishedList == null) {
            return new ArrayList<>();
        }

        return foundUnfinishedList.stream().map(entity -> {
            ItemDto dto = new ItemDto();
            dto.setId(entity.getFound_unfinished_id());
            dto.setName(entity.getFound_unfinished_name());
            dto.setDescription(entity.getFound_unfinished_desc());
            dto.setItemType(entity.getFound_unfinished_category());
            dto.setLocation(new LocationString(entity.getFound_unfinished_location()));
            dto.setImg_url(entity.getFound_unfinished_img_url());
            dto.setFound_or_lost_time(entity.getFound_unfinished_found_time());
            dto.setPublish_time(entity.getFound_unfinished_publish_time());
            return dto;
        }).collect(Collectors.toList());
    }
}
