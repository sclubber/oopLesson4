package com.icloud.sclubber;


public class Main {

    public static void main(String[] args) {

        Student studentOne = new Student("Domoslavskyi", "Mykola", true, 31, "Java OOP", 2);
        Student studentTwo = new Student("Einstein", "Albert", true, 66, "Phisics", 100500);
        Student studentThree = new Student("Fisun", "Magdalina", false, 22, "Economics", 1);
        Student studentFour = new Student("Armani", "Shcet", true, 45, "Design", 4);
        Student studentFive = new Student("Crowford", "Sindy", false, 30, "Java OOP", 1);
        Student studentSix = new Student("Iyova", "Lara", false, 24, "C#", 4);
        Group groupOne = new Group();
        groupOne.addStudent(studentOne);
        groupOne.addStudent(studentTwo);
        groupOne.addStudent(studentThree);
        groupOne.addStudent(studentFour);
        groupOne.addStudent(studentFive);
        groupOne.addStudent(studentSix);
        System.out.println(groupOne.toString());
        groupOne.delStudent(studentFive);
        System.out.println(groupOne.toString());
        System.out.println(groupOne.findStudent("Domoslavskyi"));
        System.out.println();
        System.out.println(groupOne.toString());
        groupOne.addNewStudent();
        System.out.println(groupOne.toString());
        System.out.println();
        groupOne.sortBy(4);
        System.out.println(groupOne.toString());
    }

}
