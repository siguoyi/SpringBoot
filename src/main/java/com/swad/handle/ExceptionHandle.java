package com.swad.handle;

import com.swad.enums.ResultEnum;
import com.swad.exception.StudentException;
import com.swad.model.Result;
import com.swad.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by chenlei on 2017/6/4.
 */
@ControllerAdvice
public class ExceptionHandle {
    private final static Logger LOGGER = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof StudentException){
            StudentException studentException = (StudentException) e;
            return ResultUtil.error(studentException.getCode(), studentException.getMessage());
        }else {
            LOGGER.error("系统异常={}", e.getMessage());
            return ResultUtil.error(ResultEnum.UNKNOWN_ERROR.getCode(), ResultEnum.UNKNOWN_ERROR.getMsg());
        }
    }

}
