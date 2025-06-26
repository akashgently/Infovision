package com.Day11;
import java.util.LinkedHashSet;

public class UserInterest {
    LinkedHashSet<String> interest = new LinkedHashSet<>();

    public void addInterest(String user_interest) {
        interest.add(user_interest);
    }

    public void viewInterest() {
        System.out.println(interest);
    }

    public static void main(String[] args){
        UserInterest user1 = new UserInterest();
        user1.addInterest("Cooking");
        user1.addInterest("Reading");
        user1.addInterest("Writing");
        user1.addInterest("Reading");
        user1.addInterest("Cooking");
        user1.viewInterest();
    }
}
