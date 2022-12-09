package com.example.intent_explicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Second_Activity extends AppCompatActivity {
    Button btnMoveToMainactivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        btnMoveToMainactivity = findViewById(R.id.btnMoveToMainActivity);

        btnMoveToMainactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Second_Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}