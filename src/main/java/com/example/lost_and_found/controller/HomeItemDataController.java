package com.example.lost_and_found.controller;

import com.example.lost_and_found.dao.entity.FoundUnfinished;
import com.example.lost_and_found.util.ItemColor;
import com.example.lost_and_found.util.ItemType;
import com.example.lost_and_found.util.Response;
import com.example.lost_and_found.util.ResponseCrud;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用于处理首页失物信息的控制器。
 * 和前端交互失物数据。
 */
@Slf4j
@RestController
public class HomeItemDataController {
    /**
     * 根据传入的RequesParam，搜索失物招领信息。
     * 参数默认为无时，返回所有失物信息。
     * 若传入参数，则按参数搜索。
     * 每次返回6个数据，确保新数据与旧数据不同。
     * 需求的最后一个参数showed_ids用于向前端请求有哪些旧数据。
     */
    @GetMapping("/home/itemData/search/foundFinished")
    public ResponseEntity<Response<ResponseCrud<FoundUnfinished>>> searchFoundFinished(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) ItemType type,
            @RequestParam(required = false) List<ItemColor> color,
            @RequestParam(required = false) String location,
            @RequestParam(required = false) List<Long> showed_ids
    ){
        log.info("searchFoundFinished()");
        Response<ResponseCrud<FoundUnfinished>> response = new Response<>();
        // TODO: 请实现搜索逻辑


        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
