package tests;

import models.Transaction;
import models.TransactionHistory;
import models.User;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;


public class TransactionTests {

    private static User mockedOriginatorUser;
    private static User mockedTargetUser;

    @BeforeClass
    public static void setUp() {
        mockedOriginatorUser = new User(100);
        mockedTargetUser = new User(10);
        mockedOriginatorUser.transferMoney(mockedTargetUser, 10);
        mockedOriginatorUser.transferMoney(mockedTargetUser, 10);
        mockedOriginatorUser.transferMoney(mockedTargetUser, 10);
        mockedTargetUser.transferMoney(mockedOriginatorUser, 40);


    }

    @Test
    public void moneyTransferSuccess() {
        Assert.assertEquals(0, mockedTargetUser.getCurrentBalance());
        Assert.assertEquals(110, mockedOriginatorUser.getCurrentBalance());
    }

    @Test
    public void getUserTransfersTest(){
        List<Transaction> transactions = TransactionHistory.getInstance().getTransactionsForUser(mockedOriginatorUser);
        Assert.assertEquals(4, transactions.size());
        for (var transaction : transactions){
            Assert.assertTrue(mockedOriginatorUser.getBankAccountNumber().equals(transaction.getOriginatorBankAccountId()) ||
                    mockedOriginatorUser.getBankAccountNumber().equals(transaction.getTargetBankAccountId()));
        }
    }


}
