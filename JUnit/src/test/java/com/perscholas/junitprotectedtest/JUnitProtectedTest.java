package com.perscholas.junitprotected;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JUnitProtectedTest {
    @Test
    protected void testReturnName() {
        assertEquals(JUnitProtected.returnName(), "John");
    }
}

