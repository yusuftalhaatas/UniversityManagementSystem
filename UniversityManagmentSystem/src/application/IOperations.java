package application;

public interface IOperations {
    // Sort the student list
    void sort();
    
    // Search for a student with the given student number
    void search(String stdNumber);
    
    // Calculate the sum of GPAs
    double sum();
    
    // Calculate and display the average GPA
    void average();
}
