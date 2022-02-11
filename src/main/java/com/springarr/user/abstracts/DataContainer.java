package com.springarr.user.abstracts;

import com.springarr.user.factory.SimpleDataObjectBuilder;
import com.springarr.user.utils.DataReflectProcessor;
import com.springarr.user.utils.DataUtils;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Map;

public class DataContainer implements Serializable
{
    /**
     * The unmodifiable data processor instance for this data container.
     */
    private final DataReflectProcessor dataReflectProcessor = new DataReflectProcessor(this);

    /**
     * The unmodifiable data builder instance for this data container.
     */
    private final SimpleDataObjectBuilder builder = new SimpleDataObjectBuilder(this);

    /**
     * The data util object for the manipulation of data stored in this instance, and its
     * subclasses.
     */
    private final DataUtils dataUtils = new DataUtils();

    /**
     * Creates an empty constructor with all String fields initialized to string "NULL"
     */
    public DataContainer(){
        this.builder.build();
    }

    /**
     * Returns the DataReflectProcessor associated with this instance and its subclasses.
     * @return dataReflectProcessor : DataReflectProcessor.
     */
    public DataReflectProcessor getDataReflectProcessor(){
        return  this.dataReflectProcessor;
    }

    /**
     * Returns the DataUtil object associated with this instance and its subclasses.
     * @return dataUtil : DataUtil.
     */
    protected DataUtils getDataUtils(){
        return this.dataUtils;
    }

    /** PRIVATE METHODS  */
    private Field[] getDataFields(){
        return this.getDataReflectProcessor().getDataFields();
    }

    /** PUBLIC METHODS */
    public Map<String, String> getAddressDataAsMap(){
        return this.getDataReflectProcessor().getFieldMap();
    }

    public String toJSON(){
        return this.getDataReflectProcessor().getJsonSerializer().toJson(this.getAddressDataAsMap());
    }
}
