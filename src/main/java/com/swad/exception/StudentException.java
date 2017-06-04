package com.swad.exception;

import com.swad.enums.ResultEnum;

/**
 * Created by chenlei on 2017/6/4.
 */
public class StudentException extends RuntimeException{
    private Integer code;

    public StudentException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
