package projectbms;

public class Constants {

    public static String Title = new String("Inventory Managment System ");
    public static String subTitle = new String("Invoice");

    public static String name = new String("K Malleswara Rao ");
    public static String phnNum1 = new String("9848903535");
    public static String PhnNum2 = new String("8712173660");
    public static String gstNum = new String("GSTXXXX5818");
    public static String address = new String("Shop Num 97, K.G Market, 1 town,Vijayawada 520001");

    //New 
    /*                      Product                                */
    
    public static String productDB = "jdbc:sqlite:C:\\IMS\\DB\\pro1.db";
    
    public static String ProductTable = "purchased";   // bmsbuy1
    
    public static String sellTable = "SellTable"; //lastSellTable
    
    public static String bill ="bill"; //billData
    
    public static String purchaseTable = "Purchase";  //Purchase
    
    public static String salesTable = "salesTable";   //last_Sales_Table
    
    public static String totalAmount = "total";

    
    /*                      Employee                                */            
   // public static String employeeDB = "jdbc:sqlite:C:\\Ybm/emp1.db";
    
   // public static String employeeDB = "jdbc:sqlite:C:\\Users\\Rose\\Desktop\\YBM\\DB\\emp1.db";
    
    public static String employeeDB = "jdbc:sqlite:C:\\IMS\\DB\\emp1.db";
    public static String employeeTable = "employeeData";  //bmsemp1
    
    public static String employeeAttendanceTable = "employeeAttendance"; //empattend1
    
   
    
    /*                      Manage                                */
  // public static String mangeDB = "jdbc:sqlite:C:\\Ybm/mange1.db";
    
   // public static String mangeDB = "jdbc:sqlite:C:\\Users\\Rose\\Desktop\\YBM\\DB\\mange1.db";
    
     public static String mangeDB = "jdbc:sqlite:C:\\IMS\\DB\\mange1.db";
    
    public static String csDue = "csDue"; //csdues
    
    public static String vendourDue = "vendourDue"; //ourdues
    
    public static String empDue = "empDue"; //empdues
    
    public static String manage ="manage"; //manage1
    
     public static String expensesTable ="expensesTable";   //expenses_table
     
    public static String vendourTable = "vendourTable";  //VendourTable

    public static String customerTable = "customerTable";   //customertableWith
    
}
