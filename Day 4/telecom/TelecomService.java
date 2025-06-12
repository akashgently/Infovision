package com.Day4.telecom;

public interface TelecomService {
    void start();               // start the service
    void stop();                // stop it
    void billCustomer(int units);
    void billCustomer(int units, double discount);
}
