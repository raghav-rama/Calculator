package com.example.calculator;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.calculator.databinding.FragmentCalculatorBinding;
import com.example.calculator.expression_evaluator.main.CalculatorStringParser;
import com.example.calculator.expression_evaluator.main.InputStringExpression;
import com.example.calculator.expression_evaluator.main.NumberExtractor;
import com.example.calculator.expression_evaluator.main.Resources;
import com.example.calculator.expression_evaluator.main.SetData;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Calculator extends Fragment {

    private FragmentCalculatorBinding mBinding;
    private final byte mulFlag=1, divFlag=2, addFlag=3, subtractFlag=4;
    private byte flag, flag_num;
    private boolean isBesideSign, isSubtractBesideDivide, isSubtractBesideMultiply;
    private NumberExtractor number_extractor = new NumberExtractor();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_calculator, container, false);
        View view = mBinding.getRoot();
        setButtonValues();
        mBinding.buttonResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputStringExpression.originalExpression = mBinding.getEditText();
                SetData data = new SetData(new ArrayList<Character>(), new ArrayList<BigDecimal>());
//                NumberExtractor number_extractor = new NumberExtractor();
                char c = InputStringExpression.originalExpression.charAt(0);
                String first_two = InputStringExpression.originalExpression.substring(0,2);
                if(first_two.equals(Resources.negativeAndPoint)) {
                    number_extractor.startsWithNegativeAndPositive = true;
//                    mBinding.setTextView(number_extractor.startsWithNegativeAndPositive+"");
                }
                else if(c == '-') number_extractor.startsWithNegative = true;
                else if(c == '.') number_extractor.startWithPoint = true;
//                mBinding.setTextView4(InputStringExpression.originalExpression);
//                ArrayList<Character> operations = new ArrayList<>();
//                ArrayList<BigDecimal> numbers = new ArrayList<>();
                try {
                    number_extractor.numberAndOpsExtractor(data);
                    data.doOperation();
                    mBinding.setEditText(data.numbers.get(0).toString());
                }
                catch (Exception e){
//                    mBinding.setTextView4(e.getMessage());
//                    mBinding.setTextView3(data.numbers.toString());
//                    mBinding.setTextView2(data.operations.toString());
//                    mBinding.setTextView(InputStringExpression.originalExpression);
                }
//                SetData data = new SetData(operations, numbers);
//                mBinding.setTextView(data.toString());
//                mBinding.setTextView2(data.toString());
//                mBinding.setTextView3(data.toString());
//                mBinding.setTextView4(data.toString());
            }
        });
        mBinding.b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBinding.setEditText(mBinding.getEditText()+mBinding.getButtonZero());
//                isBesideSign=false;
                flag_num=1;
//                display();
                resetFlags();
            }
        });
        mBinding.b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBinding.setEditText(mBinding.getEditText()+mBinding.getButtonOne());
//                isBesideSign=false;
                flag_num=1;
//                display();
                resetFlags();
            }
        });
        mBinding.b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBinding.setEditText(mBinding.getEditText()+mBinding.getButtonTwo());
//                isBesideSign=false;
                flag_num=1;
//                display();
                resetFlags();
            }
        });
        mBinding.b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBinding.setEditText(mBinding.getEditText()+mBinding.getButtonThree());
//                isBesideSign=false;
                flag_num=1;
//                display();
                resetFlags();
            }
        });
        mBinding.b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBinding.setEditText(mBinding.getEditText()+mBinding.getButtonFour());
//                isBesideSign=false;
                flag_num=1;
//                display();
                resetFlags();
            }
        });
        mBinding.b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBinding.setEditText(mBinding.getEditText()+mBinding.getButtonFive());
//                isBesideSign=false;
                flag_num=1;
//                display();
                resetFlags();
            }
        });
        mBinding.b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBinding.setEditText(mBinding.getEditText()+mBinding.getButtonSix());
//                isBesideSign=false;
                flag_num=1;
//                display();
                resetFlags();
            }
        });
        mBinding.b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBinding.setEditText(mBinding.getEditText()+mBinding.getButtonSeven());
//                isBesideSign=false;
                flag_num=1;
//                display();
                resetFlags();
            }
        });
        mBinding.b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBinding.setEditText(mBinding.getEditText()+mBinding.getButtonEight());
//                isBesideSign=false;
                flag_num=1;
//                display();
                resetFlags();
            }
        });
        mBinding.b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBinding.setEditText(mBinding.getEditText()+mBinding.getButtonNine());
//                isBesideSign=false;
                flag_num=1;
//                display();
                resetFlags();
            }
        });
        mBinding.buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBinding.setEditText("");
            }
        });
        mBinding.buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number_extractor.hasPoint = false;
