package me.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnectionManager {
    private Connection connection;

   /* public DBConnectionManager(String url,String username,String password) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        this.connection = DriverManager.getConnection(url,username,password);
    }*/

    public Connection getConnection(String url,String username,String password)throws ClassNotFoundException, SQLException{
    	 Class.forName("com.mysql.jdbc.Driver");
         this.connection = DriverManager.getConnection(url,username,password);
        return this.connection;
    }
}
