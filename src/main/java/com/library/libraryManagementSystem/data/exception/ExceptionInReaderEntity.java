package com.library.libraryManagementSystem.data.exception;

public class ExceptionInReaderEntity extends Exception {
    public ExceptionInReaderEntity() {
        super();
    }

    public ExceptionInReaderEntity(String message) {
        super(message);
    }

    public ExceptionInReaderEntity(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionInReaderEntity(Throwable cause) {
        super(cause);
    }

    protected ExceptionInReaderEntity(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
