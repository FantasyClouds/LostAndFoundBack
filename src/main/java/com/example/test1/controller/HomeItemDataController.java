package com.example.test1.controller;

import com.example.test1.dao.entity.FoundUnfinished;
import com.example.test1.util.ItemColor;
import com.example.test1.util.ItemType;
import com.example.test1.util.Response;
import com.example.test1.util.ResponseCrud;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeItemDataController {
    @GetMapping("/home/itemData/search/foundFinished")
    public ResponseEntity<Response<ResponseCrud<FoundUnfinished>>> searchFoundFinished(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) ItemType type,
            @RequestParam(required = false) ItemColor color,
            @RequestParam(required = false) String location,
            @RequestParam(required = false) List<Long> showed_ids
    ){
        Response<ResponseCrud<FoundUnfinished>> response = new Response<>();
        // TODO: 请实现搜索逻辑


        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
