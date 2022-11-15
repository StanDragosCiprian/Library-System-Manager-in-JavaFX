package com.example.library;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.NodeOrientation;
import javafx.scene.AccessibleRole;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;



public class SignIn extends ScenWindow {

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

AnchorPane Grid=new AnchorPane();
Grid.heightProperty().add(1000);
        for (int i = 0; i < 100; i++) {
            HBox hBox=new HBox();
            Label label=new Label(String.valueOf(i));
            hBox.getChildren().add(label);
            hBox.setTranslateY(i*30);
            Grid.getChildren().add(hBox);
        }


        ScrollPane root = new ScrollPane();
        root.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        root.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        root.accessibleRoleProperty().setValue(AccessibleRole.SCROLL_PANE);
        root.nodeOrientationProperty().setValue(NodeOrientation.INHERIT);
        root.blendModeProperty().setValue(BlendMode.SRC_OVER);
        root.setPrefWidth(400);
        root.setPrefHeight(180);
        root.setVmin(0);
        root.setVmax(1);
        root.vvalueProperty().setValue(1);
        root.vvalueProperty().set(1);
        root.vvalueProperty().add(1);
        root.setContent(Grid);



        setScene(new Scene(root));
        getStage().setScene(getScene());


        
    }
}catch (Exception e){
    popUp.setVisible(true);
}




}}
