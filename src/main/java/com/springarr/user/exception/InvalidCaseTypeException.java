package com.springarr.user.exception;
import java.lang.RuntimeException;

/**
 * This class defines the standard error or exception that will be thrown if an invalid CaseType is
 * specified.
 */
public class InvalidCaseTypeException extends RuntimeException
{
    public InvalidCaseTypeException(){
        super("The case type specified is invalid");
    }

    public InvalidCaseTypeException(String message){
        super(message);
    }
}
