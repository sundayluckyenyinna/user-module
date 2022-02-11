package com.springarr.user.data;

import java.util.Optional;

/**
 * This class defines the object that will hold the personal details for the users of this application.
 */
public class PersonalDetails
{
    private Name name;
    private Origin origin;
    private final static String NO_VALUE = "NULL";

    public PersonalDetails(){
        super();
    }

    public PersonalDetails(Name name, Address address, Origin origin){
        this.name = name;
        this.origin = origin;
    }


}
