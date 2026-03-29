import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentReader {
  private static final String FILE_NAME = "students.txt";
  private static ArrayList<Student> students = new ArrayList<>();

  public static void main(String[] args) {
    loadStudentsFromFile();
    printStudents();

    Scanner scanner = new Scanner(System.in);
    int choice;

    do {
      printMenu();
      choice = scanner.nextInt();
      scanner.nextLine(); // consume newline

      switch (choice) {
        case 1:
          addStudent(scanner);
          break;
        case 2:
          removeStudent(scanner);
          break;
        case 3:
          searchStudent(scanner);
          break;
        case 4:
          System.out.println("Exiting program.");
          break;
        default:
          System.out.println("Invalid choice. Please try again.");
      }
    } while (choice != 4);

    scanner.close();
  }

  public static void loadStudentsFromFile() {
    students.clear();

    try (Scanner fileScanner = new Scanner(new File(FILE_NAME))) {
      while (fileScanner.hasNextLine()) {
        String line = fileScanner.nextLine();
        String[] parts = line.split(" ");

        if (parts.length == 4) {
          String firstName = parts[0];
          String lastName = parts[1];
          String studentId = parts[2];
          String email = parts[3];

          Student student = new Student(firstName, lastName, studentId, email);
          students.add(student);
        }
      }
    } catch (FileNotFoundException e) {
      System.out.println("Error: File not found.");
    }
  }

  public static void printStudents() {
    System.out.println("\nStudent List:");
    for (int i = 0; i < students.size(); i++) {
      System.out.println("Line " + (i + 1) + ": " + students.get(i));
    }
  }

  public static void printMenu() {
    System.out.println("\nMenu:");
    System.out.println("1. Add a student");
    System.out.println("2. Remove a student by ID");
    System.out.println("3. Search for a student by ID");
    System.out.println("4. Exit");
    System.out.print("Enter your choice: ");
  }

  public static void addStudent(Scanner scanner) {
    System.out.print("Enter first name: ");
    String firstName = scanner.nextLine();

    System.out.print("Enter last name: ");
    String lastName = scanner.nextLine();

    System.out.print("Enter student ID: ");
    String studentId = scanner.nextLine();

    System.out.print("Enter email: ");
    String email = scanner.nextLine();

    Student newStudent = new Student(firstName, lastName, studentId, email);
    students.add(newStudent);

    saveStudentsToFile();
    System.out.println("Student added successfully.");
    printStudents();
  }

  public static void removeStudent(Scanner scanner) {
    System.out.print("Enter student ID to remove: ");
    String id = scanner.nextLine();

    boolean removed = false;

    for (int i = 0; i < students.size(); i++) {
      if (students.get(i).getStudentId().equals(id)) {
        students.remove(i);
        removed = true;
        break;
      }
    }

    if (removed) {
      saveStudentsToFile();
      System.out.println("Student removed successfully.");
      printStudents();
    } else {
      System.out.println("Error: Student not found.");
    }
  }

  public static void searchStudent(Scanner scanner) {
    System.out.print("Enter student ID to search: ");
    String id = scanner.nextLine();

    boolean found = false;

    for (Student student : students) {
      if (student.getStudentId().equals(id)) {
        System.out.println("Student found:");
        System.out.println(student);
        found = true;
        break;
      }
    }

    if (!found) {
      System.out.println("Error: Student does not exist.");
    }
  }

  public static void saveStudentsToFile() {
    try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
      for (Student student : students) {
        writer.println(student.getFirstName() + " "
            + student.getLastName() + " "
            + student.getStudentId() + " "
            + student.getEmail());
      }
    } catch (IOException e) {
      System.out.println("Error writing to file.");
    }
  }
}
