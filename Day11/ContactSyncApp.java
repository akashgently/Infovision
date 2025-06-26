package com.Day11;

import java.util.*;

public class ContactSyncApp {
    public static void main(String[] args) {
        Set<Contact> unique = new LinkedHashSet<>();
//
//        unique.add(new Contact("Akash","ak@gmail.com","1234567890"));
//        unique.add(new Contact("Jeevan","jk@gmail.com","1234567880"));
//        unique.add(new Contact("Balaji","jb@gmail.com","1234567890"));
//        unique.add(new Contact("Balaji","jb@gmail.com","1234567890"));

        Contact[] batch1={
        new Contact("Akash","ak@gmail.com","1234567890","c1"),
        new Contact("Jeevan","jk@gmail.com","1234567880","c2"),
        new Contact("Balajii","jb@gmail.com","1234567890","c2")};

        Contact[] batch2={
                new Contact("Akash","ak@gmail.com","1234567890","c3"),
                new Contact("Jeevann","jk@gmail.com","1234567880","c1"),
                new Contact("Balaji","jb@gmail.com","1234567890","c4")};

        Contact[] batch3={
                new Contact("Akashh","ak@gmail.com","1234567890","c1"),
                new Contact("Jeevan","jk@gmail.com","1234567880","c2"),
                new Contact("Balaji","jb@gmail.com","1234567890","c2")};

        Collections.addAll(unique,batch1);
        Collections.addAll(unique,batch2);
        Collections.addAll(unique,batch3);

        List<Contact> sortedcontact = new ArrayList<>(unique);
        sortedcontact.sort(Comparator.comparing(Contact ::getDepartment).
                thenComparing(Contact ::getName,String.CASE_INSENSITIVE_ORDER));

        for(Contact c:sortedcontact){
            System.out.println(c);
        }


    }

}
