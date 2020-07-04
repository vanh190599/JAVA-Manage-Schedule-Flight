/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author VanAnh
 */
public class connection {
    protected static Connection conn;
    
    final static String SERVER = "DESKTOP-DMOK647\\MSSQLSERVER1";
    final static String DB = "LichTrinhBay";
    
    public static void connectSQLserver(String strSever, String strDatabase) throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            String connectionURL = "jdbc:sqlserver://" + strSever + ":1433;"
                    + "databaseName=" + strDatabase + ";"
                    + "integratedSecurity=true;";

            conn = DriverManager.getConnection(connectionURL);
            if (conn != null) {
                //System.out.println("thanh cong!");
            } 
            else {
                //System.out.println("that bai");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("that bai");
            e.getMessage();
        }
    }
    
    public static Connection GetConnectionSQLServer() 
    {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            String connectionURL = "jdbc:sqlserver://" + SERVER + ":1433;"
                    + "databaseName=" + DB + ";"
                    + "integratedSecurity=true;";

            conn = DriverManager.getConnection(connectionURL);
            if (conn != null) {
                return conn;
            } 
            else {
                //System.out.println("that bai");
            }
        } catch (Exception e) {
            System.out.println("that bai");
            e.getMessage();
        }
        return null;
    }
    

//   public static void main(String[] args) throws SQLException {
//        connectSQLserver("DESKTOP-DMOK647\MSSQLSERVER1", "LichTrinhBay");      
//    }  
}
