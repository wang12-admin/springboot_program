package com.javacode.springboot_program.service.impl;

import com.javacode.springboot_program.exception.ExceptionClass;
import com.javacode.springboot_program.mapper.EpisodeMapper;
import com.javacode.springboot_program.mapper.PlayRecordMapper;
import com.javacode.springboot_program.mapper.VideoMapper;
import com.javacode.springboot_program.mapper.VideoOrderMapper;
import com.javacode.springboot_program.model.entity.Episode;
import com.javacode.springboot_program.model.entity.PlayRecord;
import com.javacode.springboot_program.model.entity.Video;
import com.javacode.springboot_program.model.entity.VideoOrder;
import com.javacode.springboot_program.service.VideoOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author shkstart
 * @create 2022-01-09 18:13
 */
@Service
public class VideoOrderServiceImpl implements VideoOrderService {
    @Autowired
    private VideoOrderMapper videoOrderMapper;

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private EpisodeMapper episodeMapper;

    @Autowired
    private PlayRecordMapper playRecordMapper;

    @Override
    @Transactional //开启事务，也可以在类上面使用，也就可以只在方法上使用即可
    public int saveOrder(Integer userId, int video_id) {
        VideoOrder videoOrder = videoOrderMapper.findUseIdAndVideoId(userId, video_id);
        if (videoOrder != null) {
            return 0;
        } else {
            Video video = videoMapper.findVideoId(video_id);
            VideoOrder newVideoOrder = new VideoOrder();
            newVideoOrder.setCreateTime(new Date());
            newVideoOrder.setOutTradeNo(UUID.randomUUID().toString());
            newVideoOrder.setState(1);
            newVideoOrder.setTotalFee(video.getPrice());
            newVideoOrder.setUserId(userId);
            newVideoOrder.setVideoId(video_id);
            newVideoOrder.setVideoImg(video.getCoverImg());
            newVideoOrder.setVideoTitle(video.getTitle());
            int rows = videoOrderMapper.saveOrder(newVideoOrder);
            //插入一个播放记录查询
            if (rows == 1) {
                Episode episode = episodeMapper.findByEpisode(video_id);
                if (episode == null) {
                    throw new ExceptionClass(-1, "视频没有集信息，请运营人员检查");
                }
                PlayRecord playRecord = new PlayRecord();
                playRecord.setCreateTime(new Date());
                playRecord.setCurrentNum(episode.getNum());
                playRecord.setEpisodeId(episode.getId());
                playRecord.setUserId(userId);
                playRecord.setVideoId(video_id);
                playRecordMapper.saveRecord(playRecord);
            }

            return rows; //开启事务管理后，没有集订单也不会执行，不开启事务，没有集，订单也会执行成功
        }
    }

    /**
     * 根据UserId查询出订单列表
     *
     * @param userId
     * @return
     */
    @Override
    public List<VideoOrder> findByUserIdOrders(Integer userId) {
        List<VideoOrder> videoOrderList = videoOrderMapper.findByUserIdOrders(userId);
        return videoOrderList;
    }
}
