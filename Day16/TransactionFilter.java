package com.Day16;

@FunctionalInterface
public interface TransactionFilter {
    boolean test(Transaction t);

    static TransactionFilter byMinAmount(double min) {
        return tx -> tx.getAmount() >= min;
    }

    default TransactionFilter and(TransactionFilter other) {
        return tx -> this.test(tx) && other.test(tx);
    }
}
