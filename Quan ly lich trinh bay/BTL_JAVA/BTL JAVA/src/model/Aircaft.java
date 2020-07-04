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
public class Aircaft {
    private String ID;
    private String name;
    private String makeModel;
    private int totalSeats;
    private int economySeats;
    private int BusinessSeats;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    public String getName() {
        return ID;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getEconomySeats() {
        return economySeats;
    }

    public void setEconomySeats(int economySeats) {
        this.economySeats = economySeats;
    }

    public int getBusinessSeats() {
        return BusinessSeats;
    }

    public void setBusinessSeats(int BusinessSeats) {
        this.BusinessSeats = BusinessSeats;
    }
    
    public Aircaft(){}
    
    public Aircaft(String ID,String name, String makeModel, int totalSeats, int economySeats, int BusinessSeats) {
        this.ID = ID;
        this.name = name;
        this.makeModel = makeModel;
        this.totalSeats = totalSeats;
        this.economySeats = economySeats;
        this.BusinessSeats = BusinessSeats;
    }
}
