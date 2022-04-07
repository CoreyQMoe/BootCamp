package com;
import com.model.Student;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StudentTest {
    @Test
    public void testStudent() {
        Student a = new Student();
        a.setId(1);
        a.setEmail("mgabriel@perscholas.org");
        a.setfName("Mike");
        a.setlName("Gabriel");

        Student b = new Student();
        b.setId(1);
        b.setEmail("mgabriel@perscholas.org");
        b.setfName("Mike");
        b.setlName("Gabriel");

        assertEquals(a, b);
    }

    @Test
    public void testNumberFormatException() {
        assertThrows(NumberFormatException.class, () -> {
            Integer.parseInt("Five");
        });
    }

}
