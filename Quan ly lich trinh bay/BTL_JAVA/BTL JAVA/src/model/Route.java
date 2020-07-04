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
public class Route {
    private String ID;
    private String DepartureAiportID;
    private String ArrivalAiportID;
    private int Distance;
    private String FlightTime;

    public String getID(){
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
    public String getDepartureAiportID() {
        return DepartureAiportID;
    }

    public void setDepartureAiportID(String DepartureAiportID) {
        this.DepartureAiportID = DepartureAiportID;
    }

    public String getArrivalAiportID() {
        return ArrivalAiportID;
    }

    public void setArrivalAiportID(String ArrivalAiportID) {
        this.ArrivalAiportID = ArrivalAiportID;
    }

    public int getDistance() {
        return Distance;
    }

    public void setDistance(int Distance) {
        this.Distance = Distance;
    }

    public String getFlightTime() {
        return FlightTime;
    }

    public void setFlightTime(String FlightTime) {
        this.FlightTime = FlightTime;
    }
    
    public Route(){
        
    }
    
    public Route(String DepartureAiportID, String ArrivalAiportID){
        this.DepartureAiportID = DepartureAiportID;
        this.ArrivalAiportID = ArrivalAiportID;
    }
    
    public Route(String ID, String DepartureAiportID, String ArrivalAiportID, int Distance, String FlightTime) {
        this.ID = ID;
        this.DepartureAiportID = DepartureAiportID;
        this.ArrivalAiportID = ArrivalAiportID;
        this.Distance = Distance;
        this.FlightTime = FlightTime;
    } 
    
    @Override
    public String toString() {
        return DepartureAiportID;
    } 
}
