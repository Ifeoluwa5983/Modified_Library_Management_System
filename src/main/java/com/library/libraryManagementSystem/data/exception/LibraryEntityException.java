package com.library.libraryManagementSystem.data.exception;

public class LibraryEntityException extends Exception {
    public LibraryEntityException() {
        super();
    }

    public LibraryEntityException(String message) {
        super(message);
    }

    public LibraryEntityException(String message, Throwable cause) {
        super(message, cause);
    }

    public LibraryEntityException(Throwable cause) {
        super(cause);
    }

    protected LibraryEntityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
