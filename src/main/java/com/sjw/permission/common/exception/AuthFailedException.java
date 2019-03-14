package com.sjw.permission.common.exception;

/**
 * @author sjw
 * @date 2019/3/14
 */
public class AuthFailedException extends RuntimeException {
    public AuthFailedException() {
        super();
    }

    public AuthFailedException(String message) {
        super(message);
    }

    public AuthFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthFailedException(Throwable cause) {
        super(cause);
    }

    protected AuthFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
