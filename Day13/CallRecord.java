package com.Day13;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class records{
    private String phoneNumber;
    int duration;

    public records(String phoneNumber, int duration) {
        this.phoneNumber = phoneNumber;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return  "PhoneNumber: '" + phoneNumber + '\'' +
                ", Duration: " + duration +
                's';
    }
}

public class CallRecord {
    public static void main(String[] args) {
        List<records> Customer = new ArrayList<>();
        Customer.add(new records("1234567890",18));
        Customer.add(new records("1234567891",20));
        Customer.add(new records("1234567892",23));
        Customer.add(new records("1234567893",29));

        Customer.sort(Comparator.comparingInt(c -> c.duration));

        for(records r : Customer){
            System.out.println(r);
        }
    }
}
