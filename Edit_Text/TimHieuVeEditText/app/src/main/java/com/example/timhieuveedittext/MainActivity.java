package com.example.timhieuveedittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnClickMe;
    EditText edtNoiDung;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ánh xạ
        btnClickMe = (Button) findViewById(R.id.btnClickMe);
        edtNoiDung =(EditText)findViewById(R.id.edtNoiDung);
    }
    public void btnLayNoiDung_Click(View v){
        String noidung =  edtNoiDung.getText().toString();
        Toast.makeText(MainActivity.this, noidung, Toast.LENGTH_LONG).show();
    }
}