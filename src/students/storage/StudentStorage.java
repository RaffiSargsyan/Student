package students.storage;

import students.model.Student;

public class StudentStorage {
    private Student[] array = new Student[10];
    private int size = 0;

    public void add(Student student) {
        if (size == array.length) {
            Student[] temp = new Student[array.length + 10];
            for (int i = 0; i < size; i++) {
                temp[i] = array[i];
            }
            array = temp;

        }
        array[size++] = student;
    }


    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(i + ". " + array[i]);
        }
    }


    public void deleteByIndex(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index");
        } else {
            for (int i = index; i < size; i++) {
                array[i] = array[i + 1];
            }
            size--;
        }
    }

    public void printStudentSubjectName(String lessonName) {
        for (int i = 0; i < size; i++) {
            if (array[i].getSubject().equals(lessonName)) {
                System.out.println(array[i]);
            }
        }
    }

    public int getSize() {
        return size;
    }

    public Student getStudentByIndex(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return array[index];
    }

    public void showAnOldestStudent() {
        Student oldestStudent = array[0];
        for (int i = 1; i < size; i++) {
            if (array[i].getAge() > oldestStudent.getAge()) {
                oldestStudent = array[i];
            }
        }
        System.out.println(oldestStudent.getName() + " is our oldest student");
        System.out.println("And we already have " + size + " students\n");
    }

    private void increaseArray() {

    }
}


