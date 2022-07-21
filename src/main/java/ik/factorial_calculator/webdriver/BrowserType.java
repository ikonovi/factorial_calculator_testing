package ik.factorial_calculator.webdriver;

public enum BrowserType {
    CHROME;

    public static BrowserType valueOfCaseInsensitively(String type) {
        return BrowserType.valueOf(type.toUpperCase());
    }
}
