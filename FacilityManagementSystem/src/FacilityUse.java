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

    public boolean isInUseDuringInterval(Facility facility, int startTime, int endTime, int currentDate){
        if (startTime <= currentDate && endTime >= currentDate){
            return Boolean.TRUE;
        }
        else{
            return Boolean.FALSE;
        }
    }

    public void assignFacilityToUse(Facility facility){
        //Not sure what this should be doing
    }

    public void vacateFacility(Facility facility) {
        facility.isFacilityInUse = Boolean.FALSE;
        facility.usageSchedule = null;
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
}
