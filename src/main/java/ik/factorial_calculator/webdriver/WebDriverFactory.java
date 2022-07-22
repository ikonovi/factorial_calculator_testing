package ik.factorial_calculator.webdriver;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class WebDriverFactory {

    private WebDriverFactory() {
    }

    @Step("Start browser")
    public static WebDriver getWebDriver(BrowserType type) {
        WebDriver driver;
        if (type == BrowserType.CHROME) {
            WebDriverChromeCreator webDriverChromeCreator = new WebDriverChromeCreator();
            driver = webDriverChromeCreator.create();
        } else {
            throw new IllegalArgumentException("Incorrect web driver type");
        }
        return driver;
    }
}
