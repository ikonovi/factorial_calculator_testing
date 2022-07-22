package ik.factorial_calculator.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class Page {
    protected WebDriver driver;

    protected Page(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Clear and type")
    protected void clearAndType(WebElement inputBox, String text) {
        inputBox.clear();
        inputBox.sendKeys(text);
    }
}
