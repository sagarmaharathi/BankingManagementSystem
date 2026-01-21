package bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class BalanceEnquiry {

    public static void checkBalance() {

        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Account Number: ");
            int accNo = sc.nextInt();

            Connection con = DBConnection.getConnection();

            String sql = "SELECT name, balance FROM accounts WHERE account_no = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, accNo);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Account Holder: " + rs.getString("name"));
                System.out.println("Current Balance: " + rs.getDouble("balance"));
            } else {
                System.out.println("Account not found");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

