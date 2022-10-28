package com.example.lamquenvoiprogressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
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
                CountDownTimer countDownTimer = new CountDownTimer(5000 /**/, 500) //5 000 là 5 giây, 500 là 0.5 giây|| Mỗi 0.5s chạy vào hàm onTick một lần, Chạy trong 10s
                {
                    @Override
                    public void onTick(long l) {
                        count = pbXuLy.getProgress();
                        if(count >= pbXuLy.getMax())
                            count=0;
                        pbXuLy.setProgress(count + 10);
                    }

                    @Override
                    public void onFinish() //sau khi chạy xong thì sẽ chạy vào onFinish
                    {
                        this.start();//Nếu muốn chạy vô hạng thì dô đây cho chạy tiếp tục
                        Toast.makeText(MainActivity.this, "Hết giờ", Toast.LENGTH_SHORT).show();
                    }
                };
                countDownTimer.start();
            }
        });
    }
}