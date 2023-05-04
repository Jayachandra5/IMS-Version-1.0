//Yes
// now useing 
// Main runnable file
package projectbms;

//	deepskyblue
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Formatter;
import java.util.LinkedList;
import java.util.List;
import java.util.function.UnaryOperator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;
import org.controlsfx.control.textfield.TextFields;

public class bmsinterface extends Application {

    dataBase db = new dataBase();
    sellTable stb = new sellTable();
    Product pro = new Product();
    employee emp = new employee();
    expenses exp = new expenses();
    duesTable dueTable = new duesTable();
    Data dataTable = new Data();
    Create create = new Create();
    Reports report = new Reports();
  //  totalAmount ta = new totalAmount();

    TableView<Person> table = new TableView<Person>();
    ObservableList<Person> data;

    TableView<Sell> Selltable = new TableView<Sell>();
    ObservableList<Sell> Selldata;

    TextField searchBar1, searchBar2;

    int screenWidth = (int) Screen.getPrimary().getBounds().getWidth();
    int screenHeight = (int) Screen.getPrimary().getBounds().getHeight();

    List<String> products = new LinkedList<String>();
    
    List<String> customers = new LinkedList<String>();
     
    java.util.Date date = Calendar.getInstance().getTime();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String presentDate = dateFormat.format(date);

    HBox hb1, hb2, hb3, hb4, hb5;
    Label label, b1, b2, b3, b4, b5, b6;
    Label  b7, b8, b9, b10, b11, b12;
    Menu mu1, mu2, mu3, mu4, mu5, mu6, mu7;
    MenuBar mb1, mb2, mb3, mb4, mb5, mb6, mb7;
    MenuItem m11, m12, m13;
    MenuItem m21, m22, m23, m24, m25;
    MenuItem m31, m32, m35, m36;
    MenuItem m41, m42, m43, m44, m45, m46;
    MenuItem m51, m52, m53, m54, m55, m56, m57, m58;
    MenuItem m61, m62, m63;
    MenuItem m71, m72, m73, m74;

    FontWeight fw = FontWeight.BOLD;
    FontPosture fp = FontPosture.REGULAR;

    int sceneWidth = screenWidth;
    int sceneHeight = screenHeight;

