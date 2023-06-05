package com.aston_hibernate.exeption_handler;

public class NoSuchEmployeeException extends RuntimeException {
    public NoSuchEmployeeException(String msg) {
        super(msg);
    }
}
