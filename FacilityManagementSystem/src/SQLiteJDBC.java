/**
 * Created by samhauck on 2/21/16.
 *
 */
//class for connecting to the database and creating the table.
import java.sql.*;

public class SQLiteJDBC {
    public static void Main(String args[]) {
        //starting connection to database
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:FacilityManagementSystem.db");

            //creating a table
            stmt = c.createStatement();
            String sql = "CREATE TABLE Facilities" +
                    "(ID INT PRIMARY KEY      NOT NULL" +
                    " NAME           TEXT     NOT NULL" +
                    " MANAGER        TEXT     NOT NULL" +
                    " USAGERATE      REAL     NOT NULL)";

            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        //System.out.println("Opened database sucessfully");



    }

}
