package models;

import java.util.UUID;

public class Transaction {

    private UUID transactionId;

    private int amount;

    private TransactionTypes transactionType;

    public UUID getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(UUID transactionId) {
        this.transactionId = transactionId;
    }

    public TransactionTypes getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionTypes transactionType) {
        this.transactionType = transactionType;
    }

    public UUID getOriginatorBankAccountId() {
        return originatorBankAccountId;
    }

    public void setOriginatorBankAccountId(UUID originatorBankAccountId) {
        this.originatorBankAccountId = originatorBankAccountId;
    }

    public UUID getTargetBankAccountId() {
        return targetBankAccountId;
    }

    public void setTargetBankAccountId(UUID targetBankAccountId) {
        this.targetBankAccountId = targetBankAccountId;
    }

    private UUID originatorBankAccountId;
    private UUID targetBankAccountId;


    public Transaction(TransactionTypes transactionType, int amount, UUID originatorBankAccountId, UUID targetBankAccountId) {
        this.transactionId = UUID.randomUUID();
        this.transactionType = transactionType;
        this.originatorBankAccountId = originatorBankAccountId;
        this.targetBankAccountId = targetBankAccountId;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
