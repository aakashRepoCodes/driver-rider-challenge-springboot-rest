package com.hop.ride;

public class NoRideFoundException extends RuntimeException{

    public NoRideFoundException(String message) {
        super(message);
    }
}
