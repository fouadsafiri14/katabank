package models;


public interface Operation {

    Transactions apply(Transactions accountTransactions) throws OperationException;
}
