package com.springarr.user.test;

import com.springarr.user.data.Address;
import com.springarr.user.data.Name;
import com.springarr.user.data.Origin;

public class Test
{
    public static void main(String[] args) {
//        Address address = new Address();
//        System.out.println(address.toJSON());
//
        Name name = new Name("Sunday", "Enyinna", "Makinde");
        Origin origin = new Origin();
        System.out.println(origin.toString());

    }
}
