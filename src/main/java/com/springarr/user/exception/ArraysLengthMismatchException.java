package com.springarr.user.exception;
import java.lang.RuntimeException;

/**
 * This class defines the exception class that is created and thrown when two arrays intended to be
 * used in a method and the method or function requires them to be of the sane length but the user
 * passed the arrays with different length.
 */
public class ArraysLengthMismatchException extends RuntimeException
{
    public ArraysLengthMismatchException(){
        super("The lengths of the arrays do not match");
    }

    public ArraysLengthMismatchException(String message){
        super(message);
    }

}
