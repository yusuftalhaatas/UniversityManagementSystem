package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Student extends User {
    private float gpa;
    private int degree;
    private String studentNumber;

    public Student(String name, String surname, String department, String studentNumber, float gpa, int degree) {
        super(name, department, surname);
        this.studentNumber = studentNumber;
        this.gpa = gpa;
        this.degree = degree;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public void saveToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("students.txt", true));
            
            // Prepare the student information string
            String studentInfo = studentNumber + "," + getName() + "," + getSurname() + "," +
                    getDepartment() + "," + gpa + "," + degree;
            
            // Write the student information to the file
            writer.write(studentInfo);
            writer.newLine();
            
            writer.close();
            System.out.println("Student information saved to file.");
        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage());
        }
    }
}
