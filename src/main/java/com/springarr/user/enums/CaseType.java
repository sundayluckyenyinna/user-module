package com.springarr.user.enums;

/**
 * This class enum defines the various constant for the case sentivity of data.
 * Different class or instances of classes can use this constants in the manipulation of their
 * data's sensitivity.
 */
public enum CaseType
{
    /** The constant that declares that all cases of the data be Uppercase. */
    ALL_UPPERCASE,

    /** The constant that declares that all cases of the data be lowercase. */
    ALL_LOWERCASE,

    /**
     *  The constant that declares that only the first case of the data be uppercase while
     *  the rest be lowercase.
     */
    FIRST_UPPERCASE,

}
