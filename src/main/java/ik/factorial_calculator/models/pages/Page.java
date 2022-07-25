package ik.factorial_calculator.models.pages;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class Page {
    private static final Logger logger = LogManager.getLogger();
    protected WebDriver driver;

    protected Page(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Clear and type")
    protected void clearAndType(WebElement inputBox, String text) {
        logger.debug("clear and type {}", text);
        inputBox.clear();
        inputBox.sendKeys(text);
    }
}
