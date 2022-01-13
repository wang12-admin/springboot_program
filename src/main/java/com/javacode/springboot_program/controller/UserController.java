package com.javacode.springboot_program.controller;

import com.javacode.springboot_program.model.entity.User;
import com.javacode.springboot_program.model.request.LoginRequest;
import com.javacode.springboot_program.service.UserService;
import com.javacode.springboot_program.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author shkstart
 * @create 2022-01-08 18:58
 */
@RestController
@RequestMapping("api/v1/pri/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    @RequestMapping("register")
    public JsonData register(@RequestBody Map<String, String> userMap) {
        int register = userService.register(userMap);
        System.out.println("map集合值：" + userMap);
        return register > 0 ? JsonData.buildSuccess("注册成功") : JsonData.buildErroe("注册失败");
    }

    /**
     * 登录
     * 相应一个token数据
     *
     * @param loginRequest
     * @return
     */
    @RequestMapping("login")
    public JsonData login(@RequestBody LoginRequest loginRequest) {
        String token = userService.findPwdAndPhone(loginRequest.getPhone(),loginRequest.getPwd());
        return token != null ? JsonData.buildSuccess(token) : JsonData.buildErroe("登录失败或者已经过期");
    }

    /**
     * 根据token 查询用户信息
     * @param request
     * @return
     */
    @RequestMapping("find_by_token")
    public JsonData find_by_token(HttpServletRequest request) {
        Integer userId = (Integer) request.getAttribute("userId");
        if (userId == null) {
            return JsonData.buildErroe("用户为空");
        }
        User user = userService.find_by_token(userId);
        return JsonData.buildSuccess(user);
    }
}
