package com.springarr.user.abstracts;

import com.springarr.user.utils.DataReflectProcessor;

public abstract class ObjectDataContainer extends DataContainer
{
    /**
     * Creates an instance of the ObjectDataContainer. This ObjectDataContainer is a compound
     * class. With this No-arg constructor, all objects that have been composed in this class is
     * initialized to their respective No-arg constructor at runtime.
     */
    public ObjectDataContainer(){
        DataReflectProcessor.initEmptyObjectField(this);
    }
}
