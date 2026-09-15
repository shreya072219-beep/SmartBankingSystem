package database;

import model.Account;

import java.io.*;
import java.util.ArrayList;

public class DatabaseManager {

    private static final String FILE_NAME =
            "database/accounts.txt";


    public void saveAccounts(ArrayList<Account> accounts) {

        try {

            File folder = new File("database");

            if (!folder.exists()) {
                folder.mkdir();
            }

            PrintWriter writer =
                    new PrintWriter(
                            new FileWriter(FILE_NAME)
                    );

            for (Account account : accounts) {

                writer.println(
                        account.getAccountNumber()
                        + "|"
                        + account.getName()
                        + "|"
                        + account.getBalance()
                );
            }

            writer.close();

            System.out.println(
                    "Accounts saved successfully."
            );

        } catch (IOException e) {

            System.out.println(
                    "Error saving accounts."
            );
        }
    }


    public void displaySavedAccounts() {

        File file = new File(FILE_NAME);

        if (!file.exists()) {

            System.out.println(
                    "No saved account data found."
            );

            return;
        }

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(file)
                    );

            String line;

            System.out.println(
                    "\n------ SAVED ACCOUNTS ------"
            );

            while ((line = reader.readLine()) != null) {

                System.out.println(line);
            }

            reader.close();

        } catch (IOException e) {

            System.out.println(
                    "Error reading account data."
            );
        }
    }
}