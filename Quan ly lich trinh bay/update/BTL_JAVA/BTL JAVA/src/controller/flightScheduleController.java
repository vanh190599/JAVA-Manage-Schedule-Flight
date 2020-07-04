/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Airport;
import model.ShowListSchedule;

/**
 *
 * @author VanAnh
 */
public class flightScheduleController extends connection{
   //ham lay du lieu day len  flightScheduleController
    public  ArrayList<ShowListSchedule> getList () throws SQLException{
        ArrayList<ShowListSchedule> list = new ArrayList<>();
        
        String sql = "select * from Schedules "
                + "inner join Aircrafts on Schedules.AircraftID = Aircrafts.ID "
                + "inner join Routes on Schedules.RouteID = Routes.ID "
                + "inner join AirPorts on AirPorts.ID = Routes.ArrivalAiportID order by Date asc";
        
        Statement  st = (Statement) conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        while(rs.next()){
            ShowListSchedule obj = new ShowListSchedule();
            
            obj.setID(rs.getString("ID"));
            obj.setDate(rs.getDate("Date"));
            obj.setTime(rs.getString("Time"));
            obj.setFrom(rs.getString("DepartureAiportID")); //from
            obj.setTo(rs.getString("ArrivalAiportID")); //to
            obj.setFlightNumber(rs.getInt("FlightNumber"));
            obj.setMakeModel(rs.getString("MakeModel"));
            obj.setTotalSeats(rs.getInt("TotalSeats"));
            obj.setEconomyPrice(rs.getDouble("EconomyPrice"));
            obj.setBusinessPrice(rs.getDouble("EconomyPrice")*1.2);
            obj.setConfirm(rs.getBoolean("Confirmed"));
            
            list.add(obj);
        }
              
        return list;
    }
    
    public  ArrayList<ShowListSchedule> getListOrderBy (String orderBy) throws SQLException{
        ArrayList<ShowListSchedule> list = new ArrayList<>();
        
        //sort All theo Economy Price
        String sql = "select * from Schedules "
                + "inner join Aircrafts on Schedules.AircraftID = Aircrafts.ID "
                + "inner join Routes on Schedules.RouteID = Routes.ID "
                + "inner join AirPorts on AirPorts.ID = Routes.ArrivalAiportID order by '"+orderBy+"' asc";
        
        Statement  st = (Statement) conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        while(rs.next()){
            ShowListSchedule obj = new ShowListSchedule();
            
            obj.setID(rs.getString("ID"));
            obj.setDate(rs.getDate("Date"));
            obj.setTime(rs.getString("Time"));
            obj.setFrom(rs.getString("DepartureAiportID")); //from
            obj.setTo(rs.getString("ArrivalAiportID")); //to
            obj.setFlightNumber(rs.getInt("FlightNumber"));
            obj.setMakeModel(rs.getString("MakeModel"));
            obj.setTotalSeats(rs.getInt("TotalSeats"));
            obj.setEconomyPrice(rs.getDouble("EconomyPrice"));
            obj.setBusinessPrice(rs.getDouble("EconomyPrice")*1.2);
            obj.setConfirm(rs.getBoolean("Confirmed"));
            
            list.add(obj);
        }
              
        return list;
    }
    
