package com.zero.exception;

import com.zero.enums.ResultEnum;

/**
 * Created by asd on 2019/8/29.
 */
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
