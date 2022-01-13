package com.javacode.springboot_program.model.request;

/**
 * 订单表包装类
 * @author shkstart
 * @create 2022-01-09 18:16
 */
public class VideoOrderRequest {
    private int video_id;

    public int getVideo_id() {
        return video_id;
    }

    public void setVideo_id(int video_id) {
        this.video_id = video_id;
    }

    @Override
    public String toString() {
        return "VideoOrderRequest{" +
                "video_id=" + video_id +
                '}';
    }
}
