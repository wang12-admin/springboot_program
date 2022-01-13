package com.javacode.springboot_program.config;

/**
 * key标注类
 *
 * @author shkstart
 * @create 2022-01-12 14:00
 */
public class CacheKeyConfig {
    public static final String BANNER_CACHE = "index_banner_cache";  //banner缓存key
    public static final String INDEX_VIDEO_LIST = "index_video_list"; //视频列表缓存key
    public static final String INDEX_VIDEO_DETAIL = "index_video_detail%s"; //视频列表详情缓存key 有参数 %s
}
