//package projectbms;
//
//import javafx.beans.property.SimpleStringProperty;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.geometry.Insets;
//import javafx.scene.Group;
//import javafx.scene.Scene;
//import javafx.scene.control.Label;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.layout.VBox;
//import javafx.scene.text.Font;
//import javafx.stage.Stage;
//import java.sql.*;
//import javafx.scene.layout.HBox;
//import javafx.scene.text.FontPosture;
//import javafx.scene.text.FontWeight;
//import javafx.stage.Screen;
//
//public class ProductTables extends parentform {
//    
//    private TableView<Person> table = new TableView<Person>();
//    ObservableList<Person> data;
//    
//    int screenWidth = (int) Screen.getPrimary().getBounds().getWidth();
//    int screenHeight = (int) Screen.getPrimary().getBounds().getHeight();
//    
//    int sceneWidth = screenWidth;
//    int sceneHeight = screenHeight;
//    
//    FontWeight fw=FontWeight.BOLD;
//    FontPosture fp=FontPosture.REGULAR;
//    
//    public void productTable(Stage stage){
//        
//      //  VBox vb2 = new VBox();
//     //   super.addnew(stage,vb2);
//        
//     String sql = "SELECT * FROM bmsbuy1 ORDER BY stockname";
//     String sql1 =            "SELECT COUNT(*) FROM bmsbuy1";
//        
//        try (Connection conn = this.connect();
//             Statement stmt  = conn.createStatement();
//             ResultSet rs    = stmt.executeQuery(sql);
//             Statement stmt1  = conn.createStatement();
//             ResultSet rs1 = stmt1.executeQuery(sql1)){
//            
//            rs1.next();
//            
//            int count = rs1.getInt(1);
//            
//            System.out.println("TOTAL NUMBER OF PRODUCTS :"+count);
//            
//            data = FXCollections.observableArrayList( );
//            
//            while (rs.next()) {
//                 String stockname = rs.getString("stockname");
//                 double quantity  = rs.getDouble("quantity");
//                 double mrp       = rs.getDouble("mrp");
//                 double price     = rs.getDouble("price");
//                 double tax       = rs.getDouble("tax");
//                 
//                 String qnt = String.valueOf(quantity);
//                 String mrp1 = String.valueOf(mrp);
//                 String price1 = String.valueOf(price);
//                 String tax1 = String.valueOf(tax);
//                 
//                 data.add(new Person(stockname,qnt,mrp1,price1,tax1));
//           }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//   
//        Scene sc = new Scene(new Group(),sceneWidth,sceneHeight-70);
//        
//        stage.setTitle("Table View Sample");
// 
//        final Label label = new Label("Employee List");
//        label.setFont(new Font("Arial", 20));
// 
//        table.setEditable(true);
//        table.setPrefHeight(800);
//        table.setPrefWidth(300);
// 
//        TableColumn firstNameCol = new TableColumn("Name");
//        firstNameCol.setMinWidth(100);
//        firstNameCol.setCellValueFactory(
//                new PropertyValueFactory<Person, String>("firstName"));
// 
//        TableColumn lastNameCol = new TableColumn("Quantity");
//        lastNameCol.setMinWidth(50);
//        lastNameCol.setCellValueFactory(
//                new PropertyValueFactory<Person, String>("lastName"));
// 
//        TableColumn emailCol = new TableColumn("MRP");
//        emailCol.setMinWidth(50);
//        emailCol.setCellValueFactory(
//                new PropertyValueFactory<Person, String>("email"));
//        
//        TableColumn PriceCol = new TableColumn("Price");
//        PriceCol.setMinWidth(50);
//        PriceCol.setCellValueFactory(
//                new PropertyValueFactory<Person, String>("Price"));
//        
//        TableColumn TaxCol = new TableColumn("TAX%");
//        TaxCol.setMinWidth(50);
//        TaxCol.setCellValueFactory(
//                new PropertyValueFactory<Person, String>("Tax"));
//        
//        table.getColumns().addAll(firstNameCol, lastNameCol, emailCol,PriceCol,TaxCol);
// 
//        VBox vbox = new VBox();
//        vbox.setSpacing(5);
//        vbox.setPadding(new Insets(10, 0, 0, 0));
//        vbox.getChildren().addAll(table);
//        
//        vb2.getChildren().addAll(vbox);
//        vb2.setSpacing(10);
//        vb2.setPadding(new Insets (10,10,10,10));
// 
//        table.setItems(data);
//       ((Group) sc.getRoot()).getChildren().addAll(vb2);
//       
//        stage.setScene(sc);
//        stage.show();
//}
//
//    public static class Person {
// 
//        private final SimpleStringProperty firstName;
//        private final SimpleStringProperty lastName;
//        private final SimpleStringProperty email;
//        private final SimpleStringProperty Price;
//        private final SimpleStringProperty Tax;
// 
//        private Person(String fName, String lName, String email,String price ,String tax) {
//            this.firstName = new SimpleStringProperty(fName);
//            this.lastName = new SimpleStringProperty(lName);
//            this.email = new SimpleStringProperty(email);
//            this.Price = new SimpleStringProperty(price);
//            this.Tax = new SimpleStringProperty(tax);
//        }
// 
//        public String getFirstName() {
//            return firstName.get();
//        }
// 
//        public void setFirstName(String fName) {
//            firstName.set(fName);
//        }
// 
//        public String getLastName() {
//            return lastName.get();
//        }
// 
//        public void setLastName(String fName) {
//            lastName.set(fName);
//        }
// 
//        public String getEmail() {
//            return email.get();
//        }
// 
//        public void setEmail(String fName) {
//            email.set(fName);
//        }
//        
//        public String getPrice() {
//            return Price.get();
//        }
// 
//        public void setPrice(String fName) {
//            Price.set(fName);
//        }
//        
//        public String getTax() {
//            return Tax.get();
//        }
// 
//        public void setTax(String fName) {
//            Tax.set(fName);
//        }
//    }
//    
//     private Connection connect() {
//        // SQLite connection string
//        String url = "jdbc:sqlite:V://projectBms/bmsList1.db";
//        Connection conn = null;
//        try {
//            conn = DriverManager.getConnection(url);
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return conn;
//    }
//}
//
///*import javafx.beans.property.SimpleStringProperty;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.geometry.Insets;
//import javafx.scene.Group;
//import javafx.scene.Scene;
//import javafx.scene.control.Label;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.layout.VBox;
//import javafx.scene.text.Font;
//import javafx.stage.Stage;
//import java.sql.*;
//import javafx.application.Application;
//import javafx.scene.text.FontPosture;
//import javafx.scene.text.FontWeight;
//import javafx.stage.Screen;
////import javafx.Constants;
//
//public class ProductTables extends Application {
//    
//     private TableView<Person> table = new TableView<Person>();
//    ObservableList<Person> data;
//    
//    int screenWidth = (int) Screen.getPrimary().getBounds().getWidth();
//    int screenHeight = (int) Screen.getPrimary().getBounds().getHeight();
//    
//    int sceneWidth = screenWidth;
//    int sceneHeight = screenHeight;
//    
//    FontWeight fw=FontWeight.BOLD;
//    FontPosture fp=FontPosture.REGULAR;
//    
//    @Override
//    public void start(Stage stage) {
//        
//     String sql = "SELECT * FROM bmsbuy1 ORDER BY stockname";
//     String sql1 =            "SELECT COUNT(*) FROM bmsbuy1";
//        
//        try (Connection conn = this.connect();
//             Statement stmt  = conn.createStatement();
//             ResultSet rs    = stmt.executeQuery(sql);
//             Statement stmt1  = conn.createStatement();
//             ResultSet rs1 = stmt1.executeQuery(sql1)){
//            
//            rs1.next();
//            
//            int count = rs1.getInt(1);
//            
//            System.out.println("TOTAL NUMBER OF PRODUCTS :"+count);
//            
//            data = FXCollections.observableArrayList( );
//            
//            while (rs.next()) {
//                 String stockname = rs.getString("stockname");
//                 double quantity  = rs.getDouble("quantity");
//                 double mrp       = rs.getDouble("mrp");
//                 double price     = rs.getDouble("price");
//                 double tax       = rs.getDouble("tax");
//                 
//                 String qnt = String.valueOf(quantity);
//                 String mrp1 = String.valueOf(mrp);
//                 String price1 = String.valueOf(price);
//                 String tax1 = String.valueOf(tax);
//                 
//                 data.add(new Person(stockname,qnt,mrp1,price1,tax1));
//           }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//   
//        Scene sc = new Scene(new Group(),sceneWidth,sceneHeight-70);
//        
//        stage.setTitle("Table View Sample");
// 
//        final Label label = new Label("Employee List");
//        label.setFont(new Font("Arial", 20));
// 
//        table.setEditable(true);
//        table.setPrefHeight(400);
//        table.setPrefWidth(300);
//        table.setStyle("-fx-color:white;");
//       
// 
//        TableColumn firstNameCol = new TableColumn("Name");
//        firstNameCol.setMinWidth(100);
//        firstNameCol.setCellValueFactory(
//                new PropertyValueFactory<Person, String>("firstName"));
// 
//        TableColumn lastNameCol = new TableColumn("Quantity");
//        lastNameCol.setMinWidth(50);
//        lastNameCol.setCellValueFactory(
//                new PropertyValueFactory<Person, String>("lastName"));
// 
//        TableColumn emailCol = new TableColumn("MRP");
//        emailCol.setMinWidth(50);
//        emailCol.setCellValueFactory(
//                new PropertyValueFactory<Person, String>("email"));
//        
//        TableColumn PriceCol = new TableColumn("Price");
//        PriceCol.setMinWidth(50);
//        PriceCol.setCellValueFactory(
//                new PropertyValueFactory<Person, String>("Price"));
//        
//        TableColumn TaxCol = new TableColumn("TAX%");
//        TaxCol.setMinWidth(50);
//        TaxCol.setCellValueFactory(
//                new PropertyValueFactory<Person, String>("Tax"));
//        
//        
//        table.getColumns().addAll(firstNameCol, lastNameCol, emailCol,PriceCol,TaxCol);
// 
//        VBox vbox = new VBox();
//        vbox.setSpacing(5);
//        vbox.setPadding(new Insets(10, 0, 0, 0));
//        vbox.getChildren().addAll(table);
//        
//        VBox vb2 = new VBox();
//        vb2.getChildren().addAll(vbox);
//        vb2.setSpacing(10);
//        vb2.setPadding(new Insets (10,10,10,10));
//        
//        table.setItems(data);
//        
//        ((Group) sc.getRoot()).getChildren().addAll(vb2);
//        stage.setScene(sc);
//        stage.show();
//}
//    public static void main(String[] args) {
//        launch(args);
//    }
//    public static class Person {
// 
//        private final SimpleStringProperty firstName;
//        private final SimpleStringProperty lastName;
//        private final SimpleStringProperty email;
//        private final SimpleStringProperty Price;
//        private final SimpleStringProperty Tax;
// 
//        private Person(String fName, String lName, String email,String price ,String tax) {
//            this.firstName = new SimpleStringProperty(fName);
//            this.lastName = new SimpleStringProperty(lName);
//            this.email = new SimpleStringProperty(email);
//            this.Price = new SimpleStringProperty(price);
//            this.Tax = new SimpleStringProperty(tax);
//        }
// 
//        public String getFirstName() {
//            return firstName.get();
//        }
// 
//        public void setFirstName(String fName) {
//            firstName.set(fName);
//        }
// 
//        public String getLastName() {
//            return lastName.get();
//        }
// 
//        public void setLastName(String fName) {
//            lastName.set(fName);
//        }
// 
//        public String getEmail() {
//            return email.get();
//        }
// 
//        public void setEmail(String fName) {
//            email.set(fName);
//        }
//        
//        public String getPrice() {
//            return Price.get();
//        }
// 
//        public void setPrice(String fName) {
//            Price.set(fName);
//        }
//        
//        public String getTax() {
//            return Tax.get();
//        }
// 
//        public void setTax(String fName) {
//            Tax.set(fName);
//        }
//    }
//    
//     private Connection connect() {
//        // SQLite connection string
//        String url = "jdbc:sqlite:V://projectBms/bmsList1.db";
//        Connection conn = null;
//        try {
//            conn = DriverManager.getConnection(url);
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return conn;
//    }
//} */