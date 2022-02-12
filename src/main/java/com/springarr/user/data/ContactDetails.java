package com.springarr.user.data;

import java.util.ArrayList;
import java.util.Arrays;

public class ContactDetails
{
    private ArrayList<String> list = new ArrayList<>();
    public ContactDetails(){
        this.list.addAll(Arrays.asList("1", "2"));
    }
}
