package com.example.csp;



import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class ScholarshipFacilitiesController implements Initializable {

    private TableView<Scholarship> table;
    private TableColumn<Scholarship, String> index;
    private TableColumn<Scholarship, String> name;
    private TableColumn<Scholarship, String> types;
    private TableColumn<Scholarship, String> level;

    ObservableList<Scholarship> list = FXCollections.observableArrayList(
        new Scholarship("1", "Close", "MMU President's Scholarship", "Scholarship", "UG")
    );

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        index.setCellValueFactory(new PropertyValueFactory<Scholarship, String>("index"));
        name.setCellValueFactory(new PropertyValueFactory<Scholarship, String>("status"));
        index.setCellValueFactory(new PropertyValueFactory<Scholarship, String>("name"));
        index.setCellValueFactory(new PropertyValueFactory<Scholarship, String>("types"));
        index.setCellValueFactory(new PropertyValueFactory<Scholarship, String>("level"));

        table.setItems(list);
    }

}
