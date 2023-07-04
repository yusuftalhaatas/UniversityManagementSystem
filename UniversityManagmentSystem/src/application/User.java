package application;

public abstract class User {
    private String name; // User's name
    private String surname; // User's surname
    private String department; // User's department
    
    public User(String name, String department, String surname) {
        this.name = name;
        this.department = department;
        this.surname = surname;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getSurname() {
        return surname;
    }
    
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
}
