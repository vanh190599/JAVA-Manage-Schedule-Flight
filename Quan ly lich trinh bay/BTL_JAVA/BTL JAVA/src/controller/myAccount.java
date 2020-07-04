/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

//import static controller.connection.conn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.*;
/**
 *
 * @author VanAnh
 */
public class myAccount extends connection{

    //get inf Account
    public ArrayList<Admin> getInforAdmin(String Admin_email) throws SQLException{
        ArrayList<Admin> list = new ArrayList<>();
        String sql = "select * from Admins where Admin_email = '" + Admin_email+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            //ps.setString(1, Admin_email);
            
            ResultSet rs = ps.executeQuery();
            
            //neu con dong cot tiep theo thi add
            if(rs.next()){
                Admin s = new Admin();
                s.setID(rs.getString("ID"));
                s.setAdmin_email(rs.getString("Admin_email"));
                s.setAdmin_name(rs.getString("Admin_name"));
                s.setAdmin_phone(rs.getString("Admin_phone"));
       
                list.add(s);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
    
    //Update myAccount
    public void update(String email, String name, String phone , String password, String newPassword, String reNewPassword  ) throws SQLException{
        //neu khong thay doi mat khau -> update name + phone
        if( reNewPassword.equals("") && newPassword.equals("") ){
            //kiem tra password cũ có đúng hay ko?
            String sql_check = "select * from Admins where Admin_email = ? and Admin_password = ? ";
            
            //PreparedStatement: thực thi các truy vấn được tham số hóa
            PreparedStatement pre = conn.prepareStatement(sql_check);
            pre.setString(1, email);
            pre.setString(2, password);

            ResultSet result = pre.executeQuery();
            //neu nhu dung thi cho update
            if (result.next()) {                
                //update
                String sql = "update Admins set Admin_name = ? , Admin_phone = ? where Admin_email = ? "; 
                try {
                    PreparedStatement ps = conn.prepareStatement(sql);
                    //gan gia tri theo thuc tu "?"
                    ps.setString(1, name);
                    ps.setString(2, phone);
                    ps.setString(3, email);
                    //Thuc thi truy van update
                    ps.executeUpdate();  

                    JOptionPane.showMessageDialog(null, "Update sucessful!");
                } 
                catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }     
            }
            else{
                JOptionPane.showMessageDialog(null, "Old password is incorrect!");
            }
            result.close();       
        }
        
        //neu udpate tat ca
        else if( !reNewPassword.equals("")){
            //mếu mật confirm mật khẩu đúng -> update
            if( reNewPassword.equals(newPassword) == true ){
                String sql_check = "select * from Admins where Admin_email = ? and Admin_password = ? ";
                PreparedStatement pre = conn.prepareStatement(sql_check);
                pre.setString(1, email);
                pre.setString(2, password);
               
                ResultSet result = pre.executeQuery();
                //update
                if (result.next()) {                
                    String sql_update = "update Admins set Admin_name = ?, Admin_phone = ?, Admin_password = ? where Admin_email= ?";  
                    
                    PreparedStatement ps = connection.conn.prepareStatement(sql_update);
                    ps.setString(1, name);
                    ps.setString(2, phone);
                    ps.setString(3, newPassword);
                    ps.setString(4, email);
                    
                    //thuc thi truy van
                    ps.executeUpdate();  
                    JOptionPane.showMessageDialog(null, "Update sucessful!");    
                }
                else{
                    JOptionPane.showMessageDialog(null, "Old password is incorrect!");
                }
                result.close();     
            }
            else{
                JOptionPane.showMessageDialog(null, "Password incorrect!");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Fill full the information, please!");
        }  
    }

    //display
    public void displayInforAccount(String Admin_email,JLabel lbHoTen,JLabel lbEmail, JLabel lbDienThoai 
              , JTextField txtEmailUpdate,JTextField  txtHoTenUpdate, JTextField  txtDienThoaiUpdate
            ) throws SQLException{
            ArrayList<Admin> list = getInforAdmin(Admin_email);
            //form infor
            for (int i=0 ; i<list.size(); i++)
            {          
                lbHoTen.setText(list.get(i).getAdmin_name());
                lbEmail.setText(list.get(i).getAdmin_email());
                lbDienThoai.setText(list.get(i).getAdmin_phone());
            }
            //form update
            for (int i=0 ; i<list.size(); i++)
            {
                txtHoTenUpdate.setText(list.get(i).getAdmin_name());
                txtEmailUpdate.setText(list.get(i).getAdmin_email());
                txtDienThoaiUpdate.setText(list.get(i).getAdmin_phone());
                
                txtEmailUpdate.disable();
            }
    }
}
