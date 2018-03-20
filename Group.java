package com.icloud.sclubber;

import javax.swing.*;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Comparator;


public class Group {
    private Student[] studentsArray = new Student[10];
    String pattern = "[а-яА-ЯёЁa-zA-Z]+$";
    Pattern p = Pattern.compile(pattern);
    Matcher matcher;

    public Group() {
        super();
    }

    public void sortBy(int a) {
        switch (a) {
            case 1:
                Arrays.sort(studentsArray, Student::compareTo);
                break;
            case 2:
                Arrays.sort(studentsArray, Student.SortByName);
                break;
            case 3:
                Arrays.sort(studentsArray, Student.SortBySex);
                break;
            case 4:
                Arrays.sort(studentsArray, Student.SortByAge);
                break;
            case 5:
                Arrays.sort(studentsArray, Student.SortBySpecialization);
                break;
            case 6:
                Arrays.sort(studentsArray, Student.SortBySpecialization);
                break;
        }
    }


    public String surnameAdd() {
        String surname = "";

        for (; ; ) {
            try {
                surname = JOptionPane.showInputDialog("Input surname of new student: ");
                matcher = p.matcher(surname);
                if (surname == null) {
                    throw new NullPointerException();
                }
                if (surname == "") {
                    throw new NullPointerException();
                }
                if (surname.isEmpty() == true) {
                    throw new IllegalArgumentException();
                }
                if (!matcher.find()) {
                    throw new IllegalArgumentException();
                }
                break;

            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Invalid surname format");
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Canceled");
                break;
            }
        }
        return surname;
    }

    public String nameAdd() {
        String name = "";
        for (; ; ) {
            try {
                name = JOptionPane.showInputDialog("Input name of new student: ");
                matcher = p.matcher(name);
                if (name == null) {
                    throw new NullPointerException();
                }
                if (name == "") {
                    throw new NullPointerException();
                }
                if (name.isEmpty() == true) {
                    throw new IllegalArgumentException();
                }
                if (!matcher.find()) {
                    throw new IllegalArgumentException();
                }
                break;

            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Invalid name format");
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Canceled");
                break;
            }
        }
        return name;
    }

    public boolean sexAdd() {
        String gender = "";
        boolean sex = false;
        for (; ; ) {
            try {
                gender = JOptionPane.showInputDialog("Input sex of new student(true = M; false = F)");
                matcher = p.matcher(gender);
                if ("true".compareToIgnoreCase(gender) != 0 && "false".compareToIgnoreCase(gender) != 0) {
                    throw new IllegalArgumentException();
                }
                sex = Boolean.valueOf(gender);
                if (gender == null) {
                    throw new NullPointerException();
                }
                if (gender == "") {
                    throw new NullPointerException();
                }
                if (gender.isEmpty() == true) {
                    throw new IllegalArgumentException();
                }
                if (!matcher.find()) {
                    throw new IllegalArgumentException();
                }
                break;

            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Invalid sex format");
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Canceled");
                break;
            }
        }
        return sex;

    }

    public int ageAdd() {
        String temp = "";
        int age = 0;
        for (; ; ) {
            try {
                temp = JOptionPane.showInputDialog("Input age of student");
                if (temp == null) {
                    throw new NullPointerException();
                }
                age = Integer.valueOf(temp);
                break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error number format");
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Canceled");
                break;
            }
        }
        return age;
    }

    public String specializationAdd() {
        String specialization = "";
        for (; ; ) {
            try {
                specialization = JOptionPane.showInputDialog("Input specialization of new student: ");
                if (specialization == null) {
                    throw new NullPointerException();
                }
                if (specialization == "") {
                    throw new NullPointerException();
                }
                if (specialization.isEmpty() == true) {
                    throw new IllegalArgumentException();
                }
                break;

            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Invalid specialization format");
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Canceled");
                break;
            }
        }
        return specialization;
    }

    public int levelAdd() {
        int level = 0;
        String temp = "";
        for (; ; ) {
            try {
                temp = JOptionPane.showInputDialog("Input level of student");
                if (temp == null) {
                    throw new NullPointerException();
                }
                level = Integer.valueOf(temp);
                break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error number format");
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Canceled");
                break;
            }
        }
        return level;
    }

    public void addNewStudent() {
        String surname = surnameAdd();
        if (surname != null) {
            String name = nameAdd();
            if (name != null) {
                boolean sex = sexAdd();
                int age = ageAdd();
                if (age > 0) {
                    String specialization = specializationAdd();
                    if (specialization != null) {
                        int level = levelAdd();
                        if (level != 0) {
                            Student newStudent = new Student(surname, name, sex, age, specialization, level);
                            System.out.println(newStudent);
                            addStudent(newStudent);
                        } else {
                            JOptionPane.showMessageDialog(null, "Incorrect parameters of student.");
                        }
                    }

                }
            }
        }


    }


    public void addStudent(Student student) {
        try {
            for (int i = 0; i < studentsArray.length; i++) {
                if (studentsArray[i] == null) {
                    studentsArray[i] = student;
                    break;
                } else if (i == 9) {
                    throw new MyException();
                }
            }
        } catch (MyException e) {
            System.out.println(e);
        }
    }


    public void delStudent(Student student) {
        for (int i = 0; i < studentsArray.length; i++) {
            if (studentsArray[i] != null && studentsArray[i].equals(student)) {
                studentsArray[i] = null;
            }
        }
    }

    public String findStudent(String surname) {
        Student student = new Student();
        for (int i = 0; i < studentsArray.length; i++) {
            if (studentsArray[i] != null && studentsArray[i].getSurname().equals(surname)) {
                student = studentsArray[i];
            }

        }

        return student.toString();
    }

    public Student[] getStudentsArray() {
        return studentsArray;
    }

    @Override
    public String toString() {
        Student temp;
        for (int i = 0; i < studentsArray.length; i++) {
            for (int j = i; j < studentsArray.length; j++) {
                try {
                    if (studentsArray[i].getSurname().compareTo(studentsArray[j].getSurname()) > 0) {
                        temp = studentsArray[i];
                        studentsArray[i] = studentsArray[j];
                        studentsArray[j] = temp;
                    }
                } catch (NullPointerException e) {

                }
            }

        }
        String info = "";
        for (int i = 0; i < studentsArray.length; i++) {
            if (studentsArray[i] != null) {
                info += "Group [" + studentsArray[i].toString() + "]" + "\n";
            }
        }
        return info;
    }

}
