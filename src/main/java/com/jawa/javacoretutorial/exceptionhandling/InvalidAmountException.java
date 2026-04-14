package com.jawa.javacoretutorial.exceptionhandling;

public class InvalidAmountException extends RuntimeException {

    public InvalidAmountException(String msg) {
        super(msg);
    }

}
