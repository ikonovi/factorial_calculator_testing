package ik.factorial_calculator.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class Page {
    protected WebDriver driver;

    protected Page(WebDriver driver) {
        this.driver = driver;
    }

    protected void clearAndType(WebElement inputBox, String text) {
        inputBox.clear();
        inputBox.sendKeys(text);
    }
}
