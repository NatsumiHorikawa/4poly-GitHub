package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {

    public static Connection getConnection() {
        try {
            Class.forName(
                    "com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
            		"jdbc:mysql://172.16.71.104:3306/management","user17","user17pass");

            return con;
        }catch(SQLException | ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }
    public static void main(String[] args) throws SQLException{
        Connection con = getConnection();
        System.out.println("con=" + con);
        con.close();

    }

}