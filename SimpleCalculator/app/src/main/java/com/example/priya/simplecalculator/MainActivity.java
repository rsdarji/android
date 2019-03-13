package com.example.priya.simplecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button button1,button2,button3,button4,button5,button6,button7,button8,button9,
            button10,button11,button12,buttonAdd,buttonSub,buttonMul,buttonDiv,buttonEql;
    EditText calEditText;
    float valueOne, valueTwo;

    boolean calAddition, calSubtract, calMultiplication, calDivision;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 =(Button) findViewById(R.id.button1);
        button2 =(Button) findViewById(R.id.button2);
        button3 =(Button) findViewById(R.id.button3);
        button4 =(Button) findViewById(R.id.button4);
        button5 =(Button) findViewById(R.id.button5);
        button6 =(Button) findViewById(R.id.button6);
        button7 =(Button) findViewById(R.id.button7);
        button8 =(Button) findViewById(R.id.button8);
        button9 =(Button) findViewById(R.id.button9);
        button10 =(Button) findViewById(R.id.button10);
        button11 =(Button) findViewById(R.id.button11);
        button12 =(Button) findViewById(R.id.button12);
        buttonAdd =(Button) findViewById(R.id.buttonAdd);
        buttonSub =(Button) findViewById(R.id.buttonSub);
        buttonMul =(Button) findViewById(R.id.buttonMul);
        buttonDiv =(Button) findViewById(R.id.buttonDiv);
        buttonEql =(Button) findViewById(R.id.buttonEql);
        calEditText=(EditText)findViewById(R.id.editText);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calEditText.setText(calEditText.getText() + "1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calEditText.setText(calEditText.getText()+"2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calEditText.setText(calEditText.getText()+"3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calEditText.setText(calEditText.getText()+"4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calEditText.setText(calEditText.getText()+"5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calEditText.setText(calEditText.getText()+"6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calEditText.setText(calEditText.getText()+"7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calEditText.setText(calEditText.getText()+"8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calEditText.setText(calEditText.getText()+"9");
            }
        });
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calEditText.setText(calEditText.getText()+".");
            }
        });
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calEditText.setText(calEditText.getText()+"0");
            }
        });
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calEditText.setText("");
            }
        });
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (calEditText == null) {
                    calEditText.setText("");
                } else {
                    valueOne = Float.parseFloat(calEditText.getText() + "");
                    calAddition = true;
                    calEditText.setText(null);
                }
            }
        });
        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueOne = Float.parseFloat(calEditText.getText() + "");
                calSubtract = true;
                calEditText.setText(null);
            }
        });
        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueOne = Float.parseFloat(calEditText.getText() + "");
                calMultiplication = true;
                calEditText.setText(null);
            }
        });
        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueOne = Float.parseFloat(calEditText.getText() + "");
                calDivision = true;
                calEditText.setText(null);
            }
        });
        buttonEql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueTwo = Float.parseFloat(calEditText.getText() + "");

                if (calAddition == true) {
                    calEditText.setText(valueOne + valueTwo + "");
                    calAddition = false;
                }

                if (calSubtract == true) {
                    calEditText.setText(valueOne - valueTwo + "");
                    calSubtract = false;
                }

                if (calMultiplication == true) {
                    calEditText.setText(valueOne * valueTwo + "");
                    calMultiplication = false;
                }

                if (calDivision == true) {
                    calEditText.setText(valueOne / valueTwo + "");
                    calDivision = false;
                }
            }
        });

    }
}
