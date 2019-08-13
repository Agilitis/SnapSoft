package main;

import logging.LoggerFactory;
import logging.LoggerTypes;
import models.Transaction;
import models.TransactionHistory;
import models.User;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        var logger = LoggerFactory.getLogger(LoggerTypes.CONSOLE);
        Scanner in = new Scanner(System.in);
        User mainUser = new User(200);

        User randomUser1 = new User(100);

        printMenu();


        int userMenuChoice = in.nextInt();

        while(userMenuChoice != 9){
            if (userMenuChoice == 1) {
                logger.LogUser("Current balance; " + mainUser.getCurrentBalance());
            }
            else if( userMenuChoice == 2){
                logger.LogUser("Specify amount ");
                int amount = in.nextInt();
                mainUser.withdrawMoney(amount);
            }
            else if( userMenuChoice == 3){
                logger.LogUser("Specify amount ");
                int amount = in.nextInt();
                mainUser.depositMoney(amount);
            }
            else if( userMenuChoice == 4){
                logger.LogUser("Specify amount: (we are transfering the money for only a specific person right now)");
                int amount = in.nextInt();
                mainUser.transferMoney(randomUser1, amount);
            }
            else if( userMenuChoice == 5){
                List<Transaction> mainUserTransactions = TransactionHistory.getInstance().getTransactionsForUser(mainUser);
                mainUserTransactions
                        .forEach(transaction -> logger.LogUser(transaction.toString()));

            }
            printMenu();
            userMenuChoice = in.nextInt();

        }


    }


    static void  printMenu(){
        var logger = LoggerFactory.getLogger(LoggerTypes.CONSOLE);
        logger.LogUser("1. Get current balance");
        logger.LogUser("2. Withdraw money");
        logger.LogUser("3. Deposit money");
        logger.LogUser("4. Transfer money");
        logger.LogUser("5. My transaction history");
        logger.LogUser("9. Exit");
    }
}
