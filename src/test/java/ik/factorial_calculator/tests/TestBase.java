package ik.factorial_calculator.tests;

import ik.factorial_calculator.events.TestFailureListener;
import ik.factorial_calculator.models.Application;
import ik.factorial_calculator.report.AllureScreenshotAttachment;
import ik.factorial_calculator.webdriver.BrowserType;
import ik.factorial_calculator.webdriver.WebDriverConfigurator;
import ik.factorial_calculator.webdriver.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import static ik.factorial_calculator.configs.TestsConfig.TESTNG_CONTEXT_ATTR_SCREENSHOT_ATTACHMENT;

@Listeners({TestFailureListener.class})
public abstract class TestBase {
    protected Application app;

    @BeforeClass
    @Parameters({"browser"})
    public void beforeClass(String browser, ITestContext context) {
        WebDriver driver = WebDriverFactory.getWebDriver(BrowserType.valueOfCaseInsensitively(browser));
        WebDriverConfigurator.configure(driver);
        app = new Application(driver);
        AllureScreenshotAttachment screenshot = new AllureScreenshotAttachment(driver);
        context.setAttribute(TESTNG_CONTEXT_ATTR_SCREENSHOT_ATTACHMENT, screenshot);
    }

    @AfterClass
    public void afterClass() {
        app.close();
    }
}
