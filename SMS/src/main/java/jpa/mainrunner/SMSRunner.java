package jpa.mainrunner;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import jpa.services.CourseService;
import jpa.services.StudentService;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

import static java.lang.String.format;

public class SMSRunner {
    public static final SessionFactory sf = new Configuration().configure().buildSessionFactory();
    private CourseService courseService;
    private StudentService studentService;
    private Student currentStudent;

    public SMSRunner() {
        courseService = new CourseService();
        studentService = new StudentService();
    }

    public static void main(String[] args) {
        SMSRunner sms = new SMSRunner();
        sms.run();
    }

    private void run() {
        // Login or quit
        System.out.println("\n1. Student Login\n2. Quit Application\nPlease Enter Selection: ");
        Scanner sc = new Scanner(System.in);
        int i = 0;
        try {
            i = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again");
            run();
        }
        switch (i) {
            case 1:
                if (studentLogin()) {
                    registerMenu();
                } else {
                    run();
                }
                break;
            case 2:
                System.out.println("Goodbye!");
                sf.close();
                break;
            default:
                System.out.println("Incorrect input. Please try again");
                run();
        }
    }

    private boolean studentLogin() {
        //Get credentials
        Scanner sc = new Scanner(System.in);
        boolean returnValue = false;
        System.out.print("Enter your email address: ");
        String email = sc.nextLine();
        System.out.print("Enter your password: ");
        String password = sc.next();
        StringBuffer sb = new StringBuffer();

        if(studentService.validateStudent(email, password)) {
            currentStudent = studentService.getStudentByEmail(email);
            if (currentStudent != null && currentStudent.getsPass().equals(password)) {
                studentService.printStudentCourses(studentService.getStudentCourses(currentStudent.getsEmail()));
                returnValue = true;
            } else {
                System.out.println("Wrong Credentials. Please try again.");
                studentLogin();
            }
        }
        return returnValue;
    }

    private void registerMenu() {
        //Register or log out
        Scanner sc = new Scanner(System.in);
        int i = 0;
        System.out.println("\n1. Register for a class\n2. Logout\nPlease Enter Selection: ");
        try {
            i = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again");
            registerMenu();
        }
        registration(i);
    }

    public void registration(int i) {
        //Pick a class
        int k = 0;
        StringBuffer sb = new StringBuffer();
        Scanner sc = new Scanner(System.in);
        if (i == 1) {
            List<Course> allCourses = courseService.getAllCourses();
            System.out.printf("%-5s%-30s%-20s\n", "ID", "Course", "Instructor");
            System.out.println("-------------------------------------------------------");
            for (int j = 0; j < allCourses.size(); j++) {
                sb.append(format("%-5s%-30s%-20s\n", allCourses.get(j).getcId(), allCourses.get(j).getcName(), allCourses.get(j).getcInstructorName()));
            }
            System.out.println(sb);
            System.out.println();
            System.out.print("Enter Course Number: ");
            try {
                k = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again");
                registration(i);
            }
            boolean validCourseID = false;
            if(courseService.getCourseById(k) != null){
                validCourseID = true;
            } else {
                System.out.println("Invalid course ID.");
                registration(i);
            }
            if(validCourseID) {
                studentService.registerStudentToCourse(currentStudent.getsEmail(), k);
                studentService.printStudentCourses(studentService.getStudentCourses(currentStudent.getsEmail()));
                registerMenu();
            } else {
                registration(i);
            }
        } else if (i == 2) {
            System.out.println("User logged out.");
            run();
        } else {
            System.out.println("Invalid input. Please try again");
            registration(i);
        }
    }
}
