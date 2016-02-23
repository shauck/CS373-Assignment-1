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


        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public void vacateFacility(Facility facility) {
        facility.currentUse = null;
        try {
            Connection c = openConnection();
            String sql = "UPDATE Facilities SET CURRENTUSE "
        } catch (Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

    }

    public Date[] ListInspections(Facility facility){
        //Not sure what this should be doing
    }

    public Float listActualUsage (Facility facility){
        System.out.println(facility.usageSchedule);
    }

    public Float calcUsageRate(Facility facility){
        //can you do this one, since you were saying that rate is price?
    }

    public Connection openConnection() throws ClassNotFoundException, SQLException {
        String connectionURL = "jdbc:sqlite:FacilityManagementSystem.db";
        Class.forName("org.sqlite.JDBC");
        Connection con = DriverManager.getConnection(connectionURL);
        return con;
    }
}
