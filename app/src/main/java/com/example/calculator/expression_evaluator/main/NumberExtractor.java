package com.example.calculator.expression_evaluator.main;

import java.math.BigDecimal;
import java.util.ArrayList;
public class NumberExtractor {
    private boolean div_mul = false, special = false;
    public boolean startsWithNegative = false,
            startWithPoint = false,
            hasPoint = false,
            startsWithNegativeAndPositive = false;
/*    public int debug(SetData data) {
        if(InputStringExpression.originalExpression.isEmpty())
            return 0;
        else
            return InputStringExpression.originalExpression.length();
    }
    */
    public SetData numberAndOpsExtractor(SetData data) {
        StringBuilder temp = new StringBuilder("");
//        System.out.println(InputStringExpression.originalExpression);
        char[] originalExpressionCharacters = (InputStringExpression.originalExpression+" ").toCharArray();
        int length = originalExpressionCharacters.length, i;
        boolean isDigit = true;
//        char[] ops = new char[]{' ', '\u00F7', '\u00D7', '+', '-'};
        char[] ops = new char[]{' ', '/', 'x', '+', '-'};
        for (i = 0; i<length; ++i) {
            char c = originalExpressionCharacters[i];
            if(startsWithNegativeAndPositive) {
                temp.append(Resources.negativeAndPoint);
                startsWithNegativeAndPositive=false;
                hasPoint = true;
                i=1;
                continue;
            }
            if(startsWithNegative) {
                temp.append(c);
                startsWithNegative=false;
                continue;
            }
            if(startWithPoint) {
                temp.append(c);
                startWithPoint = false;
                hasPoint = true;
                continue;
            }
            isDigit = Character.isDigit(c);
            if(!isDigit && c == '.') {
                temp.append(c);
                hasPoint = true;
                continue;
            }
            if(c == ops[1] || c == ops[2])
                div_mul = true;
            else if(div_mul && c == ops[4]) {
                div_mul=false;
                special=true;
                continue;
            }
            else
                div_mul=false;
            if (!isDigit) {
                addToList(temp, data, special);
                data.operations.add(c);
            }
            if (isDigit) {
                temp.append(c);
            }
        }
        return data;
    }
    private void addToList(StringBuilder temp, SetData data, boolean special) {
        StringBuilder num = new StringBuilder("");
        BigDecimal number;
        if(special) {
            number = new BigDecimal(("-" + temp.toString()));
            this.special = false;
        }
        else
            number = new BigDecimal(temp.toString());
        data.numbers.add(number);
        temp.setLength(0);
    }
}
