package com.example.calculator.expression_evaluator.main;

//import com.example.calculator.expression_evaluator.operation.Divide;

import java.math.BigDecimal;
//import java.math.MathContext;
import java.util.ArrayList;
//import java.util.Collection;

public class SetData {
    public ArrayList<Character> operations = new ArrayList<>();
    public ArrayList<BigDecimal> numbers = new ArrayList<>();
    SetData() {
        this.operations = null;
        this.numbers = null;
    }
    public SetData(ArrayList<Character> operations, ArrayList<BigDecimal> numbers) {
        this.operations = operations;
        this.numbers = numbers;
    }
     public void displayData() {
         System.out.println(operations);
         System.out.println(numbers);
         System.out.println(numbers.size());
     }
    public void doOperation() {
        Calculate calculate = new Calculate();
        calculate.simplify(this);
    }
}
