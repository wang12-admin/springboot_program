package com.javacode.springboot_program.utils;

/**
 * 返回数据格式工具来
 *
 * @author shkstart
 * @create 2022-01-07 21:20
 */
public class JsonData {
    private Integer code;
    private Object data;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public JsonData(Integer code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    /**
     * 成功返回【无参数】
     *
     * @return
     */
    public static JsonData buildSuccess() {
        return new JsonData(0, null, null);
    }

    /**
     * 成功返回【有参数】
     *
     * @return
     */
    public static JsonData buildSuccess(Object data) {
        return new JsonData(0, data, null);
    }

    /**
     * 失败返回【有参数】
     *
     * @return
     */
    public static JsonData buildErroe(Object data) {
        return new JsonData(-1, data, null);
    }

    /**
     * 失败返回【有参数自定义,状态码，信息】
     *
     * @return
     */
    public static JsonData buildErroe(Integer code, String msg) {
        return new JsonData(code, null, msg);
    }

    public JsonData() {
    }


    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
