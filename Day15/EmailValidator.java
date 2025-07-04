package com.Day15;

public class EmailValidator {

    public static boolean isValidEmail(String emailInput) {
        String email = emailInput.trim().toLowerCase();
        return email.contains("@") && email.endsWith(".com");
    }

    public static void main(String[] args) {
        String input = "akashgentlysamuel@gmail.com";
        boolean isValid = isValidEmail(input);
        System.out.println("Is valid: " + isValid);
    }
}

