package ik.factorial_calculator.report;

import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;

public class Screenshot {
    private static final Logger logger = LogManager.getLogger();
    private final WebDriver driver;

    public Screenshot(WebDriver driver) {
        this.driver = driver;
    }

    public void attachToAllure() {
        logger.debug("Attach a screenshot of the page.");
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES)));
    }
}
