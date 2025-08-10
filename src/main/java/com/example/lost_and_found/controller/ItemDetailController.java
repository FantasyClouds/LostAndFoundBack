package com.example.lost_and_found.controller;

import com.example.lost_and_found.dao.dto.ItemDto;
import com.example.lost_and_found.service.ItemDetailService;
import com.example.lost_and_found.util.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *  用于前端向后端查找物品详情的Controller
 */
@RestController
@Slf4j
public class ItemDetailController {
    private final ItemDetailService itemDetailService;

    @Autowired
    public ItemDetailController(ItemDetailService itemDetailService) {
        this.itemDetailService = itemDetailService;
    }
    /**
     * 返回未认领的失物详情
     */
    @GetMapping("/itemDetail/FoundUnfinished")
    public ResponseEntity<Response<ItemDto>> foundUnfinishedDetail(
            @RequestParam(value = "id") Long id
    ) {
        log.info("foundUnfinishedDetail()");
        ItemDto foundUnfinishedDto = itemDetailService.foundUnfinishedDetail(id);

        Response<ItemDto> response = new Response<>();
        response.data = foundUnfinishedDto;
        response.status = HttpStatus.OK;
        response.msg = "success";

        return ResponseEntity.ok(response);
    }
    /**
     * 返回已认领的失物详情
     */

    /**
     * 返回待审核的启示详情
     */

    /**
     * 返回未完成的启示详情
     */

    /**
     *  返回已完成的启示详情
     */
}
