package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ListTeacherController {

    @FXML
    private TableView<Teacher> teacherTable;

    @FXML
    private TableColumn<Teacher, String> nameColumn;

    @FXML
    private TableColumn<Teacher, String> surnameColumn;

    @FXML
    private TableColumn<Teacher, String> departmentColumn;

    private ObservableList<Teacher> teacherList;

    public void initialize() {
        // Create an observable list to store the teacher objects
        teacherList = FXCollections.observableArrayList();
        
        // Load teachers from file into the teacherList
        loadTeachersFromFile();

        // Set up the cell value factories for the table columns
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
        departmentColumn.setCellValueFactory(new PropertyValueFactory<>("department"));

        // Set the items of the table to the teacherList
        teacherTable.setItems(teacherList);
    }

    private void loadTeachersFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("teachers.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into parts based on the comma separator
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    // Extract the name, surname, and department from the parts
                    String name = parts[0];
                    String surname = parts[1];
                    String department = parts[2];
                    
                    // Create a new Teacher object and add it to the teacherList
                    Teacher teacher = new Teacher(name, surname, department);
                    teacherList.add(teacher);
                }
            }
        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage());
        }
    }
}
