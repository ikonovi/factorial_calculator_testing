package ik.factorial_calculator.data;

import io.qameta.allure.Attachment;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ResultMessageParser {

    private ResultMessageParser() {
    }

    /**
     * Gets number from result message.
     *
     * @param resultText text in the format. For example "The factorial of 0 is: 1"
     * @return number the factorial of which to be calculated
     */
    @Attachment("Number from the result text")
    public static synchronized String getNumber(String resultText) {
        final String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(resultText);
        if (matcher.find()) {
            return matcher.group();
        } else {
            return "";
        }
    }

    /**
     * Gets factorial of number from result message.
     *
     * @param resultText text that contains factorial of a number
     * @return value of factorial of number
     */
    @Attachment("Factorial of number from the result text")
    public static synchronized String getNumberFactorial(String resultText) {
        final String regex = "\\d+";
        String nFactorial = "";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(resultText);
        if (matcher.find()) {
            if (matcher.find()) {
                nFactorial = matcher.group();
            }
        }
        return nFactorial;
    }
}
