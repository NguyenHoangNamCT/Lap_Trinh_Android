package com.example.customdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvDangNhap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        tvDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            dialogDangNhap();
            }
        });
    }
    public void anhXa(){
        tvDangNhap = findViewById(R.id.tvDangNhap);
    }
    public void dialogDangNhap(){
        Dialog dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_custom);

        //ánh xạ
        EditText edtUserName = dialog.findViewById(R.id.edtUsername),
                edtPassword = dialog.findViewById(R.id.edtPassword);
        Button btnDangNhap = dialog.findViewById(R.id.btnDangNhap),
                btnHuy = dialog.findViewById(R.id.btnHuy);

        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = edtUserName.getText().toString().trim();
                String pass = edtPassword.getText().toString().trim();
                if(user.equals("nam") && pass.equals("123"))
                    Toast.makeText(MainActivity.this, "Đăng nhập thành công. Tiệt dời", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Bấm sai cái gì rồi", Toast.LENGTH_SHORT).show();
            }
        });

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                dialog.cancel();//c1 ẩn dialog
                dialog.dismiss();//c2 ẩn dialog
            }
        });
        dialog.show();
    }
}