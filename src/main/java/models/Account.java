package models;

import java.io.PrintStream;
import java.util.Date;

import static models.Amount.amountOf;

public class Account {

    private final Transactions transactions;

    public Account(Transactions transactions) {
        this.transactions = transactions;
    }

    public void apply(Operation operation) throws OperationException {
        Transactions operationTransactions = operation.apply(transactions);
        transactions.record(operationTransactions);
    }

    public Money balance() {
        return transactions.sum();
    }

    public Transactions transactions() {
        return transactions;
    }
}