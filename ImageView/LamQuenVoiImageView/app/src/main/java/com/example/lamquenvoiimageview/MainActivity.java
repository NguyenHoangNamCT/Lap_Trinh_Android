package com.example.lamquenvoiimageview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imgHinhXanh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgHinhXanh = findViewById(R.id.imgXanh);
        imgHinhXanh.setImageResource(R.drawable.icon_den);
    }
}