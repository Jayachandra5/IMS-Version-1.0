package projectbms;

import java.sql.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Reports extends parentform {

    private TableView<purchase> purchaseTable = new TableView<purchase>();
    ObservableList<purchase> purchaseDate;

    private TableView<Sales> salesTable = new TableView<Sales>();
    ObservableList<Sales> salesData;

    private TableView<Expenses> expensesTable = new TableView<Expenses>();
    ObservableList<Expenses> expensesData;

    private TableView<Report> reportTable = new TableView<Report>();
    ObservableList<Report> reportData;

    FontWeight fw = FontWeight.BOLD;
    FontPosture fp = FontPosture.REGULAR;

    TextField searchBar = new TextField();
    Purchase buy = new Purchase();
    Test sell = new Test();
    expenses expenses = new expenses();

    //  Label number; 
    Label numberOf;

    public void purchaseTable(Stage stage) {

        VBox vb2 = super.addnew(stage, "product");

        Label space = new Label();
        space.setPrefSize(200, 25);
        space.setStyle("-fx-background-color:DODGERBLUE;");

        searchBar.setPrefSize(570, 25);
        searchBar.setStyle("-fx-prompt-text-fill:slategray;-fx-text-fill:black;");
        searchBar.setFont(Font.font("Calibri", fw, fp, 13));
        searchBar.setPromptText("🔍 Enter Product Name Or Date (YYYY-MM-DD) Or Vendor Name");

        Label label = new Label("PURCHASE LIST");
        label.setFont(Font.font("Calibri", fw, fp, 20));

        Label count = new Label("Total Number of Purchases :");
        count.setFont(Font.font("Calibri", fw, fp, 20));

        numberOf = new Label();
        numberOf.setFont(Font.font("Calibri", fw, fp, 20));

        displayPurchase();

        purchaseTable.setEditable(true);
        purchaseTable.setPrefHeight(380);
        purchaseTable.setPrefWidth(600);
        purchaseTable.getStylesheets().add("/projectbms/mycss.css");

        TableColumn Col1 = new TableColumn("Product Name");
        Col1.setMinWidth(140);
        Col1.setCellValueFactory(
                new PropertyValueFactory<purchase, String>("firstName"));

        TableColumn Col2 = new TableColumn("Qnt Purchased");
        Col2.setMinWidth(80);
        Col2.setCellValueFactory(
                new PropertyValueFactory<purchase, String>("lastName"));

        TableColumn Col3 = new TableColumn("Amount");
        Col3.setMinWidth(70);
        Col3.setCellValueFactory(
                new PropertyValueFactory<purchase, String>("email"));

        TableColumn Col4 = new TableColumn("Qnt Available");
        Col4.setMinWidth(70);
        Col4.setCellValueFactory(
                new PropertyValueFactory<purchase, String>("Price"));

        TableColumn Col5 = new TableColumn("Date");
        Col5.setMinWidth(85);
        Col5.setCellValueFactory(
                new PropertyValueFactory<purchase, String>("Tax"));

        TableColumn Col6 = new TableColumn("Vendor");
        Col6.setMinWidth(90);
        Col6.setCellValueFactory(
                new PropertyValueFactory<purchase, String>("Vname"));

        purchaseTable.getColumns().addAll(Col1, Col2, Col3, Col4, Col5, Col6);

        HBox head = new HBox();
        head.setSpacing(5);
        head.setPadding(new Insets(10, 10, 10, 200));
        head.getChildren().addAll(label);

        HBox hb = new HBox();
        hb.setSpacing(5);
        hb.setPadding(new Insets(0, 10, 0, 130));
        hb.getChildren().addAll(count, numberOf);

        HBox hb1 = new HBox();
        hb1.setSpacing(5);
        hb1.setPadding(new Insets(0, 0, 0, 0));
        hb1.getChildren().addAll(searchBar);

        HBox hb3 = new HBox();
        hb3.setSpacing(5);
        hb3.setPadding(new Insets(0, 0, 0, 0));
        hb3.getChildren().addAll(hb1);

        VBox vb1 = new VBox();
        vb1.getChildren().addAll(head, hb, hb3);
        vb1.setSpacing(15);
        vb1.setPadding(new Insets(10, 10, 10, 10));

        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 75, 0, 72));
        vbox.getChildren().addAll(vb1, purchaseTable);

        purchaseTable.setItems(purchaseDate);

        vb2.getChildren().addAll(vbox);
        vb2.setSpacing(10);
        vb2.setPadding(new Insets(10, 10, 5, 10));
        
        searchBar.requestFocus();

        FilteredList<purchase> filterCsDue = new FilteredList<>(purchaseDate, b -> true);

        searchBar.textProperty().addListener((observable, oldValue, newValue) -> {

            filterCsDue.setPredicate(CsDue -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (CsDue.getFirstName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (CsDue.getTax().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (CsDue.getVname().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        SortedList<purchase> sortedCsData = new SortedList<>(filterCsDue);

        sortedCsData.comparatorProperty().bind(purchaseTable.comparatorProperty());

        purchaseTable.setItems(sortedCsData);

        stage.show();
    }

    public static class purchase {

        private final SimpleStringProperty firstName;
        private final SimpleStringProperty lastName;
        private final SimpleStringProperty email;
        private final SimpleStringProperty Price;
        private final SimpleStringProperty Tax;
        private final SimpleStringProperty Vname;

        private purchase(String fName, String lName, String email, String price, String tax, String Vname) {
            this.firstName = new SimpleStringProperty(fName);
            this.lastName = new SimpleStringProperty(lName);
            this.email = new SimpleStringProperty(email);
            this.Price = new SimpleStringProperty(price);
            this.Tax = new SimpleStringProperty(tax);
            this.Vname = new SimpleStringProperty(Vname);
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

        public String getTax() {
            return Tax.get();
        }

        public void setTax(String fName) {
            Tax.set(fName);
        }

        public String getVname() {
            return Vname.get();
        }

        public void setVname(String fName) {
            Vname.set(fName);
        }
    }

    public void displayPurchase() {
        String sql = "SELECT * FROM " + Constants.purchaseTable + " ORDER BY date";
        String sql1 = "SELECT COUNT(*) FROM " + Constants.purchaseTable;

        try ( Connection conn = this.connect();  Statement stmt = conn.createStatement();  ResultSet rs = stmt.executeQuery(sql);  Statement stmt1 = conn.createStatement();  ResultSet rs1 = stmt1.executeQuery(sql1)) {

            numberOf.setText(String.valueOf(rs1.getInt(1)));

            purchaseDate = FXCollections.observableArrayList();

            while (rs.next()) {
                String stockname = rs.getString("stockName");
                double qnt = rs.getDouble("qnt");
                double amount = rs.getDouble("amount");
                double qntAvl1 = rs.getDouble("qntAvl");
                String date = rs.getString("date");
                String Vname = rs.getString("vendourName");

                purchaseDate.add(new purchase(stockname,String.valueOf(qnt), String.valueOf(amount)
                        ,String.valueOf(qntAvl1) , date, Vname));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private Connection connect() {
        // SQLite connection string
        String url = Constants.productDB;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    Label number;

    public void SalesTable(Stage stage) {

        VBox vb2 = super.addnew(stage, "product");

        searchBar.setPrefSize(480, 25);
        searchBar.setStyle("-fx-prompt-text-fill:slategray;-fx-text-fill:black;");
        searchBar.setFont(Font.font("Calibri", fw, fp, 13));
        searchBar.setPromptText("🔍 Enter Product Name Or Date (YYYY-MM-DD) Or Customer Name");

        Label label = new Label("SALES LIST");
        label.setFont(Font.font("Calibri", fw, fp, 20));

        Label count = new Label("Total Number of Sales :");
        count.setFont(Font.font("Calibri", fw, fp, 20));

        number = new Label();
        number.setFont(Font.font("Calibri", fw, fp, 20));

        displaySales();
        salesTable.setEditable(true);
        salesTable.setPrefHeight(380);
        salesTable.setPrefWidth(630);
        salesTable.getStylesheets().add("/projectbms/mycss.css");

        TableColumn Col1 = new TableColumn("Name");
        Col1.setMinWidth(135);
        Col1.setCellValueFactory(
                new PropertyValueFactory<Sales, String>("firstName"));

        TableColumn Col2 = new TableColumn("Qnt Purchased");
        Col2.setMinWidth(90);
        Col2.setCellValueFactory(
                new PropertyValueFactory<Sales, String>("lastName"));

        TableColumn stock = new TableColumn("Stock");
        stock.setMinWidth(70);
        stock.setCellValueFactory(
                new PropertyValueFactory<Sales, String>("stock"));

        TableColumn Col3 = new TableColumn("Sales");
        Col3.setMinWidth(70);
        Col3.setCellValueFactory(
                new PropertyValueFactory<Sales, String>("email"));

        TableColumn Col4 = new TableColumn("Profit");
        Col4.setMinWidth(70);
        Col4.setCellValueFactory(
                new PropertyValueFactory<Sales, String>("Price"));

        TableColumn Col5 = new TableColumn("Date");
        Col5.setMinWidth(80);
        Col5.setCellValueFactory(
                new PropertyValueFactory<Sales, String>("Tax"));

        TableColumn Col6 = new TableColumn("Customer");
        Col6.setMinWidth(90);
        Col6.setCellValueFactory(
                new PropertyValueFactory<Sales, String>("Customer"));

        salesTable.getColumns().addAll(Col1, Col2, stock, Col3, Col4, Col5, Col6);

        HBox hb1 = new HBox();
        hb1.setSpacing(5);
        hb1.setPadding(new Insets(0, 10, 0, 230));
        hb1.getChildren().addAll(label);

        HBox hb = new HBox();
        hb.setSpacing(5);
        hb.setPadding(new Insets(0, 10, 0, 190));
        hb.getChildren().addAll(count, number);

        VBox vb1 = new VBox();
        vb1.getChildren().addAll(hb1, hb, searchBar);
        vb1.setSpacing(15);
        vb1.setPadding(new Insets(10, 10, 10, 10));

        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 55, 0, 62));
        vbox.getChildren().addAll(vb1, salesTable);

        salesTable.setItems(salesData);

        vb2.getChildren().addAll(vbox);
        vb2.setSpacing(10);
        vb2.setPadding(new Insets(10, 10, 5, 10));
        
        searchBar.requestFocus();

        FilteredList<Sales> filterCsDue = new FilteredList<>(salesData, b -> true);

        searchBar.textProperty().addListener((observable, oldValue, newValue) -> {

            filterCsDue.setPredicate(CsDue -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (CsDue.getFirstName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (CsDue.getTax().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (CsDue.getCustomer().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        SortedList<Sales> sortedCsData = new SortedList<>(filterCsDue);

        sortedCsData.comparatorProperty().bind(salesTable.comparatorProperty());

        salesTable.setItems(sortedCsData);

        stage.show();
    }

    public static class Sales {

        private final SimpleStringProperty firstName;
        private final SimpleStringProperty lastName;
        private final SimpleStringProperty email;
        private final SimpleStringProperty Price;
        private final SimpleStringProperty Tax;
        private final SimpleStringProperty Customer;
        private final SimpleStringProperty stock;

        private Sales(String fName, String lName, String stock, String email, String price, String tax, String Customer) {
            this.firstName = new SimpleStringProperty(fName);
            this.lastName = new SimpleStringProperty(lName);
            this.stock = new SimpleStringProperty(stock);
            this.email = new SimpleStringProperty(email);
            this.Price = new SimpleStringProperty(price);
            this.Tax = new SimpleStringProperty(tax);
            this.Customer = new SimpleStringProperty(Customer);
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

        public String getStock() {
            return stock.get();
        }

        public void setStock(String fName) {
            stock.set(fName);
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

        public String getTax() {
            return Tax.get();
        }

        public void setTax(String fName) {
            Tax.set(fName);
        }

        public String getCustomer() {
            return Customer.get();
        }

        public void setCustomer(String fName) {
            Customer.set(fName);
        }
    }

    public void displaySales() {
        String sql = "SELECT * FROM " + Constants.salesTable + " ORDER BY date";
        String sql1 = "SELECT COUNT(*) FROM " + Constants.salesTable;

        try ( Connection conn = this.connect();  Statement stmt = conn.createStatement();  ResultSet rs = stmt.executeQuery(sql);  Statement stmt1 = conn.createStatement();  ResultSet rs1 = stmt1.executeQuery(sql1)) {

            number.setText(String.valueOf(rs1.getInt(1)));

            salesData = FXCollections.observableArrayList();

            while (rs.next()) {
                String stockname = rs.getString("stockName");
                double qnt = rs.getDouble("qnt");
                double stock = rs.getDouble("stock");
                double amount = rs.getDouble("amount");
                double profit = rs.getDouble("profit");
                String date = rs.getString("date");
                String custName = rs.getString("customer");

                salesData.add(new Sales(stockname,String.valueOf(qnt),String.valueOf(stock),
                     String.valueOf(amount),String.valueOf(profit), date, custName));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void expensesTable(Stage stage) {
        VBox vb2 = super.addnew(stage, "product");

        searchBar.setPrefSize(380, 25);
        searchBar.setStyle("-fx-prompt-text-fill:slategray;-fx-text-fill:black;");
        searchBar.setFont(Font.font("Calibri", fw, fp, 13));
        searchBar.setPromptText("🔍 Enter Expenses Name Or Date (YYYY-MM-DD)");

        Label label = new Label("EXPENSES LIST");
        label.setFont(Font.font("Calibri", fw, fp, 20));

        Label count = new Label("Total Number of Expenses :");
        count.setFont(Font.font("Calibri", fw, fp, 20));

        number = new Label("10");
        number.setFont(Font.font("Calibri", fw, fp, 20));

        expensesTable.setEditable(true);
        expensesTable.setPrefHeight(380);
        expensesTable.setPrefWidth(450);
        expensesTable.getStylesheets().add("/projectbms/mycss.css");

        displayExpenses();

        TableColumn Col1 = new TableColumn("Purpose");
        Col1.setMinWidth(150);
        Col1.setCellValueFactory(
                new PropertyValueFactory<Expenses, String>("firstName"));

        TableColumn Col2 = new TableColumn("Amount Paid");
        Col2.setMinWidth(150);
        Col2.setCellValueFactory(
                new PropertyValueFactory<Expenses, String>("lastName"));

        TableColumn stock = new TableColumn("Date");
        stock.setMinWidth(135);
        stock.setCellValueFactory(
                new PropertyValueFactory<Expenses, String>("email"));

        expensesTable.getColumns().addAll(Col1, Col2, stock);

        HBox hb1 = new HBox();
        hb1.setSpacing(5);
        hb1.setPadding(new Insets(10, 10, 10, 140));
        hb1.getChildren().addAll(label);

        HBox hb = new HBox();
        hb.setSpacing(5);
        hb.setPadding(new Insets(0, 10, 0, 80));
        hb.getChildren().addAll(count, number);

        VBox vb1 = new VBox();
        vb1.getChildren().addAll(hb1, hb, searchBar);
        vb1.setSpacing(15);
        vb1.setPadding(new Insets(10, 10, 10, 10));

        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 145, 0, 145));
        vbox.getChildren().addAll(vb1, expensesTable);

        expensesTable.setItems(expensesData);

        vb2.getChildren().addAll(vbox);
        vb2.setSpacing(10);
        vb2.setPadding(new Insets(10, 10, 5, 10));

        searchBar.requestFocus();
        
        FilteredList<Expenses> filterCsDue = new FilteredList<>(expensesData, b -> true);

        searchBar.textProperty().addListener((observable, oldValue, newValue) -> {

            filterCsDue.setPredicate(CsDue -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (CsDue.getFirstName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (CsDue.getEmail().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        SortedList<Expenses> sortedCsData = new SortedList<>(filterCsDue);

        sortedCsData.comparatorProperty().bind(expensesTable.comparatorProperty());

        expensesTable.setItems(sortedCsData);

        stage.show();
    }

    public static class Expenses {

        private final SimpleStringProperty firstName;
        private final SimpleStringProperty lastName;
        private final SimpleStringProperty email;

        private Expenses(String fName, String lName, String email) {
            this.firstName = new SimpleStringProperty(fName);
            this.lastName = new SimpleStringProperty(lName);
            this.email = new SimpleStringProperty(email);

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

    }

    public void displayExpenses() {

        String sql = "SELECT * FROM " + Constants.expensesTable + " ORDER BY date";
        String sql1 = "SELECT COUNT(*) FROM " + Constants.expensesTable;

        try ( Connection conn = this.connectMange();  Statement stmt = conn.createStatement();  ResultSet rs = stmt.executeQuery(sql);  Statement stmt1 = conn.createStatement();  ResultSet rs1 = stmt1.executeQuery(sql1)) {

            rs1.next();
            number.setText(String.valueOf(rs1.getInt(1)));

            expensesData = FXCollections.observableArrayList();
            while (rs.next()) {
                String name = rs.getString("name");
                double amount = rs.getDouble("amount");
                String date = rs.getString("date");

                expensesData.add(new Expenses(name,String.valueOf(amount), date));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private Connection connectMange() {
        // SQLite connection string
        String url =Constants.mangeDB;
        //String url = "jdbc:sqlite:V://projectBms/managedb1.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    Label sumSales, sumStockAmount, sumPurchase, sumProfit, sumExpenses, sumRevenue;

    public void report(Stage stage) {

        Label l1, l2, l3, l4, l5, l6;

        VBox vb2 = super.addnew(stage, "product");

        Label label = new Label("REPORT ");
        label.setFont(Font.font("Calibri", fw, fp, 24));

        Label text = new Label();
        text.setFont(Font.font("Calibri", fw, fp, 18));

        Label start = new Label("First Date:-");
        start.setFont(Font.font("Calibri", fw, fp, 18));

        Label end = new Label("  To   End Date:-");
        end.setFont(Font.font("Calibri", fw, fp, 18));

        Button b1 = new Button("Done");
        b1.setFont(Font.font("Calibri", fw, fp, 16));

        l1 = new Label();
        l1.setFont(Font.font("Calibri", fw, fp, 18));
        sumSales = new Label();
        sumSales.setFont(Font.font("Calibri", fw, fp, 18));

        l2 = new Label();
        l2.setFont(Font.font("Calibri", fw, fp, 18));
        sumStockAmount = new Label();
        sumStockAmount.setFont(Font.font("Calibri", fw, fp, 18));

        l3 = new Label();
        l3.setFont(Font.font("Calibri", fw, fp, 18));
        sumPurchase = new Label();
        sumPurchase.setFont(Font.font("Calibri", fw, fp, 18));

        l4 = new Label();
        l4.setFont(Font.font("Calibri", fw, fp, 18));
        sumProfit = new Label();
        sumProfit.setFont(Font.font("Calibri", fw, fp, 18));

        l5 = new Label();
        l5.setFont(Font.font("Calibri", fw, fp, 18));
        sumExpenses = new Label();
        sumExpenses.setFont(Font.font("Calibri", fw, fp, 18));

        l6 = new Label();
        l6.setFont(Font.font("Calibri", fw, fp, 18));
        sumRevenue = new Label();
        sumRevenue.setFont(Font.font("Calibri", fw, fp, 18));
        TextField tf1 = new TextField();
        tf1.setPrefSize(150, 25);
        tf1.setStyle("-fx-prompt-text-fill:slategray;-fx-text-fill:black;");
        tf1.setFont(Font.font("Calibri", fw, fp, 13));
        tf1.setPromptText("Enter in (yyyy-mm-dd)");

        TextField tf2 = new TextField();
        tf2.setPrefSize(150, 25);
        tf2.setStyle("-fx-prompt-text-fill:slategray;-fx-text-fill:black;");
        tf2.setFont(Font.font("Calibri", fw, fp, 13));
        tf2.setPromptText("Enter in (yyyy-mm-dd)");

        reportTable.setPrefHeight(380);
        reportTable.setPrefWidth(500);
        reportTable.getStylesheets().add("/projectbms/mycss.css");

        TableColumn Col1 = new TableColumn("Product Name");
        Col1.setMinWidth(140);
        Col1.setCellValueFactory(
                new PropertyValueFactory<Report, String>("firstName"));

        TableColumn Col2 = new TableColumn("Qnt Available");
        Col2.setMinWidth(90);
        Col2.setCellValueFactory(
                new PropertyValueFactory<Report, String>("lastName"));

        TableColumn empty = new TableColumn();
        empty.setMinWidth(25);

        TableColumn Col3 = new TableColumn("Opening");
        Col3.setMinWidth(77);
        Col3.setCellValueFactory(
                new PropertyValueFactory<Report, String>("email"));

        TableColumn Col4 = new TableColumn("Purchased");
        Col4.setMinWidth(77);
        Col4.setCellValueFactory(
                new PropertyValueFactory<Report, String>("Price"));

        TableColumn Col5 = new TableColumn("Sold");
        Col5.setMinWidth(77);
        Col5.setCellValueFactory(
                new PropertyValueFactory<Report, String>("Tax"));

        Col1.setCellFactory(col -> createStringCell());
        Col2.setCellFactory(col -> createStringCell());
        Col3.setCellFactory(col -> createStringCell());
        Col4.setCellFactory(col -> createStringCell());
        Col5.setCellFactory(col -> createStringCell());
        empty.setCellFactory(col -> createStringCell());

        reportTable.getColumns().addAll(Col1, Col2, empty, Col3, Col4, Col5);

        HBox hb = new HBox();
        hb.setSpacing(5);
        hb.setPadding(new Insets(0, 10, 0, 10));
        hb.getChildren().addAll(start, tf1, end, tf2);

        HBox hb1 = new HBox();
        hb1.setSpacing(5);
        hb1.setPadding(new Insets(5, 10, 10, 225));
        hb1.getChildren().addAll(label);

        HBox hb2 = new HBox();
        hb2.setSpacing(5);
        hb2.setPadding(new Insets(0, 10, 0, 250));
        hb2.getChildren().addAll(b1);

        HBox hb3 = new HBox();
        hb3.setSpacing(5);
        hb3.setPadding(new Insets(-5, 10, -5, 100));
        hb3.getChildren().addAll(text);

        VBox vb1 = new VBox();
        vb1.getChildren().addAll(hb1, hb, hb2, hb3);
        vb1.setSpacing(15);
        vb1.setPadding(new Insets(10, 10, 10, 10));

        HBox hb4 = new HBox();
        hb4.setSpacing(5);
        hb4.setPadding(new Insets(5, 5, 5, 5));
        hb4.getChildren().addAll(l1, sumSales);

        HBox hb5 = new HBox();
        hb5.setSpacing(5);
        hb5.setPadding(new Insets(5, 5, 5, 5));
        hb5.getChildren().addAll(l2, sumStockAmount);

        HBox hb6 = new HBox();
        hb6.setSpacing(5);
        hb6.setPadding(new Insets(5, 5, 5, 5));
        hb6.getChildren().addAll(l3, sumPurchase);

        HBox hb7 = new HBox();
        hb7.setSpacing(5);
        hb7.setPadding(new Insets(5, 5, 5, 175));
        hb7.getChildren().addAll(l4, sumProfit);

        HBox hb8 = new HBox();
        hb8.setSpacing(5);
        hb8.setPadding(new Insets(5, 5, 5, 110));
        hb8.getChildren().addAll(l5, sumExpenses);

        HBox hb9 = new HBox();
        hb9.setSpacing(5);
        hb9.setPadding(new Insets(5, 5, 5, 140));
        hb9.getChildren().addAll(l6, sumRevenue);

        HBox hb10 = new HBox();
        hb10.setSpacing(5);
        hb10.setPadding(new Insets(5, 5, 5, 5));
        hb10.getChildren().addAll(hb4, hb7);

        HBox hb11 = new HBox();
        hb11.setSpacing(5);
        hb11.setPadding(new Insets(5, 5, 5, 5));
        hb11.getChildren().addAll(hb5, hb8);

        HBox hb12 = new HBox();
        hb12.setSpacing(5);
        hb12.setPadding(new Insets(5, 5, 5, 5));
        hb12.getChildren().addAll(hb6, hb9);

        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(0, 100, 0, 90));
        vbox.getChildren().addAll(vb1, reportTable, hb10, hb11, hb12);

        reportTable.setItems(reportData);

        vb2.getChildren().addAll(vbox);
        vb2.setSpacing(10);
        vb2.setPadding(new Insets(10, 10, 5, 10));

        tf1.requestFocus();

        tf1.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                tf2.requestFocus();
            }
        });

        tf2.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                b1.fire();
            }
        });

        tf1.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) { //when focus lost
                if (!tf1.getText().matches("^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$")) {
                    text.setStyle("-fx-text-fill:red;");
                    text.setText("Please Enter Date In yyyy-mm-dd Format Only");
                    tf1.requestFocus();
                } else {
                    text.setText("");
                }
            }
        });

        tf2.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) { //when focus lost
                if (!tf2.getText().matches("^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$")) {
                    text.setStyle("-fx-text-fill:red;");
                    text.setText("Please Enter Date In yyyy-mm-dd Format Only");
                    tf2.requestFocus();
                } else {
                    text.setText("");
                }
            }
        });

        b1.setOnAction((ActionEvent e) -> {

            displayReport(tf1.getText(), tf2.getText());

            double totalSales = sell.totalSales(tf1.getText(), tf2.getText());
            double stockAmount = sell.stockAmountSold(tf1.getText(), tf2.getText());
            double totalPurchase = buy.totalPurchase(tf1.getText(), tf2.getText());
            double totalProfit = sell.totalProfit(tf1.getText(), tf2.getText());
            double totalExpenses = expenses.totalExpenses(tf1.getText(), tf2.getText());
            double totalRevnue = totalProfit - totalExpenses;

            l1.setText("Total Sales :");
            sumSales.setText(String.valueOf(String.format("%.1f", totalSales)));

            l2.setText("Stock Amount Sold : ");
            sumStockAmount.setText(String.valueOf(String.format("%.1f",stockAmount)));

            l3.setText("Total Purchase : ");
            sumPurchase.setText(String.valueOf(String.format("%.1f",totalPurchase)));

            l4.setText("Total Profit : ");
            sumProfit.setText(String.valueOf(String.format("%.1f",totalProfit)));

            l5.setText("Total Expenses : ");
            sumExpenses.setText(String.valueOf(String.format("%.1f",totalExpenses)));

            l6.setText("Total Revenue : ");
            sumRevenue.setText(String.valueOf(String.format("%.1f",totalRevnue)));
        });

        stage.show();
    }

    private TableCell<Report, String> createStringCell() {
        return new TableCell<Report, String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setText(null);
                } else {
                    setText(item);
                    if (getIndex() == getTableView().getItems().size() - 1) {
                        setStyle("-fx-background-color: lightblue;");
                    }
                }
            }
        };
    }

    public static class Report {

        private final SimpleStringProperty firstName;
        private final SimpleStringProperty lastName;
        private final SimpleStringProperty email;
        private final SimpleStringProperty Price;
        private final SimpleStringProperty Tax;

        private Report(String fName, String lName, String email, String price, String tax) {
            this.firstName = new SimpleStringProperty(fName);
            this.lastName = new SimpleStringProperty(lName);
            this.email = new SimpleStringProperty(email);
            this.Price = new SimpleStringProperty(price);
            this.Tax = new SimpleStringProperty(tax);
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

        public String getTax() {
            return Tax.get();
        }

        public void setTax(String fName) {
            Tax.set(fName);
        }
    }

    public void displayReport(String date1, String date2) {

        String sql = "SELECT stockName,SUM(qnt) FROM " + Constants.purchaseTable
                + " WHERE date BETWEEN '" + date1 + "' and '" + date2 + "' GROUP BY stockName ";

        double totalQntAvl = 0;
        double totalPurchase = 0;
        double totalOpening = 0;
        double totalSales = 0;
        int count = 0;

        try ( Connection conn = this.connect();  Statement stmt = conn.createStatement();  ResultSet rs = stmt.executeQuery(sql)) {

            reportData = FXCollections.observableArrayList();

            while (rs.next()) {
                String stockname = rs.getString("stockName");
                double purchase = rs.getDouble("SUM(qnt)");
                double avlQnt = db.displayItem(stockname);
                double opeingQnt = buy.getOpen(stockname, date1);
                double sale = sell.oneItemQnt(stockname, date1, date2);

                totalQntAvl += avlQnt;
                totalPurchase += purchase;
                totalOpening += opeingQnt;
                totalSales += sale;
                count++;

                reportData.add(new Report(stockname, String.valueOf(avlQnt), String.valueOf(opeingQnt),
                         String.valueOf(purchase), String.valueOf(sale)));
            }

            String totnum = String.valueOf("Total Products : " + count);

            Report lastButOneRow = new Report("", "", "", "", "");
            Report lastRow = new Report(totnum, String.valueOf(totalQntAvl), String.valueOf(totalOpening),
                     String.valueOf(totalPurchase), String.valueOf(totalSales));

            reportData.add(lastButOneRow);
            reportData.add(lastRow);

            reportTable.setItems(reportData);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
