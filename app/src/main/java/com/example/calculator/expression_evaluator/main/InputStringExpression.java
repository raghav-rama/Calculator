package com.example.calculator.expression_evaluator.main;

import java.util.Scanner;

public class InputStringExpression {
    public static String originalExpression;
    public static String input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter now : ");
        originalExpression = sc.nextLine();
        return originalExpression;
    }
}

