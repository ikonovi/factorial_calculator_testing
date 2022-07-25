package ik.factorial_calculator.models;

import ik.factorial_calculator.models.pages.HomePage;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class Application {
    private static final Logger logger = LogManager.getLogger();
    private final WebDriver driver;
    private HomePage homePage;

    public Application(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Open application")
    public void open() {
        logger.debug("Open the Home page");
        homePage = new HomePage(driver);
        homePage.load();
    }

    @Step("Calculate factorial")
    public String calculateFactorial(String text) {
        logger.debug("Calculate factorial of {}", text);
        return homePage
                .enterInteger(text)
                .clickCalculate()
                .getResultText();
    }

    @Step("Close application")
    public void close() {
        logger.debug("Close application");
        driver.quit();
    }
}
