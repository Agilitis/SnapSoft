package models;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

public class TransactionHistory {

    private List<Transaction> transactions;
    private static TransactionHistory instance;

    public static TransactionHistory getInstance() {
        if(instance == null){
            return new TransactionHistory();
        }
        return instance;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public Stream<Transaction> getTransactionsForUserByBankAccount(UUID bankAccount) {
        return transactions.stream()
                .filter(s -> s.getOriginatorBankAccountId().equals(bankAccount));

    }

    private TransactionHistory(){}
}
