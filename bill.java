package projectbms;

import java.sql.*;

class totalAmount {

    public static void createNewtable() {
        String url = Constants.productDB;
        String sql = "CREATE TABLE IF NOT EXISTS " + Constants.totalAmount + " (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	name text NOT NULL,\n"
                + "	totalAmt real \n"
                + ");";

        try ( Connection conn = DriverManager.getConnection(url);  Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
            System.out.println("Table created");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private Connection connect() {
        // SQLite connection string
        //String url = "jdbc:sqlite:V://projectBms/bmsList1.db";
        String url = Constants.productDB;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public int insert(String name, double amount) {

        String sql = "INSERT INTO " + Constants.totalAmount + "(name,totalAmt)"
                + "VALUES(?,?)";
        
        String sql1 ="UPDATE "+Constants.totalAmount+" SET totalAmt = ?  "
                + "WHERE name = ?";
        
        String sql2 = "SELECT  * "
                          + "FROM "+Constants.totalAmount+" WHERE name = ?";

        try ( Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql); 
                PreparedStatement pstmt1 = conn.prepareStatement(sql1);
                PreparedStatement pstmt2 = conn.prepareStatement(sql2)){
            
            
            pstmt2.setString(1,name);
            ResultSet rs  = pstmt2.executeQuery();
            
            String csname =null;
            double getAmount =0;
            
            while(rs.next()){
            csname = rs.getString("name");
            getAmount  = rs.getDouble("totalAmt");
            }
            if(name.equals(csname)){
            pstmt1.setString(2, name);
            pstmt1.setDouble(1, getAmount+amount);
            pstmt1.executeUpdate();
            System.out.println("total amount updated");
            }else{
            pstmt.setString(1, name);
            pstmt.setDouble(2, amount);
            pstmt.executeUpdate();
            System.out.println("total amount craeted");
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public double display(String name) {

        String sql = "SELECT  * "
                          + "FROM "+Constants.totalAmount+" WHERE name = ?";

        double totalAmount=0;
        try ( Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,name);
             
            ResultSet rs  = pstmt.executeQuery();
            while(rs.next()){
           totalAmount = rs.getDouble("totalAmt");
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return totalAmount;
    }
    
    
    public int delete() {

        String sql = "DELETE FROM " + Constants.totalAmount;

        try ( Connection conn = this.connect();  Statement stmt = conn.createStatement();  ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("Product Deleted");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 3;
    }
    
}


class BillData {

    public static void createNewTable() {

        // SQLite connection string
        // String url = "jdbc:sqlite:V://projectBms/bmsList1.db";
        String url = Constants.productDB;
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS " + Constants.bill + " (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	name text NOT NULL,\n"
                + "	quantity real, \n"
                + "     Mrp real, \n"
                + "     totMrp real, \n"
                + "     net real, \n"
                + "     dis real, \n"
                + "     netDis real, \n"
                + "     taxP real, \n"
                + "     taxA real, \n"
                + "     price real, \n"
                + "     totPrice real \n"
                + ");";

        try ( Connection conn = DriverManager.getConnection(url);  Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
            System.out.println("Table created");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private Connection connect() {
        // SQLite connection string
        //String url = "jdbc:sqlite:V://projectBms/bmsList1.db";
        String url = Constants.productDB;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public int insert(String name, double qnt, double price) {

        String sql = "INSERT INTO " + Constants.bill + "(name,quantity,Mrp,totMrp,net,dis,netDis,taxP,taxA,price,totPrice) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";

        String sql1 = "SELECT  name "
                + "FROM " + Constants.bill + " WHERE name = ?";

        String sql2 = "SELECT  * "
                + "FROM " + Constants.bill + " WHERE name = ?";
        
        try ( Connection conn = this.connect();  PreparedStatement pstmt = conn.prepareStatement(sql);  PreparedStatement pstmt1 = conn.prepareStatement(sql1);  PreparedStatement pstmt2 = conn.prepareStatement(sql2)) // PreparedStatement pstmt3 = conn.prepareStatement(sql3))
        {
            pstmt1.setString(1, name);
            pstmt2.setString(1, name);

            ResultSet rs2 = pstmt2.executeQuery();
            double getMrp = 0;
            double getTax = 0;

            while (rs2.next()) {
                getMrp = rs2.getDouble("mrp");
                getTax = rs2.getDouble("taxA");
            }
            /* ResultSet rs3 = pstmt3.executeQuery();
        while (rs3.next()){
            price = rs3.getDouble("price");
        }*/
            // double x = price * (getTax / 100) + getTax;
            double totPrice = price * qnt;
            double totMrp = getMrp * qnt;
            double net = (price - (price * getTax / 100)) * qnt;

            double dis = totMrp - totPrice;
            double netDis = (net - dis);
            double taxAmt = (netDis * getTax / 100) * qnt;

            String stockName = null;

            ResultSet rs = pstmt1.executeQuery();
            while (rs.next()) {
                stockName = rs.getString("name");
            }
            if (name.equals(stockName)) {
                System.out.println(" Product alredady exist");
                return 1;
            } else {
                pstmt.setString(1, name);
                pstmt.setDouble(2, qnt);
                pstmt.setDouble(3, getMrp);
                pstmt.setDouble(4, totMrp);
                pstmt.setDouble(5, net);
                pstmt.setDouble(6, dis);
                pstmt.setDouble(7, netDis);
                pstmt.setDouble(8, getTax);
                pstmt.setDouble(9, taxAmt);
                pstmt.setDouble(10, price);
                pstmt.setDouble(11, totPrice);
                pstmt.executeUpdate();

                System.out.println("Product added");

                return 2;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public void display() {
        String sql = "SELECT * FROM " + Constants.bill + " ORDER BY name";

        try ( Connection conn = this.connect();  Statement stmt = conn.createStatement();  ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("STOCKNAME                QUANTITY   MRP      TOTMRP        NET         DIS          NETDIS       TAXP       TAXA      PRICE     TOTPRICE  ");

            while (rs.next()) {
                String stockname = rs.getString("name");
                double qnt = rs.getDouble("quantity");
                double mrp = rs.getDouble("mrp");
                double totMrp = rs.getDouble("totMrp");
                double net = rs.getDouble("net");
                double dis = rs.getDouble("dis");
                double netDis = rs.getDouble("netDis");
                double taxP = rs.getDouble("taxP");
                double taxA = rs.getDouble("taxA");
                double price = rs.getDouble("price");
                double totPrice = rs.getDouble("totPrice");

                System.out.printf("%-20s", stockname);
                System.out.printf("     %.2f", qnt);
                System.out.printf("       %.2f", mrp);
                System.out.printf("     %.2f", totMrp);
                System.out.printf("        %.2f", net);
                System.out.printf("        %.2f", dis);
                System.out.printf("        %.2f", netDis);
                System.out.printf("        %.2f", taxP);
                System.out.printf("        %.2f", taxA);
                System.out.printf("        %.2f", price);
                System.out.printf("        %.2f", totPrice);
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public String nameDis() {
        String sql = "SELECT * FROM " + Constants.bill + " ORDER BY name";
        String stockname = null;
        try ( Connection conn = this.connect();  Statement stmt = conn.createStatement();  ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                stockname = rs.getString("name");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return stockname;
    }

    public int delete() {

        String sql = "DELETE FROM " + Constants.bill;

        try ( Connection conn = this.connect();  Statement stmt = conn.createStatement();  ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("Product Deleted");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 3;
    }
}

public class bill {

    public static void main(String args[]) {
       totalAmount ta = new totalAmount();
     // ta.createNewtable();
        ta.insert("jaya", 100);

    }

    public void owner() {
        System.out.print("Enter Bussines name :");
        System.out.print("Enter Owner name :");
        System.out.print("Enter owner mobile number :");
        System.out.print("License ");
        System.out.print("GST number");
        System.out.print("Address");
        System.out.print("");
    }

    public void seller() {
        System.out.print("Date");
        System.out.print("Invoice Number");
        System.out.print("Coustmer name");
        System.out.print("payment mode");
        System.out.print("Due amount");
        System.out.print("amount in words");
    }

    public void bill() {
        
        

        /*
        name = input 
        qnt = input 
        mrp = product table 
        total mrp = mrp * qnt
        x = selling price * tax \ 100 + tax
        discount = mrp - sellingprice
        net amount = (sellingprice- x + dis ) * qnt
        net after dis = net amount - discount * qnt
        tax % form product table 
        tax amount = net after dis * tax/100 * qnt
         */
    }
}
