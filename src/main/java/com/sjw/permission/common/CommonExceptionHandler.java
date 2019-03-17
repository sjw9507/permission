package com.sjw.permission.common;

import com.sjw.permission.common.util.ErrorUtil;
import com.sjw.permission.common.util.ResponseErrorUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
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
        if (e instanceof BindException) {
            FieldError fieldError = ((BindException) e).getBindingResult().getFieldError();
            assert fieldError != null;
            String defaultMessage = fieldError.getDefaultMessage();
            ResponseErrorUtils.sendJsonError(404, defaultMessage, resp);
        }

        ResponseErrorUtils.sendJsonError(500, ErrorUtil.getMsg(e), resp);
        return null;
    }

}
