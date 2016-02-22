/**
 * Created by samhauck on 2/20/16.
 */


import java.io.*;
import java.lang.*;
import java.lang.reflect.*;
import java.util.*;
import java.math.*;
import java.sql.*;

public class Facility {

    public int ID;
    public String facilityName;
    public String facilityManager;
    public String maintenenceSchedule;
    public String usageSchedule;
    public float usageRate;
    public int problemCounter;
    public Connection c = DriverManager.getConnection("jdbc:sqlite:FacilityManagementSystem.db");
    public Statement stmt = null;

    public Facility(int ID, String facilityName, String facilityManager, String maintenenceSchedule, String usageSchedule, float usageRate, int problemCounter, Connection c){
        this.ID = ID;
        this.facilityName = facilityName;
        this.facilityManager = facilityManager;
        this.maintenenceSchedule = maintenenceSchedule;
        this.usageSchedule = usageSchedule;
        this.usageRate = usageRate;
        this.problemCounter = problemCounter;

        try {
            openConnection(c);
            stmt = c.createStatement();
            String sql = "INSERT INTO Facilities (ID, NAME, MANAGER, MAINTENANCESCHEDULE, USAGESCHEDULE, USAGERATE, PROBLEMCOUNTER) " +
                         "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, this.ID);
            ps.setString(2, this.facilityName);
            ps.setString(3, this.facilityManager);
            ps.setString(4, this.maintenenceSchedule);
            ps.setString(5, this.usageSchedule);
            ps.setFloat(6, this.usageRate);
            ps.setInt(7, this.problemCounter);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }


    public void changeName(Facility facility, String newName) {
        this.facilityName = newName;
        try{
            openConnection(c);
            stmt = c.createStatement();
            String sql = "UPDATE Facilities set NAME = ? where ID = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, this.facilityName);
            ps.setInt(2, this.ID);

        } catch (Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public void changeManager(Facility facility, String newManager) {
        this.facilityManager = newManager;
        try{
            openConnection(c);
            stmt = c.createStatement();
            String sql = "UPDATE Facilities set MANAGER = ? where ID = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, this.facilityManager);
            ps.setInt(2, this.ID);

        } catch (Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public void changeMaintenenceSchedule(Facility facility, String newSchedule) {
        this.maintenenceSchedule = newSchedule;
        try{
            openConnection(c);
            stmt = c.createStatement();
            String sql = "UPDATE Facilities set MAINTENANCESCHEDULE = ? where ID = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, this.maintenenceSchedule);
            ps.setInt(2, this.ID);

        } catch (Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }


    public void changeUsageSchedule(Facility facility, String newSchedule) {
        this.usageSchedule = newSchedule;
        try{
            openConnection(c);
            stmt = c.createStatement();
            String sql = "UPDATE Facilities set USAGESCHEDULE = ? where ID = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, this.usageSchedule);
            ps.setInt(2, this.ID);

        } catch (Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public void changeUsageRate(Facility facility, Float newRate) {
        this.usageRate = newRate;
        try{
            openConnection(c);
            stmt = c.createStatement();
            String sql = "UPDATE Facilities set USAGERATE = ? where ID = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setFloat(1, this.usageRate);
            ps.setInt(2, this.ID);

        } catch (Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }


    public String getFacilityInformation(Facility facility, int id) {
        try{
            openConnection(c);
            stmt = c.createStatement();
            String sql = "SELECT * FROM Facilities where ID = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, this.ID);

            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()){
                int i = rs.getInt("ID");
                String name = rs.getString("NAME");
                String manager = rs.getString("MANAGER");
                String mSchedule = rs.getString("MAINTENANCESCHEDULE");
                String uSchedule = rs.getString("USAGESCHEDULE");
                Float rate = rs.getFloat("USAGERATE");
                int problems = rs.getInt("PROBLEMCOUNT");
                System.out.println("ID = " + i);
                System.out.println("Facility name = " + name);
                System.out.println("Facility Manager = " + manager);
                System.out.println("Maintenance Schedule = " + mSchedule);
                System.out.println("Usage Schedule = " + uSchedule);
                System.out.println("Usage Rate = "+ rate);
                System.out.println("No. of Facility Problems = " + problems);
                System.out.println();
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public void openConnection(Connection c) {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:FacilityManagementSystem.db");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }


    }
}
