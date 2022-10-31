package com.example.listviewcoban;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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

        ListOfEvens();
    }
    //----------------------------------------------- Phương thức -----------------------------------------------
    public void ShowAlertDialog(String title, String Message){
        // Create the object of AlertDialog Builder class
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        // Set Alert Title
        builder.setTitle(title);

        // Set the message show for the Alert time
        builder.setMessage(Message);

        // Set Cance lable false for when the user clicks on the outside the Dialog Box then it will remain show
        builder.setCancelable(false);

        // Set the positive button with yes name Lambda OnClickListener method is use of DialogInterface interface.
//        builder.setPositiveButton("Yes", (DialogInterface.OnClickListener) (dialog, which) -> {
//            // When the user click yes button then app will close
//            finish();
//        });

        // Set the Negative button with No name Lambda OnClickListener method is use of DialogInterface interface.
        builder.setNegativeButton("Ok", (DialogInterface.OnClickListener) (dialog, which) -> {
            // If user click no then dialog box is canceled.
            dialog.cancel();
        });

        // Create the Alert dialog
        AlertDialog alertDialog = builder.create();
        // Show the Alert Dialog box
        alertDialog.show();
    }
    //----------------------------------------------- Sự kiện -----------------------------------------------
    public void ListOfEvens(){
        lvMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //i trả về vị trí người dùng click lên list view bắt đầu từ 0
                Toast.makeText(MainActivity.this, "Chỉ số bạn click trên list view là: " + i, Toast.LENGTH_SHORT).show();
                ShowAlertDialog("Click", arrMonHoc.get(i));
            }
        });

        lvMonHoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                ShowAlertDialog("Long click", "Chỉ số long click là: " + i);
                return false;
            }
        });
    }
}