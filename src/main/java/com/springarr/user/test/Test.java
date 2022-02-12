package com.springarr.user.test;

import com.google.gson.Gson;
import com.springarr.user.data.*;
import com.springarr.user.enums.CaseType;
import com.springarr.user.utils.DataReflectProcessor;

import java.lang.reflect.Field;

public class Test
{
    public static void main(String[] args) throws NoSuchFieldException {
        Gson g = new Gson();
        Name name = new Name();
        System.out.println(new PersonalDetails().toJSON());
    }
}
