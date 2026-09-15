package model;

import java.util.*;


public class Account {


    private String accountNumber;
    private String name;
    private String pin;
    private double balance;


    ArrayList<String> transactions = new ArrayList<>();



    public Account(String accountNumber, String name, String pin, double balance) {

        this.accountNumber = accountNumber;
        this.name = name;
        this.pin = pin;
        this.balance = balance;

        transactions.add("Account created with Rs." + balance);

    }



    public boolean verifyPin(String enteredPin) {

        return pin.equals(enteredPin);

    }



    public String getAccountNumber() {

        return accountNumber;

    }



    public String getName() {

        return name;

    }



    public double getBalance() {

        return balance;

    }




    public void deposit(double amount) {


        balance += amount;


        transactions.add(
                "Deposited Rs." + amount
        );

    }





    public boolean withdraw(double amount) {


        if(amount > balance) {

            return false;

        }


        balance -= amount;


        transactions.add(
                "Withdrawn Rs." + amount
        );


        return true;

    }






    public void transfer(Account receiver, double amount) {


        balance -= amount;

        receiver.balance += amount;



        transactions.add(
                "Transferred Rs." + amount +
                " to " + receiver.accountNumber
        );



        receiver.transactions.add(
                "Received Rs." + amount +
                " from " + accountNumber
        );


    }






    public void showDetails(){


        System.out.println("\n--------- ACCOUNT DETAILS ---------");

        System.out.println("Account Number : " + accountNumber);

        System.out.println("Name           : " + name);

        System.out.println("Balance        : Rs." + balance);


    }







    public void showTransactions(){


        System.out.println("\n------ TRANSACTION HISTORY ------");


        for(String t : transactions){

            System.out.println(t);

        }


    }







    public void addInterest(){


        double interest = balance * 0.04;


        balance += interest;



        transactions.add(
                "Interest added Rs." + interest
        );



        System.out.println(
                "Interest added successfully"
        );


    }


}