package com.graduation.user.result;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Result<T> {

    public static final Integer FAIL_RESULT_CODE = 0;

    private int code = 1;
    private String message = "SUCCESS";
    private String msg;
    private T data;

    public Result<T> withData(T data) {
        this.data = data;
        return this;
    }

    public static Result success() {
        return new Result();
    }

    public static Result fail(String message) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg(message);
        result.setMessage(message);
        return result;
    }

}
