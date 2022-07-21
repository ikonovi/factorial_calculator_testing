package ik.factorial_calculator.pages;

public interface LoadablePage {
    void load();

    void isLoaded() throws AssertionError;
}
