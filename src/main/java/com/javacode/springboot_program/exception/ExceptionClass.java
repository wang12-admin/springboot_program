package com.javacode.springboot_program.exception;

/**
 * 自定一个异常类
 * 通常运行时异常就够用
 * @author shkstart
 * @create 2022-01-08 16:38
 */
public class ExceptionClass extends RuntimeException{
    private int code;
    private String msg;

    public ExceptionClass() {
    }

    public ExceptionClass(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
