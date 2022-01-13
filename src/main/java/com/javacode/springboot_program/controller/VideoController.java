package com.javacode.springboot_program.controller;

import com.javacode.springboot_program.model.entity.Video;
import com.javacode.springboot_program.model.entity.VideoBanner;
import com.javacode.springboot_program.service.VideoService;
import com.javacode.springboot_program.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author shkstart
 * @create 2022-01-07 20:51
 */
@RestController
@RequestMapping("api/v1/pub/video")
public class VideoController {
    @Autowired
    private VideoService videoService;

    /**
     * 视频列表
     *
     * @return
     */

    @GetMapping("list")
    public JsonData videoList() {

        List<Video> videos = videoService.listVideo();
        return JsonData.buildSuccess(videos);
    }

    /**
     * 轮播图
     * 使用guava缓存机制
     *
     * @return
     */
    @GetMapping("banners")
    public JsonData listBanner() {

        List<VideoBanner> bannerList = videoService.bannerList();
        return JsonData.buildSuccess(bannerList);
    }

    /**
     * 根据视频video_id查询视频信息
     *
     * @param videoId
     * @return
     */
    @GetMapping("find_by_videoId")
    public JsonData find_by_videoId(@RequestParam(value = "video_id", required = true) int videoId) {
        Video video = videoService.findByVideoId(videoId);
        return JsonData.buildSuccess(video);
    }

}
