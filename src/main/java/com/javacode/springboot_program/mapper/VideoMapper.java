package com.javacode.springboot_program.mapper;

import com.javacode.springboot_program.model.entity.Video;
import com.javacode.springboot_program.model.entity.VideoBanner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author shkstart
 * @create 2022-01-07 20:41
 */
public interface VideoMapper {
    /**
     * 视频列表
     * @return
     */
    List<Video> listVideo();

    /**
     * 轮播图
     * @return
     */
    List<VideoBanner> listBanner();

    /**
     * 根据视频video_id查询视频详情
     * @param videoId
     * @return
     */

    Video findByVideoId(@Param("video_id") int videoId);

    /**
     * 根据视频ID查询出视频信息
     * video_id
     * @param video_id
     * @return
     */
    Video findVideoId(@Param("video_id") int video_id);
}
