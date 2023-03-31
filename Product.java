package projectbms;

import java.util.*;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.sql.*;
import java.util.List;
import org.controlsfx.control.textfield.TextFields;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.function.UnaryOperator;
import javafx.collections.FXCollections;
import javafx.scene.control.TextFormatter;
import javafx.scene.text.Text;

public class Product extends parentform {

    Label text;
    dataBase db = new dataBase();
    sellTable stb = new sellTable();
    Data info = new Data();
    dues due = new dues();
    Purchase pur = new Purchase();
    BillData billData = new BillData();

    String profit = "profit";

    List<String> products = new LinkedList<String>();

    List<String> vendours = new LinkedList<String>();
    
    List<String> customers = new LinkedList<String>();

    FontWeight fw = FontWeight.BOLD;
    FontPosture fp = FontPosture.REGULAR;

    String stockAmount = "stockamount";

    java.util.Date date = Calendar.getInstance().getTime();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String presentDate = dateFormat.format(date);

    public VBox addnew(Stage stage) {

        try {

            VBox vb2 = super.addnew(stage, "product");

            TextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, name;
            Label text, label, l1, l2, l3, l4, l5, l6, l7, l8, l9, vendour, todayDate;
            CheckBox cb1;

            Button b1;

            label = new Label("ADDING NEW PRODUCT ");
            label.setFont(Font.font("Calibri", fw, fp, 22));

            text = new Label("");
            text.setFont(Font.font("Calibri", fw, fp, 18));

            l1 = new Label("Product Name             ");
            vendour = new Label("Vendor Name             ");
            l2 = new Label("Product MRP              ");
            l3 = new Label("Buying Price                ");
            l4 = new Label("Quantity Purchased   ");
            l5 = new Label("Tax(CGST+SGST)%      ");
            l6 = new Label("Selling Price                 ");
            l7 = new Label("Amount Paid               ");
            l8 = new Label("Purchased Today            ");
            l9 = new Label("Else Purchasing Date  ");
            todayDate = new Label("( " + presentDate + " )");

            l1.setFont(Font.font("Calibri", fw, fp, 18));
            vendour.setFont(Font.font("Calibri", fw, fp, 18));
            l2.setFont(Font.font("Calibri", fw, fp, 18));
            l3.setFont(Font.font("Calibri", fw, fp, 18));
            l4.setFont(Font.font("Calibri", fw, fp, 18));
            l5.setFont(Font.font("Calibri", fw, fp, 18));
            l6.setFont(Font.font("Calibri", fw, fp, 18));
            l7.setFont(Font.font("Calibri", fw, fp, 18));
            l8.setFont(Font.font("Calibri", fw, fp, 18));
            l9.setFont(Font.font("Calibri", fw, fp, 18));

            tf1 = new TextField();
            name = new TextField();
            tf2 = new TextField();
            tf3 = new TextField();
            tf4 = new TextField();
            tf5 = new TextField();
            tf6 = new TextField();
            tf7 = new TextField();
            tf8 = new TextField();

            tf1.setFont(Font.font("Calibri", fw, fp, 18));
            name.setFont(Font.font("Calibri", fw, fp, 18));
            tf2.setFont(Font.font("Calibri", fw, fp, 18));
            tf3.setFont(Font.font("Calibri", fw, fp, 18));
            tf4.setFont(Font.font("Calibri", fw, fp, 18));
            tf5.setFont(Font.font("Calibri", fw, fp, 18));
            tf6.setFont(Font.font("Calibri", fw, fp, 18));
            tf7.setFont(Font.font("Calibri", fw, fp, 18));
            tf8.setFont(Font.font("Calibri", fw, fp, 18));

            b1 = new Button("Done");
            b1.setFont(Font.font("Calibri", fw, fp, 18));

            cb1 = new CheckBox();

            tf8.setPromptText("YYYY-MM-DD Format");

            HBox hb = new HBox();
            hb.getChildren().addAll(label);
            hb.setSpacing(7);
            hb.setPadding(new Insets(0, 0, 0, 30));

            HBox hb1 = new HBox();
            hb1.getChildren().addAll(l1, tf1);
            hb1.setSpacing(7);
            //hb1.setPadding(new Insets(5, 5, 5, 5));

            HBox vendourName = new HBox();
            vendourName.getChildren().addAll(vendour, name);
            vendourName.setSpacing(7);
            //vendourName.setPadding(new Insets(5, 5, 5, 5));

            HBox hb2 = new HBox();
            hb2.getChildren().addAll(l2, tf2);
            hb2.setSpacing(7);
            //hb2.setPadding(new Insets(5, 5, 5, 5));

            HBox hb3 = new HBox();
            hb3.getChildren().addAll(l3, tf3);
            hb3.setSpacing(7);
            //hb3.setPadding(new Insets(5, 5, 5, 5));

            HBox hb4 = new HBox();
            hb4.getChildren().addAll(l4, tf4);
            hb4.setSpacing(7);
            // hb4.setPadding(new Insets(5, 5, 5, 5));

            HBox hb5 = new HBox();
            hb5.getChildren().addAll(l5, tf5);
            hb5.setSpacing(7);
            // hb5.setPadding(new Insets(5, 5, 5, 5));

            HBox hb6 = new HBox();
            hb6.getChildren().addAll(l6, tf6);
            hb6.setSpacing(7);
            //hb6.setPadding(new Insets(5, 5, 5, 5));

            HBox hb7 = new HBox();
            hb7.getChildren().addAll(l7, tf7);
            hb7.setSpacing(7);
            //hb7.setPadding(new Insets(5, 5, 5, 5));

            HBox hb8 = new HBox();
            hb8.getChildren().addAll(l8, cb1, todayDate);
            hb8.setSpacing(7);
            hb8.setPadding(new Insets(5, 5, 5, 5));

            HBox hb9 = new HBox();
            hb9.getChildren().addAll(l9, tf8);
            hb9.setSpacing(7);
            //hb9.setPadding(new Insets(5, 5, 5, 5));

            HBox hb10 = new HBox();
            hb10.getChildren().addAll(b1);
            hb10.setSpacing(7);
            hb10.setPadding(new Insets(0, 0, 0, 160));

            HBox dis = new HBox();
            dis.getChildren().addAll(text);
            dis.setSpacing(7);
            dis.setPadding(new Insets(0, 50, 0, 100));

            VBox vb1 = new VBox();
            vb1.getChildren().addAll(hb1, vendourName, hb2, hb3, hb4, hb5, hb6, hb7, hb8, hb9, hb10);
            vb1.setSpacing(10);
            vb1.setPadding(new Insets(5, 5, 5, 100));

            VBox vb = new VBox();
            vb.getChildren().addAll(hb, vb1, dis);
            vb.setSpacing(10);
            vb.setPadding(new Insets(0, 150, 0, 100));

            // VBox vb2 = new VBox();
            vb2.getChildren().addAll(vb);
            vb2.setSpacing(10);
            vb2.setPadding(new Insets(10, 10, 5, 10));

            //   Scene scene = new Scene(vb2,sceneWidth,sceneHeight-70);
            //   stage.setScene(scene);
            stage.show();

            b1.setOnAction((ActionEvent e) -> {

                String text1 = tf1.getText();
                String nametext = name.getText();
                String text2 = tf2.getText();
                String text3 = tf3.getText();
                String text4 = tf4.getText();
                String text5 = tf5.getText();
                String text6 = tf6.getText();
                String text7 = tf7.getText();
                String text8 = tf8.getText();

                if ((text1 == null || text1.matches("\\s*")) && (text2 == null || text2.matches("\\s*")
                        && (text3 == null || text3.matches("\\s*") && (text4 == null || text4.matches("\\s*")
                        && (text5 == null || text5.matches("\\s*") && (text6 == null || text6.matches("\\s*")
                        && (text7 == null || text7.matches("\\s*") && (text8 == null || text8.matches("\\s*")
                        && (nametext == null || nametext.matches("\\s*")))))))))) {
                    text.setStyle("-fx-text-fill:red;");
                    text.setText("Please Enter Data Before Proceeding");
                } else if (text1 == null || text1.matches("\\s*")) {
                    text.setStyle("-fx-text-fill:red;");
                    text.setText("Please Enter Product Name Before Proceeding");
                } else if (nametext == null || nametext.matches("\\s*")) {
                    text.setStyle("-fx-text-fill:red;");
                    text.setText("Please Enter Vendour Name Before Proceeding");
                } else if (text2 == null || text2.matches("\\s*")) {
                    text.setStyle("-fx-text-fill:red;");
                    text.setText("Please Enter MRP Before Proceeding");
                } else if (text3 == null || text3.matches("\\s*")) {
                    text.setStyle("-fx-text-fill:red;");
                    text.setText("Please Enter Buying Price Before Proceeding");
                } else if (text4 == null || text4.matches("\\s*")) {
                    text.setStyle("-fx-text-fill:red;");
                    text.setText("Please Enter Quantity Before Proceeding");
                } else if (text5 == null || text5.matches("\\s*")) {
                    text.setStyle("-fx-text-fill:red;");
                    text.setText("Please Enter Tax Before Proceeding");
                } else if (text6 == null || text6.matches("\\s*")) {
                    text.setStyle("-fx-text-fill:red;");
                    text.setText("Please Enter Selling Price Before Proceeding");
                } else if (text7 == null || text7.matches("\\s*")) {
                    text.setStyle("-fx-text-fill:red;");
                    text.setText("Please Enter Amount Before Proceeding");
                } else if (!text2.matches("-?\\d+(\\.\\d+)?")) {
                    text.setStyle("-fx-text-fill:red;");
                    text.setText("Input Mismatch (Please Enter Number, not character)");
                } else if (!cb1.isSelected()) {

                    if (text8 == null || text8.matches("\\s*")) {
                        text.setStyle("-fx-text-fill:red;");
                        text.setText("Please Enter Date Before Proceeding");
                    } else if (!text8.matches("^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$")) {
                        text.setStyle("-fx-text-fill:red;");
                        text.setText("Please Enter Date In yyyy-mm-dd Format Only");
                        tf2.requestFocus();
                    } else {
                        double d1 = Double.parseDouble(tf2.getText());
                        double d2 = Double.parseDouble(tf3.getText());
                        double result = (double) Math.round(d2 * 10) / 10;
                        double d3 = Double.parseDouble(tf4.getText());
                        double d4 = Double.parseDouble(tf5.getText());
                        double d5 = Double.parseDouble(tf6.getText());
                        double d6 = Double.parseDouble(tf7.getText());

                        double purchase = d2 * d3;

                        if (d1 < d2) {
                            text.setStyle("-fx-text-fill:red;");
                            text.setText("Buying Price Cant Be Greater Than Mrp");
                        } else if (d1 < d5) {
                            text.setStyle("-fx-text-fill:red;");
                            text.setText("Selling Price Cant Be Greater Than Mrp");
                        } else if (d5 < d2) {
                            text.setStyle("-fx-text-fill:red;");
                            text.setText("Selling Price Cant Be Less Than Buying Price");
                        } else {
                            double dueAmount = purchase - d6;

                            int y = due.insertour(name.getText(), dueAmount);
                            double removeDue = -1 * dueAmount;

                            if (y == 2) {
                                text.setStyle("-fx-text-fill:red;");
                                text.setText("Paid More Than Purchase & Due Amount");

                            } else {
                                int x = db.insert(tf1.getText().toLowerCase(), d1, result, d3, d4);

                                if (x == 1) {
                                    text.setStyle("-fx-text-fill:red;");
                                    text.setText("Product already exists, Update If Necessary");
                                    due.insertour(name.getText(), removeDue);
                                } else if (x == 2) {
                                    stb.insert(tf1.getText().toLowerCase(), d5, d3);
                                    display(stockAmount);
                                    proTable();
                                    table.setItems(data);
                                    display_sellTable();
                                    Selltable.setItems(Selldata);
                                    info.insertVendour(name.getText(), purchase);
                                    double avlQnt = db.displayItem(tf1.getText().toLowerCase());

                                    String currentDate;

                                    currentDate = tf8.getText();
                                    pur.insert(tf1.getText().toLowerCase(), d3, purchase, avlQnt,
                                            currentDate, name.getText().toLowerCase());

                                    text.setStyle("-fx-text-fill:black;");
                                    text.setText("Product added");

                                    tf1.clear();
                                    tf2.clear();
                                    name.clear();
                                    tf3.clear();
                                    tf4.clear();
                                    tf5.clear();
                                    tf6.clear();
                                    tf7.clear();
                                    tf8.clear();
                                    tf1.requestFocus();
                                }
                            }
                        }
                    }
                } else {
                    //new
                    double d1 = Double.parseDouble(tf2.getText());
                    double d2 = Double.parseDouble(tf3.getText());
                    double result = (double) Math.round(d2 * 10) / 10;
                    double d3 = Double.parseDouble(tf4.getText());
                    double d4 = Double.parseDouble(tf5.getText());
                    double d5 = Double.parseDouble(tf6.getText());
                    double d6 = Double.parseDouble(tf7.getText());

                    double purchase = d2 * d3;

                    if (d1 < d2) {
                        text.setStyle("-fx-text-fill:red;");
                        text.setText("Buying Price Cant Be Greater Than Mrp");
                    } else if (d1 < d5) {
                        text.setStyle("-fx-text-fill:red;");
                        text.setText("Selling Price Cant Be Greater Than Mrp");
                    } else if (d5 < d2) {
                        text.setStyle("-fx-text-fill:red;");
                        text.setText("Selling Price Cant Be Less Than Buying Price");
                    } else {
                        double dueAmount = purchase - d6;

                        int y = due.insertour(name.getText(), dueAmount);
                        double removeDue = -1 * dueAmount;

                        if (y == 2) {
                            text.setStyle("-fx-text-fill:red;");
                            text.setText("Paid More Than Purchase & Due Amount");

                        } else {
                            int x = db.insert(tf1.getText().toLowerCase(), d1, result, d3, d4);

                            if (x == 1) {
                                text.setStyle("-fx-text-fill:red;");
                                text.setText("Product already exists, Update If Necessary");
                                due.insertour(name.getText(), removeDue);
                            } else if (x == 2) {
                                stb.insert(tf1.getText().toLowerCase(), d5, d3);
                                display(stockAmount);
                                proTable();
                                table.setItems(data);
                                display_sellTable();
                                Selltable.setItems(Selldata);
                                info.insertVendour(name.getText(), purchase);
                                double avlQnt = db.displayItem(tf1.getText().toLowerCase());

                                String currentDate;

                                currentDate = dateFormat.format(date);
                                pur.insert(tf1.getText().toLowerCase(), d3, purchase,
                                        avlQnt, currentDate, name.getText().toLowerCase());

                                text.setStyle("-fx-text-fill:black;");
                                text.setText("Product added");

                                tf1.clear();
                                tf2.clear();
                                name.clear();
                                tf3.clear();
                                tf4.clear();
                                tf5.clear();
                                tf6.clear();
                                tf7.clear();
                                tf8.clear();
                                tf1.requestFocus();
                                cb1.fire();
                            }
                        }
                    }
                }
            });

            tf1.requestFocus();

            tf1.setOnKeyPressed(event -> {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    name.requestFocus();
                }
                if (event.getCode() == KeyCode.DOWN) {
                    name.requestFocus();
                }
            });

            name.setOnKeyPressed(event -> {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    tf2.requestFocus();
                }
                if (event.getCode() == KeyCode.UP) {
                    tf1.requestFocus();
                }
                if (event.getCode() == KeyCode.DOWN) {
                    tf2.requestFocus();
                }
            });

