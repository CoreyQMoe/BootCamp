package jpa.services;

import jpa.DAO.CourseDAO;
import jpa.entitymodels.Course;
import org.hibernate.Session;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

import static jpa.mainrunner.SMSRunner.sf;

public class CourseService implements CourseDAO {

    public CourseService() {
    }

    @Override
    public List<Course> getAllCourses() {
        List<Course> courses = null;
        Session s = sf.openSession();
        TypedQuery tq = s.createQuery("FROM Course");
        try {
            courses = tq.getResultList();
        }
        catch (Exception e) {
            s.close();
            System.out.println("Courses not found. Please try again.");
        }
        s.close();
        return courses;
    }

    public Course getCourseById(int id) {
        Course course = null;
        Session s = sf.openSession();
        TypedQuery tq = s.createQuery("FROM Course Where cId = :id");
        try {
            tq.setParameter("id", id);
            course = (Course)tq.getSingleResult();
        } catch (NoResultException e) {
            s.close();
        }
        catch(Exception e) {
            s.close();
            System.out.println("Get course by ID query failed.");
        }
        s.close();
        return course;
    }
}
