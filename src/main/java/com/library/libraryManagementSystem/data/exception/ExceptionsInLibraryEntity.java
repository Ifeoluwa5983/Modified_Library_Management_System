package com.library.libraryManagementSystem.data.exception;

public class ExceptionsInLibraryEntity extends Exception {
    public ExceptionsInLibraryEntity() {
        super();
    }

    public ExceptionsInLibraryEntity(String message) {
        super(message);
    }

    public ExceptionsInLibraryEntity(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionsInLibraryEntity(Throwable cause) {
        super(cause);
    }

    protected ExceptionsInLibraryEntity(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
