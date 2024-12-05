package firrst_demo;



import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class StudentManagement {
	
    private List<Student> students;
    private Scanner scanner;

    public StudentManagement() {
        students = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void enterStudentList() {
        System.out.println("Enter the number of students:");
        int numberOfStudents = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("Enter first name:");
            String firstName = scanner.nextLine();
            System.out.println("Enter last name:");
            String lastName = scanner.nextLine();
            System.out.println("Enter age:");
            int age = scanner.nextInt();
            scanner.nextLine();

            students.add(new Student(firstName, lastName, age));
        }
    }

    public void findStudentsByLastName() {
        System.out.println("Enter the last name to search:");
        String lastName = scanner.nextLine();

        for (Student student : students) {
            if (student.getLastName().equalsIgnoreCase(lastName)) {
                System.out.println(student);
            }
        }
    }

    public void findAndEditStudentsByFullName() {
        System.out.println("Enter the full name to search:");
        String fullName = scanner.nextLine();

        for (Student student : students) {
            String studentFullName = student.getFirstName() + " " + student.getLastName();
            if (studentFullName.equalsIgnoreCase(fullName)) {
                System.out.println("Student found: " + student);
                System.out.println("Enter new first name:");
                String newFirstName = scanner.nextLine();
                System.out.println("Enter new last name:");
                String newLastName = scanner.nextLine();
                System.out.println("Enter new age:");
                int newAge = scanner.nextInt();
                scanner.nextLine();

                student.setFirstName(newFirstName);
                student.setLastName(newLastName);
                student.setAge(newAge);
                System.out.println("Student information updated.");
            }
        }
    }

    public void end() {
        System.out.println("Exiting program.");
        scanner.close();
    }

    public static void main(String[] args) {
        StudentManagement management = new StudentManagement();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Enter student list");
            System.out.println("2. Find students by last name");
            System.out.println("3. Find and edit students by full name");
            System.out.println("4. End");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    management.enterStudentList();
                    break;
                case 2:
                    management.findStudentsByLastName();
                    break;
                case 3:
                    management.findAndEditStudentsByFullName();
                    break;
                case 4:
                    management.end();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);
        scanner.close();
    }
}