    @Override
    public void start(Stage stage) throws Exception {
       
        stage.setTitle("INVENTORY MANAGEMENT SYSTEM ( Version 1.0 )");

        label = new Label("                                                      "
                + "                                                             "
                + "     INVENTORY MANAGEMENT SYSTEM ( Version 1.0 )");

        label.setStyle("-fx-background-color:DODGERBLUE;");
        label.setPrefSize(sceneWidth, 20);
        label.setFont(Font.font("Calibri", fw, fp, 18));

        hb1 = new HBox(label);

        b1 = new Label("Stock Amount");
        b2 = new Label("Total Sales");
        b3 = new Label("Expenses");
        b4 = new Label("Revenue");
        b5 = new Label("Profit");
        b6 = new Label("Tax");

        hb2 = new HBox();
        hb2.getChildren().addAll(b1, b2, b3, b4, b5, b6);
        hb2.setSpacing(200);
        hb2.setPadding(new Insets(0, 10, 0, 10));

        b7 = new Label();
        display("stockamount");

        b8 = new Label();
        display("totalsales");

        b9 = new Label();
        display("expenses");

        b10 = new Label();
        display("profit");

        b11 = new Label();
        revenue();

        b12 = new Label();
        display("tax");

        HBox sm = new HBox();
        sm.getChildren().addAll(b7);
        // sm.setSpacing(50);
        sm.setPadding(new Insets(0, 200, 10, 10));

        HBox ts = new HBox();
        ts.getChildren().addAll(b8);
        // ts.setSpacing(50);
        ts.setPadding(new Insets(0, 190, 10, 10));

        HBox ex = new HBox();
        ex.getChildren().addAll(b9);
        // ex.setSpacing(50);
        ex.setPadding(new Insets(0, 185, 10, 10));

        HBox prof = new HBox();
        prof.getChildren().addAll(b10);
        // prof.setSpacing(50);
        prof.setPadding(new Insets(0, 170, 10, 10));

        HBox rev = new HBox();
        rev.getChildren().addAll(b11);
        // rev.setSpacing(50);
        rev.setPadding(new Insets(0, 170, 10, 10));

        HBox ta = new HBox();
        ta.getChildren().addAll(b12);
        //ta.setSpacing(50);
        ta.setPadding(new Insets(0, 200, 10, 10));

        hb3 = new HBox();
        hb3.getChildren().addAll(sm, ts, ex, prof, rev, ta);
        hb3.setSpacing(10);
        hb3.setPadding(new Insets(0, 10, 10, 10));

        mu1 = new Menu("      Create      ");
        mu2 = new Menu("      Product      ");
        mu3 = new Menu("      Employee      ");
        mu4 = new Menu("      Expenses      ");
        mu5 = new Menu("      Dues      ");
        mu6 = new Menu("      Data      ");
        mu7 = new Menu("      Reports      ");

        m11 = new MenuItem("Date Base");
        m12 = new MenuItem("Table");
        m13 = new MenuItem("Help");

        m21 = new MenuItem("Add New ");
        m22 = new MenuItem("Purchase");
        m23 = new MenuItem("Sell");
        m24 = new MenuItem("Update");
        m25 = new MenuItem("Delete");

        m31 = new MenuItem("Add new");
        m32 = new MenuItem("Attandence");
        m35 = new MenuItem("Update");
        m36 = new MenuItem("Delete");

        m41 = new MenuItem("Rent");
        m42 = new MenuItem("Wages");
        m43 = new MenuItem("Tax");
        m44 = new MenuItem("Bills Paid");
        m45 = new MenuItem("Spoiled");
        m46 = new MenuItem("Others");

        m51 = new MenuItem("Total Due");
        m52 = new MenuItem("Customer List");
        m53 = new MenuItem("Vendor List");
        m54 = new MenuItem("Employee List");
        m55 = new MenuItem("Clear Vendor Due");
        m56 = new MenuItem("Clear Customer Due");
        m57 = new MenuItem("Add Emp Due");
        m58 = new MenuItem("Clear Emp Due");

        m61 = new MenuItem("Vendor List");
        m62 = new MenuItem("Customer List");

        m71 = new MenuItem("Purchase List");
        m72 = new MenuItem("Sales List");
        m73 = new MenuItem("Expneses List");
        m74 = new MenuItem("Report");

        mu1.getItems().addAll(m11, m12, m13);
        mu2.getItems().addAll(m21, m22, m23, m24, m25);
        mu3.getItems().addAll(m31, m32, m35, m36);
        mu4.getItems().addAll(m41, m42, m43, m44, m45, m46);
        mu5.getItems().addAll(m51, m52, m53, m54, m55, m56, m57, m58);
        mu6.getItems().addAll(m61, m62);
        mu7.getItems().addAll(m71, m72, m73, m74);

        mb1 = new MenuBar();
        mb2 = new MenuBar();
        mb3 = new MenuBar();
        mb4 = new MenuBar();
        mb5 = new MenuBar();
        mb6 = new MenuBar();
        mb7 = new MenuBar();

        mb1.getMenus().add(mu1);
        mb2.getMenus().add(mu2);
        mb3.getMenus().add(mu3);
        mb4.getMenus().add(mu4);
        mb5.getMenus().add(mu5);
        mb6.getMenus().add(mu6);
        mb7.getMenus().add(mu7);

        hb4 = new HBox(mb1, mb2, mb3, mb4, mb5, mb6, mb7);

        searchBar1 = new TextField();
        searchBar2 = new TextField();

        searchBar1.setPrefSize(325, 25);
        searchBar2.setPrefSize(250, 25);

        searchBar1.setStyle("-fx-background-color:DODGERBLUE;-fx-prompt-text-fill:black;-fx-text-fill:black;");
        searchBar2.setStyle("-fx-background-color:DODGERBLUE;-fx-prompt-text-fill:black;-fx-text-fill:black;");

        searchBar1.setFont(Font.font("Calibri", fw, fp, 13));
        searchBar2.setFont(Font.font("Calibri", fw, fp, 13));

        searchBar1.setPromptText("🔍 Enter Product Name");
        searchBar2.setPromptText("🔍 Enter Product Name");

        hb5 = new HBox();
        hb5.getChildren().addAll(searchBar1, hb4, searchBar2);

        proTable();

        table.setEditable(true);
        table.setPrefHeight(600);
        table.setPrefWidth(330);
        table.setStyle("-fx-background-color:white;");

        TableColumn firstNameCol = new TableColumn("Name");
        firstNameCol.setMinWidth(110);
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("firstName"));

