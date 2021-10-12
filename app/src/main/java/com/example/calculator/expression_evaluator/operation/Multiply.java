package com.example.calculator.expression_evaluator.operation;

import com.example.calculator.expression_evaluator.main.SetData;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Collection;

public class Multiply {
    public static void multiply(int indexOfMultiply, SetData data, MathContext mc) {
        BigDecimal A = data.numbers.get(indexOfMultiply);
        BigDecimal B = data.numbers.get(indexOfMultiply+1);
        BigDecimal C = A.multiply(B, mc);
        DataRemover.remove(indexOfMultiply, data);
        data.numbers.set(indexOfMultiply,C);
    }
}
