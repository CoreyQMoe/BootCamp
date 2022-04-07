package com;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestSuite.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
            System.out.println("U SUCK UR TESTS FAILED");
        }

        System.out.println(result.wasSuccessful());
        if(result.wasSuccessful()) {
            System.out.println("HOORAY WE PASSED THE TESTS");
        }
    }
}
