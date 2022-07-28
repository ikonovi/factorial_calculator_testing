package ik.factorial_calculator.events;

import ik.factorial_calculator.report.ReportScreenshotAttachment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static ik.factorial_calculator.configs.TestsConfig.TESTNG_CONTEXT_ATTR_SCREENSHOT_ATTACHMENT;

public class TestFailureListener implements ITestListener {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void onTestFailure(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        logger.debug("{}", methodName);
        ITestContext testContext = result.getTestContext();
        ReportScreenshotAttachment screenshotAttachment = (ReportScreenshotAttachment) testContext
                .getAttribute(TESTNG_CONTEXT_ATTR_SCREENSHOT_ATTACHMENT);
        screenshotAttachment.add("Screenshot-" + methodName);
    }
}
