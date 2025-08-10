package com.example.lost_and_found.controller;

import com.example.lost_and_found.dao.dto.FoundUnfinishedDto;
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
 *  用于查看物品详情的Controller
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
     * 查看未认领的失物详情
     */
    @GetMapping("/viewItem/FoundUnfinished")
    public ResponseEntity<Response<FoundUnfinishedDto>> viewFoundUnfinished(
            @RequestParam(value = "id", required = true) Long id
    ) {
        log.info("viewItem()");
        FoundUnfinishedDto foundUnfinishedDto;
        //TODO 调用service层方法获取物品详情
        foundUnfinishedDto = itemDetailService.foundUnfinishedDetail(id);

        Response<FoundUnfinishedDto> response = new Response<>();
        response.data = new FoundUnfinishedDto();
        response.status = HttpStatus.OK;
        response.msg = "success";

        return ResponseEntity.ok(response);
    }

}
