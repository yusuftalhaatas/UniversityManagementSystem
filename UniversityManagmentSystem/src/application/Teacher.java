package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Teacher extends User {
    
    public Teacher(String name, String surname, String department) {
        super(name, department, surname);
    }
   
    public void saveToText() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("teachers.txt", true));
            
            // Prepare the teacher information string
            String teacherInfo = getName() + "," + getSurname() + "," + getDepartment();
            
            // Write the teacher information to the file
            writer.write(teacherInfo);
            writer.newLine();
            
            writer.close();
            System.out.println("Teacher information saved to file.");
        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage());
        }
    }
}
