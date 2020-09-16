package com.example.scientific.games.demo.exceptions;

public class GameTypeException extends RuntimeException {

    public GameTypeException(String message) {
        super(message);
    }

    public GameTypeException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
