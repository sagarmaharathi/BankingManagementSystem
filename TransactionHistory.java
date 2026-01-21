package bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class TransactionHistory {

    public static void showHistory() {

        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Account Number: ");
            int accNo = sc.nextInt();

            Connection con = DBConnection.getConnection();

            String sql =
                "SELECT type, amount, tx_date FROM transactions WHERE account_no = ? ORDER BY tx_date";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, accNo);

            ResultSet rs = ps.executeQuery();

            System.out.println("\nType      Amount      Date");

            boolean found = false;

            while (rs.next()) {
                found = true;
                System.out.println(
                    rs.getString("type") + "   " +
                    rs.getDouble("amount") + "   " +
                    rs.getTimestamp("tx_date")
                );
            }

            if (!found) {
                System.out.println("No transactions found");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
