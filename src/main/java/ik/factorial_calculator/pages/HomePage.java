package ik.factorial_calculator.pages;

import ik.factorial_calculator.configs.AppConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends Page implements LoadablePage {
    private static final Logger logger = LogManager.getLogger();

    @FindBy(css = "input#number")
    private WebElement enterIntegerInput;

    @FindBy(xpath = "//button[@id='getFactorial']")
    private WebElement calculateButton;

    @FindBy(id = "resultDiv")
    private WebElement resultText;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public HomePage enterInteger(String integer) {
        clearAndType(enterIntegerInput, integer);
        return this;
    }

    public HomePage clickCalculate() {
        calculateButton.click();
        return this;
    }

    public String getResultText() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .withMessage("Result text is not empty.")
                .until(webDriver -> resultText.getText().length() > 0);
        return resultText.getText();
    }

    @Override
    public void load() {
        driver.get(AppConfig.BASE_URL);
        isLoaded();
    }

    @Override
    public void isLoaded() throws AssertionError {
        String currentUrl = driver.getCurrentUrl();
        logger.debug("currentUrl={}", currentUrl);
        if (!currentUrl.contains(AppConfig.BASE_URL)) {
            throw new AssertionError("Home page is not loaded.");
        }
    }
}