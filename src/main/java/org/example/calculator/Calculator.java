package org.example.calculator;

public class Calculator {
    public static <T extends Number> double sum(T num1, T num2) {
        return num1.doubleValue() + num2.doubleValue();
    }

    public static <T extends Number> double multiply(T num1, T num2) {
        return num1.doubleValue() * num2.doubleValue();
    }

    public static <T extends Number> double divide(T num1, T num2) {
        if (num2.doubleValue() == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed");
        }
        return num1.doubleValue() / num2.doubleValue();
    }

    public static <T extends Number> double subtract(T num1, T num2) {
        return num1.doubleValue() - num2.doubleValue();
    }

    public static void main(String[] args) {
        int intNum1 = 5;
        int intNum2 = 3;

        double doubleNum1 = 7.5;
        double doubleNum2 = 2.5;

        System.out.println("Sum: " + sum(intNum1, intNum2));
        System.out.println("Multiply: " + multiply(intNum1, intNum2));
        System.out.println("Divide: " + divide(intNum1, intNum2));
        System.out.println("Subtract: " + subtract(intNum1, intNum2));

        System.out.println("Sum: " + sum(doubleNum1, doubleNum2));
        System.out.println("Multiply: " + multiply(doubleNum1, doubleNum2));
        System.out.println("Divide: " + divide(doubleNum1, doubleNum2));
        System.out.println("Subtract: " + subtract(doubleNum1, doubleNum2));
    }
}
