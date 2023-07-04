package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListStudentController implements IOperations {
    @FXML
    private TableView<Student> studentTable;

    @FXML
    private TableColumn<Student, String> stdNumColumn; // Student number column

    @FXML
    private TableColumn<Student, String> nameColumn; // Name column

    @FXML
    private TableColumn<Student, String> surnameColumn; // Surname column

    @FXML
    private TableColumn<Student, String> departmentColumn; // Department column

    @FXML
    private TableColumn<Student, Integer> degreeColumn; // Degree column

    @FXML
    private TableColumn<Student, Float> gpaColumn; // GPA column

    @FXML
    private Button searchButton; // Search button

    @FXML
    private Button sortButton; // Sort button

    @FXML
    private TextField searchField; // Search field

    @FXML
    private Label avgLabel; // Average label

    @FXML
    private Label nameLabel; // Name label

    @FXML
    private Label surnameLabel; // Surname label

    @FXML
    private Label departmentLabel; // Department label

    @FXML
    private Label degreeLabel; // Degree label

    @FXML
    private Label gpaLabel; // GPA label

    private ObservableList<Student> studentList;

    public void initialize() {
        studentList = FXCollections.observableArrayList();
        loadFromStudents();

        stdNumColumn.setCellValueFactory(new PropertyValueFactory<>("name")); // Set the value factory for student number column
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("surname")); // Set the value factory for name column
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("department")); // Set the value factory for surname column
        departmentColumn.setCellValueFactory(new PropertyValueFactory<>("studentNumber")); // Set the value factory for department column
        gpaColumn.setCellValueFactory(new PropertyValueFactory<>("gpa")); // Set the value factory for GPA column
        degreeColumn.setCellValueFactory(new PropertyValueFactory<>("degree")); // Set the value factory for degree column

        studentTable.setItems(studentList); // Set the student list to the table

        average(); // Calculate and display the average GPA

        searchButton.setOnAction(event -> {
           
            search(searchField.getText()); // Perform search based on the input text
        });

        sortButton.setOnAction(event -> {
            sort(); // Sort the student list based on GPA
        });
    }

    @Override
    public void sort() {
        studentList.sort(Comparator.comparing(Student::getGpa)); // Sort the student list based on GPA
        studentTable.setItems(studentList); // Update the table with the sorted list
    }

    @Override
    public void search(String stdNumber) {
        try (BufferedReader reader = new BufferedReader(new FileReader("students.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (stdNumber.equals(parts[0])) {
                    System.out.println("Student Found");
                    String name = parts[1];
                    String surname = parts[2];
                    String department = parts[3];
                    Float gpa = Float.parseFloat(parts[4]);
                    int degree = Integer.parseInt(parts[5]);

                    nameLabel.setText("Name: " + name); // Display the student's name
                    surnameLabel.setText("Surname: " + surname); // Display the student's surname
                    departmentLabel.setText("Department: " + department); // Display the student's department
                    degreeLabel.setText("Degree: " + degree); // Display the student's degree
                    gpaLabel.setText("GPA: " + gpa); // Display the student's GPA
                }
            }
        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage());
        }
    }

    @Override
    public double sum() {
        double sumNum = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("students.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    Double gpa = Double.parseDouble(parts[4]);
                    sumNum = gpa + sumNum; // Calculate the sum of GPAs
                }
            }
        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage());
        }
        return sumNum;
    }

    @Override
    public void average() {
        int countStudents = studentList.size();
        avgLabel.setText("Avg: " + sum() / countStudents); // Calculate and display the average GPA
    }

    private void loadFromStudents() {
        try (BufferedReader reader = new BufferedReader(new FileReader("students.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    String stdNumber = parts[0];
                    String name = parts[1];
                    String surname = parts[2];
                    String department = parts[3];
                    Float gpa = Float.parseFloat(parts[4]);
                    int degree = Integer.parseInt(parts[5]);
                    Student student = new Student(stdNumber, name, surname, department, gpa, degree);
                    studentList.add(student); // Add the student to the student list
                }
            }
        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage());
        }
    }
}
