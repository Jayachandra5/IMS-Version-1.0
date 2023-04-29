// this file is not included in the version  1.0 its a check file

package projectbms;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class empTable extends Application {
    
    private TableView<EMP> empTable = new TableView<EMP>();
    ObservableList<EMP> empData;
    
    int screenWidth = (int) Screen.getPrimary().getBounds().getWidth();
    int screenHeight = (int) Screen.getPrimary().getBounds().getHeight();
    
    int sceneWidth = screenWidth;
    int sceneHeight = screenHeight;
    
    FontWeight fw=FontWeight.BOLD;
    FontPosture fp=FontPosture.REGULAR;
    
    @Override
    public void start(Stage stage) {
        
        calSal();
        Scene sc = new Scene(new Group(),sceneWidth,sceneHeight-70);
        
        stage.setTitle("Table View Sample");
 
        Label label = new Label("Employee Wages List");
        label.setFont(new Font("Arial", 20));
 
        empTable.setEditable(true);
        empTable.setPrefHeight(600);
        empTable.setPrefWidth(400);
        empTable.setStyle("-fx-color:white;");
       
        TableColumn Col1 = new TableColumn("Name");
        Col1.setMinWidth(100);
        Col1.setCellValueFactory(
                new PropertyValueFactory<EMP, String>("firstName"));
 
        TableColumn Col2 = new TableColumn("Daily Salary");
        Col2.setMinWidth(80);
        Col2.setCellValueFactory(
                new PropertyValueFactory<EMP, String>("lastName"));
        
        TableColumn emailCol = new TableColumn("Working Days");
        emailCol.setMinWidth(96);
        emailCol.setCellValueFactory(
                new PropertyValueFactory<EMP, String>("email"));

        TableColumn PriceCol = new TableColumn("Salary");
        PriceCol.setMinWidth(80);
        PriceCol.setCellValueFactory(
                new PropertyValueFactory<EMP, String>("Price"));
        
        TableColumn Paid = new TableColumn("Paid");
        Paid.setMinWidth(40);
        Paid.setCellValueFactory(
                new PropertyValueFactory<EMP, String>("Select"));
        
        empTable.getColumns().addAll(Col1, Col2,emailCol,PriceCol,Paid);
 
        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 100));
        vbox.getChildren().addAll(empTable);
        
        empTable.setItems(empData);
        
        ((Group) sc.getRoot()).getChildren().addAll(vbox);
        stage.setScene(sc);
        stage.show();
       
}
  
    public static class EMP {
 
        private final SimpleStringProperty firstName;
        private final SimpleStringProperty lastName;
        private final SimpleStringProperty email;
        private final SimpleStringProperty Price;
        private CheckBox Select;
        
        private EMP(String fName, String lName,String email,String price) {
            this.firstName = new SimpleStringProperty(fName);
            this.lastName = new SimpleStringProperty(lName);
            this.email = new SimpleStringProperty(email);
            this.Price = new SimpleStringProperty(price);
            this.Select= new CheckBox();
        }
 
        public String getFirstName() {
            return firstName.get();
        }
 
        public void setFirstName(String fName) {
            firstName.set(fName);
        }
 
        public String getLastName() {
            return lastName.get();
        }
 
        public void setLastName(String fName) {
            lastName.set(fName);
        }
        
        public String getEmail() {
            return email.get();
        }

        public void setEmail(String fName) {
            email.set(fName);
        }

        public String getPrice() {
            return Price.get();
        }

        public void setPrice(String fName) {
            Price.set(fName);
        }
        
        public CheckBox getSelect(){
            return Select;
        }
        
        public void setSelect(CheckBox Select){
            this.Select = Select;
        }
    }
    public void calSal()
    {
         String sql = "SELECT empname,wd FROM empattend1 ORDER BY empname";
         
         String sql1 = "SELECT * "
                          +"FROM bmsemp1 WHERE empname=?";
         
         String sql2 = "UPDATE empattend1 SET wd = ?  "
                + "WHERE empname = ?";
         
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql);
             PreparedStatement pstmt1 = conn.prepareStatement(sql1); 
             PreparedStatement pstmt2 = conn.prepareStatement(sql2)){
            
            String empname =null;
            double wd = 0;
            double sal =0;
            double salary =0;
            
            empData = FXCollections.observableArrayList( );
            
            while (rs.next() ) {
             empname =    rs.getString("empname");
             wd      =    rs.getDouble("wd");
             pstmt1.setString(1, empname);
             ResultSet rs1 = pstmt1.executeQuery();
             
             while (rs1.next()){
                 sal  =rs1.getDouble("salary");
                 salary = wd*sal;
                 String empsalary = String.valueOf(salary);
                 String dailySal = String.valueOf(sal);
                 String workingDays = String.valueOf(wd);
                 empData.add(new EMP(empname,dailySal,workingDays,empsalary));
                 }
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
      private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:V://projectBms/bmsemplist1.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
     public static void main(String []args){
         launch(args);
     }
} 