    //
    public  ArrayList<ShowListSchedule> getListIsConfirm () throws SQLException{
        ArrayList<ShowListSchedule> list = new ArrayList<>();
        
        //sort All theo Economy Price
        String sql = "select * from Schedules "
                + "inner join Aircrafts on Schedules.AircraftID = Aircrafts.ID "
                + "inner join Routes on Schedules.RouteID = Routes.ID "
                + "inner join AirPorts on AirPorts.ID = Routes.ArrivalAiportID where Confirmed = 'true' ";
        
        Statement  st = (Statement) conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        while(rs.next()){
            ShowListSchedule obj = new ShowListSchedule();
            
            obj.setID(rs.getString("ID"));
            obj.setDate(rs.getDate("Date"));
            obj.setTime(rs.getString("Time"));
            obj.setFrom(rs.getString("DepartureAiportID")); //from
            obj.setTo(rs.getString("ArrivalAiportID")); //to
            obj.setFlightNumber(rs.getInt("FlightNumber"));
            obj.setMakeModel(rs.getString("MakeModel"));
            obj.setTotalSeats(rs.getInt("TotalSeats"));
            obj.setEconomyPrice(rs.getDouble("EconomyPrice"));
            obj.setBusinessPrice(rs.getDouble("EconomyPrice")*1.2);
            obj.setConfirm(rs.getBoolean("Confirmed"));
            
            list.add(obj);
        }
        
        //--------
        String sql2 = "select * from Schedules "
                + "inner join Aircrafts on Schedules.AircraftID = Aircrafts.ID "
                + "inner join Routes on Schedules.RouteID = Routes.ID "
                + "inner join AirPorts on AirPorts.ID = Routes.ArrivalAiportID where Confirmed = 'false' ";
        Statement  st2 = (Statement) conn.createStatement();
        ResultSet rs2 = st.executeQuery(sql2);
        
        while(rs2.next()){
            ShowListSchedule obj = new ShowListSchedule();
            
            obj.setID(rs2.getString("ID"));
            obj.setDate(rs2.getDate("Date"));
            obj.setTime(rs2.getString("Time"));
            obj.setFrom(rs2.getString("DepartureAiportID")); //from
            obj.setTo(rs2.getString("ArrivalAiportID")); //to
            obj.setFlightNumber(rs2.getInt("FlightNumber"));
            obj.setMakeModel(rs2.getString("MakeModel"));
            obj.setTotalSeats(rs2.getInt("TotalSeats"));
            obj.setEconomyPrice(rs2.getDouble("EconomyPrice"));
            obj.setBusinessPrice(rs2.getDouble("EconomyPrice")*1.2);
            obj.setConfirm(rs2.getBoolean("Confirmed"));
            
            list.add(obj);
        }
              
        return list;
    }
    
    //
    public  ArrayList<ShowListSchedule> getListFromToIsConfirm (String From, String To) throws SQLException{
        ArrayList<ShowListSchedule> list = new ArrayList<>();
        
        //sort All theo Economy Price
        String sql = "select * from Schedules "
                + "inner join Aircrafts on Schedules.AircraftID = Aircrafts.ID "
                + "inner join Routes on Schedules.RouteID = Routes.ID "
                + "inner join AirPorts on AirPorts.ID = Routes.ArrivalAiportID "
                + "where Confirmed = 'true' and DepartureAiportID= '"+ From +"' and ArrivalAiportID ='"+To+"'  ";
        
        Statement  st = (Statement) conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        while(rs.next()){
            ShowListSchedule obj = new ShowListSchedule();
            
            obj.setID(rs.getString("ID"));
            obj.setDate(rs.getDate("Date"));
            obj.setTime(rs.getString("Time"));
            obj.setFrom(rs.getString("DepartureAiportID")); //from
            obj.setTo(rs.getString("ArrivalAiportID")); //to
            obj.setFlightNumber(rs.getInt("FlightNumber"));
            obj.setMakeModel(rs.getString("MakeModel"));
            obj.setTotalSeats(rs.getInt("TotalSeats"));
            obj.setEconomyPrice(rs.getDouble("EconomyPrice"));
            obj.setBusinessPrice(rs.getDouble("EconomyPrice")*1.2);
            obj.setConfirm(rs.getBoolean("Confirmed"));
            
            list.add(obj);
        }
        //--------
        String sql2 = "select * from Schedules "
                + "inner join Aircrafts on Schedules.AircraftID = Aircrafts.ID "
                + "inner join Routes on Schedules.RouteID = Routes.ID "
                + "where Confirmed = 'false' and DepartureAiportID= '"+ From +"' and ArrivalAiportID ='"+To+"'  ";
        Statement  st2 = (Statement) conn.createStatement();
        ResultSet rs2 = st.executeQuery(sql2);
        
        while(rs2.next()){
            ShowListSchedule obj = new ShowListSchedule();
            
            obj.setID(rs2.getString("ID"));
            obj.setDate(rs2.getDate("Date"));
            obj.setTime(rs2.getString("Time"));
            obj.setFrom(rs2.getString("DepartureAiportID")); //from
            obj.setTo(rs2.getString("ArrivalAiportID")); //to
            obj.setFlightNumber(rs2.getInt("FlightNumber"));
            obj.setMakeModel(rs2.getString("MakeModel"));
            obj.setTotalSeats(rs2.getInt("TotalSeats"));
            obj.setEconomyPrice(rs2.getDouble("EconomyPrice"));
            obj.setBusinessPrice(rs2.getDouble("EconomyPrice")*1.2);
            obj.setConfirm(rs2.getBoolean("Confirmed"));
            
            list.add(obj);
        }
              
        return list;
    }
    
