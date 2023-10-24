package students;

import students.command.Commands;
import students.model.Student;
import students.storage.StudentStorage;

import java.util.Scanner;

public class StudentDemo implements Commands {

    private static Scanner scanner = new Scanner(System.in);
    private static StudentStorage studentStorage = new StudentStorage();

    public static void main(String[] args) {
        studentStorage.add(new Student("Arpine", "Sargsyan", 27, "077586181", "Gyumri", "Geography"));
        studentStorage.add(new Student("Amalia", "Hakobyan", 23, "094332207", "Erevan", "English"));
        studentStorage.add(new Student("Raffi", "Sargsyan", 25, "098897474", "Gyumri", "History"));
        boolean run = true;
        while (run) {
            System.out.println("Please input " + LOGOUT + " for exit");
            System.out.println("Please input " + ADD_STUDENT + " for add student");
            System.out.println("Please input " + PRINT_ALL_STUDENTS + " for print all student");
            System.out.println("Please input " + DELETE_STUDENT_BY_INDEX + " for delete student by index");
            System.out.println("Please input " + PRINT_STUDENTS_BY_SUBJECT + " for print student by subject ");
            System.out.println("Please input " + PRINT_STUDENTS_COUNT + " for students count");
            System.out.println("Please input " + CHANGE_STUDENT_LESSON + " for change student's subject");
            System.out.println("Please input " + SHOW_AN_OLDEST_STUDENT + " for show an oldest student");


            int command = Integer.parseInt(scanner.nextLine());
            switch (command) {
                case LOGOUT:
                    run = false;
                    break;
                case ADD_STUDENT:
                    addStudent();
                    break;
                case PRINT_ALL_STUDENTS:
                    studentStorage.print();
                    break;
                case DELETE_STUDENT_BY_INDEX:
                    deleteByIndex();
                    break;
                case PRINT_STUDENTS_BY_SUBJECT:
                    printStudentBySubjectName();
                    break;
                case PRINT_STUDENTS_COUNT:
                    System.out.println("We already have " + studentStorage.getSize());
                    break;
                case CHANGE_STUDENT_LESSON:
                    changeStudentSubjectName();
                    break;
                case SHOW_AN_OLDEST_STUDENT:
                    studentStorage.showAnOldestStudent();
                    break;
                default:
                    System.err.println("Invalid command");
            }
        }
    }


    private static void changeStudentSubjectName() {
        studentStorage.print();
        System.out.println("Please choose student index");
        int index = Integer.parseInt(scanner.nextLine());
        Student student = studentStorage.getStudentByIndex(index);
        if (student == null) {
            System.out.println("Wrong index !");
            changeStudentSubjectName();
        } else {
            System.out.println("Please input new subject name");
            String newSubjectName = scanner.nextLine();
            if (newSubjectName != null && !newSubjectName.trim().equals("")) {
                student.setSubject(newSubjectName.trim());
                System.out.println("Subject name changed");
            }
        }
    }

    private static void printStudentBySubjectName() {
        System.out.println("Please input lesson name");
        String subjectName = scanner.nextLine();
        studentStorage.printStudentSubjectName(subjectName);
    }

    private static void deleteByIndex() {
        studentStorage.print();
        System.out.println("Please choose student index");
        int index = Integer.parseInt(scanner.nextLine());
        studentStorage.deleteByIndex(index);
    }

    private static void addStudent() {
        System.out.println("Please input students name");
        String name = scanner.nextLine();
        System.out.println("Please input students surname");

        String surname = scanner.nextLine();
        System.out.println("Please input students age");
        String ageStr = scanner.nextLine();
        System.out.println("Please input students phoneNumber");
        String phoneNumber = scanner.nextLine();
        System.out.println("Please input students city");
        String city = scanner.nextLine();
        System.out.println("Please input students subject");
        String subject = scanner.nextLine();

        int age = Integer.parseInt(ageStr);


        if (subject != null) {
            subject = subject.trim();
        }
        Student student = new Student(name, surname, age, phoneNumber, city, subject);
        studentStorage.add(student);
        System.out.println("Student crated");
    }

}
