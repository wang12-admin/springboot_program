package com.javacode.springboot_program.mapper;

import com.javacode.springboot_program.model.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author shkstart
 * @create 2022-01-08 19:12
 */
public interface UserMapper {
    /**
     * 用户注册
     * @param user
     * @return
     */
    int register(User user);

    /**
     * 根据电话和密码查询用户数据
     * @param phone
     * @param phone1
     * @return
     */

    User findPwdAndPhone(@Param("phone") String phone, @Param("pwd") String pwd);

    /**
     * 根据token 查询用户信息
     * @param userId
     * @return
     */
    User find_by_token(@Param("userId") Integer userId);
}