    //ham lay du lieu day len  combobox
    public  ArrayList<Airport> getToAndFrom () throws SQLException{
        ArrayList<Airport> list = new ArrayList<>();
        
        String sql = "select * from AirPorts";
        
        Statement  st = (Statement) conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        while(rs.next()){
            Airport obj = new Airport();
            
            obj.setIATAcode(rs.getString("IATAcode"));
              
            list.add(obj);
        }   
        return list;
    }
    
    //Disnal or Enable
    public void cancelFight(String ID ,boolean isConfirm) throws SQLException{
        String sql = "update Schedules set Confirmed = '"+isConfirm+"' where ID='"+ ID +"' ";
        
        Statement st = conn.createStatement();
        st.executeUpdate(sql);
    }
    

    
    public ArrayList<String> details (String FlightNumber1, String MakeModel) throws SQLException{
        
        ArrayList<String> list = new ArrayList<>();
        
        String sql =" select AirPorts.Name as 'DepartureAirport_name', "
                + "    Countries.Name as 'Departure_country_name' from Schedules "
                + "    inner join Routes on Schedules.RouteID = Routes.ID"
                + "    inner join AirPorts on Routes.DepartureAiportID = AirPorts.ID "
                + "    inner join Countries on AirPorts.CountryID = Countries.ID"
                + "    where FlightNumber = '"+FlightNumber1+"' ";
        
        Statement  st = (Statement) conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()){
            list.add(rs.getString("DepartureAirport_name"));
            list.add(rs.getString("Departure_country_name"));
            
        }  
        
        //---------------------------------------------
        String sql2 =" select ArrivalAiportID, AirPorts.Name as 'ArrivalAirport_name', Countries.Name as 'Arrival_country_name', "
                + "Distance from Schedules inner join Routes on Schedules.RouteID = Routes.ID "
                + "inner join AirPorts on Routes.ArrivalAiportID = AirPorts.ID "
                + "inner join Countries on AirPorts.CountryID = Countries.ID "
                + "where FlightNumber = '"+FlightNumber1+"'  ";
        
        Statement  st2 = (Statement) conn.createStatement();
        ResultSet rs2 = st2.executeQuery(sql2);
        
        while(rs2.next()){
            list.add(rs2.getString("ArrivalAirport_name"));
            list.add(rs2.getString("Arrival_country_name"));
            list.add(rs2.getString("Distance"));
        }  
        
         
        String sql3 = "select Name as 'airport_name' from Aircrafts where MakeModel = '"+ MakeModel +"' ";
        Statement  st3 = (Statement) conn.createStatement();
        ResultSet rs3 = st3.executeQuery(sql3);
        
        while(rs3.next()){
            list.add(rs3.getString("airport_name"));
        } 
        
