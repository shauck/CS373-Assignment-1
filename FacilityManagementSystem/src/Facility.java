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
    public String maintenanceSchedule;
    public String usageSchedule;
    public float usageRate;
    public int problemCounter;
    public float unitMaintenanceCost;
    public String currentUse;
    public String inspectionSchedule;
    public String maintenanceRequest = null;
    public Statement stmt = null;

    public Facility( int ID, String facilityName, String facilityManager, String maintenenceSchedule, String usageSchedule, float usageRate, int problemCounter, String currentUse, String inspectionSchedule, float hourlyMaintenanceCost){
        this.ID = ID;
        this.facilityName = facilityName;
        this.facilityManager = facilityManager;
        this.maintenanceSchedule = maintenenceSchedule;
        this.usageSchedule = usageSchedule;
        this.usageRate = usageRate;
        this.problemCounter = problemCounter;
        this.currentUse = currentUse;
        this.inspectionSchedule = inspectionSchedule;
        this.unitMaintenanceCost = hourlyMaintenanceCost;


        try {
            Connection c = openConnection();
            stmt = c.createStatement();
            String sql = "INSERT INTO Facilities (ID, NAME, MANAGER, MAINTENANCESCHEDULE, USAGESCHEDULE, USAGERATE, PROBLEMCOUNTER, HOURLYMAINTENANCECOST, CURRENTUSE, INSPECTIONSCHEDULE, MAINTENANCEREQUEST) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NULL)";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, this.ID);
            ps.setString(2, this.facilityName);
            ps.setString(3, this.facilityManager);
            ps.setString(4, this.maintenanceSchedule);
            ps.setString(6, this.usageSchedule);
            ps.setFloat(5, this.usageRate);
            ps.setInt(7, this.problemCounter);
            ps.setFloat(8, this.unitMaintenanceCost);
            ps.setString(8, this.currentUse);
            ps.setString(9, this.inspectionSchedule);
            ps.executeUpdate();

            ps.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }


    public void changeName(Facility facility, String newName) {
        facility.facilityName = newName;
        try{
            Connection c = openConnection();
            stmt = c.createStatement();
            String sql = "UPDATE Facilities set NAME = ? where ID = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, facility.facilityName);
            ps.setInt(2, facility.ID);
            ps.executeUpdate();

            ps.close();
            stmt.close();
            c.close();

        } catch (Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public void changeManager(Facility facility, String newManager) {
        facility.facilityManager = newManager;
        try{
            Connection c = openConnection();
            stmt = c.createStatement();
            String sql = "UPDATE Facilities set MANAGER = ? where ID = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, facility.facilityManager);
            ps.setInt(2, facility.ID);
            ps.executeUpdate();

            ps.close();
            stmt.close();
            c.close();

        } catch (Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public void changeMaintenanceSchedule(Facility facility, String newSchedule) {
        facility.maintenanceSchedule = newSchedule;
        try{
            Connection c = openConnection();
            stmt = c.createStatement();
            String sql = "UPDATE Facilities set MAINTENANCESCHEDULE = ? where ID = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, facility.maintenanceSchedule);
            ps.setInt(2, facility.ID);
            ps.executeUpdate();

            ps.close();
            stmt.close();
            c.close();

        } catch (Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }


    public void changeUsageSchedule(Facility facility, String newSchedule) {
        facility.usageSchedule = newSchedule;
        try{
            Connection c = openConnection();
            stmt = c.createStatement();
            String sql = "UPDATE Facilities set USAGESCHEDULE = ? where ID = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, facility.usageSchedule);
            ps.setInt(2, facility.ID);
            ps.executeUpdate();

            ps.close();
            stmt.close();
            c.close();

        } catch (Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public void changeUsageRate(Facility facility, Float newRate) {
        facility.usageRate = newRate;
        try{
            Connection c = openConnection();
            stmt = c.createStatement();
            String sql = "UPDATE Facilities set USAGERATE = ? where ID = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setFloat(1, facility.usageRate);
            ps.setInt(2, facility.ID);
            ps.executeUpdate();

            ps.close();
            stmt.close();
            c.close();

        } catch (Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }


    public void getFacilityInformation(int id) {
        try{
            Connection c = openConnection();
            stmt = c.createStatement();
            String sql = "SELECT * FROM Facilities where ID = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeQuery();

            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()){
                int i = rs.getInt("ID");
                String name = rs.getString("NAME");
                String manager = rs.getString("MANAGER");
                String mSchedule = rs.getString("MAINTENANCESCHEDULE");
                String uSchedule = rs.getString("USAGESCHEDULE");
                Float rate = rs.getFloat("USAGERATE");
                int problems = rs.getInt("PROBLEMCOUNT");
                float mCost = rs.getFloat("UNITMAINTENANCECOST");
                String cUse = rs.getString("CURRENTUSE");
                String iSchedule = rs.getString("INSPECTIONSCHEDULE");
                String mRequest = rs.getString("MAINTENANCEREQUEST");
                System.out.println("ID = " + i);
                System.out.println("Facility name = " + name);
                System.out.println("Facility Manager = " + manager);
                System.out.println("Maintenance Schedule = " + mSchedule);
                System.out.println("Usage Rate = "+ rate);
                System.out.println("Usage Schedule = " + uSchedule);
                System.out.println("No. of Facility Problems = " + problems);
                System.out.println("Facility Maintenance Cost = " + mCost);
                System.out.println("Facility Current use = " + cUse);
                System.out.println("Facility Inspection Schedule = " + iSchedule);
                System.out.println("Latest Facility Maintenance Request = " + mRequest);
                System.out.println();
            }
            rs.close();
            stmt.close();
            ps.close();
            c.close();
        } catch (Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public Connection openConnection() throws ClassNotFoundException, SQLException {
        String connection = "jdbc:sqlite:FacilityManagementSystem.db";
        Class.forName("org.sqlite.JDBC");
        Connection con = DriverManager.getConnection(connection);
        return con;



    }

}

