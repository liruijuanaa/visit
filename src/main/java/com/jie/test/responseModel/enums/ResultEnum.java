package com.jie.test.responseModel.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultEnum {

    UNKNOW_ERROR(-1, "未知错误"),

    SQL_ERROR(304, "暂无数据"),
    LOGIN_ERROR(500, "账户密码有误"),
    /**
     * Success result enum.
     */
    SUCCESS(200, "成功");

    ResultEnum(int code, String msg) {
        setCode(code);
        setMsg(msg);
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * Sets code.
     *
     * @param code the code
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    private Integer code;

    /**
     * Gets msg.
     *
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * Sets msg.
     *
     * @param msg the msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    private String msg;
}
