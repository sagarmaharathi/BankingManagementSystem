package bank;

import java.util.Scanner;

public class BankApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Banking Management System ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Balance Enquiry");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    CreateAccount.createAccount();
                    break;

                case 2:
                    Deposit.depositMoney();
                    break;

                case 3:
                    Withdraw.withdrawMoney();
                    break;

                case 4:
                    BalanceEnquiry.checkBalance();
                    break;

                case 5:
                    TransactionHistory.showHistory();
                    break;

                case 6:
                    System.out.println("Thank you");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}

