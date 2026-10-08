import java.util.Scanner;

class Student {
    String studentName;
    int rollno;
    double marks;
    String courseName;
    int courseCredits;

    Student(String studentName, int rollno, double marks,
            String courseName, int courseCredits) {

        this.studentName = studentName;
        this.rollno = rollno;
        this.marks = marks;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }

    double calculateFee() {
        return courseCredits * 1500;
    }

    boolean checkEligibility() {
        return marks >= 50;
    }

    double calculateScholarship() {

        if (marks >= 85) {
            return 20;
        }
        else if (marks >= 70) {
            return 10;
        }
        else {
            return 0;
        }
    }

    double calculateFinalFee() {

        double fee = calculateFee();
        double scholarship = calculateScholarship();

        double scholarshipamount = (fee * scholarship) / 100;

        return fee - scholarshipamount;
    }

    void displayDetails() {

        double fee = calculateFee();
        double scholarship = calculateScholarship();
        double scholarshipamount = fee * scholarship / 100;
        double finalfee = calculateFinalFee();

        System.out.println("Student Course Registration Details");
        System.out.println("Student Name: " + studentName);
        System.out.println("Student Roll No: " + rollno);
        System.out.println("Student Marks: " + marks);
        System.out.println("Course Name: " + courseName);
        System.out.println("Course Credits: " + courseCredits);
        System.out.println("Eligibility: Eligible");
        System.out.println("Total Fee: Rs. " + fee);
        System.out.println("Scholarship: " + scholarship + "%");
        System.out.println("Scholarship Amount: Rs. " + scholarshipamount);
        System.out.println("Final Fee: Rs. " + finalfee);
    }
}

public class Mainer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        String studentName = sc.nextLine();

        System.out.print("Enter Student Roll Number: ");
        int rollno = sc.nextInt();

        System.out.print("Enter Student Marks: ");
        double marks = sc.nextDouble();

        sc.nextLine();

        System.out.print("Enter Course Name: ");
        String courseName = sc.nextLine();

        System.out.print("Enter Course Credits: ");
        int courseCredits = sc.nextInt();

        Student s = new Student(studentName, rollno, marks,
                                courseName, courseCredits);

        if (s.checkEligibility()) {
            s.displayDetails();
        }
        else {
            System.out.println("Student is not Eligible for this registration");
        }

        sc.close();
    }
}

