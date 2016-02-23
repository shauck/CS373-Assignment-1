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

    public Array makeFacilityMaintenenceRequest(Facility facility, String maintenenceDate){
        facility.maintenenceSchedule += maintenenceDate;

    }

    public String scheduleMaintenance(Facility facility){
        try {
            Connection c = openConnection();
            stmt = c.createStatement();
            String sql = "UPDATE Facilities SET MAINTENANCESCHEDULE to ? where ID = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, facility.maintenenceSchedule);
            ps.setInt(2, facility.ID);
            ps.executeUpdate();


        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public Float calcMaintenanceCostForFacility(Facility facility, Float unitCost, Float numMaintenanceRequests){
        Float maintenenceCost = unitCost * numMaintenanceRequests;
        return maintenenceCost;
    }

    public Float calcProblemRateForFacility(Facility facility){

    }

    public Float calcDowntimeForFacility(Facility facility){

    }

    public Date[] listMaintenanceRequests(Facility facility){
        System.out.println(facility.maintenenceSchedule);
    }

    public Date[] listMaintenance(Facility facility){

    }

    public String[] listFacilityProblems(Facility facility){

    }

    public Connection openConnection() throws ClassNotFoundException, SQLException {
        String connectionURL = "jdbc:sqlite:FacilityManagementSystem.db";
        Class.forName("org.sqlite.JDBC");
        Connection con = DriverManager.getConnection(connectionURL);
        return con;
    }

}
