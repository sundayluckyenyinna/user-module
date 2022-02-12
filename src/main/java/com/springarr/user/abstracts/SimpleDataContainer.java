package com.springarr.user.abstracts;

import com.springarr.user.utils.DataReflectProcessor;

import java.lang.reflect.Field;

public abstract class SimpleDataContainer extends DataContainer
{
    /**
     * Creates a simpleDataContainer object. This creation initializes all fields to the
     * default "NULL" string value.
     */
    public SimpleDataContainer(){
        DataReflectProcessor.initEmptyPrimitiveFields(this);
    }
}
