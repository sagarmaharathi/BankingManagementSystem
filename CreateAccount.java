package bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class CreateAccount {

    public static void createAccount() {

        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Initial Balance: ");
            double balance = sc.nextDouble();

            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO accounts(name, balance) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setDouble(2, balance);

            ps.executeUpdate();

            System.out.println("Account Created Successfully");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
