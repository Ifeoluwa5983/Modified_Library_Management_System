package com.library.libraryManagementSystem.data.exception;

public class ReaderEntityException extends Exception {
    public ReaderEntityException() {
        super();
    }

    public ReaderEntityException(String message) {
        super(message);
    }

    public ReaderEntityException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReaderEntityException(Throwable cause) {
        super(cause);
    }

    protected ReaderEntityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
