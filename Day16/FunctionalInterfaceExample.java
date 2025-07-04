package com.Day16;
interface  A{
    void show();
}

public class FunctionalInterfaceExample {

    public static void main(String[] args) {

        A obj = () ->System.out.println("Show");
        obj.show();
    }

}


