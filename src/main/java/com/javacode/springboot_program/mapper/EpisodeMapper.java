package com.javacode.springboot_program.mapper;

import com.javacode.springboot_program.model.entity.Episode;
import org.apache.ibatis.annotations.Param;

/**
 * 集 mapper层
 * @author shkstart
 * @create 2022-01-11 14:33
 */
public interface EpisodeMapper {

    /**
     * 根据视频video_id查询出集信息
     * @param video_id
     * @return
     */
    Episode findByEpisode(@Param("video_id") int video_id);
}
