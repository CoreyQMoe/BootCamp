package Services;

import jpa.DAO.StudentDAO;
import jpa.entitymodels.Student;
import jpa.services.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Collections;



public class testGetStudentByEmail {
        private static StudentDAO studentService;
        @BeforeAll
        public static void setup() {
                studentService = new StudentService();
        }
        @Test
        public void testGetStudentByEmail() {
                Student expected = new Student();
                expected.setsEmail("aiannitti7@is.gd");
                expected.setsName("Alexandra Iannitti");
                expected.setsPass("TWP4hf5j");

                Student actual = studentService.getStudentByEmail("aiannitti7@is.gd");

                Assertions.assertEquals(expected.getsEmail(), actual.getsEmail());
                Assertions.assertEquals(expected.getsName(), actual.getsName());
                Assertions.assertEquals(expected.getsPass(), actual.getsPass());
        }
}

