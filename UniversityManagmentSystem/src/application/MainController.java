package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class MainController {

    @FXML
    private Button addButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button listStdButton;

    @FXML
    private Button updateButton;

    @FXML
    private Button addTeacherButton;

    @FXML
    private Button listTeacherButton;

    @FXML
    public void initialize() {
        // Actions to be performed when the controller is loaded
        // This method is automatically called when the FXML file is loaded

        // Add event listener to addButton
        addButton.setOnAction(event -> {
            // Actions to be performed when ADD STUDENT button is clicked
            System.out.println("ADD STUDENT button clicked");

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AddStudent.fxml"));
                Parent root = loader.load();
                Stage addStudentStage = new Stage();
                addStudentStage.setScene(new Scene(root));
                addStudentStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // Add event listener to deleteButton
        deleteButton.setOnAction(event -> {
            // Actions to be performed when DELETE STD button is clicked
            System.out.println("DELETE STD button clicked");
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("DeleteStudent.fxml"));
                Parent root = loader.load();
                Stage deleteStudentStage = new Stage();
                deleteStudentStage.setScene(new Scene(root));
                deleteStudentStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        });

        // Add event listener to listStdButton
        listStdButton.setOnAction(event -> {
            // Actions to be performed when LIST STD button is clicked
            System.out.println("LIST STD button clicked");
            
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ListStudents.fxml"));
                Parent root = loader.load();
                Stage listStudentStage = new Stage();
                listStudentStage.setScene(new Scene(root));
                listStudentStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // Add event listener to updateButton
        updateButton.setOnAction(event -> {
            // Actions to be performed when UPDATE STD button is clicked
            System.out.println("UPDATE STD button clicked");
            
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("UpdateStudent.fxml"));
                Parent root = loader.load();
                Stage updateStudentStage = new Stage();
                updateStudentStage.setScene(new Scene(root));
                updateStudentStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // Add event listener to addTeacherButton
        addTeacherButton.setOnAction(event -> {
            // Actions to be performed when ADD TEACHER button is clicked
            System.out.println("ADD TEACHER button clicked");
            
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AddTeacher.fxml"));
                Parent root = loader.load();
                Stage addTeacherStage = new Stage();
                addTeacherStage.setScene(new Scene(root));
                addTeacherStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // Add event listener to listTeacherButton
        listTeacherButton.setOnAction(event -> {
            // Actions to be performed when LIST TEACHER button is clicked
            System.out.println("LIST TEACHER button clicked");
            
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ListTeachers.fxml"));
                Parent root = loader.load();
                Stage listTeacherStage = new Stage();
                listTeacherStage.setScene(new Scene(root));
                listTeacherStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
