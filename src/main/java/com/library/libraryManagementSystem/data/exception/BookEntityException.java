package com.library.libraryManagementSystem.data.exception;

public class BookEntityException extends Exception {
    public BookEntityException() {
        super();
    }

    public BookEntityException(String message) {
        super(message);
    }

    public BookEntityException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookEntityException(Throwable cause) {
        super(cause);
    }

    protected BookEntityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
