package com.example.maytinhbotui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText txtSoA, txtSoB;
    private TextView lblKetQua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtSoA = (EditText) findViewById(R.id.txtSoA);
        txtSoB = (EditText) findViewById(R.id.txtSoB);
        lblKetQua = (TextView)findViewById(R.id.lblKetQua);
    }

    public void btnTong2So_Click(View v) {
//        double soA = (double)txtSoA.getText().toString();
//        double soB = (double)txtSoB.getText().toString();
        double soA = Double.parseDouble(txtSoA.getText().toString());
        double soB = Double.parseDouble(txtSoB.getText().toString());

        lblKetQua.setText(soB+soA+"");
    }
}