            tf2.setOnKeyPressed(event -> {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    tf3.requestFocus();
                }
                if (event.getCode() == KeyCode.UP) {
                    name.requestFocus();
                }
                if (event.getCode() == KeyCode.DOWN) {
                    tf3.requestFocus();
                }
            });

            tf3.setOnKeyPressed(event -> {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    tf4.requestFocus();
                }
                if (event.getCode() == KeyCode.UP) {
                    tf2.requestFocus();
                }
                if (event.getCode() == KeyCode.DOWN) {
                    tf4.requestFocus();
                }
            });

            tf4.setOnKeyPressed(event -> {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    tf5.requestFocus();
                }
                if (event.getCode() == KeyCode.UP) {
                    tf3.requestFocus();
                }
                if (event.getCode() == KeyCode.DOWN) {
                    tf5.requestFocus();
                }
            });

            tf5.setOnKeyPressed(event -> {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    tf6.requestFocus();
                }
                if (event.getCode() == KeyCode.UP) {
                    tf4.requestFocus();
                }
                if (event.getCode() == KeyCode.DOWN) {
                    tf6.requestFocus();
                }
            });

            tf6.setOnKeyPressed(event -> {
                if (event.getCode() == KeyCode.UP) {
                    tf5.requestFocus();
                }
                if (event.getCode().equals(KeyCode.ENTER)) {
                    tf7.requestFocus();
                }
                if (event.getCode() == KeyCode.DOWN) {
                    tf7.requestFocus();
                }
            });

            tf7.setOnKeyPressed(event -> {
                if (event.getCode() == KeyCode.UP) {
                    tf6.requestFocus();
                }
                if (event.getCode().equals(KeyCode.ENTER)) {
                    cb1.requestFocus();
                }
                if (event.getCode() == KeyCode.DOWN) {
                    cb1.requestFocus();
                }
            });

            cb1.setOnKeyPressed(event -> {
                if (cb1.isSelected()) {
                    if (event.getCode().equals(KeyCode.ENTER)) {
                        b1.fire();
                    }
                }
                if (event.getCode() == KeyCode.UP) {
                    tf7.requestFocus();
                }
                if (event.getCode() == KeyCode.DOWN) {
                    tf8.requestFocus();
                }

            });

            tf8.setOnKeyPressed(event -> {
                if (event.getCode() == KeyCode.UP) {
                    tf7.requestFocus();
                }
                if (event.getCode().equals(KeyCode.ENTER)) {
                    tf1.requestFocus();
                    b1.fire();
                }
            });

            cb1.setOnAction(event -> {
                tf8.setDisable(cb1.isSelected());
            });

            tf8.textProperty().addListener((observable, oldValue, newValue) -> {
                cb1.setDisable(!newValue.trim().isEmpty());
            });

            b1.setOnKeyPressed(event -> {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    tf1.requestFocus();
                }
            });

            tf8.focusedProperty().addListener((arg0, oldValue, newValue) -> {
                if (!newValue) { //when focus lost
                    if (tf8.getText() == null || tf8.getText().matches("\\s*")) {

                    } else if (!tf8.getText().matches("^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$")) {
                        text.setStyle("-fx-text-fill:red;");
                        text.setText("Please Enter Date In yyyy-mm-dd Format Only");
                        tf8.requestFocus();
                    } else {
                        text.setText("");
                    }
                }
            });

            tf2.setTextFormatter(new TextFormatter<>(getUnaryOperator()));
            tf3.setTextFormatter(new TextFormatter<>(getUnaryOperator()));
            tf4.setTextFormatter(new TextFormatter<>(getUnaryOperator()));
            tf5.setTextFormatter(new TextFormatter<>(getUnaryOperator()));
            tf6.setTextFormatter(new TextFormatter<>(getUnaryOperator()));

            displayVendourTable();
            TextFields.bindAutoCompletion(name, vendours);

        } catch (NumberFormatException e) {
            System.out.println("Invalid Number");
        } catch (InputMismatchException e) {
            System.out.println("Input mismatch");
        }
        return null;
    }

    private void validateTextField(TextField tf, Text text) {
        tf.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) { //when focus lost
                if (tf.getText() == null || tf.getText().matches("\\s*")) {

                } else if (!tf.getText().matches("-?\\d+(\\.\\d+)?")) {
                    text.setStyle("-fx-text-fill:red;");
                    text.setText("Input Mismatch (Please Enter Only Number)");
                    tf.requestFocus();
                } else {
                    text.setText("");
                }
            }
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

    public void purchase(Stage stage) {

        VBox vb2 = super.addnew(stage, "product");

        Label label, l1, l2, l3, l4, l5, l6, vendour, todayDate;
        TextField tf1, tf2, tf3, name, tf4, tf5;
        Button b1;
        CheckBox cb1;

        label = new Label("UPDATING PURCHASE ");
        label.setFont(Font.font("Calibri", fw, fp, 20));

        text = new Label("");
        text.setFont(Font.font("Calibri", fw, fp, 20));

        l1 = new Label("Product Name                    ");
        vendour = new Label("Vendor Name                     ");
        l2 = new Label("Enter Quantity                    ");
        l3 = new Label("Enter Purchasing Price     ");
        l4 = new Label("Amount Paid To Vendor ");
        l5 = new Label("Purchased Today               ");
        l6 = new Label("If Not Purchacing Date    ");
        todayDate = new Label("( " + presentDate + " )");

        l1.setFont(Font.font("Calibri", fw, fp, 18));
        vendour.setFont(Font.font("Calibri", fw, fp, 18));
        l2.setFont(Font.font("Calibri", fw, fp, 18));
        l3.setFont(Font.font("Calibri", fw, fp, 18));
        l4.setFont(Font.font("Calibri", fw, fp, 18));
        l5.setFont(Font.font("Calibri", fw, fp, 18));
        l6.setFont(Font.font("Calibri", fw, fp, 18));

        tf1 = new TextField();
        name = new TextField();
        tf2 = new TextField();
        tf3 = new TextField();
        tf4 = new TextField();
        tf5 = new TextField();

        tf1.setFont(Font.font("Calibri", fw, fp, 18));
        name.setFont(Font.font("Calibri", fw, fp, 18));
        tf2.setFont(Font.font("Calibri", fw, fp, 18));
        tf3.setFont(Font.font("Calibri", fw, fp, 18));
        tf4.setFont(Font.font("Calibri", fw, fp, 18));
        tf5.setFont(Font.font("Calibri", fw, fp, 18));

        cb1 = new CheckBox();

        b1 = new Button("Done");
        b1.setFont(Font.font("Calibri", fw, fp, 16));

        tf5.setPromptText("YYYY-MM-DD Format");

        HBox hb = new HBox();
        hb.getChildren().addAll(label);
        hb.setSpacing(5);
        hb.setPadding(new Insets(10, 10, 10, 40));

        HBox hb1 = new HBox();
        hb1.getChildren().addAll(l1, tf1);
        hb1.setSpacing(5);
        hb1.setPadding(new Insets(5, 5, 5, 5));

        HBox vendourName = new HBox();
        vendourName.getChildren().addAll(vendour, name);
        vendourName.setSpacing(5);
        vendourName.setPadding(new Insets(5, 5, 5, 5));

        HBox hb2 = new HBox();
        hb2.getChildren().addAll(l2, tf2);
        hb2.setSpacing(5);
        hb2.setPadding(new Insets(5, 5, 5, 5));

        HBox hb3 = new HBox();
        hb3.getChildren().addAll(l3, tf3);
        hb3.setSpacing(7);
        hb3.setPadding(new Insets(7, 7, 7, 7));

        HBox hb4 = new HBox();
        hb4.getChildren().addAll(l4, tf4);
        hb4.setSpacing(7);
        hb4.setPadding(new Insets(7, 7, 7, 7));

        HBox hb5 = new HBox();
        hb5.getChildren().addAll(l5, cb1, todayDate);
        hb5.setSpacing(7);
        hb5.setPadding(new Insets(7, 7, 7, 7));

        HBox hb6 = new HBox();
        hb6.getChildren().addAll(l6, tf5);
        hb6.setSpacing(7);
        hb6.setPadding(new Insets(7, 7, 7, 7));

        HBox hb7 = new HBox();
        hb7.getChildren().addAll(b1);
        hb7.setSpacing(10);
        hb7.setPadding(new Insets(10, 10, 10, 130));

        HBox dis = new HBox();
        dis.getChildren().addAll(text);
        dis.setSpacing(10);
        dis.setPadding(new Insets(0, 0, 0, 120));

        VBox vb1 = new VBox();
        vb1.getChildren().addAll(hb1, vendourName, hb2, hb3, hb4, hb5, hb6, hb7);
        vb1.setSpacing(10);
        vb1.setPadding(new Insets(10, 10, 10, 100));

        VBox vb = new VBox();
        vb.getChildren().addAll(hb, vb1, dis);
        vb.setSpacing(10);
        vb.setPadding(new Insets(10, 150, 10, 50));

        vb2.getChildren().addAll(vb);
        vb2.setSpacing(10);
        vb2.setPadding(new Insets(10, 10, 5, 10));

        stage.show();

        b1.setOnAction((ActionEvent e) -> {
            String text1 = tf1.getText();
            String nametext = name.getText();
            String text2 = tf2.getText();
            String text3 = tf3.getText();
            String text4 = tf4.getText();
            String text5 = tf5.getText();

            if ((text1 == null || text1.matches("\\s*")) && (text2 == null || text2.matches("\\s*")
                    && (text3 == null || text3.matches("\\s*") && (text4 == null || text4.matches("\\s*")
                    && (text5 == null || text5.matches("\\s*")
                    && (nametext == null || nametext.matches("\\s*"))))))) {
                text.setStyle("-fx-text-fill:red;");
                text.setText("Please Enter Data Before Proceeding");
            } else if (text1 == null || text1.matches("\\s*")) {
                text.setStyle("-fx-text-fill:red;");
                text.setText("Please Enter Product Name Before Proceeding");
            } else if (nametext == null || nametext.matches("\\s*")) {
                text.setStyle("-fx-text-fill:red;");
                text.setText("Please Enter Vendour Name Before Proceeding");
            } else if (text2 == null || text2.matches("\\s*")) {
                text.setStyle("-fx-text-fill:red;");
                text.setText("Please Enter Quantity Before Proceeding");
            } else if (text3 == null || text3.matches("\\s*")) {
                text.setStyle("-fx-text-fill:red;");
                text.setText("Please Enter Buying Price Before Proceeding");
            } else if (text4 == null || text4.matches("\\s*")) {
                text.setStyle("-fx-text-fill:red;");
                text.setText("Please Enter Amount Paid Before Proceeding");
            } else if (!text2.matches("-?\\d+(\\.\\d+)?")) {
                text.setStyle("-fx-text-fill:red;");
                text.setText("Input Mismatch (Please Enter Number, not character)");
            } else if (!cb1.isSelected()) {

                if (text5 == null || text5.matches("\\s*")) {
                    text.setStyle("-fx-text-fill:red;");
                    text.setText("Please Enter Date Before Proceeding");
                } else if (!text5.matches("^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$")) {
                    text.setStyle("-fx-text-fill:red;");
                    text.setText("Please Enter Date In yyyy-mm-dd Format Only");
                    tf2.requestFocus();
                } else {
                    double d1 = Double.parseDouble(tf2.getText());
                    double d2 = Double.parseDouble(tf3.getText());
                    double d3 = Double.parseDouble(tf4.getText());

                    double purchase = d1 * d2;
                    double dueAmount = purchase - d3;

                    int y = due.insertour(name.getText(), dueAmount);

                    if (y == 2) {
                        text.setStyle("-fx-text-fill:red;");
                        text.setText("Paid More Then Purchase & Due Amount");
                    } else {
                        int x = db.increaseqnt(tf1.getText().toLowerCase(), d1, d2);

                        switch (x) {
                            case 1 -> {
                                text.setStyle("-fx-text-fill:red;");
                                text.setText("Product not avalible please add the product first");
                            }
                            case 2 -> {
                                text.setStyle("-fx-text-fill:red;");
                                text.setText("price not matched ,If Price changed add as new product");
                            }
                            case 3 -> {
                                display(stockAmount);
                                proTable();
                                table.setItems(data);
                                display_sellTable();
                                Selltable.setItems(Selldata);
                                info.insertVendour(name.getText(), purchase);

                                double avlQnt = db.displayItem(tf1.getText().toLowerCase());

                                String currentDate;

                                currentDate = tf5.getText();
                                pur.insert(tf1.getText().toLowerCase(), d1,
                                        purchase, avlQnt, currentDate, name.getText().toLowerCase());

                                text.setStyle("-fx-text-fill:black;");
                                text.setText("Quantity Added & StockAmount Increased");

                                tf1.clear();
                                name.clear();
                                tf2.clear();
                                tf3.clear();
                                tf4.clear();
                                tf5.clear();
                                tf1.requestFocus();

                            }
                            default -> {
                            }
                        }
                    }
                }
            } else {
                //new
                double d1 = Double.parseDouble(tf2.getText());
                double d2 = Double.parseDouble(tf3.getText());
                double d3 = Double.parseDouble(tf4.getText());

                double purchase = d1 * d2;
                double dueAmount = purchase - d3;

                int y = due.insertour(name.getText(), dueAmount);

                if (y == 2) {
                    text.setStyle("-fx-text-fill:red;");
                    text.setText("Paid More Then Purchase & Due Amount");
                } else {

                    int x = db.increaseqnt(tf1.getText().toLowerCase(), d1, d2);

                    switch (x) {
                        case 1 -> {
                            text.setStyle("-fx-text-fill:red;");
                            text.setText("Product not avalible please add the product first");
                        }
                        case 2 -> {
                            text.setStyle("-fx-text-fill:red;");
                            text.setText("price not matched ,If Price changed add as new product");
                        }
                        case 3 -> {
                            display(stockAmount);
                            proTable();
                            table.setItems(data);
                            display_sellTable();
                            Selltable.setItems(Selldata);
                            info.insertVendour(name.getText(), purchase);

                            double avlQnt = db.displayItem(tf1.getText().toLowerCase());

                            String currentDate;

                            currentDate = dateFormat.format(date);
                            pur.insert(tf1.getText().toLowerCase(), d1,
                                    purchase, avlQnt, currentDate, name.getText().toLowerCase());

                            text.setStyle("-fx-text-fill:black;");
                            text.setText("Quantity Added & StockAmount Increased");

                            tf1.clear();
                            name.clear();
                            tf2.clear();
                            tf3.clear();
                            tf4.clear();
                            tf5.clear();
                            cb1.fire();
                            tf1.requestFocus();

                        }
                        default -> {
                        }
                    }
                }
            }
        });

        tf1.requestFocus();

        tf1.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                name.requestFocus();
            }
            if (event.getCode() == KeyCode.DOWN) {
                name.requestFocus();
            }
        });

        name.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                tf2.requestFocus();
            }
            if (event.getCode() == KeyCode.UP) {
                tf1.requestFocus();
            }
            if (event.getCode() == KeyCode.DOWN) {
                tf2.requestFocus();
            }
        });

        tf2.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                tf3.requestFocus();
            }
            if (event.getCode() == KeyCode.UP) {
                name.requestFocus();
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
                tf4.requestFocus();
            }
            if (event.getCode() == KeyCode.DOWN) {
                tf4.requestFocus();
            }
        });

        tf4.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                cb1.requestFocus();
            }
            if (event.getCode() == KeyCode.UP) {
                tf3.requestFocus();
            }
            if (event.getCode() == KeyCode.DOWN) {
                cb1.requestFocus();
            }
        });

        cb1.setOnKeyPressed(event -> {
            if (cb1.isSelected()) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    b1.fire();
                }
            }
            if (event.getCode() == KeyCode.UP) {
                tf4.requestFocus();
            }
            if (event.getCode() == KeyCode.DOWN) {
                tf5.requestFocus();
            }
        });

        tf5.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                b1.fire();
                tf1.requestFocus();
            }
            if (event.getCode() == KeyCode.UP) {
                tf4.requestFocus();
            }
        });

        cb1.setOnAction(event -> {
            tf5.setDisable(cb1.isSelected());
        });

        tf5.textProperty().addListener((observable, oldValue, newValue) -> {
            cb1.setDisable(!newValue.trim().isEmpty());
        });

        tf2.setTextFormatter(new TextFormatter<>(getUnaryOperator()));
        tf3.setTextFormatter(new TextFormatter<>(getUnaryOperator()));
        tf4.setTextFormatter(new TextFormatter<>(getUnaryOperator()));

        /*   tf2.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) { //when focus lost
                if (!tf2.getText().matches("-?\\d+(\\.\\d+)?")) {
                    text.setStyle("-fx-text-fill:red;");
                    text.setText("Input Mismatch (Please Enter Only Number)");
                    tf2.requestFocus();
                } else {
                    text.setText("");
                }
            }
        });*/
        display();
        TextFields.bindAutoCompletion(tf1, products);

        displayVendourTable();
        TextFields.bindAutoCompletion(name, vendours);
    }

    public void sell(Stage stage) {

        VBox vb2 = super.addnew(stage, "product");

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
        v_b.setPadding(new Insets(10, 100, 10, 50));

        vb2.getChildren().addAll(v_b);
        vb2.setSpacing(10);
        vb2.setPadding(new Insets(10, 10, 5, 10));

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
                            totalAmount ta = new totalAmount();
                            ta.insert(csname, onePrice);
                            display(stockAmount);
                            display("totalsales");
                            display(profit);
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
                        totalAmount ta = new totalAmount();
                        ta.insert(csname, onePrice);
                        display(stockAmount);
                        display("totalsales");
                        display(profit);
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
            proceed(stage);
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

        display();
        TextFields.bindAutoCompletion(tf1, products);
        
        displayCustomerTable();
        TextFields.bindAutoCompletion(nametxt, customers);
    }

    public void update(Stage stage) {

        VBox vb2 = super.addnew(stage, "product");

        Label label, text, l1, l2;
        TextField tf1, tf2;
        Button b1;

        label = new Label("UPDATING PRODUCT ");
        label.setFont(Font.font("Calibri", fw, fp, 22));

        text = new Label("");
        text.setFont(Font.font("Calibri", fw, fp, 20));

        l1 = new Label("Product Name               ");
        l2 = new Label("Enter Updated Price     ");
        l1.setFont(Font.font("Calibri", fw, fp, 20));
        l2.setFont(Font.font("Calibri", fw, fp, 20));

        tf1 = new TextField();
        tf2 = new TextField();
        tf1.setFont(Font.font("Calibri", fw, fp, 16));
        tf2.setFont(Font.font("Calibri", fw, fp, 16));

        b1 = new Button("Done");
        b1.setFont(Font.font("Calibri", fw, fp, 16));

        HBox hb = new HBox();
        hb.getChildren().addAll(label);
        hb.setSpacing(15);
        hb.setPadding(new Insets(50, 50, 10, 10));

        HBox hb1 = new HBox();
        hb1.getChildren().addAll(l1, tf1);
        hb1.setSpacing(15);
        hb1.setPadding(new Insets(10, 10, 10, 10));

        HBox hb2 = new HBox();
        hb2.getChildren().addAll(l2, tf2);
        hb2.setSpacing(15);
        hb2.setPadding(new Insets(10, 10, 10, 10));

        HBox hb3 = new HBox();
        hb3.getChildren().addAll(b1);
        hb3.setSpacing(15);
        hb3.setPadding(new Insets(10, 10, 10, 170));

        HBox hb4 = new HBox();
        hb4.getChildren().addAll(text);
        hb4.setSpacing(15);
        hb4.setPadding(new Insets(10, 10, 10, 10));

        VBox vb1 = new VBox();
        vb1.getChildren().addAll(hb1, hb2, hb3, hb4);
        vb1.setSpacing(15);
        vb1.setPadding(new Insets(10, 10, 10, 100));

        VBox vb = new VBox();
        vb.getChildren().addAll(hb, vb1);
        vb.setSpacing(15);
        vb.setPadding(new Insets(10, 130, 100, 80));

        vb2.getChildren().addAll(vb);
        vb2.setSpacing(10);
        vb2.setPadding(new Insets(10, 10, 5, 10));

        stage.show();

        b1.setOnAction((ActionEvent e) -> {

            String text1 = tf1.getText();
            String text2 = tf2.getText();
            if ((text1 == null || text1.matches("\\s*")) && (text2 == null || text2.matches("\\s*"))) {
                text.setStyle("-fx-text-fill:red;");
                text.setText("Please Enter Data Before Proceeding");
            } else if (text1 == null || text1.matches("\\s*")) {
                text.setStyle("-fx-text-fill:red;");
                text.setText("Please Enter Name Before Proceeding");
            } else if (text2 == null || text2.matches("\\s*")) {
                text.setStyle("-fx-text-fill:red;");
                text.setText("Please Enter Amount Before Proceeding");
            } else if (!text2.matches("-?\\d+(\\.\\d+)?")) {
                text.setStyle("-fx-text-fill:red;");
                text.setText("Input Mismatch (Please Enter Number, not character)");
            } else {
                double d1 = Double.parseDouble(tf2.getText());
                int x = stb.update(tf1.getText().toLowerCase(), d1);

                switch (x) {
                    case 1 -> {

                        text.setStyle("-fx-text-fill:red;");
                        text.setText("Product not available please add the product first");
                    }
                    case 2 -> {
                        text.setStyle("-fx-text-fill:red;");
                        text.setText("You have entered same price as before");
                    }
                    case 3 -> {
                        text.setStyle("-fx-text-fill:black;");
                        text.setText("Product Price Updated Successfully");
                        display_sellTable();
                        Selltable.setItems(Selldata);
                        tf1.clear();
                        tf2.clear();
                    }
                    case 4 -> {
                        text.setStyle("-fx-text-fill:red;");
                        text.setText("Input Mismatch");
                    }
                    default -> {
                    }
                }
            }
        });

        tf1.requestFocus();

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
                tf1.requestFocus();
                b1.fire();
            }
            if (event.getCode() == KeyCode.UP) {
                tf1.requestFocus();
            }
        });

        b1.setOnMouseClicked(event -> {
            tf1.requestFocus();
        });

        tf2.setTextFormatter(new TextFormatter<>(getUnaryOperator()));

        display();
        TextFields.bindAutoCompletion(tf1, products);
    }

    public void delete(Stage stage) {

        VBox vb2 = super.addnew(stage, "product");

        Label label, text, l1;
        TextField tf1;
        Button b1;

        label = new Label("DELETE PRODUCT ");
        label.setFont(Font.font("Calibri", fw, fp, 22));

        text = new Label("");
        text.setFont(Font.font("Calibri", fw, fp, 20));

        l1 = new Label("Enter Product Name to Delete    ");
        l1.setFont(Font.font("Calibri", fw, fp, 20));

        tf1 = new TextField();
        tf1.setFont(Font.font("Calibri", fw, fp, 20));

        b1 = new Button("Done");
        b1.setFont(Font.font("Calibri", fw, fp, 16));
        b1.setPrefSize(70, 30);

        tf1.setPrefSize(250, 20);
        tf1.setFont(Font.font("Calibri", fw, fp, 16));

        HBox hb = new HBox();
        hb.getChildren().addAll(label);
        hb.setSpacing(15);
        hb.setPadding(new Insets(50, 50, 10, 10));

        HBox hb1 = new HBox();
        hb1.getChildren().addAll(l1, tf1);
        hb1.setSpacing(15);
        hb1.setPadding(new Insets(10, 10, 10, 10));

        HBox hb2 = new HBox();
        hb2.getChildren().addAll(text);
        hb2.setSpacing(15);
        hb2.setPadding(new Insets(10, 10, 10, 30));

        HBox hb3 = new HBox();
        hb3.getChildren().addAll(b1);
        hb3.setSpacing(15);
        hb3.setPadding(new Insets(10, 10, 10, 230));

        VBox vb1 = new VBox();
        vb1.getChildren().addAll(hb1, hb3, hb2);
        vb1.setSpacing(15);
        vb1.setPadding(new Insets(10, 10, 10, 50));

        VBox vb = new VBox();
        vb.getChildren().addAll(hb, vb1);
        vb.setSpacing(15);
        vb.setPadding(new Insets(10, 40, 100, 85));

        vb2.getChildren().addAll(vb);
        vb2.setSpacing(10);
        vb2.setPadding(new Insets(10, 10, 5, 10));

        stage.show();

        b1.setOnAction((ActionEvent e) -> {
            String text1 = tf1.getText();

            if (text1 == null || text1.matches("\\s*")) {
                text.setStyle("-fx-text-fill:red;");
                text.setText("Please Enter Name Before Proceeding");
            } else {
                int x = db.delete(tf1.getText().toLowerCase());
                proTable();
                display_sellTable();
                switch (x) {
                    case 1 -> {
                        text.setStyle("-fx-text-fill:red;");
                        text.setText("No such product available");
                    }
                    case 2 -> {
                        text.setStyle("-fx-text-fill:black;");
                        text.setText("Product Deleted Succesfully");
                        proTable();
                        table.setItems(data);
                        display_sellTable();
                        Selltable.setItems(Selldata);
                        tf1.clear();

                    }
                    case 3 -> {
                        text.setStyle("-fx-text-fill:red;");
                        text.setText("Quantity Still Avaliable,Sell Or Enter to Spoiled");
                    }
                    default -> {
                    }
                }
            }
        });
        tf1.requestFocus();

        tf1.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                b1.fire();
            }
        });

        b1.setOnMouseClicked(event -> {
            tf1.requestFocus();
        });

        display();
        TextFields.bindAutoCompletion(tf1, products);
    }

    public void proceed(Stage stage) {
        
        VBox vb2 = super.addnew(stage, "product");

        Label text, l1, l2, l3, l4, l5, l6, l7, l8, l9, tf2, tf3, tf4, tf6;
        TextField tf1, tf5, tf7;
        RadioButton rb1, rb2;
        Button b1,b2;

        text = new Label("");
        text.setFont(Font.font("Calibri", fw, fp, 20));

        l1 = new Label("Customer Name    ");
        l2 = new Label("Total Amount                   ");
        l3 = new Label("Previous Due                    ");
        l4 = new Label("Total Amount(Incl Due)  ");
        l5 = new Label("Amount Paid          ");
        l6 = new Label("New Due Amount             ");
        l7 = new Label("Payment Mode               ");
      //  l8 = new Label("With Bill                                   ");
      //  l9 = new Label("With Out Bill                           ");
        l1.setFont(Font.font("Calibri", fw, fp, 18));
        l2.setFont(Font.font("Calibri", fw, fp, 18));
        l3.setFont(Font.font("Calibri", fw, fp, 18));
        l4.setFont(Font.font("Calibri", fw, fp, 18));
        l5.setFont(Font.font("Calibri", fw, fp, 18));
        l6.setFont(Font.font("Calibri", fw, fp, 18));
        l7.setFont(Font.font("Calibri", fw, fp, 18));
      //  l8.setFont(Font.font("Calibri", fw, fp, 16));
      //  l9.setFont(Font.font("Calibri", fw, fp, 16));

        tf1 = new TextField();
        tf2 = new Label();
        tf3 = new Label();
        tf4 = new Label();
        tf5 = new TextField();
        tf6 = new Label();
        tf7 = new TextField();
        tf1.setFont(Font.font("Calibri", fw, fp, 18));
        tf2.setFont(Font.font("Calibri", fw, fp, 18));
        tf3.setFont(Font.font("Calibri", fw, fp, 18));
        tf4.setFont(Font.font("Calibri", fw, fp, 18));
        tf5.setFont(Font.font("Calibri", fw, fp, 18));
        tf6.setFont(Font.font("Calibri", fw, fp, 18));
        tf7.setFont(Font.font("Calibri", fw, fp, 18));

        rb1 = new RadioButton();
        rb2 = new RadioButton();

        b1 = new Button("Ok");
        b1.setFont(Font.font("Calibri", fw, fp, 18));
       
        b2 = new Button("Done");
        b2.setFont(Font.font("Calibri", fw, fp, 18));

        HBox hb1 = new HBox();
        hb1.getChildren().addAll(l1, tf1);
        hb1.setSpacing(15);
        hb1.setPadding(new Insets(8, 8, 5, 10));

        HBox hb2 = new HBox();
        hb2.getChildren().addAll(l2, tf2);
        hb2.setSpacing(15);
        hb2.setPadding(new Insets(8, 8, 5, 10));

        HBox hb3 = new HBox();
        hb3.getChildren().addAll(l3, tf3);
        hb3.setSpacing(15);
        hb3.setPadding(new Insets(8, 8, 5, 10));

        HBox hb4 = new HBox();
        hb4.getChildren().addAll(l4, tf4);
        hb4.setSpacing(15);
        hb4.setPadding(new Insets(8, 8, 5, 10));

        HBox hb5 = new HBox();
        hb5.getChildren().addAll(l5, tf5);
        hb5.setSpacing(15);
        hb5.setPadding(new Insets(8, 8, 5, 10));

        HBox hb6 = new HBox();
        hb6.getChildren().addAll(l6, tf6);
        hb6.setSpacing(15);
        hb6.setPadding(new Insets(8, 8, 5, 10));

        HBox hb7 = new HBox();
        hb7.getChildren().addAll(l7, tf7);
        hb7.setSpacing(15);
        hb7.setPadding(new Insets(8, 8, 5, 10));

     /*   HBox hb8 = new HBox();
        hb8.getChildren().addAll(l8, rb1);
        hb8.setSpacing(15);
        hb8.setPadding(new Insets(8, 8, 5, 10));

        HBox hb9 = new HBox();
        hb9.getChildren().addAll(l9, rb2);
        hb9.setSpacing(15);
        hb9.setPadding(new Insets(8, 8, 5, 10));*/

        HBox hb10 = new HBox();
        hb10.getChildren().addAll(b1);
        hb10.setSpacing(15);
        hb10.setPadding(new Insets(8, 8, 5, 140));
        
        HBox hb12 = new HBox();
        hb12.getChildren().addAll(b2);
        hb12.setSpacing(15);
        hb12.setPadding(new Insets(8, 8, 5, 130));

        HBox hb11 = new HBox();
        hb11.getChildren().addAll(text);
        hb11.setSpacing(15);
        hb11.setPadding(new Insets(0, 0, 0, 250));

        VBox vb1 = new VBox();
        vb1.getChildren().addAll(hb1,hb10, hb2, hb3, hb4, hb5,hb12);
        vb1.setSpacing(10);
        vb1.setPadding(new Insets(10, 10, 10, 140));

        VBox vb = new VBox();
        vb.getChildren().addAll(vb1, hb11);
        vb.setSpacing(10);
        vb.setPadding(new Insets(10, 150, 0, 0));

        vb2.getChildren().addAll(vb);
        vb2.setSpacing(10);
        vb2.setPadding(new Insets(10, 10, 5, 60));

        stage.show();
        
        b1.setOnAction((ActionEvent e) -> {
            String text1 = tf1.getText();
            
            if ((text1 == null || text1.matches("\\s*"))) {
                text.setStyle("-fx-text-fill:red;");
                text.setText("Please Enter Name Before Proceeding");
            }else{
            totalAmount ta = new totalAmount();
            double totalAmount=ta.display(text1);
            tf2.setText(String.valueOf(totalAmount));
            
            dues due = new dues ();
            double oldDue = due.displaycs(text1);
            tf3.setText(String.valueOf(oldDue));
            
            double total = totalAmount+oldDue;
            
            tf4.setText(String.valueOf(total));
            }
        });
        
       b2.setOnAction((ActionEvent e) -> {
           
            String text1 = tf1.getText();
            if ((text1 == null || text1.matches("\\s*")) && (tf5.getText() == null || tf5.getText().matches("\\s*"))) {
                text.setStyle("-fx-text-fill:red;");
                text.setText("Please Enter Data Before Proceeding");
            }else if ((text1 == null || text1.matches("\\s*"))) {
                text.setStyle("-fx-text-fill:red;");
                text.setText("Please Enter Name Before Proceeding");
            }else if ((tf5.getText() == null || tf5.getText().matches("\\s*"))) {
                text.setStyle("-fx-text-fill:red;");
                text.setText("Please Enter Name Before Proceeding");
            }
            else{
            totalAmount ta = new totalAmount();
            
            double oldDue = due.displaycs(text1);
            double totalAmount=ta.display(text1);
            double total = totalAmount+oldDue;
            
            double paid = Double.parseDouble(tf5.getText());
            
            double newDueAmount = total-paid;
            
            if (newDueAmount==0){
                due.insertcs(text1, newDueAmount);
                text.setText("Sales Successfull");
                ta.delete();
            }else if (newDueAmount>0){
                due.insertcs(text1, newDueAmount);
                text.setText("Sales Successfull");
                ta.delete();
            }else if (newDueAmount<0){
                text.setText("Paying More Amount");
            }
            }
        });
       
       
       tf1.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                b1.fire();
            }
        });
       
       tf5.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                b2.fire();
            }
        });
         displayCustomerTable();
        TextFields.bindAutoCompletion(tf1, customers);
        
        tf5.setTextFormatter(new TextFormatter<>(getUnaryOperator()));
       
    }

    public void display() {
        String sql = "SELECT * FROM " + Constants.ProductTable + " ORDER BY stockname";

        try ( Connection conn = this.connect();  Statement stmt = conn.createStatement();  ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String stockname = rs.getString("stockname");
                products.add(stockname);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private Connection connect() {
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

    private Connection connect2() {
        // SQLite connection string
        // String url = "jdbc:sqlite:V://projectBms/bmsList1.db";
        String url = Constants.mangeDB;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void displayVendourTable() {
        String sql = "SELECT * FROM " + Constants.vendourTable + " ORDER BY vName";

        try ( Connection conn = this.connect2();  Statement stmt = conn.createStatement();  
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String vendourName = rs.getString("vName");
                vendours.add(vendourName);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void displayCustomerTable() {

        String sql = "SELECT * FROM " + Constants.customerTable + " ORDER BY cName";

        try ( Connection conn = this.connect2();  Statement stmt = conn.createStatement();  
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String vendourName = rs.getString("cName");
                customers.add(vendourName);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
