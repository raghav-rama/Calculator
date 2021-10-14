package com.example.calculator.expression_evaluator.main;

import com.example.calculator.expression_evaluator.operation.Add;
import com.example.calculator.expression_evaluator.operation.Divide;
import com.example.calculator.expression_evaluator.operation.Multiply;
import com.example.calculator.expression_evaluator.operation.Subtract;

import java.math.MathContext;
import java.util.ArrayList;

public class Calculate {
    public void simplify(SetData data) {
        char[] ops = new char[]{' ', '/', 'x', '+', '-'};
        MathContext mc = new MathContext(9);
        boolean do_divide_multiply=true,
                do_addition_subtraction=true;
        int counter = 0;
        do {
            char c = data.operations.get(counter);
            do_divide_multiply = (data.operations.contains(ops[1]) || data.operations.contains(ops[2]));
            if (c == ops[1]) {
                String error = Divide.divide(counter, data, mc);
                if(error.equals(Resources.divideByZero)) System.exit(0);
                continue;
            } else if (c == ops[2]) {
                Multiply.multiply(counter, data, mc);
                continue;
            }
            ++counter;
        }while(do_divide_multiply);
        counter = 0;
        do {
            char c = data.operations.get(counter);
            do_addition_subtraction = (data.operations.contains(ops[3]) || data.operations.contains(ops[4]));
            if(c == ops[3]) {
                Add.add(counter, data, mc);
                continue;
            } else if(c == ops[4]) {
                Subtract.subtract(counter, data, mc);
                continue;
            }
            ++counter;
        }while(do_addition_subtraction);

    }

}
//894/789*646+5648-78*98/7895*983
