/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.connection.conn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Admin;

/**
 *
 * @author VanAnh
 */
public class adminController extends connection{
    private PreparedStatement ps, pre;
    private ResultSet rs, result;
    private DefaultTableModel model;
    
    //get Admin
    public ArrayList<Admin> getAdmin() throws SQLException{
        ArrayList<Admin> list = new ArrayList<>();
        String sql = "select * from Admins";

        //thuc thi truy van
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        //doc tung dong
        while(rs.next()){
            Admin ad = new Admin();
            ad.setID(rs.getString("ID"));
            ad.setAdmin_name(rs.getString("Admin_name"));
            ad.setAdmin_phone(rs.getString("Admin_phone"));
            ad.setAdmin_email(rs.getString("Admin_email"));

            list.add(ad);
        }
        return list;
    }
        
    //Add Admin
    public void addAmin(Admin ad) throws SQLException{
        boolean check_ID = false;
        boolean check_Email = false;
        
        //check ID
        String sql_checkID = "select * from Admins where ID = '"+ad.getID()+"'";
        //PreparedStatement: thực thi các truy vấn được tham số hóa
        pre = conn.prepareStatement(sql_checkID);
        result = pre.executeQuery();
        if (result.next()) {                
            check_ID = true;
        }
        
        //check email
        String sql_checkEmail = "select * from Admins where Admin_email = '"+ad.getAdmin_email()+"'";
        //PreparedStatement: thực thi các truy vấn được tham số hóa
        ps = conn.prepareStatement(sql_checkEmail);
        rs = ps.executeQuery();
        if (rs.next()) {                
            check_Email = true;
        }
        if( check_ID && check_Email){
            JOptionPane.showMessageDialog(null, "Email and ID already exists!");
            return;
        }
        //1 trong 2 chua ton tai
        if(!check_ID || !check_Email){
            
            if(!check_ID && check_Email){
                JOptionPane.showMessageDialog(null, "Email already exists!");
                return;
            }
            else if(check_ID && !check_Email){
                JOptionPane.showMessageDialog(null, "ID already exists!");
                return;
            }
            //update---------
            String sql = "insert into Admins(ID, Admin_name, Admin_email, Admin_phone, Admin_password)"
                + "VALUES(?, ?, ?, ?, ?)";
            //thuc thi truy van
            PreparedStatement psUpdate = conn.prepareStatement(sql);
            psUpdate.setString(1, ad.getID() );
            psUpdate.setString(2, ad.getAdmin_name());
            psUpdate.setString(3, ad.getAdmin_email());
            psUpdate.setString(4, ad.getAdmin_phone());
            psUpdate.setString(5, ad.getAdmin_password());

            psUpdate.executeUpdate();
            JOptionPane.showMessageDialog(null, "Added successfully!");
        }   
    }
    
    //search Admin
    public ArrayList<Admin> searchAdmin(String key) throws SQLException{
       ArrayList<Admin> list = new ArrayList<>();
       //key = "Van Anh";
       String sql = "select * from Admins where Admin_name like '%" + key + "%' "
               + "or ID like '%" + key + "%' or Admin_email like '%" + key + "%'"
               + " or Admin_phone like '%" + key + "%' ";
       
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        
        while(rs.next()){
            Admin ad = new Admin();
            ad.setID(rs.getString("ID"));
            ad.setAdmin_name(rs.getString("Admin_name"));
            ad.setAdmin_email(rs.getString("Admin_email"));
            ad.setAdmin_phone(rs.getString("Admin_phone"));
                
            list.add(ad);
        }
        
        return list;
    }
    
    //delete Admin
    public void deleteAdmin(String id) throws SQLException{
        String sql = "DELETE FROM Admins WHERE ID = '"+ id +"'";
        ps = conn.prepareStatement(sql);
        
        ps.executeUpdate();
    }
    
    //display 
    public void loadListAdmin(JTable tbQuanTriVien, JLabel lbHoTen, JLabel lbEmail, JLabel lbDienThoai) throws SQLException{
        //get admin
        ArrayList<Admin> list = getAdmin();
        //load into table
        
        int i= 1;
        model = (DefaultTableModel) tbQuanTriVien.getModel();
        
        for(int j = 0 ; j<list.size(); j++){
            Admin ad = list.get(j);
            //add 1 doi tuong
            model.addRow(new Object[]{
                i++, ad.getID() , ad.getAdmin_name(), ad.getAdmin_email(), ad.getAdmin_phone()
            });
        } 
    };
}
