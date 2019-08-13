package models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionHistory {



    private List<Transaction> transactions;
    private static TransactionHistory instance;

    public static TransactionHistory getInstance() {
        if(instance == null){
            instance = new TransactionHistory();
        }
        return instance;
    }

    void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public List<Transaction> getTransactionsForUser(User user) {
        return transactions.stream()
                .filter(s -> s.getOriginatorBankAccountId().equals(user.getBankAccountNumber()) || s.getTargetBankAccountId().equals(user.getBankAccountNumber()))
                .collect(Collectors.toList());

    }

    public List<Transaction> getWithdrawalsForUser(User user) {
        return transactions.stream()
                .filter(s -> s.getOriginatorBankAccountId().equals(user.getBankAccountNumber()))
                .filter(s -> s.getTransactionType().equals(TransactionTypes.WITHDRAWAL))
                .collect(Collectors.toList());
    }

    public List<Transaction> getDepositsForUser(User user) {
        return transactions.stream()
                .filter(s -> s.getOriginatorBankAccountId().equals(user.getBankAccountNumber()))
                .filter(s -> s.getTransactionType().equals(TransactionTypes.DEPOSIT))
                .collect(Collectors.toList());
    }

    private TransactionHistory(){
        transactions = new ArrayList<>();
    }
}
