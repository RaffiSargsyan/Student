package students;

import java.util.Scanner;

public class StudentDemo {

    private static Scanner scanner = new Scanner(System.in);
    private static StudentStorage studentStorage = new StudentStorage();

    public static void main(String[] args) {
        studentStorage.add(new Student("Arpine", "Sargsyan", 27, "09499", "Gyumri", "Geography"));
        studentStorage.add(new Student("Amalia", "Hakobyan", 22, "09433", "Gyumri", "English"));
        studentStorage.add(new Student("Raffi", "Sargsyan", 24, "09474", "Gyumri", "History"));
        boolean run = true;
        while (run) {
            System.out.println("Please input 0 for exit");
            System.out.println("Please input 1 for add student");
            System.out.println("Please input 2 for print all student");
            System.out.println("Please input 3 for delete student by index");
            System.out.println("Please input 4 for print student by subject ");
            System.out.println("Please input 5 for students student count");
            System.out.println("Please input 6 for change student's subject");
            int command = Integer.parseInt(scanner.nextLine());
            switch (command) {
                case 0:
                    run = false;
                    break;
                case 1:
                    addStudent();
                    break;
                case 2:
                    studentStorage.print();
                    break;
                case 3:
                    deleteByIndex();
                    break;
                case 4:
                    printStudentBySubjectName();
                    break;
                case 5:
                    System.out.println("Student count" + studentStorage.getSize());
                    break;
                case 6:
                    changeStudentSubjectName();
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
