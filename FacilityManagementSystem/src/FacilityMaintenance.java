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


    public Array makeFacilityMaintenenceRequest(Facility facility, String maintenenceDate){
        facility.maintenenceSchedule += maintenenceDate;

    }

    public Date scheduleMaintenance(Facility facility){

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

}
