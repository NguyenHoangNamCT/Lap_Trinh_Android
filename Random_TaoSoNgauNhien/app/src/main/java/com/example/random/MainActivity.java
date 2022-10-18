package com.example.random;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btnRandom;
    TextView tvNumber;
    EditText edtNum1, edtNum2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ánh xạ
        anhXa();
    }
    private void anhXa(){
        //ánh xạ
        btnRandom = (Button) findViewById(R.id.btnRandom);
        tvNumber = (TextView) findViewById(R.id.tvNumber);
        edtNum1 =  (EditText) findViewById(R.id.edtMin);
        edtNum2 = (EditText) findViewById(R.id.edtMax);
    }
    public void btnRandom1_Click(View v){
        //tạo một số ngẫu nhiên từ 0 đến n - 1
        Random rd = new Random();
        int number = rd.nextInt(10);// từ 0 đến 9
        tvNumber.setText(number+"");
    }
    public void btnRandom2_Click(View v){
        String chuoi1 = edtNum1.getText().toString(), chuoi2 = edtNum2.getText().toString();
        if(chuoi1.length() == 0 || chuoi2.length() == 0)
            Toast.makeText(MainActivity.this, "Vui lòng nhập đủ số", Toast.LENGTH_SHORT).show();
        else{
            int min = Integer.parseInt(chuoi1);
            int max = Integer.parseInt(chuoi2);
            if(max < min){
                int temp = max;
                max = min;
                min = temp;
            }
            Random r = new Random();
            int ketQuaRandom = r.nextInt((max - min + 1))  + min;
            tvNumber.setText( ketQuaRandom + "");
        }

    }
}