package tests;

import models.User;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import utility.BankError;


public class UserTest {

    private static User mockedUser;

    @BeforeClass
    public static void setUp() {
        mockedUser = new User( 100);
    }

    @Test
    public void withdrawMoneySuccess() {
        mockedUser.withdrawMoney(99);
        Assert.assertEquals(mockedUser.getCurrentBalance(), 1);
    }

    @Test(expected = BankError.class)
    public void withdrawMoneyFail() {
        mockedUser.withdrawMoney(99);
    }
}