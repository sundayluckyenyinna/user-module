package com.springarr.user.utils;

import com.springarr.user.enums.CaseType;
import com.springarr.user.exception.ArraysLengthMismatchException;
import com.springarr.user.exception.InvalidCaseTypeException;

import java.util.*;

/**
 * The Utility class that is responsible for the manipulation of data. This class will be used
 * privately by all the data classes for the manipulation of their separate data for its
 * specific presentation.
 */
public class DataUtils
{
    /**
     * Returns the concatenated string of the values of a map with the specified delimiter.
     * @param map
     * @param delimiter
     * @return joinedString : String
     */
    public static String concatWithSeparator(Map<String, String> map, String delimiter){
        StringBuilder builder = new StringBuilder();
        Set<String> keySet = map.keySet();
        String[] keys = keySet.toArray(new String[0]);
        for (int i = 0; i < map.size() -1 ; i++){
            builder.append(map.get(keys[i]) + delimiter);
        }
        builder.append(map.get(keys[keys.length - 1]));
        return builder.toString();
    }

    public static String concatWithSeparator(Map<String, String> map, char ch){
        return concatWithSeparator(map, String.valueOf(ch));
    }

    public static String[] valuesCaseArray(Map<String, String> map, CaseType caseType){
        List<String> list = new ArrayList<>();
        switch (caseType){
            case ALL_LOWERCASE:{map.forEach((key, value) -> { list.add(value.toLowerCase());});break; }
            case ALL_UPPERCASE:{map.forEach((key, value) -> { list.add(value.toUpperCase());});break; }
            case FIRST_UPPERCASE:{map.forEach((key, value) ->{ list.add(firstCharToUppercase(value));});break;}
            default: throw new InvalidCaseTypeException();
        }
        String[] array = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {array[i] = list.get(i);}
        return array;
    }

    private static String firstCharToUppercase(String string){
        StringBuilder builder = new StringBuilder();
        builder.append(String.valueOf(string.charAt(0)).toUpperCase());
        for(int i = 1; i < string.length(); i++){
            builder.append(String.valueOf(string.charAt(i)).toLowerCase());
        }
        return builder.toString();
    }

    /**
     * Creates a simple map from an array of keys and another array of corresponding values.
     * @param keys
     * @param values
     * @return
     */
    public static Map<String, String> createMap(String[] keys, String[] values){
        Map<String, String> map = new HashMap<>();
        if(keys.length != values.length) throw new ArraysLengthMismatchException();
        for (int i = 0; i < keys.length; i++){
            map.put(keys[i], values[i]);
        }
        return map;
    }
}
