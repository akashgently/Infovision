package com.Day4;


public interface Bank
{
    public void deposite (double amount) throws InvalidAmountException;
    public double withdraw (double amount) throws InsufficientFundsException, DailyLimitException;
    public void balanceEnquiry ();
}