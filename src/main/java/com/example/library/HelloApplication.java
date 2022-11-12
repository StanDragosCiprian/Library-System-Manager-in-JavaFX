package com.example.library;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Parameter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class HelloApplication extends Application {
    //public FileSystem fileSystem=new FileSystem("C:\\Users\\Retro\\IdeaProjects\\Library\\src\\main\\java\\com\\example\\library\\pass.txt");
    FirstPage firstPage = new FirstPage();
    MySqlConnect mySqlConnect=new MySqlConnect();

    @Override
    public void start(Stage stage) throws IOException {


        try {
            firstPage.generatePage("FirstPage.fxml");
            mySqlConnect.getConnection();
           List<LogInObject>list=mySqlConnect.Select();
            for (LogInObject logInObject : list) {
                System.out.println(logInObject.getId()+" "+logInObject.getEmail()+" "+logInObject.getPassword());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        launch();
    }
}