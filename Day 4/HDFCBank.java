package com.Day4;

import com.Day4.InsufficientFundsException;
import com.Day4.InvalidAmountException;
public class HDFCBank implements Bank
{
    private double balance;
    private static final double DAILY_WITHDRAWAL_LIMIT = 20000.0;

    public void deposite (double amount) throws InvalidAmountException
    {
        if (amount <= 0)
        {
            throw new InvalidAmountException (amount + "is not valid");
        }
        balance = balance + amount;
    }
    public double withdraw (double amount) throws InsufficientFundsException, DailyLimitException 
    {
    	
    	if (DAILY_WITHDRAWAL_LIMIT > amount)
        {
            throw new DailyLimitException ("Daily Limit Exceeded");
            
        }
        if (balance < amount)
        {
            throw new InsufficientFundsException ("insufficient funds");
            
        }
        balance = balance - amount;
        return amount;
    }
    public void balanceEnquiry ()
    {
        System.out.println ("current balance = " + balance);
    }
}