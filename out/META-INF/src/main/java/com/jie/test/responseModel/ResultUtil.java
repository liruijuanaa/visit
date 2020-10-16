package com.jie.test.responseModel;

import com.jie.test.responseModel.enums.ResultEnum;
//import jdk.jshell.spi.ExecutionControl;

import java.util.List;

public class ResultUtil {
    /**
     * Success result.
     *
     * @param object the object
     * @return the result
     */
    public static Response success(Object object) {
        Response result = new Response();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMessage(ResultEnum.SUCCESS.getMsg());
        result.setData(object);
        result.setData(object);
        return result;
    }

    /**
     * Success result.
     *
     * @return the result
     */
    public static Response success() {
        return success(null);
    }

    /**
     * Error result.
     *
     * @param code the code
     * @param msg  the msg
     * @return the result
     */
    public static Response error(Integer code, String msg) {
        Response result = new Response();
        result.setCode(code);
        result.setMessage(msg);
        return result;
    }

    /**
     * Error result.
     *
     * @param resultEnum the result enum
     * @return the result
     */
//    public static Response error(ResultEnum resultEnum) {
//        return error(resultEnum.getCode(), resultEnum.getMsg());
//    }
//
//    /**
//     * Error result.
//     *
//     * @param userException the user exception
//     * @return the result
//     */
//    public static Response error(ExecutionControl.UserException userException) {
//        return error(1000, userException.getMessage());
//    }

}
