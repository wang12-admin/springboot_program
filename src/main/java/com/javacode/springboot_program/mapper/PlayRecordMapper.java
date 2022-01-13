package com.javacode.springboot_program.mapper;


import com.javacode.springboot_program.model.entity.PlayRecord;

/**
 * @author shkstart
 * @create 2022-01-11 14:27
 */
public interface PlayRecordMapper {

    /**
     * 添加播放记录信息
     * @param playRecord
     * @return
     */
    int saveRecord(PlayRecord playRecord);
}
