package com.example.csp;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//FOR CHANGING SCENES - BUTTONS, HYPERLINKS ETC

public class SceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToCourseInfo(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("stud_course_info.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToEditCourseInfo(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("stud_edit_course_info.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToEditStudInfo(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("edit_stud_info.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToFeeStructure(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("stud_fee_structure.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToFuturePlanning(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("stud_future_planning.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToLogin(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToRegister(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("register.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScholarshipFacilities(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("stud_stud_scholarship_facilities.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToStudentDashboard(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("stud_dashboard.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToStudentInformation(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("student_information.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToMainPortal2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("main_portal_2.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToMainPortal1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("main_portal.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
