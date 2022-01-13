package com.javacode.springboot_program.controller;

import com.javacode.springboot_program.model.entity.VideoOrder;
import com.javacode.springboot_program.model.request.VideoOrderRequest;
import com.javacode.springboot_program.service.VideoOrderService;
import com.javacode.springboot_program.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 订单控制器
 *
 * @author shkstart
 * @create 2022-01-09 18:13
 */
@RestController
@RequestMapping("api/v1/pri/order")
public class VideoOrderController {
    @Autowired
    private VideoOrderService videoOrderService;

    /**
     * 添加订单
     *
     * @param request
     * @param videoOrderRequest
     * @return
     */
    @RequestMapping("saveOrder")
    public JsonData saveOrder(@RequestBody VideoOrderRequest videoOrderRequest, HttpServletRequest request) {
        Integer userId = (Integer) request.getAttribute("userId");
        int saveOrder = videoOrderService.saveOrder(userId, videoOrderRequest.getVideo_id());
        return saveOrder > 0 ? JsonData.buildSuccess("添加成功") : JsonData.buildErroe("订单或许已经存在，下单失败");
    }

    /**
     * 根据UserId查询出订单列表，一个用户可以有多个订单哦
     *
     * @param request
     * @return
     */
    @GetMapping("listOrders")
    public JsonData listOrder(HttpServletRequest request) {
        Integer userId = (Integer) request.getAttribute("userId");
        List<VideoOrder> byUserIdOrders = videoOrderService.findByUserIdOrders(userId);
        return JsonData.buildSuccess(byUserIdOrders);
    }

}
