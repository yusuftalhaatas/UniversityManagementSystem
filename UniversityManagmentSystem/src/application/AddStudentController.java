package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AddStudentController implements Initializable {

    @FXML
    private TextField studentNameField; // Text field for student name

    @FXML
    private TextField studentSurnameField; // Text field for student surname

    @FXML
    private TextField departmentField; // Text field for department

    @FXML
    private TextField studentNumberField; // Text field for student number

    @FXML
    private TextField gpaField; // Text field for GPA

    @FXML
    private TextField degreeField; // Text field for degree

    @FXML
    private Button addButton; // Add button

    @FXML
    private Label nameLabel; // Label for displaying student name

    @FXML
    private Label surnameLabel; // Label for displaying student surname

    @FXML
    private Label departmentLabel; // Label for displaying department

    @FXML
    private Label studentNumberLabel; // Label for displaying student number

    @FXML
    private Label gpaLabel; // Label for displaying GPA

    @FXML
    private Label degreeLabel; // Label for displaying degree

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addButton.setOnAction(event -> {
            addButtonClicked();
        });
    }

    @FXML
    private void addButtonClicked() {
        String studentName = studentNameField.getText();
        String studentSurname = studentSurnameField.getText();
        String department = departmentField.getText();
        String studentNumber = studentNumberField.getText();
        float gpa = Float.parseFloat(gpaField.getText());
        int degree = Integer.parseInt(degreeField.getText());

        // Perform the necessary operations when the ADD button is clicked
        System.out.println("Student Name: " + studentName);
        System.out.println("Surname: " + studentSurname);
        System.out.println("Department: " + department);
        System.out.println("Student Number: " + studentNumber);
        System.out.println("GPA: " + gpa);
        System.out.println("Degree: " + degree);

        Student newStudent = new Student(studentName, studentSurname, department, studentNumber, gpa, degree);
        newStudent.saveToFile(); // Save the new student information to a file
    }
}
