/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog6122assignmentone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Student {
    private ArrayList<StudentModel> students = new ArrayList<>();
    
    Scanner scanner = new Scanner(System.in);
    
    public void SaveStudent(){
        System.out.println("CAPTURE A NEW STUDENT\n"
                + "*******************************************");
        System.out.print("Enter the student id: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter the student name: ");
        String name = scanner.nextLine();
        
        int age;
        System.out.print("Enter the student age: ");
        
        // A "while" loop is used to ensure that the user enters a valid student age.
        // It continues to prompt the user until a valid age (greater than or equal to 16) is entered.
        while (true) {
        if (scanner.hasNextInt()) {
            age = scanner.nextInt();
            if (age >= 16) {
                break;
            } else {
                System.out.print("You have entered an incorrect student age!!!\nPlease re-enter the student age >>");
                scanner.nextLine(); 
            }
        } else {
            System.out.print("You have entered an incorrect student age!!!\nPlease re-enter the student age >>");
            scanner.next(); 
        }
    
    }
        scanner.nextLine(); 
        System.out.print("Enter the student email: ");
        String email = scanner.nextLine();
        System.out.print("Enter the student course: ");
        String course = scanner.nextLine();

        StudentModel student = new StudentModel(id, age, name, email, course);
        students.add(student);
        System.out.println("Student details have been successfully saved.");
        
    }
    
    public void SearchStudent(Scanner scanner){
        
         System.out.print("Enter the student id to search: ");
         int searchId = scanner.nextInt();
         System.out.println("******************************************");
        
        // A "for-each" loop is used that iterates through the list of students.
        // It checks if each student's ID matches the ID the user is searching for.
         for (StudentModel student : students) {
            if (student.getId() == searchId) {
                System.out.println("STUDENT ID: " + student.getId());
                System.out.println("STUDENT NAME: " + student.getName());
                System.out.println("STUDENT AGE: " + student.getAge());
                System.out.println("STUDENT EMAIL: " + student.getEmail());
                System.out.println("STUDENT COURSE: " + student.getCourse());
                System.out.println("******************************************");
                return;
            }
        }
        System.out.println("Student with Student Id: " + searchId + " was not found!");
        System.out.println("******************************************");
    }
    
    public void DeleteStudent(Scanner scanner){
        System.out.print("Enter the student id to delete: ");
        int searchId = scanner.nextInt();
        System.out.println("******************************************");
        
        // A "for-each" loop is used to iterate through the list of students.
        // It checks if each student's ID matches the ID the user wants to delete.
        for (StudentModel student : students) {
            
            // If a match is found, it asks for confirmation with an "if" statement.
            if (student.getId() == searchId){
                System.out.println("Are you sure you want to delete " + searchId + " from the system? Yes (y) to delete. ");
                char confirm = scanner.next().charAt(0);
                
                // If the user confirms ('y'), the student is removed from the list.
                if (confirm == 'y'){
                    students.remove(student);
                    System.out.println("***************************************************");
                    System.out.println("Student with id: " + searchId + " WAS deleted successfully");
                    System.out.println("***************************************************");
                    
                // If the user doesn't enter 'y' and enters something else, the deletion is canceled.    
                } else {
                    System.out.println("***************************************************");
                    System.out.println("Student deletion cancelled...");
                    System.out.println("***************************************************");
                }
                return;
            }
        }
    }
    
    public void StudentReport(){        
        // The for loop is used here to iterate through the list of students.
        // It allows the program to print a report for each student in the list.
        // The loop iterates from 0 to students.size(), and 'i' represents the index of each student.
        for (int i = 0; i < students.size(); i++) {
            StudentModel student = students.get(i);
            System.out.println("STUDENT " + (i + 1));
            System.out.println("***************************************************");
            System.out.println("STUDENT ID: " + student.getId());
            System.out.println("STUDENT NAME: " + student.getName());
            System.out.println("STUDENT AGE: " + student.getAge());
            System.out.println("STUDENT EMAIL: " + student.getEmail());
            System.out.println("STUDENT COURSE: " + student.getCourse());
            System.out.println("***************************************************");
        }
    }
    
    public void ExitStudentApplication(){   
        System.out.println("Exiting the application.");
    }
    
     public List<StudentModel> getStudents() {
        return students;
    }
    
    
    
}
