package com.stu.manage.demo.config;

import com.stu.manage.demo.result.Result;
import com.stu.manage.demo.result.ResultEnum;
import com.stu.manage.demo.result.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author wzh
 */


@ControllerAdvice
@ResponseBody
public class DefaultControllerAdvice {

    @ExceptionHandler(Exception.class)
    public Result exceptionHandler() {

        return ResultUtil.error(ResultEnum.UNKNOWN_ERROR.getCode(),ResultEnum.UNKNOWN_ERROR.getMsg());
    }
}
