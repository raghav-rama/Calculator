package com.example.calculator.expression_evaluator.operation;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collection;

import com.example.calculator.expression_evaluator.main.NumberExtractor;
import com.example.calculator.expression_evaluator.main.Resources;
import com.example.calculator.expression_evaluator.main.SetData;

public class Divide {
    public static String divideByZero;

    public static String divide(int indexOfDivide,SetData data, MathContext mc) {
        BigDecimal A = data.numbers.get(indexOfDivide);
        BigDecimal B = data.numbers.get(indexOfDivide+1);
        try {
            BigDecimal C = A.divide(B, mc);
            DataRemover.remove(indexOfDivide, data);
            data.numbers.set(indexOfDivide,C);
            return "";
        }
        catch(Exception e){
            return (Resources.divideByZero);
        }
    }
}
