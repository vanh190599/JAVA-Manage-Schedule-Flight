/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author VanAnh
 */
public class loginController extends  connection{
    //Login
    public boolean login(String email, String password) throws SQLException{
        ResultSet result;
        try {
            String sql="select * from Admins where Admin_email=? and Admin_password=?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, email);
            pre.setString(2, password);
            result = pre.executeQuery();
            
            if (result.next()) {                
                return true;
            }
            result.close();
            
            return false;   
        } catch (SQLException ex) {
            ex.getErrorCode();
        }
       
        return false;
    }
//    public static void main(String[] args) throws SQLException {
//       connection.connectSQLserver("DESKTOP-DMOK647\\MSSQLSERVER1", "LichTrinhBay");
//    }
}
