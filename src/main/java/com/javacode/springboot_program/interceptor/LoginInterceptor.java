package com.javacode.springboot_program.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javacode.springboot_program.utils.JWTUtil;
import com.javacode.springboot_program.utils.JsonData;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 登录拦截器
 *
 * @author shkstart
 * @create 2022-01-09 14:16
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            String token = request.getHeader("token");
            if (token == null) {
                token = request.getParameter("token");
            }

            if (StringUtils.isNoneBlank(token)) {
                Claims claims = JWTUtil.checkJWT(token);
                if (claims == null) {
                    //通知前台
                    sendJson(response, JsonData.buildErroe("拦截器通知：账户可能已经过期,重新登录"));
                    return false;
                }
                Integer id = (Integer) claims.get("id");
                String name = (String) claims.get("name");
                request.setAttribute("userId", id);
                request.setAttribute("username", name);
                return true; //拦截器放行

            }
            //通知前台
            sendJson(response, JsonData.buildErroe("拦截器通知：账户可能已经过期,重新登录"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void sendJson(HttpServletResponse response, Object json) {
        try {
            response.setContentType("application/json;charset=utf-8");
            PrintWriter writer = response.getWriter();
            ObjectMapper objectMapper = new ObjectMapper();
             //将对象返回Json数据
            writer.print(objectMapper.writeValueAsString(json));
            writer.close();
            response.flushBuffer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
