package tests;

import models.Transaction;
import models.TransactionHistory;
import models.User;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TransactionHistoryTests {

    private static TransactionHistory mockedTransactionHistory;
    private static User mockedOriginatorUser;
    private static User mockedTargetUser;

    @BeforeClass
    public static void setUp() {
        mockedOriginatorUser = new User( 100);
        mockedTargetUser = new User( 10);
        mockedTransactionHistory.addTransaction(new Transaction());
    }


}
