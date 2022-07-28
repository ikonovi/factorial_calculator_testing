package ik.factorial_calculator.report;

import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;

public class AllureScreenshotAttachment implements ReportScreenshotAttachment {
    private static final Logger logger = LogManager.getLogger();
    private final WebDriver driver;

    public AllureScreenshotAttachment(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void add(String name) {
        logger.debug("Attach a screenshot.");
        ByteArrayInputStream content = new ByteArrayInputStream(((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES));
        Allure.addAttachment(name, content);
    }
}
