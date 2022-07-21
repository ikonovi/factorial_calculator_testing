package ik.factorial_calculator.models;

import ik.factorial_calculator.pages.HomePage;
import ik.factorial_calculator.webdriver.BrowserType;
import ik.factorial_calculator.webdriver.WebDriverConfigurator;
import ik.factorial_calculator.webdriver.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class Application {
    private final WebDriver driver;
    private HomePage homePage;

    public Application(String browser) {
        driver = WebDriverFactory.getWebDriver(BrowserType.valueOfCaseInsensitively(browser));
        WebDriverConfigurator.configure(driver);
    }

    public void open() {
        homePage = new HomePage(driver);
        homePage.load();
    }

    public String calculateFactorial(String text) {
        return homePage
                .enterInteger(text)
                .clickCalculate()
                .getResultText();
    }

    public void close() {
        driver.quit();
    }
}
