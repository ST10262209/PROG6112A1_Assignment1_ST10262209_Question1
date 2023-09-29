/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prog6122assignmentone;

import java.util.Scanner;

public class PROG6122AssignmentOne {
    
    /*
    This program allows users to add Students with their id, age, name, course and email. Multiple students can be added
    at a time. The user can then search for students by entering the student's id. The porgram also has a feature allowing
    users to delete students aswell as display a report of all the students currently added into the program. The report
    displays all the student informatiion entered for each user.
    */

    public static void main(String[] args) {
        // Create an instance of the Student class
        Student student = new Student();
        // Create a Scanner object
        Scanner scanner = new Scanner(System.in);
        // Initializes the choice variable to 0 to store the user's menu choice
        int choice = 0;

        System.out.println("STUDENT MANAGEMENT APPLICATION\n"
                + "***************************************************");
        
        while (true) {
        System.out.println("Enter (1) to launch menu or any other key to exit");
        choice = scanner.nextInt();
        
        
        // An "if" statement is used to check whether the user's choice is not equal to 1.
        // This condition determines whether to exit the program based on the user's input.
        if (choice != 1) {
            // Exit the program if any key other than '1' is entered
            System.out.println("Exiting the application.");
            break;
        }

        System.out.println("Please select one of the following menu items:\n"
                + "(1) Capture a new student.\n"
                + "(2) Search for a student.\n"
                + "(3) Delete a student.\n"
                + "(4) Print student report.\n"
                + "(5) Exit Application.\n"
                + "Enter your choice: ");
        choice = scanner.nextInt();
        
        switch (choice) {
            case 1:
                // Calls the SaveStudent method for case 1
                student.SaveStudent();
                break;
            case 2:
                // Calls the SearchStudent method for case 2
                student.SearchStudent(scanner);
                break;
            case 3:
                // Calls the DeleteStudent method for case 3
                student.DeleteStudent(scanner);
                break;
            case 4:
                // Calls the StudentReport method for case 4
                student.StudentReport();
                break;
            case 5:
                // Calls the ExitStudentApplication method for case 5
                student.ExitStudentApplication();
                break;
            default: //re prompts if there is an invalid choice
                System.out.println("Invalid choice.");
                break;
        }
    }
}

}

