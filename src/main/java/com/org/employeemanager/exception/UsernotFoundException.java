package com.org.employeemanager.exception;

public class UsernotFoundException extends  RuntimeException{
    public UsernotFoundException(String message) {
        super(message);
    }
}
