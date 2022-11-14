package com.example.library;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.example.library.Controll.Grid;

public class SignIn extends ScenWindow implements Controll{

    @FXML
    private TextField email;

    @FXML
    private PasswordField password;



    @FXML
    private Label popUp;
    private MySqlConnect mySqlConnect=new MySqlConnect();

    @FXML
    void enterAccount(ActionEvent event) throws IOException {

        List<Label> z=new ArrayList<Label>();
mySqlConnect.getConnection();
try {
    if(mySqlConnect.uniqAccount(email.getText(),password.getText())){

        setRoot(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("BookArea.fxml"))));
        setStage((Stage) ((Node) event.getSource()).getScene().getWindow());

        AnchorPane Grid2=new AnchorPane();

        for (int i = 0; i < 100; i++) {
            Label da=new Label(" 21 ");
            da.setTranslateX(i*30);
            Grid2.getChildren().add(da);
        }
        ScrollPane root = new ScrollPane();
        root.setPrefWidth(400);
        root.setPrefHeight(180);
        root.setContent(Grid2);



        setScene(new Scene(root));
        getStage().setScene(getScene());


        
    }
}catch (Exception e){
    popUp.setVisible(true);
}




}}
