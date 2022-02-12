package com.springarr.user.utils;

import com.google.gson.Gson;
import com.springarr.user.abstracts.ObjectDataContainer;
import com.springarr.user.abstracts.SimpleDataContainer;
import com.springarr.user.annotation.NoData;
import com.springarr.user.exception.IllegalTypeException;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * This class is responsible for the processing of data classes. It should be noted that this class is extremely
 * different from the DataUtil helper class in that it uses java reflection api to process the data and
 * fields of the Object passed to it, whereas the DataUtil class only handles the low-level details of dealing
 * with already generated data.
 */
public class DataReflectProcessor
{
    /**
     * An instance of the JSON serializer
     */
    private final Gson jsonSerializer = new Gson();

    /**
     * A static constant to indicate a string value of 'nothing'.
     */
    private final static String NO_VALUE = "NULL";

    private final static Integer NO_INTEGER =  0;

    private final static Double NO_DOUBLE = 0.0;

    private final static Float NO_FLOAT = 0.0f;


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
    public static Field[] getDataFields(Object object){
        Field[] allFields = object.getClass().getDeclaredFields();
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
    public static List<Field> getFieldList(Object object){
        return Arrays.asList(getDataFields(object));
    }

    /**
     * Returns a map of the fields of the serializable object such that the name of the field is the key
     * and the value stored in the field at runtime is the value.
     * @return map : Map<String, String>
     */
    public Map<String, String> getFieldMap(Object object){
        Map<String, String> map = new HashMap<>();
        getFieldList(object).stream().forEach(field -> {
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
    public String toJSONString(Object object){
        return this.jsonSerializer.toJson(this.getFieldMap(object));
    }

    /**
     * Returns the names of the declared fields for the serializable object in an array.
     * @return array : String[]
     */
    public static String[] getNamesOfFields(Object object){
        List<String> list = new ArrayList<>();
        getFieldList(object).stream().forEach(field -> { field.setAccessible(true); list.add(field.getName());});
        return list.toArray(new String[0]);
    }

    public static void initEmptyPrimitiveFields(SimpleDataContainer object){
        getFieldList(object).forEach(field -> {
            try {
                if(field.getType().toString().contains("String"))
                    field.set(object, DataReflectProcessor.NO_VALUE);
                else if(field.getType().toString().contains("Integer"))
                    field.set(object, DataReflectProcessor.NO_INTEGER);
                else if(field.getType().toString().contains("Double"))
                    field.set(object, DataReflectProcessor.NO_DOUBLE);
                else if(field.getType().toString().contains("Float"))
                    field.set(object, DataReflectProcessor.NO_FLOAT);
                else
                    throw new IllegalTypeException();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }

    public static void initEmptyObjectField(ObjectDataContainer object){
        getFieldList(object).forEach(field -> {
            try {
                field.set(object, field.getType().newInstance());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        });
    }

}
