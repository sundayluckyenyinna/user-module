package com.springarr.user.exception;

public class IllegalTypeException extends RuntimeException
{
    public IllegalTypeException(){
        super("The type entered id not supported. The supported primitive types are: \n " +
                "java.lang.String, java.lang.Integer, java.lang.Double, java.lang.Double, java.lang.Float");
    }

    public IllegalTypeException(String message){
        super(message);
    }
}
