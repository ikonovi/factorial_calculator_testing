package ik.factorial_calculator.tests;

import ik.factorial_calculator.data.InputDataProviders;
import ik.factorial_calculator.data.ResultMessageParser;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Epic("Testing online factorial calculator")
@Feature("Factorial calculation")
public class CalculationTests extends TestBase {

    @BeforeMethod
    public void setUp() {
        app.open();
    }

        @Test(description = "Test with valid input data",
            dataProvider = "Non-negative integer and n!",
            dataProviderClass = InputDataProviders.class)
    public void testWithValidInputData(String number, String factorial) {
        String resultText = app.calculateFactorial(number);
        String resultFactorial = ResultMessageParser.getNumberFactorial(resultText);
        String resultNumber = ResultMessageParser.getNumber(resultText);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(resultFactorial, factorial, "factorial of number " + number);
        softAssert.assertEquals(resultNumber, number, "number");
        softAssert.assertAll();
    }

    @Test(description = "Test with invalid input data",
            dataProvider = "Invalid input data",
            dataProviderClass = InputDataProviders.class)
    public void testWithInvalidInputData(String text) {
        final String expectedErrorMessage = "Please enter an integer";
        String resultText = app.calculateFactorial(text);
        Assert.assertEquals(resultText, expectedErrorMessage, "Error message");
    }
}
