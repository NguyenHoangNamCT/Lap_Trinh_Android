package com.example.ungdungrandomhinhnen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    LinearLayout laLinearLayout;
    ArrayList<Integer> arrImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        laLinearLayout = (LinearLayout) findViewById(R.id.idLinearLayout);
        arrImage = new ArrayList<>();
        arrImage.add(R.drawable.img_1);
        arrImage.add(R.drawable.img_2);
        arrImage.add(R.drawable.img_3);
        arrImage.add(R.drawable.img_4);
        arrImage.add(R.drawable.img_5);
        arrImage.add(R.drawable.img_6);

        Random r = new Random();
        int vitri = r.nextInt(arrImage.size());
        laLinearLayout.setBackgroundResource(arrImage.get(vitri));
    }
}