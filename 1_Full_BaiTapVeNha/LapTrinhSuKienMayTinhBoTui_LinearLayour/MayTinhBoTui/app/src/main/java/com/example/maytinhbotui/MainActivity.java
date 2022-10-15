package com.example.maytinhbotui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText txtSoA, txtSoB;
    private TextView lblKetQua;
    private Button btnHieu2So, btnTich2So;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtSoA = (EditText) findViewById(R.id.txtSoA);
        txtSoB = (EditText) findViewById(R.id.txtSoB);
        lblKetQua = (TextView)findViewById(R.id.lblKetQua);

        //Lập trình sự kiện theo cách 2
        btnHieu2So = findViewById(R.id.btnHieu2So);
        btnHieu2So.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double soA = Double.parseDouble(txtSoA.getText().toString());
                double soB = Double.parseDouble(txtSoB.getText().toString());
                lblKetQua.setText(-soB+soA+"");
            }
        });

        btnTich2So = (Button)findViewById(R.id.btnTich2So);
        //lập trình sự kiện cách 3
        //Bước 1 implements View.OnClickListener cho MainActivity
        //Bước 2 setOnClickListener cho btn Tich
        btnTich2So.setOnClickListener(this);
        //Bước 3 code logic tính tích trong onclick
    }
    @Override
    public void onClick(View view) {
        double soA = Double.parseDouble(txtSoA.getText().toString());
        double soB = Double.parseDouble(txtSoB.getText().toString());
        lblKetQua.setText(soB*soA+"");
    }

    //Lập trình sự kiện cách 1
    public void btnTong2So_Click(View v) {
        double soA = Double.parseDouble(txtSoA.getText().toString());
        double soB = Double.parseDouble(txtSoB.getText().toString());
        lblKetQua.setText(soB+soA+"");
    }

    public void btnThuong2So_click(View v)
    {
        double soA = Double.parseDouble(txtSoA.getText().toString());
        double soB = Double.parseDouble(txtSoB.getText().toString());
        lblKetQua.setText(soB/soA+"");
    }
    public void btnUocChungLonNhat_click(View v)
    {
        double soA = Double.parseDouble(txtSoA.getText().toString());
        double soB = Double.parseDouble(txtSoB.getText().toString());

        int a = (int)soA, b = (int)soB, du;
        while(b!=0) {
            du = a % b;
            a = b;
            b = du;
        }
        lblKetQua.setText(a+"");
    }
    public void btnThoatChuongTrinh_click(View v)
    {
        finish();
        System.exit(0);
    }
}