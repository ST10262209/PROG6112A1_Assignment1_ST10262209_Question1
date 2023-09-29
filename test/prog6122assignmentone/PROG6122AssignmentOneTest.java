/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package prog6122assignmentone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import org.junit.Test;
import static org.junit.Assert.*;


public class PROG6122AssignmentOneTest {
    
        private Student student;
        
    public PROG6122AssignmentOneTest() {
    }
    

    @Test
    public void testSaveStudent() {
        student = new Student();
        
        //Create a new StudentModel instance using the constructor
        StudentModel addedStudent = new StudentModel(1, 20, "Alice", "alice@example.com", "Math");

        //Add the student to the Student instance
        student.getStudents().add(addedStudent);

        //Retrieve the added student's details
        StudentModel retrievedStudent = student.getStudents().get(0);

        //Verify that the details were correctly set using the constructor
        assertEquals(1, retrievedStudent.getId());
        assertEquals("Alice", retrievedStudent.getName());
        assertEquals(20, retrievedStudent.getAge());
        assertEquals("alice@example.com", retrievedStudent.getEmail());
        assertEquals("Math", retrievedStudent.getCourse());
    }
    
    @Test
    public void testDeleteStudent() {
        //Create an instance of the Student class
        student = new Student();

        //Create a new StudentModel instance using the constructor
        StudentModel studentToDelete = new StudentModel(1, 20, "Alice", "alice@example.com", "Math");

        //Add the student to the Student instance
        student.getStudents().add(studentToDelete);

        //Delete the student by calling the DeleteStudent method
        Scanner scanner = new Scanner("1\ny\n");
        student.DeleteStudent(scanner);

        //Verify that the student has been successfully deleted
        assertEquals(0, student.getStudents().size()); // The student list should be empty
    }
    
    @Test
    public void testDeleteStudent_StudentNotFound() {
        //Create an instance of the Student class
        student = new Student();

        //Redirect System.in to use the simulated input stream with a student ID that does not exist
        String simulatedInput = "2\n"; // Simulate user input for a student ID that does not exist
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        //Delete the student by calling the DeleteStudent method
        student.DeleteStudent(new Scanner(System.in));

        //Verify that the student list remains unchanged (no student should be deleted)
        assertEquals(0, student.getStudents().size()); // The student list should still be empty
    }
    
    
     @Test
    public void testSearchStudent() {
        //Create an instance of the Student class
        student = new Student();

        //Create a new StudentModel instance using the constructor
        StudentModel studentToSearch = new StudentModel(1, 20, "Alice", "alice@example.com", "Math");

        //Add the student to the Student instance
        student.getStudents().add(studentToSearch);

        //Redirect System.in to use the simulated input stream with the student ID to search
        String simulatedInput = "1\n"; // Simulate user input for searching student with ID 1
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        //Capture the output to verify the search result
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        //Search for a student by calling the SearchStudent method
        student.SearchStudent(new Scanner(System.in));

        //Verify that the student is found in the output
        assertTrue(outputStream.toString().contains("STUDENT ID: 1"));
        assertTrue(outputStream.toString().contains("STUDENT NAME: Alice"));
        assertTrue(outputStream.toString().contains("STUDENT AGE: 20"));
        assertTrue(outputStream.toString().contains("STUDENT EMAIL: alice@example.com"));
        assertTrue(outputStream.toString().contains("STUDENT COURSE: Math"));
    }
  
     
    @Test
    public void testSearchStudent_StudentNotFound() {
        //Create an instance of the Student class
        student = new Student();

        //Create a new StudentModel instance using the constructor
        StudentModel studentToSearch = new StudentModel(1, 20, "Alice", "alice@example.com", "Math");

        //Add the student to the Student instance
        student.getStudents().add(studentToSearch);

        //Redirect System.in to use the simulated input stream with a student ID that does not exist
        String simulatedInput = "2\n"; // Simulate user input for searching student with ID 2
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        //Capture the output to verify the search result
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        //Search for a student by calling the SearchStudent method
        student.SearchStudent(new Scanner(System.in));

        //Verify that the student is not found in the output
        assertFalse(outputStream.toString().contains("STUDENT ID: 2"));
        assertFalse(outputStream.toString().contains("STUDENT NAME:"));
        assertFalse(outputStream.toString().contains("STUDENT AGE:"));
        assertFalse(outputStream.toString().contains("STUDENT EMAIL:"));
        assertFalse(outputStream.toString().contains("STUDENT COURSE:"));
    }
    
    @Test
    public void testStudentAge_StudentAgeValid() {
        student = new Student();
        
        //Create a new StudentModel instance with a valid age
        StudentModel validAgeStudent = new StudentModel(2, 18, "Bob", "bob@example.com", "History");

        //Add the student to the Student instance
        student.getStudents().add(validAgeStudent);

        //Retrieve the added student's details
        StudentModel retrievedStudent = student.getStudents().get(0);

        //Verify that the age is valid (greater than or equal to 16)
        assertTrue(retrievedStudent.getAge() >= 16);
    }
    
    @Test
    public void testStudentAge_StudentAgeInvalid() {
        student = new Student();
        
        //Create a new StudentModel instance with an invalid age (less than 16)
        StudentModel invalidAgeStudent = new StudentModel(3, 14, "Charlie", "charlie@example.com", "Science");

        //Add the student to the Student instance
        student.getStudents().add(invalidAgeStudent);

        //Retrieve the added student's details
        StudentModel retrievedStudent = student.getStudents().get(0);

        //Verify that the age is invalid (less than 16)
        assertFalse(retrievedStudent.getAge() >= 16);
    }
    
    @Test
    public void testStudentAge_StudentAgeInvalidCharacter() {
        student = new Student();

        //Redirects System.in to use the simulated input stream with an invalid character for age
        String simulatedInput = "1\n c\n Charlie\n charlie@example.com\n Science"; // Simulate user input with an invalid character and then a valid age
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        //Captures the output to verify the error message
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        //Call the SaveStudent method to capture the invalid age input
        student.SaveStudent();

        //Verify that the error message is displayed
        assertTrue(outputStream.toString().contains("You have entered an incorrect student age!!!"));
}
    
    
}








    

