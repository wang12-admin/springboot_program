package com.javacode.springboot_program.service;

import com.javacode.springboot_program.model.entity.Video;
import com.javacode.springboot_program.model.entity.VideoBanner;

import java.util.List;

/**
 * @author shkstart
 * @create 2022-01-07 20:44
 */
public interface VideoService {
    /**
     * 视频列表
     * @return
     */
    List<Video> listVideo();

    /**
     * 轮播图
     * @return
     */

    List<VideoBanner> bannerList();

    /**
     * 根据视频video_id查询视频信息
     * @param videoId
     * @return
     */
    Video findByVideoId(int videoId);
}
