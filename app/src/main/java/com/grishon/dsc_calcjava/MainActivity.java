package com.grishon.dsc_calcjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Stack;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener{
    TextView one, two, three, four, five, six, seven, eight, nine, zero, plus, minus, multiply, divide, point, cancel, opEditText, resultTextView;
    Button calculate;
    String holder = "";
    private float varOne;
    private float varTwo;
    private int varOne1;
    private int varTwo1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        one = findViewById(R.id.one);
        one.setOnClickListener(this);

        two = findViewById(R.id.two);
        two.setOnClickListener(this);

        three = findViewById(R.id.three);
        three.setOnClickListener(this);

        four = findViewById(R.id.four);
        four.setOnClickListener(this);

        five = findViewById(R.id.five);
        five.setOnClickListener(this);

        six = findViewById(R.id.six);
        six.setOnClickListener(this);

        seven = findViewById(R.id.seven);
        seven.setOnClickListener(this);

        eight = findViewById(R.id.eight);
        eight.setOnClickListener(this);

        nine = findViewById(R.id.nine);
        nine.setOnClickListener(this);

        zero = findViewById(R.id.zero);
        zero.setOnClickListener(this);

        plus = findViewById(R.id.plus);
        plus.setOnClickListener(this);

        minus = findViewById(R.id.minus);
        minus.setOnClickListener(this);

        multiply = findViewById(R.id.multiply);
        multiply.setOnClickListener(this);

        divide = findViewById(R.id.divide);
        divide.setOnClickListener(this);

        point = findViewById(R.id.point);
        point.setOnClickListener(this);

        cancel = findViewById(R.id.cancel);
        cancel.setOnClickListener(this);
        cancel.setOnLongClickListener(this);

        opEditText = findViewById(R.id.operation_edit_text);
        resultTextView = findViewById(R.id.result_text_view);

        calculate = findViewById(R.id.calculate);
        calculate.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.one:
                String holder = opEditText.getText().toString();
                holder+= "1";
                opEditText.setText(holder);
                break;

            case R.id.two:
                holder = opEditText.getText().toString();
                holder+="2";
                opEditText.setText(holder);
                break;

            case R.id.three:
                holder = opEditText.getText().toString();
                holder+="3";
                opEditText.setText(holder);
                break;

            case R.id.four:
                holder = opEditText.getText().toString();
                holder+="4";
                opEditText.setText(holder);
                break;

            case R.id.five:
                holder = opEditText.getText().toString();
                holder+="5";
                opEditText.setText(holder);
                break;
            case R.id.six:
                holder = opEditText.getText().toString();
                holder+="6";
                opEditText.setText(holder);
                break;
            case R.id.seven:
                holder = opEditText.getText().toString();
                holder+="7";
                opEditText.setText(holder);
                break;
            case R.id.eight:
                holder = opEditText.getText().toString();
                holder+="8";
                opEditText.setText(holder);
                break;
            case R.id.nine:
                holder = opEditText.getText().toString();
                holder+="9";
                opEditText.setText(holder);
                break;
            case R.id.zero:
                holder = opEditText.getText().toString();
                holder+="0";
                opEditText.setText(holder);
                break;
            case R.id.plus:
                holder = opEditText.getText().toString();
                holder+="+";
                opEditText.setText(holder);
                break;
            case R.id.minus:
                holder = opEditText.getText().toString();
                holder+="-";
                opEditText.setText(holder);
                break;
            case R.id.multiply:
                holder = opEditText.getText().toString();
                holder+="*";
                opEditText.setText(holder);
                break;
            case R.id.divide:
                holder = opEditText.getText().toString();
                holder+="/";
                opEditText.setText(holder);
                break;
            case R.id.point:
                holder = opEditText.getText().toString();
                holder+=".";
                opEditText.setText(holder);
                break;
            case R.id.cancel:
                holder = opEditText.getText().toString();
                opEditText.setText(deleteLast(holder));
                break;
            case R.id.calculate:
                holder = opEditText.getText().toString();
                if (holder.contains("+")){
                    performOperation("+");
                }else if (holder.contains("-")){
                    performOperation("-");
                }
                else if(holder.contains("/")){
                    performOperation("/");
                }else if(holder.contains("*")){
                    performOperation("*");
                }
                break;
            default:
                break;
        }

    }

    private void performOperation(String operand){
        holder = opEditText.getText().toString();
        String newVal1 = "";
        String newVal2 = "";
        int val = holder.indexOf(operand);
        for (int i = 0; i <= val; i++){
            newVal1+=holder.charAt(i);
        }
        for (int i = holder.indexOf(operand)+ 1; i <= holder.length() -1; i++){
            newVal2+=holder.charAt(i);
        }
        newVal1 = deleteLast(newVal1);

        if (newVal1.contains(".") || newVal2.contains(".")) {
            varOne = Float.parseFloat(newVal1);
            varTwo = Float.parseFloat(newVal2);

            if (operand == "+"){
                String finall = String.valueOf(varOne + varTwo);
                resultTextView.setText(finall);
            }else if (operand == "-"){
                String finall = String.valueOf(varOne - varTwo);
                resultTextView.setText(finall);
            }else if (operand == "/"){
                String finall = String.valueOf(varOne / varTwo);
                resultTextView.setText(finall);
            }else if (operand == "*"){
                String finall = String.valueOf(varOne * varTwo);
                resultTextView.setText(finall);
            }
        }else {
            varOne1 = Integer.parseInt(newVal1);
            varTwo1 = Integer.parseInt(newVal2);

            if (operand == "+"){
                String finall = String.valueOf(varOne1 + varTwo1);
                resultTextView.setText(finall);
            }else if (operand == "-"){
                String finall = String.valueOf(varOne1 - varTwo1);
                resultTextView.setText(finall);
            }else if (operand == "/"){
                varOne = Float.parseFloat(newVal1);
                varTwo = Float.parseFloat(newVal2);
                String finall = String.valueOf(varOne / varTwo);
                resultTextView.setText(finall);
            }else if (operand == "*"){
                String finall = String.valueOf(varOne1 * varTwo1);
                resultTextView.setText(finall);
            }
        }
    }
    public String deleteLast(String str) {
        if (str != null && str.length() > 0) {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }

    @Override
    public boolean onLongClick(View view) {
        switch (view.getId()){
            case R.id.cancel:
                resultTextView.setText("");
                opEditText.setText("");
        }
        return false;
    }
}
