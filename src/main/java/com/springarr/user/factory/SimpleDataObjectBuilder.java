package com.springarr.user.factory;

import com.springarr.user.abstracts.DataContainer;

import java.lang.reflect.Field;
import java.util.List;

public class SimpleDataObjectBuilder implements ObjectFactory
{

    private final DataContainer object;

    public SimpleDataObjectBuilder(DataContainer object){
        this.object = object;
    }

    public DataContainer getObject(){
        return this.object;
    }

    /** Builds an object by inspecting the constructor of the object */
    @Override
    public void build() {
        List<Field> fieldList = this.object.getDataReflectProcessor().getFieldList();
        fieldList.forEach(field -> {
            field.setAccessible(true);
            try {
                field.set(this.object, "NULL");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }
}
