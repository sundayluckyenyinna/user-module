package com.springarr.user.utils;

import com.google.gson.Gson;
import com.springarr.user.annotation.NoData;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.*;

/**
 * This class is responsible for the processing of data classes.
 */
public class DataReflectProcessor
{
    /**
     * An instance of the JSON serializer
     */
    private final Gson jsonSerializer = new Gson();

    /**
     * An instance of the object for which this DataReflectProcessor object will operate on. This implies
     * all concrete, abstract or interface classes that will use this instance of this class must implement the Serializable
     * interface.
     */
    private final Serializable object;

    /**
     * Creates a DataReflectProcessor instance for the serializable object. The serializable object must
     * be passed as an argument to this instance.
     * @param object : Serializable.
     */
    public DataReflectProcessor(Serializable object){
        this.object = object;
    }

    /**
     * Returns the GSON instance that is used to serialize the passed serializable object to JSON.
     * @return
     */
    public Gson getJsonSerializer(){
        return this.jsonSerializer;
    }

    /**
     * Returns all declared fields of the serializable object in an array.
     * @return array : Field[]
     */
    public Field[] getDataFields(){
        Field[] allFields = this.object.getClass().getDeclaredFields();
        List<Field> dataFields = new ArrayList<>();
        Arrays.stream(allFields).forEach(field -> {
            field.setAccessible(true);
            if(!field.isAnnotationPresent(NoData.class))
                dataFields.add(field);
        });
        return dataFields.toArray(new Field[0]);
    }

    /**
     * Returns all declared fields of the serializable object in a List format.
     * @return list : List<Field>
     */
    public List<Field> getFieldList(){
        return Arrays.asList(this.getDataFields());
    }

    /**
     * Returns a map of the fields of the serializable object such that the name of the field is the key
     * and the value stored in the field at runtime is the value.
     * @return map : Map<String, String>
     */
    public Map<String, String> getFieldMap(){
        Map<String, String> map = new HashMap<>();
        this.getFieldList().stream().forEach(field -> {
            field.setAccessible(true);
            try {
                map.put(field.getName(), (String)field.get(object));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        return map;
    }

    /**
     * Returns the JSON string for the serializable object in well format string format.
     * @return JSON : String.
     */
    public String toJSONString(){
        return this.jsonSerializer.toJson(this.getFieldMap());
    }

    /**
     * Returns the names of the declared fields for the serializable object in an array.
     * @return array : String[]
     */
    public String[] getNamesOfFields(){
        List<String> list = new ArrayList<>();
        this.getFieldList().stream().forEach(field -> { field.setAccessible(true); list.add(field.getName());});
        return list.toArray(new String[0]);
    }


}
