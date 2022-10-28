package com.example.maytinhbotui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView lbl;
    Button btnSo1, btnSo2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lbl = (TextView)findViewById(R.id.lblChuoiDauVao);
        btnSo1 = (Button)findViewById(R.id.btnSo1);
        btnSo2 = (Button)findViewById(R.id.btnSo2);
//        btnSo3 = (Button)findViewById(R.id.btnSo3);
//        btnSo4 = (Button)findViewById(R.id.btnSo4);
//        btnSo5 = (Button)findViewById(R.id.btnSo5);
//        btnSo6 = (Button)findViewById(R.id.btnSo6);
//        btnSo7 = (Button)findViewById(R.id.btnSo7);
//        btnSo8 = (Button)findViewById(R.id.btnSo8);
//        btnSo9 = (Button)findViewById(R.id.btnSo9);



        btnSo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lbl.setText(lbl.getText() + "1");
            }
        });
        btnSo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lbl.setText(lbl.getText() + "2");
            }
        });
        btnSo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lbl.setText(lbl.getText() + "3");
            }
        });
        btnSo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lbl.setText(lbl.getText() + "4");
            }
        });
        btnSo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lbl.setText(lbl.getText() + "5");
            }
        });
        btnSo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lbl.setText(lbl.getText() + "6");
            }
        });
        btnSo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lbl.setText(lbl.getText() + "7");
            }
        });
        btnSo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lbl.setText(lbl.getText() + "8");
            }
        });
        btnSo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lbl.setText(lbl.getText() + "9");
            }
        });
    }


    public static double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)` | number
            //        | functionName `(` expression `)` | functionName factor
            //        | factor `^` factor

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return +parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    if (!eat(')')) throw new RuntimeException("Missing ')'");
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    if (eat('(')) {
                        x = parseExpression();
                        if (!eat(')')) throw new RuntimeException("Missing ')' after argument to " + func);
                    } else {
                        x = parseFactor();
                    }
                    if (func.equals("sqrt")) x = Math.sqrt(x);
                    else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                    else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                    else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

                return x;
            }
        }.parse();
    }
}