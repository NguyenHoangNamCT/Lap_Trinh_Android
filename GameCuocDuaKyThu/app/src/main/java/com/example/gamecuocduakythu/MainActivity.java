package com.example.gamecuocduakythu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    CheckBox cb1, cb2, cb3;
    SeekBar sb1, sb2, sb3;
    ImageButton btnPlay;
    TextView lblDiemSo;
    EditText test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anh_xa();

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CountDownTimer countDownTimer = new CountDownTimer(5000, 300) {
                    @Override
                    public void onTick(long l) {
                        Random r = new Random();
                        int max = sb1.getMax();

                        if(sb1.getProgress() < max && sb2.getProgress() < max && sb3.getProgress() < max){
                            sb1.setProgress(sb1.getProgress() + r.nextInt(6)+1);//(max - min + 1) + min
                            sb2.setProgress(sb2.getProgress() + r.nextInt(6)+1);
                            sb3.setProgress(sb3.getProgress() + r.nextInt(6)+1);
                        }
                    }

                    @Override
                    public void onFinish() {
                        ThongBaoNguoiWin(sb1.getProgress(), sb2.getProgress(), sb3.getProgress());
                    }
                };
                countDownTimer.start();
            }
        });
    }
    public void anh_xa(){
        cb1 = (CheckBox) findViewById(R.id.checkboxOne);
        cb2 = (CheckBox) findViewById(R.id.checkboxTwo);
        cb3 = (CheckBox) findViewById(R.id.checkboxThree);
        sb1 = (SeekBar) findViewById(R.id.seekbarOne);
        sb2 = (SeekBar) findViewById(R.id.seekbarTwo);
        sb3 = (SeekBar) findViewById(R.id.seekbarThree);
        btnPlay = (ImageButton) findViewById(R.id.btnPlay);
        lblDiemSo = (TextView) findViewById(R.id.lblDiemSo);
    }

    public void ThongBaoNguoiWin(int a, int b, int c){
        if(a == b && a == c)
            Toast.makeText(MainActivity.this, "Cả 3 hòa", Toast.LENGTH_LONG).show();
        else if(a == b)
            Toast.makeText(MainActivity.this, "Người chơi 1 và 2 cùng win", Toast.LENGTH_LONG).show();
        else if(a == c)
            Toast.makeText(MainActivity.this, "Người chơi 1 và 3 cùng win", Toast.LENGTH_LONG).show();
        else if(b == c)
            Toast.makeText(MainActivity.this, "Người chơi 2 và 3 cùng win", Toast.LENGTH_LONG).show();
        else if( a > b && a > c)
            Toast.makeText(MainActivity.this, "Người chơi 1 win", Toast.LENGTH_LONG).show();
        else if(b > a && a > c)
            Toast.makeText(MainActivity.this, "Người chơi 2 win", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(MainActivity.this, "Người chơi 3 win", Toast.LENGTH_LONG).show();
    }
}