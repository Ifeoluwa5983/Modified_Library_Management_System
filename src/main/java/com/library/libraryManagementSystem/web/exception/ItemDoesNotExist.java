package com.library.libraryManagementSystem.web.exception;

public class ItemDoesNotExist extends Exception {
    public ItemDoesNotExist() {
        super();
    }

    public ItemDoesNotExist(String message) {
        super(message);
    }

    public ItemDoesNotExist(String message, Throwable cause) {
        super(message, cause);
    }

    public ItemDoesNotExist(Throwable cause) {
        super(cause);
    }

    protected ItemDoesNotExist(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
