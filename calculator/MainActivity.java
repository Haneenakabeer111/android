package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button button0, button1, button2, button3, button4, button5, button6, button7,
            button8, button9, buttonC, buttonAdd, buttonSub, buttonMul, buttonDiv,
            buttonEql, buttonDot;
    EditText result;
    float mValueOne, mValueTwo;
    boolean addition, subtract, multiplication, division;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Button initialization
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonC = findViewById(R.id.buttonClear);
        buttonAdd = findViewById(R.id.buttonPlus);
        buttonSub = findViewById(R.id.buttonMinus);
        buttonMul = findViewById(R.id.buttonMultiply);
        buttonDiv = findViewById(R.id.buttonDivide);
        buttonEql = findViewById(R.id.buttonEquals);
        buttonDot = findViewById(R.id.buttonDot);
        result = findViewById(R.id.display);

        // Number buttons
        View.OnClickListener numberListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                result.setText(result.getText().toString() + b.getText().toString());
            }
        };

        button0.setOnClickListener(numberListener);
        button1.setOnClickListener(numberListener);
        button2.setOnClickListener(numberListener);
        button3.setOnClickListener(numberListener);
        button4.setOnClickListener(numberListener);
        button5.setOnClickListener(numberListener);
        button6.setOnClickListener(numberListener);
        button7.setOnClickListener(numberListener);
        button8.setOnClickListener(numberListener);
        button9.setOnClickListener(numberListener);
        buttonDot.setOnClickListener(numberListener);

        // Clear button
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText("");
                mValueOne = mValueTwo = 0;
                addition = subtract = multiplication = division = false;
            }
        });

        // Operation buttons
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!result.getText().toString().equals("")) {
                    mValueOne = Float.parseFloat(result.getText().toString());
                    addition = true;
                    result.setText("");
                }
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!result.getText().toString().equals("")) {
                    mValueOne = Float.parseFloat(result.getText().toString());
                    subtract = true;
                    result.setText("");
                }
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!result.getText().toString().equals("")) {
                    mValueOne = Float.parseFloat(result.getText().toString());
                    multiplication = true;
                    result.setText("");
                }
            }
        });

        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!result.getText().toString().equals("")) {
                    mValueOne = Float.parseFloat(result.getText().toString());
                    division = true;
                    result.setText("");
                }
            }
        });

        buttonEql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!result.getText().toString().equals("")) {
                    mValueTwo = Float.parseFloat(result.getText().toString());

                    if (addition) {
                        result.setText(String.valueOf(mValueOne + mValueTwo));
                        addition = false;
                    } else if (subtract) {
                        result.setText(String.valueOf(mValueOne - mValueTwo));
                        subtract = false;
                    } else if (multiplication) {
                        result.setText(String.valueOf(mValueOne * mValueTwo));
                        multiplication = false;
                    } else if (division) {
                        if (mValueTwo == 0) {
                            result.setText("Error");
                        } else {
                            result.setText(String.valueOf(mValueOne / mValueTwo));
                        }
                        division = false;
                    }
                }
            }
        });
    }
}
