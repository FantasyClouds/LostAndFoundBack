package com.example.lost_and_found.controller;

import com.example.lost_and_found.dao.dto.FoundUnfinishedSearchDto;
import com.example.lost_and_found.dao.dto.ItemDto;
import com.example.lost_and_found.service.HomeItemDataService;
import com.example.lost_and_found.util.Response;
import com.example.lost_and_found.util.ResponseCrud;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;  // 替换原@GetMapping，因前端传JSON用POST更规范
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 首页物品数据控制器
 * 负责接收前端搜索请求，调用Service层完成业务逻辑，返回标准化响应
 *
 * 修改说明
 * 1. 请求方式调整改为 @PostMapping，更适合传输复杂 JSON 数据
 * 2. 依赖注入规范化， 通过构造器注入 HomeItemDataService，而非字段注入
 * 3. 日志增强,增加请求参数打印：log.info("开始处理搜索请求: {}", searchDto);便于排查问题时追溯请求参数
 * 4. 响应状态码适配，支持从 Response 对象中获取自定义状态码
 * 5. 完整调用链路，串联 Controller → Service → Dao 三层
 */
@Slf4j
@RestController
public class HomeItemDataController {
    /**原本的注释
     * 根据传入的RequesParam，搜索失物招领信息。
     * 参数默认为无时，返回所有失物信息。
     * 若传入参数，则按参数搜索。
     * 每次返回6个失物数据，确保新数据与旧数据不同。
     * 需求的最后一个参数showed_ids用于向前端请求有哪些旧数据。
     */

    private final HomeItemDataService homeItemDataService;

    /**
     * 构造器注入Service，符合Spring依赖注入规范
     */
    public HomeItemDataController(HomeItemDataService homeItemDataService) {
        this.homeItemDataService = homeItemDataService;
    }

    /**
     * 搜索失物信息接口
     * 1. 接收前端JSON参数（@RequestBody绑定DTO）
     * 2. 调用Service层完成业务逻辑
     * 3. 封装标准化响应返回前端
     *
     * @param searchDto 前端传入的搜索条件
     * @return 包含搜索结果的标准化响应
     */
    @PostMapping("/home/itemData/search/foundFinished")  // 建议用POST接收复杂JSON参数
    public ResponseEntity<Response<ResponseCrud<ItemDto>>> searchFoundUnFinished(
            @RequestBody FoundUnfinishedSearchDto searchDto
    ) {
        log.info("开始处理搜索请求: {}", searchDto);
        
        // TODO: 请实现搜索逻辑
        // TODO：请使用ItemDto进行数据传输。

        // 调用Service层完成业务逻辑
        Response<ResponseCrud<ItemDto>> response = homeItemDataService.searchFoundUnfinished(searchDto);

        // 统一处理响应状态码（可根据实际业务调整）
        HttpStatus status = response.getStatus() != null ?
                response.getStatus() : HttpStatus.OK;

        return new ResponseEntity<>(response, status);
    }
}