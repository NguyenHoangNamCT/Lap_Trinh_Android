package com.example.quytrinhthietkeungdung;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtNoiDung;    //toàn cục
    Button btnClickMePlease;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ánh xạ
       txtNoiDung = (TextView) findViewById(R.id.txtAlo);
       btnClickMePlease = (Button)findViewById(R.id.btnClickMePlease);

       //viết code
       btnClickMePlease.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               txtNoiDung.setTextSize(35);
               txtNoiDung.setText("Bạn đã click vào button");
           }
       });
    }
}