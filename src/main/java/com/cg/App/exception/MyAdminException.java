package com.cg.App.exception;
 
public class MyAdminException extends RuntimeException {
 
    private static final long serialVersionUID = 1L;
 
    public MyAdminException() {
        super();

    }
 
    public MyAdminException(String message) {
        super(message);

    }
 
}
