package com.example.timhieuvetoast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnToastNe_Click() {
//        Context context = getApplicationContext();
//        String text = "Toast trông như thế này đây";
//        int duration = Toast.LENGTH_LONG;
//        Toast name = Toast.makeText(context, text, duration);
//        name.show();

//        Toast.makeText(getApplicationContext(), "Toast trông như thế này đây", Toast.LENGTH_SHORT).show();

        Toast name = Toast.makeText(MainActivity.this, "Toast trông như thế này nè", Toast.LENGTH_LONG);
        name.show();
    }
}