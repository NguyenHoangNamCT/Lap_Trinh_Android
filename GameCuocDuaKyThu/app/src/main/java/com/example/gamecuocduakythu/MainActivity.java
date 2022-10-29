package com.example.gamecuocduakythu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    CheckBox cb1, cb2, cb3;
    SeekBar sb1, sb2, sb3;
    ImageButton btnPlay;
    TextView lblDiemSo, lblNV1, lblNV2, lblNV3;
    EditText test;
    int num = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anh_xa();

        CountDownTimer countDownTimer = new CountDownTimer(12000, 100) {
            @Override
            public void onTick(long l) {
                Random r = new Random();
                int max = sb1.getMax();
                if(sb1.getProgress() < max && sb2.getProgress() < max && sb3.getProgress() < max){
                    sb1.setProgress(sb1.getProgress() + r.nextInt(num));
                    sb2.setProgress(sb2.getProgress() + r.nextInt(num));
                    sb3.setProgress(sb3.getProgress() + r.nextInt(num));
//                    sb1.setProgress(sb1.getProgress() + num);
//                    sb2.setProgress(sb2.getProgress() + num);
//                    sb3.setProgress(sb3.getProgress() + num);
                }
                else{
                    ThongBaoNguoiWinVaCapNhatDiem();
                    btnPlay.setVisibility(View.VISIBLE);
                    BatCheckBox();
                    BatSB();
                    this.cancel();
                }
            }
            @Override
            public void onFinish() {
            }
        };

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!cb1.isChecked() && !cb2.isChecked() && !cb3.isChecked()){
                    Toast.makeText(MainActivity.this, "Vui lòng đặt cược trước khi chơi", Toast.LENGTH_SHORT).show();
                    return;
                }

                TatChetBox();
                TatSB();
                sb1.setProgress(0); sb2.setProgress(0); sb3.setProgress(0);
                btnPlay.setVisibility(View.INVISIBLE);
                countDownTimer.start();
            }
        });

        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    cb2.setChecked(false);
                    cb3.setChecked(false);
                }
            }
        });

        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    cb1.setChecked(false);
                    cb3.setChecked(false);
                }
            }
        });

        cb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    cb2.setChecked(false);
                    cb1.setChecked(false);
                }
            }
        });

        sb1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                lblNV1.setText("Nhân vật 1: " + i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Ê ẩu rồi đó 3 :D", Toast.LENGTH_SHORT);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        sb2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                lblNV1.setText("Nhân vật 2: " + i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Ê ẩu rồi đó 3 :D", Toast.LENGTH_SHORT);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sb3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                lblNV1.setText("Nhân vật 3: " + i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Ê ẩu rồi đó 3 :D", Toast.LENGTH_SHORT);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void BatCheckBox(){
        cb1.setEnabled(true);
        cb2.setEnabled(true);
        cb3.setEnabled(true);
    }

    public void TatChetBox(){
        cb1.setEnabled(false);
        cb2.setEnabled(false);
        cb3.setEnabled(false);
    }

    public void BatSB(){
        sb1.setEnabled(true);
        sb2.setEnabled(true);
        sb3.setEnabled(true);
    }
    public void TatSB(){
        sb1.setEnabled(false);
        sb2.setEnabled(false);
        sb3.setEnabled(false);
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
        lblNV1 = (TextView) findViewById(R.id.lblDiemNguoi1);
        lblNV2 = (TextView) findViewById(R.id.lblDiemNguoi2);
        lblNV3 = (TextView) findViewById(R.id.lblDiemNguoi3);
    }

    public void ThongBaoNguoiWinVaCapNhatDiem(){
        ArrayList<Integer> MangDiemCuaNhanVat = new ArrayList<>();
        ArrayList<Integer> MangViTriMax = new ArrayList<>();
        ArrayList<SeekBar> MangSeekBar = new ArrayList<>();
        ArrayList<CheckBox> MangChekBox = new ArrayList<>();
//        for(int i = 1; i < 4; i++){
//            MangSeekBar.add(("sb"+i));
//        }
        MangSeekBar.add(sb1);
        MangSeekBar.add(sb2);
        MangSeekBar.add(sb3);

        MangChekBox.add(cb1);
        MangChekBox.add(cb2);
        MangChekBox.add(cb3);

        for(int i = 0; i < MangSeekBar.size(); i++)
            MangDiemCuaNhanVat.add(MangSeekBar.get(i).getProgress());

        int max = MangDiemCuaNhanVat.get(0);
        for(int i = 1; i < MangDiemCuaNhanVat.size(); i++){
            if(max < MangDiemCuaNhanVat.get(i))
                max = MangDiemCuaNhanVat.get(i);
        }

        for(int i = 0; i < MangDiemCuaNhanVat.size(); i++){
            if(MangDiemCuaNhanVat.get(i) == max)
                MangViTriMax.add(i);
        }

        boolean chonDung = false;
        if(MangChekBox.get(MangViTriMax.get(0)).isChecked())
            chonDung = true;

        String sThongBaoNguoiWin = "Người chơi: " + (MangViTriMax.get(0) + 1);
        for(int i = 1; i < MangViTriMax.size(); i++){
            sThongBaoNguoiWin += (", " + (MangViTriMax.get(i) + 1));
            if(MangChekBox.get(MangViTriMax.get(i)).isChecked())
                chonDung = true;
        }
        String sThongBaoCapNhatDiem = "";
        int diemThang = 27;
        int diemThua = 9;
        if(chonDung){
            lblDiemSo.setText((Integer.parseInt(lblDiemSo.getText().toString()) + diemThang) + "");
            sThongBaoCapNhatDiem = "Bạn đã chọn đúng và được cộng "+diemThang+" điểm";
        }
        else{
            sThongBaoCapNhatDiem = "Bạn đã chọn sai và bị trừ "+diemThua+" điểm";
            lblDiemSo.setText((Integer.parseInt(lblDiemSo.getText().toString()) - diemThua) + "");
        }
        Toast.makeText(MainActivity.this, sThongBaoNguoiWin + " thắng. " + sThongBaoCapNhatDiem, Toast.LENGTH_SHORT).show();
    }
}