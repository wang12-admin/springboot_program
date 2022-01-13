package com.javacode.springboot_program.mapper;

import com.javacode.springboot_program.model.entity.VideoOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单mapper层
 *
 * @author shkstart
 * @create 2022-01-09 18:12
 */
public interface VideoOrderMapper {
    /**
     * 根据user_id 和视频video_id查询出订单信息
     *
     * @param userId
     * @param video_id
     * @return
     */
    VideoOrder findUseIdAndVideoId(@Param("user_id") Integer userId, @Param("video_id") int video_id);

    /**
     * 添加订单
     *
     * @param videoOrder
     * @return
     */
    int saveOrder(VideoOrder videoOrder);

    /**
     * 根据UserId查询出订单列表
     *
     * @param userId
     * @return
     */

    List<VideoOrder> findByUserIdOrders(@Param("userId") Integer userId);
}
