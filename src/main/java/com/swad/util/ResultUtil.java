package com.swad.util;

import com.swad.model.Result;

/**
 * Created by chenlei on 2017/6/4.
 */
public class ResultUtil {

    public static Result success(){
        return success(null);
    }


    public static Result success(Object object){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result error(Integer code, String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
