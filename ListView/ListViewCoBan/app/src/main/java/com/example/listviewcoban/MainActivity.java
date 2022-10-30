package com.example.listviewcoban;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lvMonHoc;
    ArrayList<String> arrMonHoc;

    public void anh_xa(){
        lvMonHoc = (ListView) findViewById(R.id.listView_MonHoc);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anh_xa();
        arrMonHoc = new ArrayList<>();
        arrMonHoc.add("Android");
        arrMonHoc.add("PHP");
        arrMonHoc.add("ios");
        arrMonHoc.add("Unity");
        arrMonHoc.add("Asb.net");
        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, arrMonHoc);
        lvMonHoc.setAdapter(arrayAdapter);
    }
}