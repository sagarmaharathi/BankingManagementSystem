package bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Withdraw {

    public static void withdrawMoney() {

        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Account Number: ");
            int accNo = sc.nextInt();

            System.out.print("Enter Amount to Withdraw: ");
            double amount = sc.nextDouble();

            Connection con = DBConnection.getConnection();

            String checkSql = "SELECT balance FROM accounts WHERE account_no = ?";
            PreparedStatement check = con.prepareStatement(checkSql);
            check.setInt(1, accNo);
            ResultSet rs = check.executeQuery();

            if (rs.next()) {
                double balance = rs.getDouble("balance");

                if (balance >= amount) {

                    String updateSql =
                        "UPDATE accounts SET balance = balance - ? WHERE account_no = ?";
                    PreparedStatement ps = con.prepareStatement(updateSql);
                    ps.setDouble(1, amount);
                    ps.setInt(2, accNo);
                    ps.executeUpdate();

                    String txSql =
                        "INSERT INTO transactions(account_no, type, amount) VALUES (?, ?, ?)";
                    PreparedStatement tx = con.prepareStatement(txSql);
                    tx.setInt(1, accNo);
                    tx.setString(2, "WITHDRAW");
                    tx.setDouble(3, amount);
                    tx.executeUpdate();

                    System.out.println("Withdrawal Successful");

                } else {
                    System.out.println("Insufficient Balance");
                }

            } else {
                System.out.println("Account not found");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
