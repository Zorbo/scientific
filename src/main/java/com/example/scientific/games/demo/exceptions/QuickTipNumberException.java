package com.example.scientific.games.demo.exceptions;


public class QuickTipNumberException extends RuntimeException {

    public QuickTipNumberException(String message) {
        super(message);
    }

    public QuickTipNumberException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

}
