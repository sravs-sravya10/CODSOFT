import java.io.*;
import java.util.*;

public class StudentManagementSystem {

    private static List<Student> students = new ArrayList<>();
    private static final String FILE_NAME = "students.dat";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        loadFromFile();

        int choice;
        do {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Edit Student");
            System.out.println("4. Search Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Enter a number.");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    editStudent();
                    break;
                case 4:
                    searchStudent();
                    break;
                case 5:
                    displayStudents();
                    break;
                case 6:
                    saveToFile();
                    System.out.println("Data saved. Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);
    }

    private static void addStudent() {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        if (name.isEmpty()) {
            System.out.println("Name cannot be empty!");
            return;
        }

        System.out.print("Enter Roll Number: ");
        int roll = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Grade: ");
        String grade = scanner.nextLine();

        System.out.print("Enter Marks: ");
        double marks = scanner.nextDouble();
        scanner.nextLine();

        students.add(new Student(name, roll, grade, marks));
        System.out.println("Student added successfully!");
    }

    private static void removeStudent() {
        System.out.print("Enter Roll Number to remove: ");
        int roll = scanner.nextInt();
        scanner.nextLine();

        students.removeIf(student -> student.getRollNumber() == roll);
        System.out.println("Student removed if existed.");
    }

    private static void editStudent() {
        System.out.print("Enter Roll Number to edit: ");
        int roll = scanner.nextInt();
        scanner.nextLine();

        for (Student student : students) {
            if (student.getRollNumber() == roll) {
                System.out.print("Enter New Name: ");
                student.setName(scanner.nextLine());

                System.out.print("Enter New Grade: ");
                student.setGrade(scanner.nextLine());

                System.out.print("Enter New Marks: ");
                student.setMarks(scanner.nextDouble());
                scanner.nextLine();

                System.out.println("Student updated!");
                return;
            }
        }
        System.out.println("Student not found!");
    }

    private static void searchStudent() {
        System.out.print("Enter Roll Number to search: ");
        int roll = scanner.nextInt();
        scanner.nextLine();

        for (Student student : students) {
            if (student.getRollNumber() == roll) {
                System.out.println(student);
                return;
            }
        }
        System.out.println("Student not found!");
    }

    private static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(students);
        } catch (IOException e) {
            System.out.println("Error saving data!");
        }
    }

    private static void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            students = (List<Student>) ois.readObject();
        } catch (Exception e) {
            students = new ArrayList<>();
        }
    }
}