package com.shiguang.controller;

import com.shiguang.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created By Shiguang On 2024/9/13 17:11
 */
@RestController
@Slf4j
@Api(tags = "订单接口")
@RequestMapping("order")
public class OrderController {

    @Resource
    private OrderService orderService;

    @ApiOperation("新增订单")
    @PostMapping()
    public void addOrder(){
        orderService.addOrder();
    }

    @ApiOperation("根据keyId 查询订单")
    @GetMapping("{id}")
    public String getOrderById(@PathVariable() Integer id){
       return orderService.getOrderById(id);
    }
}
