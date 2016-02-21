/**
 * Created by samhauck on 2/20/16.
 */


import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;
import java.sql.*;

public class Facility {

    public String facilityName;
    public String facilityManager;
    public String maintenenceSchedule;
    public float usageRate;
    public int problemCounter;



    public void changeName(String newName){
        facilityName = newName;
    }

    public void changeManager(String newManager){
        facilityManager = newManager;
    }

    public void changeMaintenenceSchedule(String newSchedule){
        maintenenceSchedule = newSchedule;
    }

    public void changeUsageRate(Float newRate){
        usageRate = newRate;
    }




    public String getFacilityInformation(Facility facility){
        String info = ("Facility Name: " + facility.facilityName +"\nFacility Manager: " +
                facility.facilityManager + "\nMaintenence Schedule: " + facility.maintenenceSchedule +
                "\nUsage Rate: " + facility.usageRate);

        return info;
    }
}
