/**
 * Created by samhauck on 2/20/16.
 */

import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;
import java.sql.*;
import java.util.Date;


public class FacilityUse {
    public Statement stmt = null;


    public boolean isInUseDuringInterval(Facility facility, int startTime, int endTime, int currentDate){
        if (startTime <= currentDate && endTime >= currentDate){
            return Boolean.TRUE;
        }
        else{
            return Boolean.FALSE;
        }
    }

    public void assignFacilityToUse(Facility facility, String use){
        facility.currentUse = use;
        try {
            Connection c = openConnection();
            stmt = c.createStatement();
            String sql = "UPDATE Facilities SET CURRENTUSE to ? where ID = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, facility.currentUse);
            ps.setInt(2, facility.ID);
            ps.executeUpdate();

            ps.close();
            stmt.close();
            c.close();


        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public void vacateFacility(Facility facility) {
        facility.currentUse = null;
        try {
            Connection c = openConnection();
            String sql = "UPDATE Facilities SET CURRENTUSE to NULL where ID = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, facility.ID);
            ps.executeUpdate();
        } catch (Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

    }

    public String ListInspections(Facility facility){
        String result = null;
        try {
            Connection c = openConnection();
            String sql = "SELECT INSPECTIONSCHEDULE FROM Facilities WHERE ID = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, facility.ID);
            ps.executeQuery();

            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                result = rs.getString("INSPECTIONSCHEDULE");
                System.out.println(result);
                System.out.println();
            }
            rs.close();
            ps.close();
            c.close();
        } catch (Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return result;
    }

    public String listActualUsage (Facility facility) {
        System.out.println(facility.usageSchedule);

        String result = null;
        try {
            Connection c = openConnection();
            String sql = "SELECT USAGESCHEDULE FROM Facilities WHERE ID = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, facility.ID);
            ps.executeQuery();

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result = rs.getString("USAGESCHEDULE");
                System.out.println(result);
                System.out.println();
            }
            rs.close();
            ps.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return result;
    }


    public float calcUsageRate(Facility facility, int hours){
        float rate = facility.usageRate;
        float totalrate = rate * hours;
        System.out.println("The rate for the " + facility + " for " + hours + " hours is $" + totalrate);
        return totalrate;
    }

    public Connection openConnection() throws ClassNotFoundException, SQLException {
        String connectionURL = "jdbc:sqlite:FacilityManagementSystem.db";
        Class.forName("org.sqlite.JDBC");
        Connection con = DriverManager.getConnection(connectionURL);
        return con;
    }
}
