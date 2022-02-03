package com.springarr.user.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ArrayUtils
{
    public static String[] from(List<String> collection){
        String[] array = new String[collection.size()];
        for(int i = 0; i < array.length; i++){
            array[i] = collection.get(i);
        }
        return array;
    }

    public static void main(String[] args) {
        ArrayList<String> l = new ArrayList<>();
        l.add("This"); l.add(("is")); l.add(("somrthing")); l.add("huge");
        String[] a = ArrayUtils.from(l);
        for(String s : a) System.out.println(s);
    }
}