        TableColumn lastNameCol = new TableColumn("Quantity");
        lastNameCol.setMinWidth(50);
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("lastName"));

        TableColumn emailCol = new TableColumn("MRP");
        emailCol.setMinWidth(50);
        emailCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("email"));

        TableColumn PriceCol = new TableColumn("Price");
        PriceCol.setMinWidth(50);
        PriceCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("Price"));

        TableColumn TaxCol = new TableColumn("TAX%");
        TaxCol.setMinWidth(50);
        TaxCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("Tax"));

        table.getColumns().addAll(firstNameCol, lastNameCol, emailCol, PriceCol, TaxCol);
        table.setItems(data);

        Label label, text, l_1, l_2, l_3, l_4, name, phn;
        TextField tf1, tf2, tf3, nametxt, phntxt;
        CheckBox cb1;
        Button b_1, b_2;

        label = new Label("PRODUCTS SELLING ");
        label.setFont(Font.font("Calibri", fw, fp, 20));

        text = new Label("");
        text.setFont(Font.font("Calibri", fw, fp, 18));

        name = new Label("Enter Customer Name           ");
        phn = new Label("Enter Mobile Number            ");
        l_1 = new Label("Enter Product Name               ");
        l_2 = new Label("Enter Quantity                         ");
        l_3 = new Label("Sell With Feeded Amount     ");
        l_4 = new Label("Enter Selling Price(For 1 unit)");
        l_1.setFont(Font.font("Calibri", fw, fp, 18));
        l_2.setFont(Font.font("Calibri", fw, fp, 18));
        l_3.setFont(Font.font("Calibri", fw, fp, 18));
        l_4.setFont(Font.font("Calibri", fw, fp, 18));
        name.setFont(Font.font("Calibri", fw, fp, 18));
        phn.setFont(Font.font("Calibri", fw, fp, 18));

        nametxt = new TextField();
        phntxt = new TextField();
        tf1 = new TextField();
        tf2 = new TextField();
        tf3 = new TextField();
        tf1.setFont(Font.font("Calibri", fw, fp, 18));
        tf2.setFont(Font.font("Calibri", fw, fp, 18));
        tf3.setFont(Font.font("Calibri", fw, fp, 18));
        nametxt.setFont(Font.font("Calibri", fw, fp, 18));
        phntxt.setFont(Font.font("Calibri", fw, fp, 18));

        cb1 = new CheckBox();

        b_1 = new Button("Add Product");
        b_1.setFont(Font.font("Calibri", fw, fp, 18));
        b_2 = new Button("Proceed");
        b_2.setFont(Font.font("Calibri", fw, fp, 18));

        HBox hb = new HBox();
        hb.getChildren().add(label);
        hb.setSpacing(15);
        hb.setPadding(new Insets(10, 10, 10, 40));

        HBox cs = new HBox();
        cs.getChildren().addAll(name, nametxt);
        cs.setSpacing(15);
        cs.setPadding(new Insets(10, 10, 10, 10));

        HBox mob = new HBox();
        mob.getChildren().addAll(phn, phntxt);
        mob.setSpacing(15);
        mob.setPadding(new Insets(10, 10, 10, 10));

        HBox hb_1 = new HBox();
        hb_1.getChildren().addAll(l_1, tf1);
        hb_1.setSpacing(15);
        hb_1.setPadding(new Insets(10, 10, 10, 10));

        HBox hb_2 = new HBox();
        hb_2.getChildren().addAll(l_2, tf2);
        hb_2.setSpacing(15);
        hb_2.setPadding(new Insets(10, 10, 10, 10));

        HBox hb_3 = new HBox();
        hb_3.getChildren().addAll(l_3, cb1);
        hb_3.setSpacing(15);
        hb_3.setPadding(new Insets(10, 10, 10, 10));

        HBox hb_4 = new HBox();
        hb_4.getChildren().addAll(l_4, tf3);
        hb_4.setSpacing(15);
        hb_4.setPadding(new Insets(10, 10, 10, 10));

        HBox hb_5 = new HBox();
        hb_5.getChildren().addAll(b_1, b_2);
        hb_5.setSpacing(15);
        hb_5.setPadding(new Insets(0, 10, 0, 100));

        HBox hb_6 = new HBox();
        hb_6.getChildren().addAll(text);
        hb_6.setSpacing(0);
        hb_6.setPadding(new Insets(-15, 10, -15, 120));

        VBox vb1 = new VBox();
        vb1.getChildren().addAll(hb, cs, mob, hb_1, hb_2, hb_3, hb_4, hb_5);
        vb1.setSpacing(15);
        vb1.setPadding(new Insets(10, 10, 10, 100));

        VBox v_b = new VBox();
        v_b.getChildren().addAll(hb, vb1, hb_6);
        v_b.setSpacing(15);
        v_b.setPadding(new Insets(10, 130, 10, 50));

        display_sellTable();

        Selltable.setEditable(true);
        Selltable.setPrefHeight(600);
        Selltable.setPrefWidth(250);
        Selltable.setStyle("-fx-color:white;");

        TableColumn Col1 = new TableColumn("Name");
        Col1.setMinWidth(100);
        Col1.setCellValueFactory(
                new PropertyValueFactory<Sell, String>("firstName"));

        TableColumn Col2 = new TableColumn("Price");
        Col2.setMinWidth(80);
        Col2.setCellValueFactory(
                new PropertyValueFactory<Sell, String>("lastName"));

        TableColumn Col3 = new TableColumn("Quantity");
        Col3.setMinWidth(70);
        Col3.setCellValueFactory(
                new PropertyValueFactory<Sell, String>("email"));

        Selltable.getColumns().addAll(Col1, Col2, Col3);

        VBox vboxST = new VBox();
        vboxST.setSpacing(5);
        vboxST.setPadding(new Insets(0, 0, 0, 0));
        vboxST.getChildren().addAll(Selltable);
        Selltable.setItems(Selldata);

        HBox hbox = new HBox();
        hbox.getChildren().addAll(table, v_b, Selltable);
        // hbox.setSpacing(15);
        hbox.setPadding(new Insets(0, 0, 0, 0));

        VBox vb = new VBox();
        vb.setSpacing(10);
        vb.setPadding(new Insets(10, 10, 10, 10));
        vb.getChildren().addAll(hb1, hb2, hb3, hb5, hbox);

        Scene sc = new Scene(new Group(), sceneWidth, sceneHeight - 70);
      
        Image image = new Image("C:\\IMS\\splash.gif");
        ImageView imageView = new ImageView(image);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(0), new KeyValue(imageView.opacityProperty(), 0.0)));
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(1000), new KeyValue(imageView.opacityProperty(), 1.0)));
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(5000), new KeyValue(imageView.opacityProperty(), 1.0)));
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(6000), new KeyValue(imageView.opacityProperty(), 0.0)));
        timeline.setCycleCount(1);
        timeline.setOnFinished(event -> {
            ((Group) sc.getRoot()).getChildren().addAll(vb);
            stage.setMaximized(true);
            stage.setScene(sc);
            stage.show();
        });
        timeline.play();
        StackPane root = new StackPane(imageView);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        b_1.setOnAction((ActionEvent e) -> {
            String csname = nametxt.getText();
            String csphn = phntxt.getText();
            String text1 = tf1.getText();
            String text2 = tf2.getText();
            String text3 = tf3.getText();

            if ((text1 == null || text1.matches("\\s*")) && (text2 == null || text2.matches("\\s*"))) {
                text.setStyle("-fx-text-fill:red;");
                text.setText("Please Enter Data Before Proceeding");
            } else if (csname == null || csname.matches("\\s*")) {
                text.setStyle("-fx-text-fill:red;");
                text.setText("Please Enter Product Name Before Proceeding");
            } else if (csphn == null || csphn.matches("\\s*")) {
                text.setStyle("-fx-text-fill:red;");
                text.setText("Please Enter Product Name Before Proceeding");
            } else if (text1 == null || text1.matches("\\s*")) {
                text.setStyle("-fx-text-fill:red;");
                text.setText("Please Enter Product Name Before Proceeding");
            } else if (text2 == null || text2.matches("\\s*")) {
                text.setStyle("-fx-text-fill:red;");
                text.setText("Please Enter Quantity Before Proceeding");
            } else if (!text2.matches("-?\\d+(\\.\\d+)?")) {
                text.setStyle("-fx-text-fill:red;");
                text.setText("Input Mismatch (Please Enter Number, not character)");
            } else if (!cb1.isSelected()) {
                if (text3 == null || text3.matches("\\s*")) {
                    text.setStyle("-fx-text-fill:red;");
                    text.setText("Please Enter Product Name Before Proceeding");
                } else {
                    double sellingPrice = Double.parseDouble(text3);
                    double d = Double.parseDouble(tf2.getText());
                    
                    int x = db.redcuceqnt(text1, d, sellingPrice, dateFormat.format(date), csname);
                    switch (x) {
                        case 1 -> {
                            text.setStyle("-fx-text-fill:red;");
                            text.setText("No Such Product Available");
                        }
                        case 2 -> {
                            text.setStyle("-fx-text-fill:red;");
                            text.setText("Selling Quantity is more than available");
                        }
                        case 3 -> {
                            text.setStyle("-fx-text-fill:black;");
                            text.setText("Selling Entered");
                          //  billData.insert(text1, d, sellingPrice);
                            Data csData = new Data();
                            double onePrice = d * sellingPrice;
                            csData.insertCustomer(csname, onePrice, csphn);
                            totalAmount tat = new totalAmount();
                            tat.insert(csname, onePrice);
                            display("stockamount");
                            display("totalsales");
                            display("profit");
                            revenue();
                            proTable();
                            table.setItems(data);
                            display_sellTable();
                            Selltable.setItems(Selldata);
                            tf1.clear();
                            tf2.clear();
                            tf3.clear();
                           
                            tf1.requestFocus();
                        }
                        default -> {

                        }
                    }
                }
            } else {
                //new
                double sellingPrice = stb.getprice(text1);
                double d = Double.parseDouble(tf2.getText());
                int x = db.redcuceqnt(text1, d, sellingPrice, dateFormat.format(date), csname);
                switch (x) {
                    case 1 -> {
                        text.setStyle("-fx-text-fill:red;");
                        text.setText("No Such Product Available");
                    }
                    case 2 -> {
                        text.setStyle("-fx-text-fill:red;");
                        text.setText("Selling Quantity is more than available");
                    }
                    case 3 -> {
                        text.setStyle("-fx-text-fill:black;");
                        text.setText("Selling Entered");
                      //  billData.insert(text1, d, sellingPrice);
                        Data csData = new Data();
                        double onePrice = d * sellingPrice;
                        csData.insertCustomer(csname, onePrice, csphn);
                        totalAmount tat = new totalAmount();
                        tat.insert(csname, onePrice);
                        display("stockamount");
                        display("totalsales");
                        display("profit");
                        revenue();
                        proTable();
                        table.setItems(data);
                        display_sellTable();
                        Selltable.setItems(Selldata);
                        tf1.clear();
                        tf2.clear();
                        tf3.clear();
                         cb1.fire();
                        tf1.requestFocus();
                    }
                    default -> {

                    }
                }
            }

        });

        b_2.setOnAction((ActionEvent e) -> {
            pro.proceed(stage);
        });

        nametxt.requestFocus();

        nametxt.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                phntxt.requestFocus();
            }
            if (event.getCode() == KeyCode.DOWN) {
                phntxt.requestFocus();
            }
        });

        phntxt.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                tf1.requestFocus();
            }
            if (event.getCode() == KeyCode.UP) {
                nametxt.requestFocus();
            }
            if (event.getCode() == KeyCode.DOWN) {
                tf1.requestFocus();
            }
        });

        tf1.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                tf2.requestFocus();
            }
            if (event.getCode() == KeyCode.DOWN) {
                tf2.requestFocus();
            }
        });

        tf2.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                cb1.requestFocus();
            }
            if (event.getCode() == KeyCode.UP) {
                tf1.requestFocus();
            }
            if (event.getCode() == KeyCode.DOWN) {
                cb1.requestFocus();
            }
        });

        cb1.setOnKeyPressed(event -> {
            if (cb1.isSelected()) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    b_1.fire();
                }
            }
            if (event.getCode() == KeyCode.UP) {
                tf2.requestFocus();
            }
            if (event.getCode() == KeyCode.DOWN) {
                tf3.requestFocus();
            }
        });

        tf3.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.UP) {
                tf2.requestFocus();
            }
            if (event.getCode().equals(KeyCode.ENTER)) {
                b_1.fire();
            }
        });

        cb1.setOnAction(event -> {
            tf3.setDisable(cb1.isSelected());
        });

        tf3.textProperty().addListener((observable, oldValue, newValue) -> {
            cb1.setDisable(!newValue.trim().isEmpty());
        });

        phntxt.setTextFormatter(new TextFormatter<>(getUnaryOperator()));
        tf2.setTextFormatter(new TextFormatter<>(getUnaryOperator()));
        tf3.setTextFormatter(new TextFormatter<>(getUnaryOperator()));

       // proTable();
        TextFields.bindAutoCompletion(tf1, products);
        
        displayCustomerTable();
        TextFields.bindAutoCompletion(nametxt, customers);
        
        FilteredList<Person> filterdBuyData = new FilteredList<>(data, b -> true);

        searchBar1.textProperty().addListener((observable, oldValue, newValue) -> {
            filterdBuyData.setPredicate(Person -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (Person.getFirstName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        SortedList<Person> sortedData = new SortedList<>(filterdBuyData);

        sortedData.comparatorProperty().bind(table.comparatorProperty());

        table.setItems(sortedData);

        FilteredList<Sell> filterSellData = new FilteredList<>(Selldata, b -> true);

        searchBar2.textProperty().addListener((observable, oldValue, newValue) -> {
            filterSellData.setPredicate(Sell -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (Sell.getFirstName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        SortedList<Sell> sortedSellData = new SortedList<>(filterSellData);

        sortedSellData.comparatorProperty().bind(Selltable.comparatorProperty());

        Selltable.setItems(sortedSellData);

        TextFields.bindAutoCompletion(tf1, products);

        // Create 
        m11.setOnAction((ActionEvent e) -> {
            create.createDb(stage);
        });

        m12.setOnAction((ActionEvent e) -> {
            create.createTable(stage);
        });

        m13.setOnAction((ActionEvent e) -> {
            create.Help(stage);
        });

        // Product
        m21.setOnAction((ActionEvent e) -> {
            pro.addnew(stage);
        });

        m22.setOnAction((ActionEvent e) -> {
            pro.purchase(stage);
        });

        m24.setOnAction((ActionEvent e) -> {
            pro.update(stage);
        });

        m25.setOnAction((ActionEvent e) -> {
            pro.delete(stage);
        });

        // employee
        m31.setOnAction((ActionEvent e) -> {
            emp.addnew(stage);
        });

        m32.setOnAction((ActionEvent e) -> {
            emp.attandnce(stage);
        });

        m35.setOnAction((ActionEvent e) -> {
            emp.update(stage);
        });

        m36.setOnAction((ActionEvent e) -> {
            emp.delete(stage);
        });

        // Expenses
        m41.setOnAction((ActionEvent e) -> {
            exp.rent(stage);
        });

        m42.setOnAction((ActionEvent e) -> {
            exp.wages(stage);
        });

        m43.setOnAction((ActionEvent e) -> {
            exp.tax(stage);
        });

        m44.setOnAction((ActionEvent e) -> {
            exp.bills(stage);
        });

        m45.setOnAction((ActionEvent e) -> {
            exp.spoiled(stage);
        });

        m46.setOnAction((ActionEvent e) -> {
            exp.others(stage);
        });

        // Dues
        m51.setOnAction((ActionEvent e) -> {
            dueTable.totalDue(stage);
        });

        m52.setOnAction((ActionEvent e) -> {
            dueTable.customerDueTable(stage);
        });

        m53.setOnAction((ActionEvent e) -> {
            dueTable.VendourTable(stage);
        });

        m54.setOnAction((ActionEvent e) -> {
            dueTable.EmpDueTable(stage);
        });

        m55.setOnAction((ActionEvent e) -> {
            dueTable.VendourClearDue(stage);
        });

        m56.setOnAction((ActionEvent e) -> {
            dueTable.CustomerClearDue(stage);
        });

        m57.setOnAction((ActionEvent e) -> {
            dueTable.EmpAddDue(stage);
        });

        m58.setOnAction((ActionEvent e) -> {
            dueTable.EmpClearDue(stage);
        });

        // DATA
        m61.setOnAction((ActionEvent e) -> {
            dataTable.vendourTable(stage);
        });

        m62.setOnAction((ActionEvent e) -> {
            dataTable.customerTable(stage);
        });

        // REPORTS
        m71.setOnAction((ActionEvent e) -> {
            report.purchaseTable(stage);
        });

        m72.setOnAction((ActionEvent e) -> {
            report.SalesTable(stage);
        });

        m73.setOnAction((ActionEvent e) -> {
            report.expensesTable(stage);
        });

        m74.setOnAction((ActionEvent e) -> {
            report.report(stage);
        });
    }
    

    public UnaryOperator<TextFormatter.Change> getUnaryOperator() {
        return change -> {
            String newText = change.getControlNewText();
            if (newText.length() <= 10 && newText.matches("^\\d*\\.?\\d{0,1}$")) {
                return change;
            }
            return null;
        };
    }
    /*  public boolean doubleCheck(String check){
         int index = 0;
         boolean out=false;
         
            while ( index < check.length()){
                char abc = check.charAt(index);
                System.out.println(abc);
                if( abc == '.' ||(!(check.charAt(index) >= '0'&& check.charAt(index) <= '9'))){
                    out = true;
                }
                index++;
            }
            return out;
    }  */
    public void display(String name) {
        String sql = "SELECT  * "
                + "FROM " + Constants.manage + " WHERE name = ?";

        try ( Connection conn = this.connect();  PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);

            ResultSet rs = pstmt.executeQuery();

            Formatter formatter = new Formatter();
            double price;

            while (rs.next()) {
                price = rs.getDouble("amount");
                formatter.format("%.2f", price);
            }

            String amount = String.valueOf(formatter.toString());

            if (name.equals("stockamount")) {
                b7.setText(amount);
            }
            if (name.equals("totalsales")) {
                b8.setText(amount);
            }
            if (name.equals("expenses")) {
                b9.setText(amount);
            }
            if (name.equals("profit")) {
                b10.setText(amount);
            }
            if (name.equals("tax")) {
                b12.setText(amount);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void revenue() {
        String name1 = "profit";
        String name2 = "expenses";

        String sql = "SELECT  * "
                + "FROM " + Constants.manage + " WHERE name = ?";

        String sql1 = "SELECT  * "
                + "FROM " + Constants.manage + " WHERE name = ?";
        try ( Connection conn = this.connect();  PreparedStatement pstmt = conn.prepareStatement(sql);  PreparedStatement pstmt1 = conn.prepareStatement(sql1)) {

            pstmt.setString(1, name1);
            pstmt1.setString(1, name2);

            ResultSet rs = pstmt.executeQuery();
            ResultSet rs1 = pstmt1.executeQuery();

            Formatter formatter = new Formatter();
            double profit = 0;

            while (rs.next()) {
                profit = rs.getDouble("amount");
            }

            double expenses = 0;
            while (rs1.next()) {
                expenses = rs1.getDouble("amount");
            }

            double revenue = profit - expenses;
            formatter.format("%.2f", revenue);

            String Rev = String.valueOf(formatter.toString());
            b11.setText(Rev);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private Connection connect() {
        // SQLite connection string
        //   String url = "jdbc:sqlite:V://projectBms/managedb1.db";
        String url = Constants.mangeDB;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void proTable() {

        String sql = "SELECT * FROM " + Constants.ProductTable + " ORDER BY stockname";
        String sql1 = "SELECT COUNT(*) FROM " + Constants.ProductTable + "";

        try ( Connection conn = this.connect_2();  Statement stmt = conn.createStatement();  ResultSet rs = stmt.executeQuery(sql);  Statement stmt1 = conn.createStatement();  ResultSet rs1 = stmt1.executeQuery(sql1)) {

            rs1.next();
            int count = rs1.getInt(1);
            Formatter formatter = new Formatter();

            //System.out.println("TOTAL NUMBER OF PRODUCTS :" + count);
            data = FXCollections.observableArrayList();

            while (rs.next()) {
                String stockname = rs.getString("stockname");
                double quantity = rs.getDouble("quantity");
                double mrp = rs.getDouble("mrp");
                double price = rs.getDouble("price");
                double tax = rs.getDouble("tax");

                formatter.format("%.1f", quantity);
                formatter.format("%.1f", mrp);
                formatter.format("%.1f", price);
                formatter.format("%.1f", tax);

                String qnt = String.valueOf(quantity);
                String mrp1 = String.valueOf(mrp);
                String price1 = String.valueOf(price);
                String tax1 = String.valueOf(tax);

                products.add(stockname);

                data.add(new Person(stockname, qnt, mrp1, price1, tax1));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static class Person {

        private final SimpleStringProperty firstName;
        private final SimpleStringProperty lastName;
        private final SimpleStringProperty email;
        private final SimpleStringProperty Price;
        private final SimpleStringProperty Tax;

        private Person(String fName, String lName, String email, String price, String tax) {
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

    private Connection connect_2() {
        // SQLite connection string
        // String url = "jdbc:sqlite:V://projectBms/bmsList1.db";

        String url = Constants.productDB;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static class Sell {

        private final SimpleStringProperty firstName;
        private final SimpleStringProperty lastName;
        private final SimpleStringProperty email;

        private Sell(String fName, String lName, String email) {
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

    public void display_sellTable() {
        String sql = "SELECT * FROM " + Constants.sellTable + " ORDER BY stockname";
        String sql1 = "SELECT COUNT(*) FROM " + Constants.sellTable;

        try ( Connection conn = this.connect_2();  Statement stmt = conn.createStatement();  ResultSet rs = stmt.executeQuery(sql);  Statement stmt1 = conn.createStatement();  ResultSet rs1 = stmt1.executeQuery(sql1)) {

            rs1.next();

            int count = rs1.getInt(1);

            //    System.out.println("TOTAL NUMBER OF PRODUCTS :" + count);
            Selldata = FXCollections.observableArrayList();

            Formatter formatter = new Formatter();
            while (rs.next()) {
                String stockname = rs.getString("stockname");
                double price = rs.getDouble("price");
                double qnt = rs.getDouble("qnt");

                formatter.format("%.1f", price);
                String price1 = String.valueOf(price);

                formatter.format("%.1f", qnt);
                String qnt1 = String.valueOf(qnt);

                Selldata.add(new Sell(stockname, price1, qnt1));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void displayCustomerTable() {

        String sql = "SELECT * FROM " + Constants.customerTable + " ORDER BY cName";

        try ( Connection conn = this.connect();  Statement stmt = conn.createStatement();  
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String vendourName = rs.getString("cName");
                customers.add(vendourName);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
