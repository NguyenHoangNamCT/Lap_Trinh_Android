package com.example.ungdungdemngayxaem;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText edtNgayBD, edtNgayGap;
    Button btnTinh;
    Calendar calendarOne, calendarTwo;
    SimpleDateFormat simpleDateFormat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        edtNgayBD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chonNgayBatDauXa();
            }
        });

        edtNgayGap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chonNgayGap();
            }
        });

        btnTinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int soNgay = (int) ((calendarTwo.getTimeInMillis() - calendarOne.getTimeInMillis()) / (1000*60*60*24));
                if(soNgay < 0)
                    Toast.makeText(MainActivity.this, "Vui lòng chọn ngày gặp sau ngày bắt đầu xa", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Xa em " + soNgay + " ngày", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void chonNgayBatDauXa(){
        calendarOne = Calendar.getInstance();
        int ngay = calendarOne.get(calendarOne.DATE),
        thang = calendarOne.get(calendarOne.MONTH),
        nam = calendarOne.get(calendarOne.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        calendarOne.set(i, i1, i2);
                        edtNgayBD.setText(simpleDateFormat.format(calendarOne.getTime()));
                    }
                }, nam, thang,ngay);
        datePickerDialog.show();
    }
    public void chonNgayGap(){
        calendarTwo = Calendar.getInstance();
        int ngay = calendarTwo.get(Calendar.DATE),
        thang = calendarTwo.get(Calendar.MONTH),
        nam = calendarTwo.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                calendarTwo.set(i, i1, i2);
                edtNgayGap.setText(simpleDateFormat.format(calendarTwo.getTime()));
            }
        }, nam, thang, ngay);
        datePickerDialog.show();
    }
    public void anhXa(){
        edtNgayBD = findViewById(R.id.edtNgayBatDau);
        edtNgayGap = findViewById(R.id.edtNgayGapMat);
        btnTinh = findViewById(R.id.btnTinh);
    }
}