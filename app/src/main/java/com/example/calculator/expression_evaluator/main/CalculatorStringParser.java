package com.example.calculator.expression_evaluator.main;

import java.math.BigDecimal;
import java.util.ArrayList;

public class CalculatorStringParser {
    public static void main(String args[]) {
        InputStringExpression.input();
        SetData data = new SetData(new ArrayList<Character>(), new ArrayList<BigDecimal>());
        NumberExtractor number_extractor = new NumberExtractor();
        number_extractor.numberAndOpsExtractor(data);
        data.doOperation();
        data.displayData();
    }
}
