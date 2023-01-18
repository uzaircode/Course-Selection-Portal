package com.example.csp;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class FuturePlanningController extends Application implements Initializable {

    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("stud_future_planning.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 960, 540);
        stage.setTitle("Future Planning");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @FXML
    private Label label_future_career;

    @FXML
    private ChoiceBox<String> choicebox_course;

    private final String[] course = {
            "Design Engineer",
            "Project Engineer",
            "Test Engineer",
            "Protection Engineer",
            "Power Engineer",
            "Sales Engineer",
            "High Voltage Engineer",
            "Service Engineer",
            "Electrical Production Engineer",
            "Product Development Engineer",
            "Electrical and Instrument Engineer",
            "PCB Design Engineer QC Engineer",
            "Field Service Engineer",
            "Electrical Engineering Manager",
            "ME Engineer",
            "Oil  Gas Process Engineer"
    };

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        choicebox_course.getItems().addAll(course);
        choicebox_course.setOnAction(this::getFutureCareer);

    }

    public void getFutureCareer(ActionEvent event) {

        String myFood = choicebox_course.getValue();
        label_future_career.setText(myFood);
    }

}