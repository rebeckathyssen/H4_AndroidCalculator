package com.example.calculator;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

// Hvordan binder man funktionalitet til en knap? -> onClick
// Hvordan undgår man at man mister indtastede data når telefonen vendes? -> Gem i variabel der ikke slettes (safeinstance)
// Hvordan overfører man data fra én activity til en anden?
// Hvilke muligheder har man for at lave persistens i appen?

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //if (savedInstanceState != null){
          //  result = savedInstanceState.getDouble("result");
            //tv1.setText(String.valueOf(result));
        //}
    }

    double firstNumber;
    String func;
    double secondNumber;
    double result;
    TextView tv1;

    //@Override
    //public void onRestoreInstanceState(Bundle savedInstanceState){
        //super.onRestoreInstanceState(savedInstanceState);
        //double result = savedInstanceState.getDouble("result");
        //tv1.setText(String.valueOf(result));
    //}

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        tv1 = (TextView)findViewById(R.id.textView2);

        //tv1.setText(view);
        switch (view.getId()){
            case (R.id.buttonC):
                tv1.setText("");
                firstNumber = 0;
                func = "";
                secondNumber = 0;
                result = 0;
                break;

            case (R.id.button0):
                tv1.append("0");
                break;

            case (R.id.button1):
                tv1.append("1");
                break;

            case (R.id.button2):
                tv1.append("2");
                break;

            case (R.id.button3):
                tv1.append("3");
                break;

            case (R.id.button4):
                tv1.append("4");
                break;

            case (R.id.button5):
                tv1.append("5");
                break;

            case (R.id.button6):
                tv1.append("6");
                break;

            case (R.id.button7):
                tv1.append("7");
                break;

            case (R.id.button8):
                tv1.append("8");
                break;

            case (R.id.button9):
                tv1.append("9");
                break;

            case (R.id.buttonPlus):
                stringLogic();
                func = "+";
                break;

            case (R.id.buttonMinus):
                stringLogic();
                func = "-";
                break;

            case (R.id.buttonMultiply):
                stringLogic();
                func = "*";
                break;

            case (R.id.buttonDivide):
                stringLogic();
                func = "/";
                break;

            case (R.id.buttonPoint):
                tv1.append(",");
                break;

            case (R.id.buttonEquals):
                secondNumber = Double.parseDouble(tv1.getText().toString());
                calculate(func);
                tv1.setText("");
                DecimalFormat format = new DecimalFormat("0.#");
                tv1.setText(format.format(result));
                break;
        }
    }

    public void stringLogic(){
        if (firstNumber == 0) {
            firstNumber = Double.parseDouble(tv1.getText().toString());
        } else {
            secondNumber = Double.parseDouble(tv1.getText().toString());
            calculate(func);
            firstNumber = result;
        }
        tv1.setText("");
    }

    public void calculate(String func){
        switch (func){
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                result = firstNumber / secondNumber;
                break;
        }
    }

    //@Override
    //public void onSaveInstanceState(Bundle savedInstanceState){
        //super.onSaveInstanceState(savedInstanceState);
        //savedInstanceState.putDouble("result", result);
    //}

}