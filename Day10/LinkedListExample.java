package com.Day10;

import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {

    List<String> call_history = new LinkedList<>();

    public void addHistory(String history){
        call_history.add(history);
    }

    public void deleteHistory(int id){
        call_history.remove(id);
    }

    public void setHistory(int id,String history){
        call_history.set(id,history);
    }

    public void viewHistory(){
        for(String i: call_history){
            System.out.println(i);
        }
    }


    public static void main(String[] args){

        LinkedListExample call_history = new LinkedListExample();

        call_history.addHistory("person-1");
        call_history.addHistory("person-2");
        call_history.addHistory("person-3");
        call_history.viewHistory();
        call_history.setHistory(0,"person");
        System.out.println("---------------------");
        call_history.viewHistory();
        System.out.println("---------------------");
        call_history.deleteHistory(2);
        System.out.println("---------------------");
        call_history.viewHistory();
    }
}
