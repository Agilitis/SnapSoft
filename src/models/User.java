package models;

import utility.BankError;

import java.util.UUID;

public class User {

    public UUID getBankAccountNumber() {
        return bankAccountNumber;
    }

    private UUID bankAccountNumber;

    // This can be calculated from transactions, so there is some redundance but this is faster
    private int currentBalance;


    public User(int currentBalance) {
        this.bankAccountNumber = UUID.randomUUID();
        this.currentBalance = currentBalance;
    }

    public int getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(int currentBalance) {
        this.currentBalance = currentBalance;
    }

    public void withdrawMoney(int amount) throws BankError {
        if (this.currentBalance - amount < 0) {
            throw new BankError("Insufficient money");
        }
        //Save transaction
        Transaction transaction = new Transaction(TransactionTypes.WITHDRAWAL, amount, this.bankAccountNumber, null);
        TransactionHistory.getInstance().addTransaction(transaction);

        //Do the job
        currentBalance -= amount;
    }

    public void depositMoney(int amount) {
        // Save transaction
        Transaction transaction = new Transaction(TransactionTypes.DEPOSIT, amount,  this.bankAccountNumber, null);
        TransactionHistory.getInstance().addTransaction(transaction);

        //Do the job
        currentBalance += amount;
    }

    public void transferMoney(User targetUser, int amount) throws BankError{
        if (this.currentBalance - amount < 0) {
            throw new BankError("Insufficient money");
        }

        //Save transaction
        Transaction transaction = new Transaction(TransactionTypes.TRANSFER, amount, this.bankAccountNumber, targetUser.getBankAccountNumber());
        TransactionHistory.getInstance().addTransaction(transaction);

        //Do the job
        this.currentBalance -= amount;
        targetUser.setCurrentBalance(targetUser.getCurrentBalance() + amount);

    }
}
