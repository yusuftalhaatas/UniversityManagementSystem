package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddTeacherController {

    private Teacher newTeacher; // Instance of the Teacher class to store the new teacher information

    @FXML
    private TextField teacherNameField; // Text field for teacher name

    @FXML
    private TextField teacherSurnameField; // Text field for teacher surname

    @FXML
    private TextField departmentField; // Text field for department

    @FXML
    private Button addTeacherButton; // Add teacher button

    @FXML
    public void initialize() {
        addTeacherButton.setOnAction(event -> {
            String teacherName = teacherNameField.getText();
            String teacherSurname = teacherSurnameField.getText();
            String department = departmentField.getText();

            System.out.println("Teacher Name: " + teacherName);
            System.out.println("Teacher Surname: " + teacherSurname);
            System.out.println("Department: " + department);

            newTeacher = new Teacher(teacherName, teacherSurname, department); // Create a new Teacher object
            newTeacher.saveToText(); // Save the new teacher information to a text file
        });
    }

}
