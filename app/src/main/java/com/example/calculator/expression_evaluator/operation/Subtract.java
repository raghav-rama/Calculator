package com.example.calculator.expression_evaluator.operation;

import com.example.calculator.expression_evaluator.main.SetData;

import java.math.BigDecimal;
import java.math.MathContext;

public class Subtract {
    public static void subtract(int indexOfSubtract, SetData data, MathContext mc) {
        BigDecimal A = data.numbers.get(indexOfSubtract);
        BigDecimal B = data.numbers.get(indexOfSubtract + 1);
        BigDecimal C = A.subtract(B, mc);
        DataRemover.remove(indexOfSubtract, data);
        data.numbers.set(indexOfSubtract, C);
    }
}
