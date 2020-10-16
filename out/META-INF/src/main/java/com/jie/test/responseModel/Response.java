package com.jie.test.responseModel;

import lombok.Data;

//同一结果返回类
@Data
public class Response<T> {

    /**
     * 接口响应代码
     */
    private int code = 200;

    /**
     * 接口访问信息
     */
    private String message = "Success";

    private T data;

    @Override
    public String toString() {
        return "Response{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
