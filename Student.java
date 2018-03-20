package com.icloud.sclubber;

import java.util.Comparator;

public class Student extends Human implements Comparable<Student> {
    private String specialization;
    private int level;

    public Student(String surname, String name, boolean sex, int age, String specialization, int level) {
        super(surname, name, sex, age);
        this.specialization = specialization;
        this.level = level;
    }

    public Student(String surname, String name, boolean sex, int age) {
        super(surname, name, sex, age);
    }

    public Student() {
    }

    ;

    public int compareTo(Student student) {
        return (this.getSurname().compareTo(student.getSurname()));
    }

    //Comparator для сортировки  массива объектов по имени
    public static Comparator<Student> SortByName = new Comparator<Student>() {
        @Override
        public int compare(Student studentOne, Student studentTwo) {
            return (studentOne.getName().compareTo(studentTwo.getName()));
        }

    };
    //Comparator для сортировки  массива объектов по полу
    public static Comparator<Student> SortBySex = new Comparator<Student>() {
        @Override
        public int compare(Student studentOne, Student studentTwo) {
            String temp1, temp2;
            if (studentOne.isSex()) {
                temp1 = "true";
            } else {
                temp1 = "false";
            }
            if (studentTwo.isSex()) {
                temp2 = "true";
            } else {
                temp2 = "false";
            }
            return (temp1.compareTo(temp2));
        }

    };

    //Comparator для сортировки  массива объектов по возрасту
    public static Comparator<Student> SortByAge = new Comparator<Student>() {

        @Override
        public int compare(Student studentOne, Student studentTwo) {
            return studentOne.getAge() - studentTwo.getAge();
        }
    };

    //Comparator для сортировки массива объектов по специализации
    public static Comparator<Student> SortBySpecialization = new Comparator<Student>() {

        @Override
        public int compare(Student studentOne, Student studentTwo) {
            return (studentOne.getSpecialization().compareTo(studentTwo.getSpecialization()));
        }
    };

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + level;
        result = prime * result + ((specialization == null) ? 0 : specialization.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (level != other.level)
            return false;
        if (specialization == null) {
            if (other.specialization != null)
                return false;
        } else if (!specialization.equals(other.specialization))
            return false;
        return true;
    }


    @Override
    public void getInfo() {
        String sexPrint;
        if (isSex()) {
            sexPrint = "Male";
        } else {
            sexPrint = "Female";
        }
        System.out.println(getSurname() + " " + getName() + " " + sexPrint + " " + getAge() + " " + specialization
                + " Level: " + level);
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        String sexPrint;
        if (isSex()) {
            sexPrint = "Male";
        } else {
            sexPrint = "Female";
        }
        return (getSurname() + " " + getName() + " " + sexPrint + " " + getAge() + " " + specialization + " Level: "
                + level);
    }


}
