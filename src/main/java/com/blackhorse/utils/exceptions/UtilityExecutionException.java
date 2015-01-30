package com.blackhorse.utils.exceptions;

/**
 * Created by Valentin
 */
public class UtilityExecutionException extends RuntimeException {

    public UtilityExecutionException() {
        super();
    }

    public UtilityExecutionException(String message) {
        super(message);
    }

    public UtilityExecutionException(String message, Throwable cause) {
        super(message, cause);
    }

    public UtilityExecutionException(Throwable cause) {
        super(cause);
    }

    protected UtilityExecutionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public static void throwNew() throws UtilityExecutionException {
        throw new UtilityExecutionException();
    }
}
