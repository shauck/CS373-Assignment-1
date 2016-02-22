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
    Connection c = DriverManager.getConnection("jdbc:sqlite:FacilityManagementSystem.db");
    Statement stmt = null;

    public Facility(int ID, String facilityName, String facilityManager, String maintenenceSchedule, String usageSchedule, float usageRate, int problemCounter){
        this.ID = ID;
        this.facilityName = facilityName;
        this.facilityManager = facilityManager;
        this.maintenenceSchedule = maintenenceSchedule;
        this.usageSchedule = usageSchedule;
        this.usageRate = usageRate;
        this.problemCounter = problemCounter;

        try {
            openConnection();
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


    public void changeName(String newName) {
        facilityName = newName;
    }

    public void changeManager(String newManager) {
        facilityManager = newManager;
    }

    public void changeMaintenenceSchedule(String newSchedule) {
        maintenenceSchedule = newSchedule;
    }


    public void changeUsageSchedule(String newSchedule) {
        usageSchedule = newSchedule;
    }

    public void changeUsageRate(Float newRate) {
        usageRate = newRate;
    }


    public String getFacilityInformation(Facility facility) {
        String info = ("Facility Name: " + facility.facilityName + "\nFacility Manager: " +
                facility.facilityManager + "\nMaintenence Schedule: " + facility.maintenenceSchedule +
                "\nUsage Rate: " + facility.usageRate);


        return info;
    }

    public void openConnection() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:FacilityManagementSystem.db");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }


    }
}
