package com.javacode.springboot_program.model.request;

/**
 * 验证登录信息包装类
 *
 * @author shkstart
 * @create 2022-01-09 12:24
 */
public class LoginRequest {
    private String pwd;
    private String phone;

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                "pwd='" + pwd + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
