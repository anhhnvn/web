package first_pro;

import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String fullName;
    private int age;

    // Constructor
    public Student(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }

    // Getters and setters
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{fullName='" + fullName + "', age=" + age + "}";
    }
}

// Class StudentManager
class StudentManager {
    private ArrayList<Student> studentList;

    public StudentManager() {
        studentList = new ArrayList<>();
    }

    // 1. Enter student list
    public void addStudent(String fullName, int age) {
        studentList.add(new Student(fullName, age));
    }

    // 2. Find students by last name
    public ArrayList<Student> findByLastName(String lastName) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student student : studentList) {
            String[] nameParts = student.getFullName().split(" ");
            if (nameParts[nameParts.length - 1].equalsIgnoreCase(lastName)) {
                result.add(student);
            }
        }
        return result;
    }

    // 3. Find and edit students by full name
    public boolean editStudentByFullName(String fullName, String newFullName, int newAge) {
        for (Student student : studentList) {
            if (student.getFullName().equalsIgnoreCase(fullName)) {
                student.setFullName(newFullName);
                student.setAge(newAge);
                return true;
            }
        }
        return false;
    }

    // Print all students
    public void printStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students in the list.");
        } else {
            for (Student student : studentList) {
                System.out.println(student);
            }
        }
    }
}

public class demo {
	
	

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        int choice;

        do {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Enter student list");
            System.out.println("2. Find students by last name");
            System.out.println("3. Find and edit students by full name");
            System.out.println("4. End");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student full name: ");
                    String fullName = scanner.nextLine();
                    System.out.print("Enter student age: ");
                    int age = scanner.nextInt();
                    manager.addStudent(fullName, age);
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    System.out.print("Enter last name to search: ");
                    String lastName = scanner.nextLine();
                    ArrayList<Student> foundStudents = manager.findByLastName(lastName);
                    if (foundStudents.isEmpty()) {
                        System.out.println("No students found with last name " + lastName);
                    } else {
                        System.out.println("Students found:");
                        for (Student student : foundStudents) {
                            System.out.println(student);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter full name to find: ");
                    String searchName = scanner.nextLine();
                    System.out.print("Enter new full name: ");
                    String newFullName = scanner.nextLine();
                    System.out.print("Enter new age: ");
                    int newAge = scanner.nextInt();
                    boolean isUpdated = manager.editStudentByFullName(searchName, newFullName, newAge);
                    if (isUpdated) {
                        System.out.println("Student updated successfully!");
                    } else {
                        System.out.println("No student found with full name " + searchName);
                    }
                    break;

                case 4:
                    System.out.println("Exiting the program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);

        scanner.close();
    }

		

	}


