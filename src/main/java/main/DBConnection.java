package main;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() throws Exception {

        String url = "jdbc:sqlserver://localhost:1433;databaseName=ql_thuvien;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String pass = "123456"; 

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, user, pass);
    }
}