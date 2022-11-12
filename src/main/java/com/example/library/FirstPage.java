package com.example.library;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.*;
import java.util.Objects;

public class FirstPage extends ScenWindow{

    private Stage thisStage;
    @FXML
    private Button logIn;

    @FXML
    private Button signIn;


public void generatePage(String fxmlFile) throws IOException {
    setRoot(FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxmlFile))));
    setScene(new Scene(getRoot()));
    setStage(new Stage());
    getStage().setScene(getScene());
    getStage().show();
}

    public void switchToScene2(ActionEvent event) throws IOException {
        setRoot(FXMLLoader.load(getClass().getResource("LogIn.fxml")));
        setStage((Stage)((Node)event.getSource()).getScene().getWindow());
        setScene(new Scene(getRoot()));
       getStage().setScene(getScene());
       getStage().show();

    }


    @FXML
    void logInEvent(ActionEvent event)  {

        //FileSystem fileSystem=new FileSystem("C:\\Users\\Retro\\IdeaProjects\\Library\\src\\main\\java\\com\\example\\library\\pass.txt");
       //"LogIn.fxml"



    }

    @FXML
    void signInEvent(ActionEvent event) {

    }
}
