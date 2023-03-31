package projectbms;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Create extends parentform {

    FontWeight fw = FontWeight.BOLD;
    FontPosture fp = FontPosture.REGULAR;

    public void Help(Stage stage) {

        VBox vb2 = super.addnew(stage, "product");

        Label label, l1, l2, l3,l4;

        label = new Label("For Any Queries & Help:-");
        label.setFont(Font.font("Calibri", fw, fp, 22));

        l1 = new Label("Created By K.Jayachandra ");
        l1.setFont(Font.font("Calibri", fw, fp, 20));

        l2 = new Label("Call: +91 8712173660  ");
        l2.setFont(Font.font("Calibri", fw, fp, 20));

        l3 = new Label("Mail: inventorymanagementsystem2023@gmail.com");
        l3.setFont(Font.font("Calibri", fw, fp, 20));
        
        l4 = new Label("Website: http://ims.unaux.com/");
        l4.setFont(Font.font("Calibri", fw, fp, 20));

        HBox hb = new HBox();
        hb.getChildren().addAll(label);
        hb.setSpacing(15);
        hb.setPadding(new Insets(50, 50, 10, 10));

        HBox hb1 = new HBox();
        hb1.getChildren().addAll(l1);
        hb1.setSpacing(15);
        hb1.setPadding(new Insets(10, 0, 10, 0));

        HBox hb2 = new HBox();
        hb2.getChildren().addAll(l2);
        hb2.setSpacing(15);
        hb2.setPadding(new Insets(10, 0, 10, 0));

        HBox hb3 = new HBox();
        hb3.getChildren().addAll(l3);
        hb3.setSpacing(15);
        hb3.setPadding(new Insets(10, 0, 10, 0));
        
        HBox hb4 = new HBox();
        hb4.getChildren().addAll(l4);
        hb4.setSpacing(15);
        hb4.setPadding(new Insets(10, 0, 10, 0));

        VBox vb1 = new VBox();
        vb1.getChildren().addAll(hb1, hb2,hb4, hb3);
        vb1.setSpacing(15);
        vb1.setPadding(new Insets(10, 10, 10, 10));

        VBox vb = new VBox();
        vb.getChildren().addAll(hb, vb1);
        vb.setSpacing(15);
        vb.setPadding(new Insets(10, 100, 100, 180));

        vb2.getChildren().addAll(vb);
        vb2.setSpacing(10);
        vb2.setPadding(new Insets(10, 10, 5, 10));

        stage.show();
    }

    Label text;
    public void createDb(Stage stage) {
        VBox vb2 = super.addnew(stage, "product");

        Label label, l1, l2;
        TextField tf1;
        RadioButton rb1;
        Button b1;

        label = new Label("Createing DataBase");
        label.setFont(Font.font("Calibri", fw, fp, 22));

        l1 = new Label("Enter Path :- ");
        l1.setFont(Font.font("Calibri", fw, fp, 20));

        tf1 = new TextField();
        tf1.setFont(Font.font("Calibri", fw, fp, 20));

        l2 = new Label("Create All DataBase  ");
        l2.setFont(Font.font("Calibri", fw, fp, 20));

        rb1 = new RadioButton();

        b1 = new Button("Done");
        b1.setFont(Font.font("Calibri", fw, fp, 20));

        text = new Label();
        text.setFont(Font.font("Calibri", fw, fp, 20));
        
        HBox hb = new HBox();
        hb.getChildren().addAll(label);
        hb.setSpacing(15);
        hb.setPadding(new Insets(50, 50, 10, 10));

        HBox hb1 = new HBox();
        hb1.getChildren().addAll(l1, tf1);
        hb1.setSpacing(15);
        hb1.setPadding(new Insets(10, 10, 10, 10));

        HBox hb2 = new HBox();
        hb2.getChildren().addAll(l2, rb1);
        hb2.setSpacing(15);
        hb2.setPadding(new Insets(10, 10, 10, 10));

        HBox hb4 = new HBox();
        hb4.getChildren().addAll(b1);
        hb4.setSpacing(15);
        hb4.setPadding(new Insets(10, 10, 10, 130));

        HBox hb5 = new HBox();
        hb5.getChildren().addAll(text);
        hb5.setSpacing(15);
        hb5.setPadding(new Insets(10, 10, 10, 10));
        
        VBox vb1 = new VBox();
        vb1.getChildren().addAll(hb1, hb2, hb4,hb5);
        vb1.setSpacing(15);
        vb1.setPadding(new Insets(10, 10, 10, 50));

        VBox vb = new VBox();
        vb.getChildren().addAll(hb, vb1);
        vb.setSpacing(15);
        vb.setPadding(new Insets(10, 100, 100, 180));

        vb2.getChildren().addAll(vb);
        vb2.setSpacing(10);
        vb2.setPadding(new Insets(10, 10, 5, 10));

        stage.show();

        b1.setOnAction((ActionEvent e) -> {
            if (rb1.isSelected()) {
                dataBase db = new dataBase();
                db.createNewDatabase();
                manage mdb = new manage();
                mdb.createNewDatabase();
                empDatabase edb = new empDatabase();
                edb.createNewDatabase();
                
                text.setStyle("-fx-text-fill:black;");
                text.setText("DataBases Created Successfully");
            }
            else{
                text.setStyle("-fx-text-fill:red;");
                text.setText("Something Went Worng Please Try Again");
            }
        });
    }

    public void createTable(Stage stage) {

        VBox vb2 = super.addnew(stage, "product");

        Label label, l1, l2;
        TextField tf1;
        RadioButton rb1;
        Button b1;

        label = new Label("Createing Tables");
        label.setFont(Font.font("Calibri", fw, fp, 22));

        l1 = new Label("Enter Path :- ");
        l1.setFont(Font.font("Calibri", fw, fp, 20));

        tf1 = new TextField();
        tf1.setFont(Font.font("Calibri", fw, fp, 20));

        l2 = new Label("Create All Tables  ");
        l2.setFont(Font.font("Calibri", fw, fp, 20));

        rb1 = new RadioButton();

        b1 = new Button("Done");
        b1.setFont(Font.font("Calibri", fw, fp, 20));

        text = new Label();
        text.setFont(Font.font("Calibri", fw, fp, 20));
        
        HBox hb = new HBox();
        hb.getChildren().addAll(label);
        hb.setSpacing(15);
        hb.setPadding(new Insets(50, 50, 10, 10));

        HBox hb1 = new HBox();
        hb1.getChildren().addAll(l1, tf1);
        hb1.setSpacing(15);
        hb1.setPadding(new Insets(10, 10, 10, 10));

        HBox hb2 = new HBox();
        hb2.getChildren().addAll(l2, rb1);
        hb2.setSpacing(15);
        hb2.setPadding(new Insets(10, 10, 10, 10));

        HBox hb4 = new HBox();
        hb4.getChildren().addAll(b1);
        hb4.setSpacing(15);
        hb4.setPadding(new Insets(10, 10, 10, 130));

        HBox hb5 = new HBox();
        hb5.getChildren().addAll(text);
        hb5.setSpacing(15);
        hb5.setPadding(new Insets(10, 10, 10, 10));
        
        VBox vb1 = new VBox();
        vb1.getChildren().addAll(hb1, hb2, hb4,hb5);
        vb1.setSpacing(15);
        vb1.setPadding(new Insets(10, 10, 10, 50));

        VBox vb = new VBox();
        vb.getChildren().addAll(hb, vb1);
        vb.setSpacing(15);
        vb.setPadding(new Insets(10, 100, 100, 180));

        vb2.getChildren().addAll(vb);
        vb2.setSpacing(10);
        vb2.setPadding(new Insets(10, 10, 5, 10));

        stage.show();

        b1.setOnAction((ActionEvent e) -> {
            if (rb1.isSelected()) {
                dataBase db = new dataBase();
                db.createNewTable();
                sellTable Cstb = new sellTable();
                Cstb.createNewTableSell();
                BillData BD = new BillData();
                BD.createNewTable();
                Purchase pur = new Purchase();
                pur.createNewTable();
                Test test = new Test();
                test.createNewTable();
                empDatabase edb = new empDatabase();
                edb.createNewTable();
                empAttandnce empattend = new empAttandnce();
                empattend.createNewTable();
                dues due = new dues();
                due.createNewTable();
                manage mdb = new manage();
                mdb.createNewTable();
                expenses exp = new expenses();
                exp.createNewTable();
                Data data = new Data();
                data.createNewVendourTable();
                data.createNewCustomerTable();

                mdb.insert("stockamount", 0);
                mdb.insert("profit", 0);
                mdb.insert("expenses", 0);
                mdb.insert("totalcsdues", 0);
                mdb.insert("totalempdues", 0);
                mdb.insert("totalourdues", 0);
                mdb.insert("totaldue", 0);
                mdb.insert("tax", 0);
                mdb.insert("totalsales", 0);

                text.setStyle("-fx-text-fill:black;");
                text.setText("DataBases Created Successfully");
            }
            else{
                text.setStyle("-fx-text-fill:red;");
                text.setText("Something Went Worng Please Try Again");
            }

        });
    }
}
