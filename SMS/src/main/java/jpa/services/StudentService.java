package jpa.services;

import jpa.DAO.StudentDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;
import static jpa.mainrunner.SMSRunner.sf;

public class StudentService implements StudentDAO {

    public StudentService() {
    }

    @Override
    public List<Student> getAllStudents() {
        Session s = sf.openSession();
        List<Student> students = new ArrayList<>();
        TypedQuery tq = s.createQuery("FROM Student");
        try {
            students = tq.getResultList();
        } catch (Exception e) {
            s.close();
            System.out.println("Get all students query Failed.");
            e.printStackTrace();
        }
        s.close();
        return students;
    }

    @Override
    public Student getStudentByEmail(String email) {
        Session s = sf.openSession();
        Student student = new Student();
        try {
            TypedQuery tq = s.createQuery("FROM Student  WHERE sEmail = :email");
            tq.setParameter("email", email);
            student = (Student)tq.getSingleResult();
        } catch (Exception e) {
            s.close();
            System.out.println("Get student by email query Failed.");
            e.printStackTrace();
        }
        s.close();
        return student;
    }

    @Override
    public boolean validateStudent(String email, String password) {
        boolean result = false;
        String pw = new String();
        Session s = sf.openSession();
        TypedQuery tq = s.createQuery("SELECT sPass FROM Student WHERE sEmail = :email");
        tq.setParameter("email", email);
        try {
            pw = (String)tq.getSingleResult();
        } catch (Exception e) {
            s.close();
            System.out.println("Validation failed.");

        }
        if(pw.equals(password)) {
            result = true;
        }
        s.close();
        return result;
    }

    @Override
    public void registerStudentToCourse(String email, int cid) {
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        TypedQuery tq = s.createQuery("SELECT s FROM Student s LEFT JOIN FETCH s.sCourses WHERE s.sEmail = :email");
        TypedQuery tqy = s.createQuery("SELECT c FROM Course c WHERE c.id = :id");
        tq.setParameter("email", email);
        tqy.setParameter("id", cid);
        try {
            Student student = (Student) tq.getSingleResult();
            Course newCourse = (Course) tqy.getSingleResult();
            if(!student.getsCourses().contains(newCourse)) {
                student.getsCourses().add(newCourse);
                System.out.println("You have enrolled in " + newCourse.getcName() + " with " + newCourse.getcInstructorName() + ".\n");
                s.save(student);
                t.commit();
            } else {
                System.out.println("You are already enrolled in this course.");
            }
        } catch (Exception e) {
            s.close();
            System.out.println("Register student to course query Failed.");
            e.printStackTrace();
        }
        s.close();
    }

    @Override
    public List<Course> getStudentCourses(String email) {
        List<Course> courses = new ArrayList<>();
        Session s = sf.openSession();
        TypedQuery tq = s.createQuery("SELECT s FROM Student s JOIN FETCH s.sCourses WHERE s.sEmail = :email");
        tq.setParameter("email", email);
        try {
            Student student = (Student) tq.getSingleResult();
            courses = student.getsCourses();
        } catch (NoResultException e) {
            s.close();
        }
        catch (Exception e) {
            s.close();
            System.out.println("Get student courses query Failed.");
            e.printStackTrace();
        }
        return courses;
    }

    public void printStudentCourses(List<Course> studentCourses) {
        StringBuffer sb = new StringBuffer();
        System.out.println("Your current classes:");
        System.out.printf("%-5s%-30s%-20s\n", "ID", "Course", "Instructor");
        System.out.println("-------------------------------------------------------");
        for (int i = 0; i < studentCourses.size(); i++) {
            sb.append(format("%-5s%-30s%-20s\n", studentCourses.get(i).getcId(), studentCourses.get(i).getcName(), studentCourses.get(i).getcInstructorName()));
        }
        System.out.println(sb);
    }
}
