package com.example.listviewnangcao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayList<TraiCay> traiCayArrayList;
    ListView traiCayListView;
    traiCayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anh_xa();

        adapter = new traiCayAdapter(MainActivity.this, R.layout.dong_trai_cay, traiCayArrayList);
        traiCayListView.setAdapter(adapter);
    }

    public void anh_xa(){
        traiCayListView = (ListView) findViewById(R.id.lvTraiCay);
        traiCayArrayList = new ArrayList<>();

        traiCayArrayList.add(new TraiCay("Bình bát", "Bình bát sống", R.drawable.binhbat));
        traiCayArrayList.add(new TraiCay("Bơ", "Bơ đã bóc tem", R.drawable.bo));
        traiCayArrayList.add(new TraiCay("Cam" ,"Cam fake", R.drawable.cam));
        traiCayArrayList.add(new TraiCay("Hạnh", "Hạnh xịn", R.drawable.hanh));
        traiCayArrayList.add(new TraiCay("khom", "none", R.drawable.khom));
        traiCayArrayList.add(new TraiCay("Kiwi", "Kiwi mất zin", R.drawable.kiwi));
        traiCayArrayList.add(new TraiCay("Táo", "Táo fake", R.drawable.tao));
    }
}











