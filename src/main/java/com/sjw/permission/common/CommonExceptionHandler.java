package com.sjw.permission.common;

import com.sjw.permission.common.util.ErrorUtil;
import com.sjw.permission.common.util.ResponseErrorUtils;
import com.sjw.permission.common.vo.Result;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author sjw
 * @date 2019/2/19
 */
@ControllerAdvice
public class CommonExceptionHandler {


    /**
     * @param e exception
     * @return null
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ModelAndView defaultExceptionHandler(HttpServletRequest req, HttpServletResponse resp, Exception e) {
        ResponseErrorUtils.sendJsonError(500, ErrorUtil.getMsg(e), resp);
        return null;
    }


    /**
     *  拦截MethodArgumentNotValidException类的异常
     * @param e exception
     * @return Result
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Result exceptionHandler(MethodArgumentNotValidException e) throws NullPointerException{
        FieldError fieldError = e.getBindingResult().getFieldError();
        assert fieldError != null;
        String defaultMessage = fieldError.getDefaultMessage();
        return Result.genFail(defaultMessage);
    }





}
