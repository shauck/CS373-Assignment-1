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

    public String makeFacilityMaintenanceRequest(Facility facility, String maintenanceDate){
        String mS = facility.maintenanceSchedule;
        mS = mS + maintenanceDate;
        return mS;
    }

    public String scheduleMaintenance(Facility facility){
        try {
            Connection c = openConnection();
            stmt = c.createStatement();
            String sql = "UPDATE Facilities SET MAINTENANCESCHEDULE to ? where ID = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, facility.maintenanceSchedule);
            ps.setInt(2, facility.ID);
            ps.executeUpdate();


        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return facility.maintenanceSchedule;
    }

    public Float calcMaintenanceCostForFacility(Facility facility){
        Float maintenenceCost = unitCost * numMaintenanceRequests;
        return maintenenceCost;
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
