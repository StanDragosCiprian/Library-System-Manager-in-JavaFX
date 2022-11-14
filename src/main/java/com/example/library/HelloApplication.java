package com.example.library;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Parameter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collection;
import java.util.List;

public class HelloApplication extends Application {
    //public FileSystem fileSystem=new FileSystem("C:\\Users\\Retro\\IdeaProjects\\Library\\src\\main\\java\\com\\example\\library\\pass.txt");
    FirstPage firstPage = new FirstPage();


    @Override
    public void start(Stage stage) throws IOException {


        try {
            firstPage.generatePage("FirstPage.fxml");
         

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        launch();
    }
}