package com.example.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Second_Activity extends Activity {

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
        Log.d("AAA", "onCreate Second");
    }

    @Override
    protected void onStart() {
        Log.d("AAA", "onStart Second");
        super.onStart();
    }

    @Override
    protected void onRestart() {
        Log.d("AAA", "onRestart Second");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.d("AAA", "onResume Second");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d("AAA", "onPause Second");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d("AAA", "onStop Second");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("AAA", "onDestroy Second");
        super.onDestroy();
    }
}