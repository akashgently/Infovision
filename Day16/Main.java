package com.Day16;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        BankService bank = new BankService();

        bank.addCustomer("C001", "Preety Singh");

        bank.deposit("C001", 5000);
        bank.deposit("C001", 15000);
        bank.withdraw("C001", 2000);

        System.out.println("\n💰 All Transactions:");
        bank.findCustomer("C002").ifPresent(c ->
            c.getAccount().getTransactionStream()
              .forEach(System.out::println)
        );

        System.out.println("\n📌 Filter: Transactions > ₹10,000:");
       // List<Transaction> filtered = bank.filterTransactions("C001", TransactionFilter.byMinAmount(10000));
       // filtered.forEach(System.out::println);

        System.out.println("\n📈 Yearly Interest at 6%: ₹" +
            bank.checkInterest("C002", 6.0)
        );
    }
}
