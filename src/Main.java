/*************************************************
 File: Main.java
 By: Jeanine Nebrija
 Date: 4/24/24
 Compile: Open directory as IntelliJ project, compile and run.
 System: Windows w/ Java
 Description: Main driver for BankCustomerBuilder and customer's bank account data information.
 *************************************************/


import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("");
        System.out.println("Setting up data...");
        //SET UP CUSTOMER DATA
        BankCustomer customer = new BankCustomerBuilder()
            .buildWithId(1)
            .buildWithFirstName("John")
            .buildWithLastName("Doe")
            .buildWithEmail("jdoe@SFSU.edu")
            .buildWithPhone("415-555-1212")
            .buildWithSex("M")
            .buildWithBirthday(LocalDate.now())
            .build();
        System.out.println(customer);

        //SET UP BANK ACCOUNT DATA
        BankAccount account=new BankAccount("12345");
        account.setCustNum(1);
        account.setBalance(1.99);
        account.setAcctType("CH");
        account.setOdLimit(2000);
        account.setIntRate(3.2);
        System.out.println(account);

        //CREATE TRANSACTION (DEPOSIT)
        System.out.println();
        System.out.println("Preparing deposit transaction...");
        BankAccountTransaction.DepositTransaction deposit = new BankAccountTransaction.DepositTransaction(account, 4.20);
        deposit.setDescription("sample deposit");

        System.out.println("Creating invoker...");
        BankAccountTransaction transaction = new BankAccountTransaction(deposit);
        System.out.println(transaction);
        System.out.println("Executing transaction...");
        transaction.execute(deposit);
        System.out.println(transaction);

        System.out.println("New account balance: " + account.getBalance());


        //CREATE TRANSACTION (WITHDRAWAL)
        System.out.println();
        System.out.println("Preparing withdrawal transaction...");
        BankAccountTransaction.WithdrawalTransaction withdrawal = new BankAccountTransaction.WithdrawalTransaction(account, 7.00);
        withdrawal.setDescription("sample withdrawal");

        System.out.println("Creating invoker...");
        transaction = new BankAccountTransaction(withdrawal);
        System.out.println(transaction);
        System.out.println("Executing transaction...");
        transaction.execute(withdrawal);
        System.out.println(transaction);

        System.out.println("New account balance: " + account.getBalance());
    }
}