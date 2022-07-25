package ik.factorial_calculator.models.pages;

public interface LoadablePage {
    void load();

    void isLoaded() throws AssertionError;
}
