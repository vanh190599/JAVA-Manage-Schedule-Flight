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
public class Airport {
    private String ID;
    private String countryID;
    private String IATAcode;
    private String name;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getCountryID() {
        return countryID;
    }

    public void setCountryID(String countryID) {
        this.countryID = countryID;
    }

    public String getIATAcode() {
        return IATAcode;
    }

    public void setIATAcode(String IATAcode) {
        this.IATAcode = IATAcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Airport(){
    
    }
    
    
    
    public Airport(String ID, String countryID, String IATAcode, String name) {
        this.ID = ID;
        this.countryID = countryID;
        this.IATAcode = IATAcode;
        this.name = name;
    }

    @Override
    public String toString() {
        return IATAcode; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
