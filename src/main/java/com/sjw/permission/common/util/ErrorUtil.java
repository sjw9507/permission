package com.sjw.permission.common.util;

import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

/**
 * @author sjw
 * @date 2019/3/14
 */


public class ErrorUtil {
    public ErrorUtil() {
    }

    public static String getMsg(Exception e) {
        if (e instanceof ConstraintViolationException) {
            ConstraintViolationException cve = (ConstraintViolationException)e;
            return (String)cve.getConstraintViolations().stream().map((item) -> {
                return item.getPropertyPath() + ": " + item.getMessage();
            }).collect(Collectors.joining(","));
        } else {
            String msg = e.getMessage();

            for(Throwable rawEx = e.getCause(); rawEx != null && rawEx.getMessage() != null; rawEx = rawEx.getCause()) {
                msg = rawEx.getMessage();
            }

            return msg;
        }
    }
}