//                if(flag_num==0);
                if(flag==addFlag && isBesideSign);
                else if(number_extractor.hasPoint);
                else if(flag==addFlag && !isBesideSign) {
                    mBinding.setEditText(mBinding.getEditText()+mBinding.getButtonAdd());
                    isBesideSign=true;
                }
                else if(isBesideSign && isSubtractBesideDivide) {
                    mBinding.setEditText(deleteLastChars(2)+mBinding.getButtonAdd());
                    isSubtractBesideDivide=false;
                    flag = addFlag;
                }
                else if(isBesideSign && isSubtractBesideMultiply) {
                    mBinding.setEditText(deleteLastChars(2)+mBinding.getButtonAdd());
                    isSubtractBesideMultiply=false;
                    flag = addFlag;
                }
                else if(!isBesideSign && (isSubtractBesideMultiply || isSubtractBesideDivide)) {
                    mBinding.setEditText(mBinding.getEditText()+mBinding.getButtonAdd());
                    flag = addFlag;
                }
                else if((flag==addFlag || flag==subtractFlag || flag==mulFlag || flag==divFlag) && isBesideSign) {
                    flag=addFlag;
                    mBinding.setEditText(deleteLastChars(1)+mBinding.getButtonAdd());
                }
                else if(flag==0) {
                    mBinding.setEditText(mBinding.getEditText()+mBinding.getButtonAdd());
                    flag=addFlag;
                    isBesideSign=true;
                }
                else {
                    mBinding.setEditText(mBinding.getEditText()+mBinding.getButtonAdd());
                    flag=addFlag;
                    isBesideSign=true;
                }
//                display();
            }
        });
        mBinding.buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number_extractor.hasPoint = false;
//                if(flag_num==0);
                if(flag==subtractFlag && isBesideSign);
                else if(number_extractor.hasPoint);
                else if(flag==subtractFlag && !isBesideSign) {
                    mBinding.setEditText(mBinding.getEditText()+mBinding.getButtonSubtract());
                    isBesideSign=true;
                }
                else if(flag==mulFlag && isBesideSign && !isSubtractBesideMultiply) {
                    mBinding.setEditText(mBinding.getEditText()+mBinding.getButtonSubtract());
                    isSubtractBesideMultiply=true;
                }
                else if(flag==mulFlag && isBesideSign && isSubtractBesideMultiply){
                  mBinding.setEditText(deleteLastChars(2)+mBinding.getButtonSubtract());
                  isSubtractBesideMultiply=false;
                }
                // else if(flag==mulFlag && !isBesideSign) {
                //     mBinding.setEditText(mBinding.getEditText()+mBinding.getButtonSubtract());
                //     flag=subtractFlag;
                //     isBesideSign=true;
                // }
                else if(flag==divFlag && isBesideSign && !isSubtractBesideDivide) {
                    mBinding.setEditText(mBinding.getEditText()+mBinding.getButtonSubtract());
                    isSubtractBesideDivide=true;
                }
                else if(flag==divFlag && isBesideSign && isSubtractBesideDivide) {
                  mBinding.setEditText(deleteLastChars(2)+mBinding.getButtonSubtract());
                  isSubtractBesideDivide=false;
                }
                // else if(flag==divFlag && !isBesideSign) {
                //     mBinding.setEditText(mBinding.getEditText()+mBinding.getButtonSubtract());
                //     flag=subtractFlag;
                //     isBesideSign=true;
                // }
                else if((flag==addFlag || flag==subtractFlag || flag==mulFlag || flag==divFlag) && isBesideSign) {
                    flag=subtractFlag;
                    mBinding.setEditText(deleteLastChars(1)+mBinding.getButtonSubtract());
                }
                else if(flag==0) {
                    mBinding.setEditText(mBinding.getEditText()+mBinding.getButtonSubtract());
                    flag=subtractFlag;
                    isBesideSign=true;
                }
                else {
                  mBinding.setEditText(mBinding.getEditText()+mBinding.getButtonSubtract());
                  flag=subtractFlag;
                  isBesideSign=true;
                }
//                display();
            }
        });
        mBinding.buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number_extractor.hasPoint = false;
                if(flag_num==0);
                else if(number_extractor.hasPoint);
                // mBinding.setEditText(mBinding.getEditText()+mBinding.getButtonMultiply());
//                if(flag==mulFlag && isBesideSign);
                else if(flag==mulFlag && !isBesideSign) {
                  mBinding.setEditText(mBinding.getEditText()+mBinding.getButtonMultiply());
                  isBesideSign=true;

                }
                else if((flag==divFlag || flag==mulFlag) && isSubtractBesideDivide) {
                  mBinding.setEditText(deleteLastChars(2)+mBinding.getButtonMultiply());
                  flag=mulFlag;
                  isSubtractBesideDivide=false;
                  isBesideSign=true;
                }
                else if((flag==divFlag || flag==mulFlag) && isSubtractBesideMultiply) {
                  mBinding.setEditText(deleteLastChars(2)+mBinding.getButtonMultiply());
                  flag=mulFlag;
                  isSubtractBesideMultiply=false;
                  isBesideSign=true;
                }
                else if((flag==addFlag || flag==subtractFlag || flag==mulFlag || flag==divFlag) && isBesideSign) {
                    flag=mulFlag;
                    mBinding.setEditText(deleteLastChars(1)+mBinding.getButtonMultiply());
                }
                else if(flag==0) {
                    mBinding.setEditText(mBinding.getEditText()+mBinding.getButtonMultiply());
                    flag=mulFlag;
                    isBesideSign=true;
                }
                else {
                  mBinding.setEditText(mBinding.getEditText()+mBinding.getButtonMultiply());
                  flag=mulFlag;
                  isBesideSign=true;
                }
