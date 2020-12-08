package com.library.libraryManagementSystem.data.exception;

public class ExceptionsInBookEntity extends Exception {
    public ExceptionsInBookEntity() {
        super();
    }

    public ExceptionsInBookEntity(String message) {
        super(message);
    }

    public ExceptionsInBookEntity(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionsInBookEntity(Throwable cause) {
        super(cause);
    }

    protected ExceptionsInBookEntity(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
