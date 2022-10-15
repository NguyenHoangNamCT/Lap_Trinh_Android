package com.example.chuyendoidocsangdof;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText DoF, DoC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DoF = (EditText)findViewById(R.id.txtDoF);
        DoC = (EditText) findViewById(R.id.txtDoC);
    }

    public void btnChuyenSangDoC_Click(View v)
    {
        double doF = Double.parseDouble(DoF.getText().toString());
        DoC.setText(String.format("%.2f", (doF - 32) * 5/9));
    }

    public void btnChuyenSangDoF_Click(View v)
    {
        double doC = Double.parseDouble(DoC.getText().toString());
        DoF.setText(String.format("%.2f", doC * 9/5 + 32));
    }
}