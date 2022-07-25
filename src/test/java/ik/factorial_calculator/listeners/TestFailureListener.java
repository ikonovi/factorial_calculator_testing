package ik.factorial_calculator.listeners;

import ik.factorial_calculator.report.Screenshot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static ik.factorial_calculator.configs.TestsConfig.TESTNG_CONTEXT_ATTR_SCREENSHOT;

public class TestFailureListener implements ITestListener {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void onTestFailure(ITestResult result) {
        logger.debug("{}", result.getMethod().getMethodName());
        ITestContext testContext = result.getTestContext();
        Screenshot screenshot = (Screenshot) testContext.getAttribute(TESTNG_CONTEXT_ATTR_SCREENSHOT);
        screenshot.attach();
    }
}