//                display(); //for debugging
            }
        });
        mBinding.buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number_extractor.hasPoint = false;
                if(flag_num==0);
                else if(number_extractor.hasPoint);
                // mBinding.setEditText(mBinding.getEditText()+mBinding.getButtonDivide());
//                if(flag==divFlag && isBesideSign);
                else if(flag==divFlag && !isBesideSign) {
                  mBinding.setEditText(mBinding.getEditText()+mBinding.getButtonDivide());
                  isBesideSign=true;
                }
                else if((flag==divFlag || flag==mulFlag) && isSubtractBesideDivide) {
                  mBinding.setEditText(deleteLastChars(2)+mBinding.getButtonDivide());
                  flag=divFlag;
                  isSubtractBesideDivide=false;
                  isBesideSign=true;
                }
                else if((flag==divFlag || flag==mulFlag) && isSubtractBesideMultiply) {
                  mBinding.setEditText(deleteLastChars(2)+mBinding.getButtonDivide());
                  flag=divFlag;
                  isSubtractBesideMultiply=false;
                  isBesideSign=true;
                }
                else if(flag==0) {
                    mBinding.setEditText(mBinding.getEditText()+mBinding.getButtonDivide());
                    flag=divFlag;
                    isBesideSign=true;
                }
                else if((flag==addFlag || flag==subtractFlag || flag==mulFlag || flag==divFlag) && isBesideSign) {
                    flag = divFlag;
                    mBinding.setEditText(deleteLastChars(1) + mBinding.getButtonDivide());
                }
                else {
                  mBinding.setEditText(mBinding.getEditText()+mBinding.getButtonDivide());
                  flag=divFlag;
                  isBesideSign=true;
                }
//                display();
            }
        });
        mBinding.buttonPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(number_extractor.hasPoint);
                else {
                    mBinding.setEditText(mBinding.getEditText() + mBinding.getButtonPoint());
                    number_extractor.hasPoint = true;
                }
            }
        });
        mBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBinding.setEditText(new StringBuffer(mBinding.getEditText()).deleteCharAt(mBinding.getEditText().length() - 1).toString());
            }
        });
//         Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_calculator, container, false);
        return view;
    }
    private String deleteLastChars(int n) {
        StringBuffer temp = new StringBuffer(mBinding.getEditText());
        int length = temp.length();
        temp.setLength(length-n);
        return temp.toString();
//        return new StringBuffer(mBinding.getEditText()).deleteCharAt(mBinding.getEditText().length() - 1).toString();
    }
    private String getLastChars(int n) {
        StringBuffer temp = new StringBuffer(mBinding.getEditText());
        int length = temp.length();
        temp.substring(length-n-1);
        return temp.toString();
//        return new StringBuffer(mBinding.getEditText()).deleteCharAt(mBinding.getEditText().length() - 1).toString();
    }
    private void resetFlags() {
        isBesideSign=false;
        isSubtractBesideDivide=false;
        isSubtractBesideMultiply=false;
//        number_extractor.hasPoint = false;
        number_extractor.startWithPoint = false;
        number_extractor.startsWithNegative = false;
    }
    private void display() {
        mBinding.setTextView("flag:"+flag);
        mBinding.setTextView2("isbessign:"+isBesideSign);
        mBinding.setTextView3("issubmul:"+isSubtractBesideMultiply);
        mBinding.setTextView4("issubdiv:"+isSubtractBesideDivide);
    }
    private void setButtonValues() {
        mBinding.setButtonZero("0");
        mBinding.setButtonOne("1");
        mBinding.setButtonTwo("2");
        mBinding.setButtonThree("3");
        mBinding.setButtonFour("4");
        mBinding.setButtonFive("5");
        mBinding.setButtonSix("6");
        mBinding.setButtonSeven("7");
        mBinding.setButtonEight("8");
        mBinding.setButtonNine("9");
        mBinding.setButtonBrackets("()");
        mBinding.setButtonDivide("/");
        mBinding.setButtonMultiply("x");
        mBinding.setButtonClear("C");
        mBinding.setButtonPercent("%");
        mBinding.setButtonPoint(".");
        mBinding.setButtonNegate("+/-");
        mBinding.setButtonResult("=");
        mBinding.setButtonAdd("+");
        mBinding.setButtonSubtract("-");
        mBinding.setEditText("");
    }
}
