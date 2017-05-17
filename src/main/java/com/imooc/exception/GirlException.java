package com.imooc.exception;

/**
 * Created by Dell on 2017-5-17.
 */
public class GirlException extends RuntimeException{

    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public GirlException(Integer code , String message) {
        super(message);
        this.code = code;
    }
}
