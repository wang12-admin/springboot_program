package com.javacode.springboot_program.service.impl;

import com.javacode.springboot_program.mapper.UserMapper;
import com.javacode.springboot_program.model.entity.User;
import com.javacode.springboot_program.service.UserService;
import com.javacode.springboot_program.utils.JWTUtil;
import com.javacode.springboot_program.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.Random;

/**
 * @author shkstart
 * @create 2022-01-08 19:11
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 注册
     *
     * @param userMap
     * @return
     */

    @Override
    public int register(Map<String, String> userMap) {
        User user = parseToUser(userMap);
        if (user != null) {
            int register = userMapper.register(user);
            return register;
        }
        return 0;
    }


    /**
     * 过渡成User对象方法
     *
     * @param userMap
     * @return
     */
    private User parseToUser(Map<String, String> userMap) {
        if (userMap.containsKey("name") && userMap.containsKey("pwd") && userMap.containsKey("phone")) {
            User user = new User();
            user.setName(userMap.get("name"));
            String pwd = MD5Util.MD5(userMap.get("pwd"));
            user.setPwd(pwd);
            user.setPhone(userMap.get("phone"));
            user.setHeadImg(backImage());
            user.setCreateTime(new Date());
            return user;
        } else {
            return null;
        }
    }

    /**
     * 随机头像属性
     */
    private static final String[] headImg = {
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/12.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/11.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/13.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/14.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/15.jpeg"
    };

    /**
     * 返回一个头像
     *
     * @return
     */
    public String backImage() {
        int length = headImg.length;
        Random random = new Random();
        int i = random.nextInt(length);
        String s = headImg[i];
        System.out.println("==============================" + s);
        return s;
    }


    /**
     * 用户登录
     * 返回一个token数据
     *
     * @param phone
     * @param pwd
     * @return
     */
    @Override
    public String findPwdAndPhone(String phone, String pwd) {
        User user = userMapper.findPwdAndPhone(phone, MD5Util.MD5(pwd));
        if (user != null) {
            return JWTUtil.geneToken(user);
        } else {
            return null;
        }

    }

    /**
     * 根据token查询用户信息
     *
     * @param userId
     * @return
     */
    @Override
    public User find_by_token(Integer userId) {
        User user = userMapper.find_by_token(userId);
        user.setPwd("");
        return user;
    }
}
