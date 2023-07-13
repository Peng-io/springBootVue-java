package com.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * controller 统一返回包装类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    public static final String Success_CODE = "200"; //请求成功
    public static final String Unauthorized_CODE = "401"; // 未经授权
    public static final String Error_CODE = "500"; // 请求失败

    private String code;
    private String message;
    private Object data;

    public Result(String code, String msg) {
        this.code = code;
        this.message = msg;
    }

    public static Result success(String message, Object data) {
        return new Result(Success_CODE, message, data);
    }

    public static Result success() {
        return new Result(Success_CODE, "no data");
    }

    public static Result success(String message) {
        return new Result(Success_CODE, message);
    }

    public static Result error(String message) {
        return new Result(Success_CODE, message);
    }

    public static Result unauthorized(String message) {
        return new Result(Unauthorized_CODE, message);
    }
}
