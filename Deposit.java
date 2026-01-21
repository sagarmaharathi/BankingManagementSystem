package bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Deposit {

    public static void depositMoney() {

        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Account Number: ");
            int accNo = sc.nextInt();

            System.out.print("Enter Amount to Deposit: ");
            double amount = sc.nextDouble();

            Connection con = DBConnection.getConnection();

            String updateSql =
                "UPDATE accounts SET balance = balance + ? WHERE account_no = ?";
            PreparedStatement ps = con.prepareStatement(updateSql);
            ps.setDouble(1, amount);
            ps.setInt(2, accNo);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                String txSql =
                    "INSERT INTO transactions(account_no, type, amount) VALUES (?, ?, ?)";
                PreparedStatement tx = con.prepareStatement(txSql);
                tx.setInt(1, accNo);
                tx.setString(2, "DEPOSIT");
                tx.setDouble(3, amount);
                tx.executeUpdate();

                System.out.println("Deposit Successful");
            } else {
                System.out.println("Account not found");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
