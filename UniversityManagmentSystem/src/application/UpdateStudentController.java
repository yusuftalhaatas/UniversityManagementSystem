package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class UpdateStudentController implements Initializable {
    String studentName = " ";
    String studentSurname = " ";
    String department = " ";
    String studentNumber = " ";
    String gpa = " ";
    String degree = " ";

    @FXML
    private TextField studentNameField;

    @FXML
    private	 TextField studentSurnameField;

    @FXML
    private TextField departmentField;

    @FXML
    private TextField studentNumberField;

    @FXML
    private TextField gpaField;

    @FXML
    private TextField degreeField;

    @FXML
    private Button updateButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateButton.setOnAction(event -> {
            updateButtonClicked();
        });
    }

    @FXML
    private void updateButtonClicked() {
        // Get the values entered by the user
        studentName = studentNameField.getText();
        studentSurname = studentSurnameField.getText();
        department = departmentField.getText();
        studentNumber = studentNumberField.getText();
        gpa = gpaField.getText();
        degree = degreeField.getText();

        // Update the file
        updateInFile(studentNumber, studentName, studentSurname, department, gpa, degree);
    }

    public void updateInFile(String studentNumber, String studentName, String studentSurname, String department,
                             String gpa, String degree) {
        try {
            File inputFile = new File("students.txt");
            File tempFile = new File("temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;

            // Read each line of the file
            while ((currentLine = reader.readLine()) != null) {
                String[] studentInfo = currentLine.split(",");

                // Find the student information that needs to be updated
                if (studentInfo[0].equals(studentNumber)) {
                    // Update the student information with the updated values
                    if (!studentName.isEmpty()) {
                        studentInfo[1] = studentName;
                    }
                    if (!studentSurname.isEmpty()) {
                        studentInfo[2] = studentSurname;
                    }
                    if (!department.isEmpty()) {
                        studentInfo[3] = department;
                    }
                    if (!gpa.isEmpty()) {
                        studentInfo[4] = gpa;
                    }
                    if (!degree.isEmpty()) {
                        studentInfo[5] = degree;
                    }

                    // Write the updated student information to the file
                    writer.write(studentInfo[0] + "," + studentInfo[1] + "," + studentInfo[2] + "," +
                            studentInfo[3] + "," + studentInfo[4] + "," + studentInfo[5]);
                } else {
                    // Write the unchanged student information to the file
                    writer.write(currentLine);
                }

                writer.newLine();
            }

            reader.close();
            writer.close();

            // Delete the original file and rename the temporary file to the original file name
            inputFile.delete();
            tempFile.renameTo(inputFile);

            System.out.println("Student information has been updated.");
        } catch (IOException e) {
            System.out.println("File processing error: " + e.getMessage());
        }
    }
}
