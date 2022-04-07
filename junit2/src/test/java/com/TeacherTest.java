package com;

import com.model.Teacher;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TeacherTest {
    @Test
    public void testStudent() {
        Teacher a = new Teacher();
        a.setId(1);
        a.setEmail("mgabriel@perscholas.org");
        a.setfName("Mike");
        a.setlName("Gabriel");

        Teacher b = new Teacher();
        b.setId(1);
        b.setEmail("mgabriel@perscholas.org");
        b.setfName("Mike");
        b.setlName("Gabriel");

        assertEquals(a, b);
    }
}