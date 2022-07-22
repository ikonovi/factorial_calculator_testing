package ik.factorial_calculator.data;

import io.qameta.allure.Attachment;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FactorialResultParser {

    private FactorialResultParser() {
    }

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
