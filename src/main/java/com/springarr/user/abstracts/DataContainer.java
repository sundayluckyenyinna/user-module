package com.springarr.user.abstracts;

import com.springarr.user.utils.DataReflectProcessor;

public abstract class DataContainer
{
    /**
     * Creates a simple DataContainer object.
     */
    public DataContainer(){
        super();
    }

    /**
     * Returns a String JSON value of this object or sub concrete class that extends this class.
     * @return JSON : String.
     */
    public String toJSON(){
        return new DataReflectProcessor().getJsonSerializer().toJson(this);
    }

}
