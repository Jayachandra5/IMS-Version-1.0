package projectbms;

import java.sql.*;
import java.util.*;

public class empAttandnce {
    public static void createNewTable() {
        // SQLite connection string
       // String url = "jdbc:sqlite:V://projectBms/bmsemplist1.db";
       
       String url = Constants.employeeDB;
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS "+Constants.employeeAttendanceTable+" (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	empname text NOT NULL,\n"
                + "	wd real \n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
            System.out.println("Table created");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
     
     private Connection connect() {
        // SQLite connection string
       // String url = "jdbc:sqlite:V://projectBms/bmsemplist1.db";
       
       String url =Constants.employeeDB;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
     public int markattend()
    {
         String sql = "SELECT empname,wd FROM "+Constants.employeeAttendanceTable+" ORDER BY empname";
         String sql1 ="UPDATE "+Constants.employeeAttendanceTable+" SET wd = ?  "
                + "WHERE empname = ?";
         
         Scanner sc = new Scanner(System.in);
         System.out.print("\n Enter p for Present , a for Attandnce , hp for HalfDayPresent ");
       
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql);
             PreparedStatement pstmt1  = conn.prepareStatement(sql1)){
            
            while (rs.next()) {
            String empname =    rs.getString("empname");
            double wd      =    rs.getDouble("wd");
            
            System.out.println(empname+" :");
            
            String attandence = sc.nextLine();
            String attendence1 = attandence.toLowerCase();
            
            if(empname == null){
                return 0;
            }
            if(empname == null){
                break;
            }
            else if("p".equals(attendence1)){
                wd=wd+1;
                
            pstmt1.setDouble(1,wd );
            pstmt1.setString(2, empname);
            pstmt1.executeUpdate();
             return 1;
            }
            
            else if ("hp".equals(attendence1)){
                wd=wd+0.5;
                
            pstmt1.setDouble(1,wd );
            pstmt1.setString(2, empname);
            pstmt1.executeUpdate();
             return 2;
            }
            else if("a".equals(attendence1)){
                System.out.println("Marked absent");
                 return 3;
            }
            else{
                System.out.println("Input MissMatch ");
                
            }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
         return 4;
    }
    
     public void display(){
        String sql = "SELECT id,empname,wd FROM "+Constants.employeeAttendanceTable+" ORDER BY empname";
       
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            System.out.println("EMPLOYEENAME         WORKINGDAYS");
            
            while (rs.next()) {
            String empname =    rs.getString("empname");
            double wd  =    rs.getDouble("wd");
            
            System.out.printf("%-20s",empname);
            System.out.printf("     %.2f",wd);
            System.out.println("\n\n");
                                   
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}