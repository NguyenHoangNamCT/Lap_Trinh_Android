package com.example.gridviewnangcao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    GridView gvHinhAnh;
    ArrayList<HinhAnh> hinhAnhList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anh_xa();
        cacPhuongThuc();
    }

    public void anh_xa(){
        gvHinhAnh = findViewById(R.id.gridViewHinhAnh);

        hinhAnhList = new ArrayList<>();
        hinhAnhList.add(new HinhAnh("Hình 1", R.drawable.img1));
        hinhAnhList.add(new HinhAnh("Hình 2", R.drawable.img2));
        hinhAnhList.add(new HinhAnh("Hình 3", R.drawable.img3));
        hinhAnhList.add(new HinhAnh("Hình 4", R.drawable.img4));
        hinhAnhList.add(new HinhAnh("Hình 5", R.drawable.img5));
        hinhAnhList.add(new HinhAnh("Hình 6", R.drawable.img6));
        hinhAnhList.add(new HinhAnh("Hình 7", R.drawable.img7));
        hinhAnhList.add(new HinhAnh("Hình 8", R.drawable.img8));
        hinhAnhList.add(new HinhAnh("Hình 9", R.drawable.img9));
        hinhAnhList.add(new HinhAnh("Hình 10", R.drawable.img10));
        hinhAnhList.add(new HinhAnh("Hình 11", R.drawable.img11));
        hinhAnhList.add(new HinhAnh("Hình 12", R.drawable.img12));
        hinhAnhList.add(new HinhAnh("Hình 13", R.drawable.img13));
        hinhAnhList.add(new HinhAnh("Hình 14", R.drawable.img14));
        hinhAnhList.add(new HinhAnh("Hình 15", R.drawable.img15));
        hinhAnhList.add(new HinhAnh("Hình 16", R.drawable.img16));
        hinhAnhList.add(new HinhAnh("Hình 17", R.drawable.img17));
        hinhAnhList.add(new HinhAnh("Hình 18", R.drawable.img18));
        hinhAnhList.add(new HinhAnh("Hình 19", R.drawable.img19));
        hinhAnhList.add(new HinhAnh("Hình 20", R.drawable.img20));
        hinhAnhList.add(new HinhAnh("Hình 21", R.drawable.img21));
        hinhAnhList.add(new HinhAnh("Hình 22", R.drawable.img22));
        hinhAnhList.add(new HinhAnh("Hình 23", R.drawable.img23));
        hinhAnhList.add(new HinhAnh("Hình 24", R.drawable.img24));
        hinhAnhList.add(new HinhAnh("Hình 25", R.drawable.img25));

        HinhAnhAdapter hinhAnhAdapter = new HinhAnhAdapter(MainActivity.this, R.layout.dong_hinh_anh, hinhAnhList);

        gvHinhAnh.setAdapter(hinhAnhAdapter);
    }

    public void cacPhuongThuc(){
        gvHinhAnh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,"Bạn vừa click" + hinhAnhList.get(i).getTen(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}