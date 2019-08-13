package models;

import java.util.Date;
import java.util.UUID;

public class Transaction {

    private UUID transactionId;
    private Date date;
    private int amount;
    private TransactionTypes transactionType;
    private UUID originatorBankAccountId;
    private UUID targetBankAccountId;

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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    Transaction(TransactionTypes transactionType, int amount, UUID originatorBankAccountId, UUID targetBankAccountId) {
        this.transactionId = UUID.randomUUID();
        this.transactionType = transactionType;
        this.originatorBankAccountId = originatorBankAccountId;
        this.targetBankAccountId = targetBankAccountId;
        this.amount = amount;
        this.date = new Date(System.currentTimeMillis());
    }


    @Override
    public String toString() {
        return "Date: " + this.date.toString() + " To: " + this.targetBankAccountId + " Amount: " + this.amount;
    }
}
