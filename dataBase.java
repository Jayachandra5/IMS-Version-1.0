package projectbms;
import java.sql.*;

public class dataBase  {
    manage mdb = new manage();
    sellTable cdb = new sellTable();
    
     public static void createNewDatabase() {

      //  String url = "jdbc:sqlite:V:/projectBms/" + fileName;
      String url = Constants.productDB;
      
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    } 
    
     public static void createNewTable() {
        // SQLite connection string
       // String url = "jdbc:sqlite:V://projectBms/bmsList1.db";
        String url = Constants.productDB;
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS "+Constants.ProductTable+" (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	stockname text NOT NULL,\n"
                + "	quantity real, \n"
                + "     mrp real, \n"
                + "     price real, \n"
                + "     tax real \n"
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

    public int insert(String stockname, double  mrp, double price , double quantity ,double tax) {
        
        String sql = "INSERT INTO "+Constants.ProductTable+"(stockname,mrp,price,quantity,tax) VALUES(?,?,?,?,?)";
        
        String sql1 = "SELECT  stockname "
                          + "FROM "+Constants.ProductTable+" WHERE stockname = ?";
        
      try (Connection conn = this.connect();
                            
      PreparedStatement pstmt = conn.prepareStatement(sql);
      PreparedStatement pstmt1 = conn.prepareStatement(sql1))
          
        {
            pstmt1.setString(1, stockname);
            
        ResultSet rs = pstmt1.executeQuery();
        String name =null;
        while (rs.next()){
            name=rs.getString("stockname");
        }
         if (stockname.equals(name)){
            System.out.println(" Product alredady exist if u want update qunaity do that");
            return 1;
        }
         else{
            pstmt.setString(1, stockname);
            pstmt.setDouble(2, mrp);
            pstmt.setDouble(3, price);
             pstmt.setDouble(4, quantity);
            pstmt.setDouble(5, tax);
            
            pstmt.executeUpdate();
            System.out.println("Product added");
            
            double amount1= price*quantity;
            String stockAmount= "stockamount";
            mdb.increaseAmount(stockAmount, amount1);
            return 2;
         }
        } 
           catch (SQLException e) {
            System.out.println(e.getMessage());
         }
      return 0;
  }
    
     public void display(){
        String sql = "SELECT * FROM "+Constants.ProductTable+" ORDER BY stockname";
        String sql1 =            "SELECT COUNT(*) FROM "+Constants.ProductTable;
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql);
             Statement stmt1  = conn.createStatement();
             ResultSet rs1 = stmt1.executeQuery(sql1)){
            
            rs1.next();
            
            int count = rs1.getInt(1);
            
            System.out.println("TOTAL NUMBER OF PRODUCTS :"+count);
            System.out.println("\n");
            
            System.out.println("STOCKNAME                QUANTITY      MRP      PRICE AT BUYED      TAX%  ");
        
            while (rs.next()) {
                 String stockname = rs.getString("stockname");
                 double quantity  = rs.getDouble("quantity");
                 double mrp       = rs.getDouble("mrp");
                 double price     = rs.getDouble("price");
                 double tax       = rs.getDouble("tax");
                 
                 System.out.printf("%-20s",stockname);
                 System.out.printf("     %.2f",quantity);
                 System.out.printf("       %.2f",mrp);
                 System.out.printf("     %.2f",price);
                 System.out.printf("                %.2f",tax);
                 System.out.println();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
     
    public int increaseqnt(String stockname, double quantity,double price) {
        
        double temp=quantity*price;
        String stockamount ="stockamount";
        
        String sql = "SELECT  * "
                          + "FROM "+Constants.ProductTable+" WHERE stockname = ?";
        
        String sql2 = "UPDATE "+Constants.ProductTable+" SET quantity = ?  "
                + "WHERE stockname = ?";
        
         String sql3 = "UPDATE "+Constants.sellTable+" SET qnt = ?  "
                + "WHERE stockname = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql);
             PreparedStatement pstmt1 = conn.prepareStatement(sql2);
                PreparedStatement pstmt2 = conn.prepareStatement(sql3)) {
            
             pstmt.setString(1,stockname);
             
            ResultSet rs  = pstmt.executeQuery();
            
            String pname=null;
            double prc=0;
            double qnt=0;
            while (rs.next()){
                pname = rs.getString("stockname");
                prc = rs.getDouble("price");
                qnt=rs.getDouble("quantity");
            }
            
            if(pname == null){
                System.out.println("Product not avalible please add the product first");
                return 1;
            }
            
            else if(prc != price) {
                System.out.println("price of "+pname+" saved as "+prc+" and you have entered  price as"+price);
                System.out.println("If the product price changed soo kindly add new product");
                return 2;
            }
            else{
            double q=qnt+quantity;
            pstmt1.setDouble(1, q);
            pstmt1.setString(2, stockname);
            pstmt1.executeUpdate();
           
            pstmt2.setDouble(1, q);
            pstmt2.setString(2, stockname);
            pstmt2.executeUpdate();
            
            System.out.println("quantity added ");
            mdb.increaseAmount(stockamount,temp);
            System.out.println("Stockamount incresed");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 3;
    }

    public int redcuceqnt(String stockname, double quantity,double price,String presentDate,String csname) {
        double tempqnt=quantity;
        double tempprice =price;
        
        String sql = "SELECT  *"
                          + "FROM "+Constants.ProductTable+" WHERE stockname = ?";
        
        String sql2 = "UPDATE "+Constants.ProductTable+" SET quantity = ?  "
                + "WHERE stockname = ?";
        
        String sql3 = "UPDATE  "+Constants.sellTable+"  SET qnt = ?  "
                + "WHERE stockname = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql);
             PreparedStatement pstmt1 = conn.prepareStatement(sql2);
             PreparedStatement pstmt2 = conn.prepareStatement(sql3)){
             pstmt.setString(1,stockname);
            
            ResultSet rs  = pstmt.executeQuery();
            
            double qnt=0;
            double prc=0;
            String name =null;
            while (rs.next()) {
                 name = rs.getString("stockname");
                 qnt=rs.getDouble("quantity");
                 prc=rs.getDouble("price");
            }
            if(name == null){
                return 1;
            }
            if (qnt<quantity)
                 {
                   System.out.println("Orderd quantity is more then avaliblie");
                   System.out.println("Available qunantity is "+qnt+ " only");
                   return 2;
                 }else{
                double q = qnt-quantity;
            pstmt1.setDouble(1, q);
            pstmt1.setString(2, stockname);
            
            pstmt1.executeUpdate();
            
            pstmt2.setDouble(1, q);
            pstmt2.setString(2, stockname);
            pstmt2.executeUpdate();
            
            System.out.println("Qnt reduced");
            
            String stockamount ="stockamount";
            double temp = tempqnt *prc;
            mdb.decreaseAmount(stockamount,temp);
            System.out.println("Stockamount decresed");
            
            String totalsales ="totalsales";
            double sales = tempqnt*tempprice;
            mdb.increaseAmount(totalsales,sales);
            System.out.println("Sales value Increased ");
            
            double prc1 = tempprice- prc;
            double profit= prc1*tempqnt;
            
            String varname = "profit";
            mdb.increaseAmount(varname, profit);
            System.out.println("Profit Increased");
            Test sale = new Test();
            sale.insert(stockname, quantity, temp, sales, profit, presentDate, csname);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 3;
    }

    public int delete(String stockname) {
        String sql1 ="SELECT * "
                       + "From "+Constants.ProductTable+" WHERE stockname = ?";
        
        String sql = "DELETE FROM "+Constants.ProductTable+" WHERE stockname = ?";
        
        String sql2 = "DELETE FROM "+Constants.sellTable+" WHERE stockname = ?";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                PreparedStatement pstmt1 = conn.prepareStatement(sql1);
                PreparedStatement pstmt2 = conn.prepareStatement(sql2)){
            pstmt1.setString(1, stockname);
            ResultSet rs  = pstmt1.executeQuery();
            
            double qnt =0;
            String name=null;
            while (rs.next()){
                qnt = rs.getDouble("quantity");
                name=rs.getString("stockname");
            }
            
            if(name == null){
                System.out.println("No such product available");
                return 1;
            }
            else{
            if(qnt == 0){   
            pstmt.setString(1, stockname);
            pstmt.executeUpdate();
            System.out.println("Product deleted from product list");
            
            pstmt2.setString(1 , stockname);
            pstmt2.executeUpdate();
            System.out.println("product delted from sell list");
            return 2;
            
            }
            else if(qnt != 0){
                System.out.println("Quantity avalabile is "+qnt+" sell all the qunatity before deleting");
                System.out.println("Are kindly add the product into spoiled data");
            }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 3;
    }
    
     public double displayItem(String stockname)
     {
         String sql = "SELECT  * "
                          + "FROM "+Constants.ProductTable+" WHERE stockname = ?";
        
         String temp1=null;
            double temp2=0;
            double temp3=0;
            double temp4=0;
            double temp5=0;
            
        try (Connection conn = this.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql)) {
             pstmt.setString(1,stockname);
            
            ResultSet rs  = pstmt.executeQuery();
                        while (rs.next()) {
                 temp1=rs.getString("stockname");
                 temp2=rs.getDouble("quantity");
                 temp3=rs.getDouble("mrp");
                 temp4=rs.getDouble("price");
                 temp5=rs.getDouble("tax");
            }
            
            if( temp1 == null){
                System.out.println("No such product available");
            }
            
            else{
          /*  System.out.println("Product name            :"+temp1);
            System.out.println("Product quantity        :"+temp2);
            System.out.println("Product MRP             :"+temp3);
            System.out.println("product buying price    :"+temp4);
            System.out.println("product tax%(CGST+SGST) :"+temp5);*/
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return temp2;
     }
     
    public int spoil(String stockname, double quantity)
    {
         double tempqnt=quantity;
        String sql = "SELECT  * "
                          + "FROM "+Constants.ProductTable+" WHERE stockname = ?";
        
        String sql2 = "UPDATE "+Constants.ProductTable+" SET quantity = ?  "
                + "WHERE stockname = ?";
        
        String sql3 = "UPDATE "+Constants.sellTable+" SET qnt = ?  "
                + "WHERE stockname = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql);
             PreparedStatement pstmt1 = conn.prepareStatement(sql2);
                PreparedStatement pstmt2 = conn.prepareStatement(sql3)) {
            
             pstmt.setString(1,stockname);
            
            ResultSet rs  = pstmt.executeQuery();
            
            // loop through the result set
            double qnt=0;
            double prc=0;
            String name=null;
            while (rs.next()) {
                 name = rs.getString("stockname");
                 qnt= rs.getDouble("quantity");
                 prc= rs.getDouble("price");
            }
            
            if(name == null){
                System.out.println("No such product available");
                return 1;
            }
            else if (qnt<quantity)
                 {
                   System.out.println("Quantity enterd is more then available");
                   System.out.println("Available qunantity is "+qnt+ " only");
                   System.out.println("Kindly try againg by "
                           + "entering quantity less then are equal to "+qnt);
                   return 2;
                 }
            
            else{
            double q = qnt-quantity;
            pstmt1.setDouble(1, q);
            pstmt1.setString(2, stockname);
            
            pstmt2.setDouble(1, q);
            pstmt2.setString(2, stockname);
            
            pstmt1.executeUpdate();
            pstmt2.executeUpdate();
            System.out.println("Qnt reduced");
            double temp =tempqnt*prc;
            
            String stockamount="stockamount";
            String expenses ="expenses";
          
            mdb.increaseAmount(expenses, temp);
            System.out.println("Expenses Incresed ");
            mdb.decreaseAmount(stockamount, temp);
            System.out.println("stockamount decresed");
            
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 3;
    }
}

