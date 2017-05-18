package com.imooc.enums;

/**
 * Created by Dell on 2017-5-18.
 */
public enum ResultEnum {

    UNKONW_ERROR(-1,"我并不知道这是什么鬼异常"),
    SUCCESS(00,"success"),
    TOO_SMALL(100,"TOO SAMLL!"),
    BIG_ENOUGH(101,"BIG_ENOUGH"),
    TOO_BIG(102,"TOO BIG!")


    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    //枚举不需要Set

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
