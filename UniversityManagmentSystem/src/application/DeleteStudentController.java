package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.*;

public class DeleteStudentController {

    @FXML
    private TextField studentNumberField; // Text field for student number

    @FXML
    private Button deleteButton; // Delete button

    @FXML
    private Label infoLabel; // Info label for displaying messages

    @FXML
    public void initialize() {
        deleteButton.setOnAction(event -> {
            String studentNumber = studentNumberField.getText();
            System.out.println("DELETE button clicked. Student number to be deleted: " + studentNumber);
            deleteStudentRecord(studentNumber); // Delete student record
        });
    }

    private void deleteStudentRecord(String studentNumber) {
        File inputFile = new File("students.txt");
        File tempFile = new File("temp.txt");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;
            boolean found = false;

            while ((currentLine = reader.readLine()) != null) {
                if (currentLine.startsWith(studentNumber)) {
                    found = true;
                    continue;
                }
                writer.write(currentLine);
                writer.newLine();
            }

            writer.close();
            reader.close();

            if (found) {
                inputFile.delete();
                tempFile.renameTo(inputFile);
                System.out.println("Student record deleted.");
                infoLabel.setText("Student Deleted");
            } else {
                tempFile.delete();
                infoLabel.setText("Student Not Found");
                System.out.println("Student record not found.");
            }
        } catch (IOException e) {
            System.out.println("File operation error: " + e.getMessage());
        }
    }
}
