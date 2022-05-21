package pl.sdacademy.unit.test.advance.exercises.task1;

public class Calculator {

    public long add(int firstDigit, int secondDigit) {
        return (long)firstDigit + secondDigit;
    }

    public double divide(int firstDigit, int secondDigit) {
        if(secondDigit == 0) {
            throw new IllegalArgumentException("Cannot divide by zero!");
        }
        return (double)firstDigit/secondDigit;
    }
}
