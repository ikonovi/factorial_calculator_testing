package ik.factorial_calculator.data;

import org.testng.annotations.DataProvider;

public class FactorialDataProviders {

    @DataProvider(name = "Non-negative integer and n!")
    public static Object[][] validInputData() {
        return new String[][]{
                {"0", "1"},
                {"1", "1"},
                {"2", "2"},
                {"3", "6"},
                {"5", "120"},
                {"10", "3628800"}
        };
    }

    @DataProvider(name = "Invalid input data")
    public static Object[][] invalidInputData() {
        return new String[][]{
                {"A"}, {"z"}, {""}, {"!"}, {"*"}, {"/>"}, {"--"}, {"'"}, {"<!--"}
        };
    }
}
