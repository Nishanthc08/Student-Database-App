package studentdatabaseapp;

import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private String gradeYear;
    private String studentId;
    private String courses = "";
    private int tuitionBalance = 0;
    private static int costOfCourse = 600;
    private static int id = 1000;
    //Constructor: prompts user to enter student's name and year
    public Student() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter student's first name: ");
        this.firstName = in.nextLine();

        System.out.println("Enter student's last name: ");
        this.lastName = in.nextLine();

        System.out.println("-----------------------------");

        System.out.println("1 - Freshmen\n2 - Sophomore\n3 - Junior\n4 - Senior\nEnter student's class level: ");
        this.gradeYear = in.nextLine();
        setStudentId();
        System.out.println("-----------------------------");
    }

    //Generate an ID
    private void setStudentId() {
        //Grade level + ID
        id++;
        this.studentId = gradeYear + "" + id;
    }


    //Enroll in courses
    public void enroll() {
        //Get inside a loop, user hits 0
        do {
            System.out.println("Enter course to enroll (Q to quit): ");
            Scanner in = new Scanner(System.in);
            String course = in.nextLine();

            if (!course.equals("Q")) {
                courses = courses + "\n " + course;
                tuitionBalance += costOfCourse;
            } else { break; }
        } while (1 != 0);
        System.out.println("-----------------------------");
    }

    //View balance
    public void viewBalance() {
        System.out.println("Your balance is: $" + tuitionBalance);
    }

    //Pay tuition
    public void payTuition() {
        viewBalance();
        System.out.print("Enter your payment: $");
        Scanner in = new Scanner(System.in);
        int payment = in.nextInt();
        tuitionBalance -= payment;
        System.out.println("Thank you for your payment of $" + payment);
        viewBalance();
        System.out.println("-----------------------------");
    }

    //Show status
    public String toString() {
        return "Name: " + firstName + " " + lastName +
                "\nGrade Level: " + gradeYear +
                "\nStudent ID: " + studentId +
                "\nCourses Enrolled:" + courses +
                "\nBalance: $" + tuitionBalance;
    }
}
