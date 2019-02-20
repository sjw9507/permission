package com.sjw.permission.common;

import com.sjw.permission.common.vo.Result;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author sjw
 * @date 2019/2/19
 */
@ControllerAdvice
public class CommonExceptionHandler {

    /**
     *  拦截Exception类的异常
     * @param e exception
     * @return Result
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Result exceptionHandler(MethodArgumentNotValidException e) throws NullPointerException{
        String defaultMessage = e.getBindingResult().getFieldError().getDefaultMessage();
        return Result.genFail(defaultMessage);
    }
}
