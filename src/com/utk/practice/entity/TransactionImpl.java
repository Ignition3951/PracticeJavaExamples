package com.utk.practice.entity;

public class TransactionImpl {

    public static void main(String[] args) {
        Transaction transaction = new Transaction();
        transaction.setTransactionId("something");
        transaction.getTransactionType();
        System.out.println(transaction.toString());
    }
}
