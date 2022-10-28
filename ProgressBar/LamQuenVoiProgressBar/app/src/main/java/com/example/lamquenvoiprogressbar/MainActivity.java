package com.example.lamquenvoiprogressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnClick;
    ProgressBar pbXuLy;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnClick = (Button) findViewById(R.id.button);
        pbXuLy = (ProgressBar) findViewById(R.id.progressBar2);

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count =pbXuLy.getProgress();
                if(count >= pbXuLy.getMax())
                    count=0;
                pbXuLy.setProgress(count + 10);
            }
        });
    }
}