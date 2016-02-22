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

    public boolean isInUseDuringInterval(Facility facility, int startTime, int endTime){
        if (facility.isFacilityInUse == Boolean.TRUE){

        }
    }

    public void assignFacilityToUse(Facility facility){

    }

    public void vacateFacility(Facility facility) {
        facility.isFacilityInUse = Boolean.FALSE;
        facility.usageSchedule = null;
    }

    public Date[] ListInspections(Facility facility){

    }

    public Float listActualUsage (Facility facility){

    }

    public Float calcUsageRate(Facility facility){

    }
}
