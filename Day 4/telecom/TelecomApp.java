package com.Day4.telecom;

public class TelecomApp {
    public static void main(String[] args) {
        TelecomService sms = new SMSService(1.5);        // ₹1.5 per SMS
        TelecomService voice = new VoiceCallService(2.0);// ₹2.0 per minute

        runService(sms, 10, 2.0);
        runService(voice, 5, 3.0);
    }

    private static void runService(TelecomService service, int units, double discount) {
        service.start();
        service.billCustomer(units);
        System.out.println("After discount");
        service.billCustomer(units,discount);
        service.stop();
        System.out.println();
    }
}
