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
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Aircaft;
import model.Airport;
import model.Route;

/**
 *
 * @author VanAnh
 */
public class MyAirportController extends connection {

    //ham lay du lieu day len  aircaft
    public ArrayList<Aircaft> getList() throws SQLException {
        ArrayList<Aircaft> list = new ArrayList<>();

        String sql = "select * from Aircrafts ";

        Statement st = (Statement) conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            Aircaft obj = new Aircaft();

            obj.setID(rs.getString("ID"));
            obj.setName(rs.getString("Name"));
            obj.setMakeModel(rs.getString("MakeModel"));
            obj.setTotalSeats(rs.getInt("TotalSeats"));
            obj.setEconomySeats(rs.getInt("EconomySeats"));
            obj.setBusinessSeats(rs.getInt("BusinessSeats"));

            list.add(obj);
        }
        return list;
    }

    // tim kiem theo id
    public ArrayList<Aircaft> SearchByID(String ID) throws SQLException {
        ArrayList<Aircaft> list = new ArrayList<>();
        String sql = "select * from Aircrafts where ID = '" + ID + "'   ";

        Statement st = (Statement) conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            Aircaft obj = new Aircaft();

            obj.setID(rs.getString("ID"));
            obj.setName(rs.getString("Name"));
            obj.setMakeModel(rs.getString("MakeModel"));
            obj.setTotalSeats(rs.getInt("TotalSeats"));
            obj.setEconomySeats(rs.getInt("EconomySeats"));
            obj.setBusinessSeats(rs.getInt("BusinessSeats"));

            list.add(obj);
        }
        return list;
    }

    // lay du lieu trong bang Route
    public ArrayList<Route> getListRoute() throws SQLException {
        ArrayList<Route> list = new ArrayList<>();

        String sql = "select * from Routes ";

        Statement st = (Statement) conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            Route obj = new Route();
            obj.setID(rs.getString("ID"));
            obj.setDepartureAiportID(rs.getString("DepartureAiportID"));
            obj.setArrivalAiportID(rs.getString("ArrivalAiportID"));
            obj.setDistance(rs.getInt("Distance"));
            obj.setFlightTime(rs.getString("FlightTime"));

            list.add(obj);
        }
        return list;
    }

    // tim kiem theo id
    public ArrayList<Route> SearchRouteByID(String ID) throws SQLException {
        ArrayList<Route> list = new ArrayList<>();
        String sql = "select * from Routes where ID = '" + ID + "'   ";

        Statement st = (Statement) conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            Route obj = new Route();
            obj.setID(rs.getString("ID"));
            obj.setDepartureAiportID(rs.getString("DepartureAiportID"));
            obj.setArrivalAiportID(rs.getString("ArrivalAiportID"));
            obj.setDistance(rs.getInt("Distance"));
            obj.setFlightTime(rs.getString("FlightTime"));

            list.add(obj);
        }
        return list;
    }

    public void addRoute(Route ad) throws SQLException {
        boolean check_ID = false;
        boolean check_Route = false;

        //check ID
        String sql_checkID = "select * from Routes where ID = '" + ad.getID() + "'";

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql_checkID);

        if (rs.next()) {
            check_ID = true;
        }
        //check departureAirport && arrivalAirportID
        String sql_checkRoute = "select * from Routes where DepartureAiportID = '" + ad.getDepartureAiportID() + "' and ArrivalAiportID = '" + ad.getArrivalAiportID() + "'";

        Statement st1 = conn.createStatement();
        ResultSet rs1 = st1.executeQuery(sql_checkRoute);
        if (rs1.next()) {
            check_Route = true;
        }
        if (check_ID) {
            JOptionPane.showMessageDialog(null, "Sorry, ID already exists");
        } else {
            if (check_Route) {
                JOptionPane.showMessageDialog(null, "Sorry, Flight route already exists");
            } else {
                //add---------
                String sql = "insert into Routes values('" + ad.getID() + "','" + ad.getDepartureAiportID() + "','" + ad.getArrivalAiportID() + "','" + ad.getDistance() + "','" + ad.getFlightTime() + "')";
                JOptionPane.showMessageDialog(null, "Add sucessful");
                //thuc thi truy van
                st = conn.createStatement();
                st.executeUpdate(sql);
            }
        }

    }

    public void updateRoute(String ID, String Departure, String Arrival, int Distance, String FlightTime) throws SQLException {
        //update
        String sql = "update Routes set DepartureAiportID = ? ,ArrivalAiportID = ?,  Distance = ?, FlightTime = ? where ID = ? ";
        PreparedStatement ps = conn.prepareStatement(sql);
        //gan gia tri theo thuc tu "?"
        ps.setString(1, Departure);
        ps.setString(2, Arrival);
        ps.setInt(3, Distance);
        ps.setString(4, FlightTime);
        ps.setString(5, ID);
        //Thuc thi truy van update
        ps.executeUpdate();
    }

    //ham lay du lieu day len  combobox
    public ArrayList<Airport> getToAndFrom() throws SQLException {
        ArrayList<Airport> list = new ArrayList<>();

        String sql = "select * from AirPorts";

        Statement st = (Statement) conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            Airport obj = new Airport();

            obj.setIATAcode(rs.getString("IATAcode"));

            list.add(obj);
        }
        return list;
    }
}