        return list;
        
    }
    
    
    public void update(String FlightNumber, String date, String time, String price) throws SQLException{
        String sql = "update Schedules set Date = '"+date+"', Time = '"+time+"', EconomyPrice = '"+price+"' where FlightNumber = '"+FlightNumber+"'  "; 

        Statement st = conn.createStatement();
        st.executeUpdate(sql);  
       
    }

    public ArrayList<ShowListSchedule> filter(String From, String To, String SortBy, String Date, String FlightNumber) throws SQLException{
        ArrayList<ShowListSchedule> list = new ArrayList<>();
        
        String sql = "select * from Schedules "
                + "inner join Aircrafts on Schedules.AircraftID = Aircrafts.ID "
                + "inner join Routes on Schedules.RouteID = Routes.ID "
                + "inner join AirPorts on AirPorts.ID = Routes.ArrivalAiportID WHERE ";
        
        System.out.println("so hieu = " + FlightNumber);
        if(From.length() == 3) sql+= "DepartureAiportID = '"+From+"'  and ";
        if(To.length() == 3) sql+= "ArrivalAiportID = '"+To+"' and ";
        if(!Date.equals("")) sql+= "Date = '"+Date+"' and ";
        if(!FlightNumber.equals("")) sql+= "FlightNumber = '"+FlightNumber+"'  and ";
        if(From.length() > 3 && To.length() > 3 && Date.equals("") && FlightNumber.equals("") ){
            sql = sql.substring(0, sql.length()-6);
        }
        //Bây giờ mình sẽ sử  dụng cắt chuỗi từ trái sang phải lấy ra 3 ký tự: (ABC)
        else sql = sql.substring(0, sql.length()-4);
        
        //-------- order by --------------
        if(SortBy.equals("DateTime")){
            sql+= "order by Date asc";
        }
        else if(SortBy.equals("EconomyPrice")){
            sql+= "order by EconomyPrice asc";
        }
        
        Statement  st = (Statement) conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        System.out.println(sql);
        
        while(rs.next()){
            ShowListSchedule obj = new ShowListSchedule();
            
            obj.setID(rs.getString("ID"));
            obj.setDate(rs.getDate("Date"));
            obj.setTime(rs.getString("Time"));
            obj.setFrom(rs.getString("DepartureAiportID")); //from
            obj.setTo(rs.getString("ArrivalAiportID")); //to
            obj.setFlightNumber(rs.getInt("FlightNumber"));
            obj.setMakeModel(rs.getString("MakeModel"));
            obj.setTotalSeats(rs.getInt("TotalSeats"));
            obj.setEconomyPrice(rs.getDouble("EconomyPrice"));
            obj.setBusinessPrice(rs.getDouble("EconomyPrice")*1.2);
            obj.setConfirm(rs.getBoolean("Confirmed"));
            
            list.add(obj);
        }
        
        //ShowListSchedule obj1 = new ShowListSchedule();
        
        //sắp xếp confirm với Array list truyền vào
        //Riêng SortBy confirm, 
        if(SortBy.equals("Confirm")){
            return isConf(list);
        }
        
        return list;
    }
            
    //cach 1: day array list
    public ArrayList<ShowListSchedule> isConf(ArrayList<ShowListSchedule> list){
        ArrayList<ShowListSchedule> listfinal = new ArrayList<>();
        
        //duyệt những object nào là True thì gán vào trước, sau là false
        for(int i=0; i<list.size() ; i++){
            ShowListSchedule obj = new ShowListSchedule();
            obj = list.get(i);
            if(obj.isConfirm()){
                listfinal.add(obj);
            }
        }
        //nguoc lai
        for(int i=0; i<list.size() ; i++){
            ShowListSchedule obj = new ShowListSchedule();
            obj = list.get(i);
            if(!obj.isConfirm()){
                listfinal.add(obj);
            }
        }
        
        return listfinal;    
    }
}
