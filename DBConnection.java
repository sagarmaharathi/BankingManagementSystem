package bank;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() throws Exception {

        String url = "jdbc:mysql://localhost:3306/bankdb";
        String user = "root";
        String password = "@MRsagar546";

        return DriverManager.getConnection(url, user, password);
    }
}

