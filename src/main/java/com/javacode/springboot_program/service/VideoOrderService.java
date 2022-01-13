package com.javacode.springboot_program.service;

import com.javacode.springboot_program.model.entity.VideoOrder;

import java.util.List;

/**
 * @author shkstart
 * @create 2022-01-09 18:13
 */
public interface VideoOrderService {
    /**
     * 下单
     *
     * @param userId
     * @param video_id
     * @return
     */
    int saveOrder(Integer userId, int video_id);

    /**
     * 根据userId查询订单列表
     *
     * @param userId
     * @return
     */
    List<VideoOrder> findByUserIdOrders(Integer userId);
}
