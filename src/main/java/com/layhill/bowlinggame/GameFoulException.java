package com.layhill.bowlinggame;

public class GameFoulException extends RuntimeException{

    public GameFoulException() {
        super("Committed a game foul.");
    }
}
