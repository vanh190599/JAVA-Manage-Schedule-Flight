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
public class ShowListSchedule {
    private String ID;
    private Date date;
    private String  time;
    private String  from;
    private String to;
    private int flightNumber;
    private String makeModel;
    private int totalSeats;
    private double economyPrice;
    private double businessPrice;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    private boolean confirm;

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

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public double getEconomyPrice() {
        return economyPrice;
    }

    public void setEconomyPrice(double economyPrice) {
        this.economyPrice = economyPrice;
    }

    public double getBusinessPrice() {
        return businessPrice;
    }

    public void setBusinessPrice(double businessPrice) {
        this.businessPrice = businessPrice;
    }

    public boolean isConfirm() {
        return confirm;
    }

    public void setConfirm(boolean confirm) {
        this.confirm = confirm;
    }
    
    public ShowListSchedule(){
    
    }
    
    public ShowListSchedule(String ID ,Date date, String time, String from, String to, int flightNumber, String makeModel, int totalSeats, double economyPrice, double businessPrice, boolean confirm) {
        this.ID = ID;
        this.date = date;
        this.time = time;
        this.from = from;
        this.to = to;
        this.flightNumber = flightNumber;
        this.makeModel = makeModel;
        this.totalSeats = totalSeats;
        this.economyPrice = economyPrice;
        this.businessPrice = businessPrice;
        this.confirm = confirm;
    }
}
