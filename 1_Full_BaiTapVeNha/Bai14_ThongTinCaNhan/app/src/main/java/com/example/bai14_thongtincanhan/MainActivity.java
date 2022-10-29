package com.example.bai14_thongtincanhan;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText HoTen, cmnd, ThongTinBoXung;
    RadioButton TrungCap, CaoDang, DaiHoc;
    CheckBox DocBao, DocSach, DocCode;
    Button goithongtin;
    public void anhxa(){
        HoTen = (EditText) findViewById(R.id.hoten);
        cmnd = (EditText) findViewById(R.id.cmnd);
        ThongTinBoXung = (EditText) findViewById(R.id.thongtinbosung);
        TrungCap = (RadioButton) findViewById(R.id.trungcap);
        CaoDang = (RadioButton) findViewById(R.id.caodang);
        DaiHoc  = (RadioButton) findViewById(R.id.daihoc);
        DocBao = (CheckBox) findViewById(R.id.docbao);
        DocSach = (CheckBox) findViewById(R.id.docsach);
        DocCode = (CheckBox) findViewById(R.id.doccode);
        goithongtin = (Button) findViewById(R.id.goithongtin);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();

    }

    public void btnGuiThongTin(View v){
        if(HoTen.getText().toString().trim() == "" || HoTen.getText().toString().trim().length() < 3)
        {
            Toast.makeText(MainActivity.this, "Họ tên không được bỏ trống và phải trên 3 ký tự", Toast.LENGTH_SHORT).show();
            return;
        }
        if(cmnd.getText().toString().trim().length() != 9)
        {
            Toast.makeText(MainActivity.this, "Chứng minh nhân dân chỉ có 9 ký tự, vui lòng nhập lại", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!DocBao.isChecked() && !DocSach.isChecked() && !DocCode.isChecked()){
            Toast.makeText(MainActivity.this, "Bạn phải chọn một sở thích", Toast.LENGTH_SHORT).show();
            return;
        }
        if(ThongTinBoXung.getText().toString().trim() == ""){
            Toast.makeText(MainActivity.this, "THông tin bổ xung không được bỏ trống", Toast.LENGTH_SHORT).show();
            return;
        }
        String BangCap="", SoThich = "";
        if(TrungCap.isChecked())
            BangCap = TrungCap.getText().toString();
        else if(CaoDang.isChecked())
            BangCap = CaoDang.getText().toString();
        else if(DaiHoc.isChecked())
            BangCap = DaiHoc.getText().toString();
        int count = 0;
        if(DocBao.isChecked()){
            count++;
            SoThich = "Doc Bao";
        }
        if(DocSach.isChecked()) {
            if(count < 1)
                SoThich += "Doc Sach";
            else
                SoThich += ", Doc sach";
            count++;
        }
        if(DocCode.isChecked()) {
            if(count < 1)
                SoThich += "Doc code";
            else
                SoThich += ", Doc code";
        }

        messagebox(HoTen.getText().toString() + "\n" + cmnd.getText().toString() + "\n" + BangCap + "\n" + SoThich + "\n" + ThongTinBoXung.getText().toString());
    }
    private void messagebox( String name) {
        AlertDialog.Builder mess = new AlertDialog.Builder(this);
        mess.setTitle("Thông tin cá nhân");
        mess.setIcon(R.mipmap.ic_launcher);
        mess.setMessage(name);
        mess.setPositiveButton("Đóng", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        mess.show();
    }
}