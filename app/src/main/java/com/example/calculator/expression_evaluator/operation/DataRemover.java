package com.example.calculator.expression_evaluator.operation;

import com.example.calculator.expression_evaluator.main.SetData;

import java.math.BigDecimal;

public class DataRemover {
    public static void remove(int index, SetData data) {
        data.numbers.remove(index+1);
        data.operations.remove(index);
    }
}
