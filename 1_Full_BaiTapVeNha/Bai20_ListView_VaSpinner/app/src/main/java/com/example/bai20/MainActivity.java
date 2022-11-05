package com.example.bai20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lv;
    private ArrayList<ob> obArrayList, tempOBList;
    private OBAdapter obAdapter;
    private Spinner s;
    private ArrayList<String> phanLoaiList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anh_xa();
        obAdapter = new OBAdapter(MainActivity.this, R.layout.dongdienthoai, obArrayList);
        lv.setAdapter(obAdapter);

        s.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, phanLoaiList));

        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tempOBList = new ArrayList<>();
                for(int j = 0; j < obArrayList.size(); j++)
                    if(obArrayList.get(j).getLoai() == phanLoaiList.get(i))
                        tempOBList.add(new ob(obArrayList.get(j).getTen(), obArrayList.get(j).getHinh(), obArrayList.get(j).getLoai()));
                lv.setAdapter(new OBAdapter(MainActivity.this, R.layout.dongdienthoai, tempOBList));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void anh_xa(){
        lv = (ListView) findViewById(R.id.listView);
        s = (Spinner) findViewById(R.id.spinner);

        phanLoaiList = new ArrayList<>();
        phanLoaiList.add("Điện thoại");
        phanLoaiList.add("Tablet");

        obArrayList = new ArrayList<>();
        obArrayList.add(new ob("Iphone", R.drawable.iphone, phanLoaiList.get(0)));
        obArrayList.add(new ob("Nokia", R.drawable.nokia,phanLoaiList.get(0)));
        obArrayList.add(new ob("Samsung", R.drawable.samsung,phanLoaiList.get(0)));
        obArrayList.add(new ob("Sony", R.drawable.sony,phanLoaiList.get(0)));
        obArrayList.add(new ob("Vsmart", R.drawable.vsmart,phanLoaiList.get(0)));

        obArrayList.add(new ob("TL1", R.drawable.tl1,phanLoaiList.get(1)));
        obArrayList.add(new ob("TL2", R.drawable.tl2,phanLoaiList.get(1)));
        obArrayList.add(new ob("TL3", R.drawable.tl3,phanLoaiList.get(1)));
        obArrayList.add(new ob("TL4", R.drawable.tl4,phanLoaiList.get(1)));
    }
}