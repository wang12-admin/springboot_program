package com.javacode.springboot_program.service;

import com.javacode.springboot_program.model.entity.User;

import java.util.Map;

/**
 * @author shkstart
 * @create 2022-01-08 19:10
 */
public interface UserService {
    public int register(Map<String, String> userMap);

    String findPwdAndPhone(String phone, String pwd);

    User find_by_token(Integer userId);
}
