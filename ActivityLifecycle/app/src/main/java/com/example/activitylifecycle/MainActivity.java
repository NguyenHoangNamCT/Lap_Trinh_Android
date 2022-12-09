package com.example.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    Button btnMoveToSecondActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMoveToSecondActivity = findViewById(R.id.btnMoveToSecondActivity);

        btnMoveToSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Second_Activity.class);
                startActivity(intent);
            }
        });

        Log.d("AAA", "onCreate Main");
    }

    @Override
    protected void onStart() {
        Log.d("AAA", "onStart Main");
        super.onStart();
    }

    @Override
    protected void onRestart() {
        Log.d("AAA", "onRestart Main");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.d("AAA", "onResume Main");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d("AAA", "onPause Main");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d("AAA", "onStop Main");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("AAA", "onDestroy Main");
        super.onDestroy();
    }
}