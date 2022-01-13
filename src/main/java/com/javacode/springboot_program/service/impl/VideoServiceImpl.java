package com.javacode.springboot_program.service.impl;

import com.javacode.springboot_program.config.CacheKeyConfig;
import com.javacode.springboot_program.mapper.VideoMapper;
import com.javacode.springboot_program.model.entity.Video;
import com.javacode.springboot_program.model.entity.VideoBanner;
import com.javacode.springboot_program.service.VideoService;
import com.javacode.springboot_program.utils.GuavaCacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shkstart
 * @create 2022-01-07 20:45
 */
@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private GuavaCacheUtil guavaCacheUtil;

    /**
     * 视频列表
     * 使用Guava缓存机制
     *
     * @return
     */
    @Override
    public List<Video> listVideo() {
        try {
            Object object = guavaCacheUtil.getTenMinuteCache().get(CacheKeyConfig.INDEX_VIDEO_LIST, () -> {
                List<Video> videos = videoMapper.listVideo();
                return videos;
            });
            if (object instanceof List) {
                List<Video> videoList = (List<Video>) object;
                return videoList;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 轮播图
     * 使用Guava缓存机制
     *
     * @return
     */
    @Override
    public List<VideoBanner> bannerList() {
        try {
            Object object = guavaCacheUtil.getTenMinuteCache().get(CacheKeyConfig.BANNER_CACHE, () -> {
                List<VideoBanner> bannerList = videoMapper.listBanner();
                System.out.println("没有找到数据；从数据库中拿数据");
                return bannerList;
            });
            if (object instanceof List) {
                List<VideoBanner> banners = (List<VideoBanner>) object;
                return banners;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据视频video_id查询视频信息
     * 使用Guava缓存机制
     * @param videoId
     * @return
     */
    @Override
    public Video findByVideoId(int videoId) {

        String format = String.format(CacheKeyConfig.INDEX_VIDEO_DETAIL, videoId);
        try {
            Object object = guavaCacheUtil.getOneHoursCache().get(format, () -> {
                Video byVideoId = videoMapper.findByVideoId(videoId);
                return byVideoId;
            });

            if (object instanceof Video) {
                Video video = (Video) object;
                return video;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
