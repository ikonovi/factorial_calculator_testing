package ik.factorial_calculator.tests;

import ik.factorial_calculator.models.Application;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public abstract class TestBase {
    protected Application app;

    @BeforeClass
    @Parameters({"browser"})
    public void beforeClass(String browser) {
        app = new Application(browser);
    }

    @AfterClass
    public void afterClass() {
        app.close();
    }
}
