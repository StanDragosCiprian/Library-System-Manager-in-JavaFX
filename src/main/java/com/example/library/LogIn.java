package com.example.library;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class LogIn extends ScenWindow {
    @FXML
    private TextField email;

    @FXML
    private TextField name;

    @FXML
    private PasswordField passworld;


    @FXML
    private Label popUp;

    private final MySqlConnect mySqlConnect = new MySqlConnect();

    @FXML
    void sendData(ActionEvent event) throws SQLException, IOException {
        mySqlConnect.getConnection();
        if (mySqlConnect.isNotDublicate(email.getText())) {
            String query = "INSERT INTO log_in (Name, Email, Password) VALUES('" + name.getText() + "','" + email.getText() + "','" + passworld.getText() + "')";
            mySqlConnect.getConnection();
            mySqlConnect.mySqlInsertQuery(query);

            setRoot(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("BookArea.fxml"))));
            setStage((Stage) ((Node) event.getSource()).getScene().getWindow());
            setScene(new Scene(getRoot()));
            getStage().setScene(getScene());
            getStage().show();
            getStage().resizableProperty().setValue(false);
        } else {
            popUp.setVisible(true);
        }
    }


}
