package com.example.scientificcalculator;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.mariuszgromada.math.mxparser.Expression;

public class MainActivity extends AppCompatActivity {
    private TextView previous;
    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        previous = findViewById(R.id.previous);
        display = findViewById(R.id.display);
        display.setShowSoftInputOnFocus(false);
    }
    public void UpdateDisplay(String valToAdd){
        String curVal = display.getText().toString();
        int cursor = display.getSelectionStart();
        String leftVal = curVal.substring(0, cursor);
        String rightVal = curVal.substring(cursor);

        display.setText(String.format("%s%s%s", leftVal, valToAdd, rightVal));
        display.setSelection(cursor + valToAdd.length());
    }

    public void zero(View view){
        UpdateDisplay(getResources().getString(R.string.zeroKey));
    }
    public void one(View view){
        UpdateDisplay(getResources().getString(R.string.oneKey));
    }
    public void two(View view){
        UpdateDisplay(getResources().getString(R.string.twoKey));
    }
    public void three(View view){
        UpdateDisplay(getResources().getString(R.string.threeKey));
    }
    public void four(View view){
        UpdateDisplay(getResources().getString(R.string.fourKey));
    }
    public void five(View view){
        UpdateDisplay(getResources().getString(R.string.fiveKey));
    }
    public void six(View view){
        UpdateDisplay(getResources().getString(R.string.sixKey));
    }
    public void seven(View view){
        UpdateDisplay(getResources().getString(R.string.sevenKey));
    }
    public void eight(View view){
        UpdateDisplay(getResources().getString(R.string.eightKey));
    }
    public void nine(View view){
        UpdateDisplay(getResources().getString(R.string.nineKey));
    }
    public void parClose(View view){
        UpdateDisplay(getResources().getString(R.string.parClose));
    }
    public void parOpen(View view){
        UpdateDisplay(getResources().getString(R.string.ParOpen));
    }
    public void division(View view){ UpdateDisplay(getResources().getString(R.string.division)); }
    public void multiply(View view){ UpdateDisplay(getResources().getString(R.string.multiplication)); }
    public void add(View view){
        UpdateDisplay(getResources().getString(R.string.addition));
    }
    public void subtract(View view){ UpdateDisplay(getResources().getString(R.string.subtraction)); }
    public void decimal(View view){
        UpdateDisplay(getResources().getString(R.string.point));
    }

    public void cancel(View view){
        display.setText("");
        previous.setText("");
    }
    public void delete(View view){
        int cursor = display.getSelectionStart();
        int length = display.getText().length();

        if(cursor != 0 && length != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursor-1, cursor, "");
            display.setText(selection);
            display.setSelection(cursor-1);
        }
    }
    public void equalsTo(View view){
        String value = display.getText().toString();

        previous.setText(value);
        value = value.replace(getResources().getString(R.string.division), "/");
        value = value.replace(getResources().getString(R.string.multiplication), "*");

        Expression expression = new Expression(value);
        String value2 = String.valueOf(expression.calculate());
        display.setText(value2);
        display.setSelection(value2.length());
    }
    public void sin(View view){
        UpdateDisplay("sin(");
    }
    public void cos(View view){
        UpdateDisplay("cos(");
    }
    public void tan(View view){
        UpdateDisplay("tan(");
    }
    public void arcsin(View view){
        UpdateDisplay("arcsin(");
    }
    public void arccos(View view){
        UpdateDisplay("arccos(");
    }
    public void arctan(View view){
        UpdateDisplay("arctan(");
    }
    public void log(View view){
        UpdateDisplay("log(");
    }
    public void ln(View view){
        UpdateDisplay("ln(");
    }
    public void sqrt(View view){
        UpdateDisplay("sqrt(");
    }
    public void e(View view){
        UpdateDisplay("e");
    }
    public void pi(View view){
        UpdateDisplay("pi");
    }
    public void nth(View view){
        UpdateDisplay("^(");
    }
    public void square(View view){
        UpdateDisplay("^(2)");
    }
    public void absolute(View view){
        UpdateDisplay("abs(");
    }
    public void isPrime(View view){
        UpdateDisplay("ispr(");
    }
}