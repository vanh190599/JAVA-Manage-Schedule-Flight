/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author VanAnh
 */
public class Schedule {
   private String ID;
   private Date date;
   private String time;
   private String aircraftID;
   private String routeID;
   private String flightNumber;
   private double economyPrice;
   private boolean confirm ;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAircraftID() {
        return aircraftID;
    }

    public void setAircraftID(String aircraftID) {
        this.aircraftID = aircraftID;
    }

    public String getRouteID() {
        return routeID;
    }

    public void setRouteID(String routeID) {
        this.routeID = routeID;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public double getEconomyPrice() {
        return economyPrice;
    }

    public void setEconomyPrice(double economyPrice) {
        this.economyPrice = economyPrice;
    }
    
    //no day
    public boolean isConfirm() {
        return confirm;
    }

    public void setConfirm(boolean confirm) {
        this.confirm = confirm;
    }
    
    public Schedule(){
    
    }

    public Schedule(String ID, Date date, String time, String aircraftID, String routeID, String flightNumber, double economyPrice, boolean confirm) {
        this.ID = ID;
        this.date = date;
        this.time = time;
        this.aircraftID = aircraftID;
        this.routeID = routeID;
        this.flightNumber = flightNumber;
        this.economyPrice = economyPrice;
        this.confirm = confirm;
    } 
}


