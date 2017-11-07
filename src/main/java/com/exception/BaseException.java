package com.exception;

/**
 * 异常基类
 */
public class BaseException extends RuntimeException {
    public BaseException() {
        super();
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable t) {
        super(message, t);
    }

    public BaseException(Throwable t) {
        super(t);
    }
}
