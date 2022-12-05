package com.example.apptoancau;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtHoTen, edtEmail, edtSoDienThoai;
    TextView tvThongTin;
    Button btnXacNhan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anh_xa();
        cacPhuongThuc();
    }
    public void cacPhuongThuc(){
        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten = edtHoTen.getText().toString() + '\n',
                email = edtEmail.getText().toString() + '\n',
                sdt = edtSoDienThoai.getText().toString();

                tvThongTin.setText("Chào bạn: " + ten + "Email: " + email + "SĐT: " + sdt);
            }
        });
    }
    public void anh_xa(){
        edtHoTen = findViewById(R.id.edtHoTen);
        edtEmail = findViewById(R.id.edtEmail);
        edtSoDienThoai = findViewById(R.id.edtSDT);
        tvThongTin = findViewById(R.id.tvThongTin);
        btnXacNhan = findViewById(R.id.btnXacNhan);
    }
}