package com.example.library;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ScenWindow {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Parent getRoot() {
        return root;
    }

    public void setRoot(Parent root) {
        this.root = root;
    }
}
