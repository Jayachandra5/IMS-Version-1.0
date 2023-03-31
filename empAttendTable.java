package projectbms;

import java.sql.Connection;
import java.sql.DriverManager;
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

public class empAttendTable extends Application {
    
    private TableView<empAttend> empAttendTable = new TableView<empAttend>();
    ObservableList<empAttend> empAttendData;
    
    int screenWidth = (int) Screen.getPrimary().getBounds().getWidth();
    int screenHeight = (int) Screen.getPrimary().getBounds().getHeight();
    
    int sceneWidth = screenWidth;
    int sceneHeight = screenHeight;
    
    FontWeight fw=FontWeight.BOLD;
    FontPosture fp=FontPosture.REGULAR;
    
    @Override
    public void start(Stage stage) {
        
        display_EmpAttendTable();
        Scene sc = new Scene(new Group(),sceneWidth,sceneHeight-70);
        
        stage.setTitle("Table View Sample");
 
        final Label label = new Label("Employee List");
        label.setFont(new Font("Arial", 20));
 
        empAttendTable.setEditable(true);
        empAttendTable.setPrefHeight(600);
        empAttendTable.setPrefWidth(350);
        empAttendTable.setStyle("-fx-background-color:white;");
       
        TableColumn Col1 = new TableColumn("Name");
        Col1.setMinWidth(200);
        Col1.setCellValueFactory(
                new PropertyValueFactory<empAttend, String>("firstName"));
 
        TableColumn Col2 = new TableColumn("Daily Salary");
        Col2.setMinWidth(145);
        Col2.setCellValueFactory(
                new PropertyValueFactory<empAttend, String>("lastName"));
 
        empAttendTable.getColumns().addAll(Col1, Col2);
 
        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 100));
        vbox.getChildren().addAll(empAttendTable);
        
        empAttendTable.setItems(empAttendData);
        
        ((Group) sc.getRoot()).getChildren().addAll(vbox);
        stage.setScene(sc);
        stage.show();
}
  
    public static class empAttend {
 
        private final SimpleStringProperty firstName;
        private final SimpleStringProperty lastName;
       
        private empAttend(String fName, String lName) {
            this.firstName = new SimpleStringProperty(fName);
            this.lastName = new SimpleStringProperty(lName);
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
    }
    
    public void display_EmpAttendTable(){
        String sql = "SELECT id,empname,wd FROM "+Constants.employeeAttendanceTable+" ORDER BY empname";
       
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
             empAttendData = FXCollections.observableArrayList( );
             
            while (rs.next()) {
            String empname =    rs.getString("empname");
            double wd  =    rs.getDouble("wd");
            
            String empworkingdays = String.valueOf(wd);
                 empAttendData.add(new empAttend(empname,empworkingdays));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
     private Connection connect() {
        // SQLite connection string
        //String url = "jdbc:sqlite:V://projectBms/bmsemplist1.db";
        String url = Constants.employeeDB;
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