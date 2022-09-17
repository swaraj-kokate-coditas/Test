package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
    static final String driver = "com.mysql.jdbc.Driver";
    static final String URL = "jdbc:mysql://localhost:3306/Assignment";
    static final String username = "root";
    static final String password = "C0d!t@s2406";

    public static Connection connect() {
        try{
            Class.forName(driver);

            Connection connection = DriverManager.getConnection(URL, username, password);

            return connection;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
