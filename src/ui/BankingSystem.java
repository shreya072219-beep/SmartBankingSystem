package ui;

import model.Account;
import java.util.*;


public class BankingSystem {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Account> accounts = new ArrayList<>();

    static int accountCounter = 1001;


    public static void main(String args[]) {


        while(true){

            System.out.println("\n==============================");
            System.out.println(" SMART BANKING MANAGEMENT ");
            System.out.println("==============================");

            System.out.println("1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");


            System.out.print("Enter choice: ");

            int choice = sc.nextInt();


            switch(choice){

                case 1:
                    createAccount();
                    break;


                case 2:
                    login();
                    break;


                case 3:

                    System.out.println(
                    "Thank you for using Smart Banking"
                    );

                    System.exit(0);


                default:

                    System.out.println(
                    "Invalid choice"
                    );

            }

        }

    }



    static void createAccount(){

        sc.nextLine();

        System.out.print("Enter your name: ");
        String name = sc.nextLine();


        System.out.print("Create PIN: ");
        String pin = sc.next();


        System.out.print("Enter initial deposit: ");
        double amount = sc.nextDouble();



        String accountNumber =
                "SB" + accountCounter++;



        Account account =
                new Account(
                        accountNumber,
                        name,
                        pin,
                        amount
                );


        accounts.add(account);



        System.out.println(
        "\nAccount created successfully"
        );

        System.out.println(
        "Your Account Number: " 
        + accountNumber
        );

    }




    static void login(){


        System.out.print("Enter account number: ");

        String acc = sc.next();



        Account user = findAccount(acc);



        if(user == null){

            System.out.println("Account not found");

            return;

        }



        System.out.print("Enter PIN: ");

        String pin = sc.next();



        if(!user.verifyPin(pin)){

            System.out.println("Incorrect PIN");

            return;

        }



        userMenu(user);

    }





    static void userMenu(Account user){


        while(true){


            System.out.println(
            "\nWelcome " + user.getName()
            );


            System.out.println(
            "1. View Account Details\n" +
            "2. Deposit Money\n" +
            "3. Withdraw Money\n" +
            "4. Transfer Money\n" +
            "5. Transaction History\n" +
            "6. Add Interest\n" +
            "7. Logout"
            );


            System.out.print("Enter choice: ");

            int choice = sc.nextInt();



            switch(choice){


                case 1:

                    user.showDetails();

                    break;



                case 2:

                    System.out.print("Enter amount: ");

                    user.deposit(sc.nextDouble());

                    System.out.println("Deposit successful");

                    break;



                case 3:

                    System.out.print("Enter amount: ");

                    if(user.withdraw(sc.nextDouble()))

                        System.out.println("Withdrawal successful");

                    else

                        System.out.println("Insufficient balance");

                    break;



                case 4:

                    System.out.print("Enter receiver account: ");

                    String receiverNo = sc.next();



                    Account receiver = findAccount(receiverNo);



                    if(receiver == null){

                        System.out.println("Receiver not found");

                        break;

                    }



                    System.out.print("Enter amount: ");

                    double amount = sc.nextDouble();



                    if(amount <= user.getBalance()){

                        user.transfer(receiver, amount);

                        System.out.println("Transfer successful");

                    }

                    else{

                        System.out.println("Insufficient balance");

                    }

                    break;



                case 5:

                    user.showTransactions();

                    break;



                case 6:

                    user.addInterest();

                    break;



                case 7:

                    return;



                default:

                    System.out.println("Wrong choice");

            }

        }

    }





    static Account findAccount(String number){


        for(Account a : accounts){

            if(a.getAccountNumber().equals(number))

                return a;

        }


        return null;

    }

}