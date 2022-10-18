package com.example.cachganhinhnen;



import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TableLayout;

public class MainActivity extends AppCompatActivity {

    TableLayout manHinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manHinh = (TableLayout) findViewById(R.id.manHinh);

//        manHinh.setBackgroundColor(Color.rgb(123,33,200));//Không set được màu nền bị lỗi gì không biết luôn
//        manHinh.setBackgroundColor(Color.BLUE);
    }
}