package com.example.lab6_var4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CarsApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CarsApplication.class.getResource("cars.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 475);
        stage.setTitle(" АВТОМОБИЛЬНЫЙ САЛОН");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
