/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author VanAnh
 */

public class Admin {
    private String ID;
    private String Admin_name;
    private String Admin_email;
    private String Admin_phone;
    private String Admin_password;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getAdmin_name() {
        return Admin_name;
    }

    public void setAdmin_name(String Admin_name) {
        this.Admin_name = Admin_name;
    }

    public String getAdmin_email() {
        return Admin_email;
    }

    public void setAdmin_email(String Admin_email) {
        this.Admin_email = Admin_email;
    }

    public String getAdmin_phone() {
        return Admin_phone;
    }

    public void setAdmin_phone(String Admin_phone) {
        this.Admin_phone = Admin_phone;
    }

    public String getAdmin_password() {
        return Admin_password;
    }

    public void setAdmin_password(String Admin_password) {
        this.Admin_password = Admin_password;
    } 
    
    public Admin(){}
            
    
    public Admin(String ID, String Admin_name, String Admin_email, String Admin_phone, String Admin_password) {
        this.ID = ID;
        this.Admin_name = Admin_name;
        this.Admin_email = Admin_email;
        this.Admin_phone = Admin_phone;
        this.Admin_password = Admin_password;
    }  
}
