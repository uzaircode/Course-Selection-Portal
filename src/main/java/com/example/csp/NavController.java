package com.example.csp;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class NavController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void toStudInfo(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("student_information.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void toCourseEnrol(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("course_enrolment.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void toFinance(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("finance.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
