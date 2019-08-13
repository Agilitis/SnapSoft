package models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionHistory {

    public List<Transaction> getTransactions() {
        return transactions;
    }

    private List<Transaction> transactions;
    private static TransactionHistory instance;

    public static TransactionHistory getInstance() {
        if(instance == null){
            instance = new TransactionHistory();
        }
        return instance;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> getTransactionsForUser(User user) {
        return transactions.stream()
                .filter(s -> s.getOriginatorBankAccountId().equals(user.getBankAccountNumber()))
                .collect(Collectors.toList());

    }

    private TransactionHistory(){
        transactions = new ArrayList<>();
    }
}
