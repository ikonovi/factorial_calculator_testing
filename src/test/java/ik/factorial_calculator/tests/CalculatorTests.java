package ik.factorial_calculator.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalculatorTests extends TestBase {

    @BeforeMethod
    public void setUp() {
        app.open();
    }

    @Test
    public void testInteger() {
        String n = "3";
        String actual = app.calculateFactorial(n);
        String expected = "6";
        Assert.assertEquals(actual, expected, n + "! = ?");
    }

    /*@Test
    public void test2() {
        System.out.println("2");
    }

    @Test
    public void test3() {
        System.out.println("3");
    }*/
}
