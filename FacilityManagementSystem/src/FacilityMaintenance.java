import java.util.Date;
import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;
import java.sql.*;


/**
 * Created by samhauck on 2/20/16.
 */

public class FacilityMaintenance {
    public Statement stmt = null;
    public float requestCounter = 0;

    public void makeFacilityMaintenanceRequest(Facility facility, String maintenanceRequest){

        scheduleMaintenance(facility, maintenanceRequest);
        System.out.println("A Maintenance Request for " + facility + " has been sumbitted.");
        requestCounter += 1;
    }

    public void scheduleMaintenance(Facility facility, String maintenanceRequest){
        facility.maintenanceRequest = maintenanceRequest;
        String newRequest = facility.maintenanceRequest;
        try {
            Connection c = openConnection();
            stmt = c.createStatement();
            String sql = "UPDATE Facilities SET MAINTENANCESCHEDULE to ? where ID = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, facility.maintenanceSchedule);
            ps.setInt(2, facility.ID);
            ps.executeUpdate();
            System.out.println("Maintenance for "+ facility + " has been scheduled.");


        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

    }

    public float calcMaintenanceCostForFacility(Facility facility){
        float maintenanceCost = facility.unitMaintenanceCost * requestCounter;
        String stringRequestCounter = Float.toString(requestCounter);
        try {
            Connection c = openConnection();
            stmt = c.createStatement();
            String sql = "UPDATE Facilities SET MINTENANCECOST to ? where ID = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, stringRequestCounter);
            ps.setInt(2, facility.ID);
            ps.executeUpdate();

            ps.close();
            stmt.close();
            c.close();


        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return maintenanceCost;
    }

    public int calcProblemRateForFacility(Facility facility){
        int problemRate = 0;
        return problemRate;
    }

    public int calcDowntimeForFacility(Facility facility){
        int downtime = 0;
        return downtime;

    }

    public String listMaintenanceRequests(Facility facility){
        try {
            Connection c = openConnection();
            stmt = c.createStatement();
            String sql = "SELECT MAINTENANCESCHEDULE FROM Facilities where ID = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, facility.ID);
            ps.executeQuery();

            String result = null;
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                result = rs.getString("INSPECTIONSCHEDULE");
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
        return facility.maintenanceSchedule;
    }

    public String listMaintenance(Facility facility){
        String maintenance = null;
        return maintenance;
    }

    public String listFacilityProblems(Facility facility){
        String problems = null;
        return problems;
    }

    public Connection openConnection() throws ClassNotFoundException, SQLException {
        String connectionURL = "jdbc:sqlite:FacilityManagementSystem.db";
        Class.forName("org.sqlite.JDBC");
        Connection con = DriverManager.getConnection(connectionURL);
        return con;
    }

}
