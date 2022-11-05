package com.example.listviewnangcao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class traiCayAdapter extends BaseAdapter{
    private Context context;
    private int layout;
    private List<TraiCay> traiCayList;

    public traiCayAdapter(Context context, int layout, List<TraiCay> traiCayList) {
        this.context = context;
        this.layout = layout;
        this.traiCayList = traiCayList;
    }

    @Override
    public int getCount() {
        return traiCayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        view = layoutInflater.inflate(layout, null);

        //ánh xạ
        TextView txtTen = (TextView) view.findViewById(R.id.textViewTen), txtMoTa =(TextView) view.findViewById(R.id.textViewMoTa);
        ImageView imgHinhTraiCay =(ImageView) view.findViewById(R.id.imageViewHinhAnh);

        TraiCay traiCay = traiCayList.get(i);

        txtTen.setText(traiCay.getTen());
        txtMoTa.setText(traiCay.getMoTa());
        imgHinhTraiCay.setImageResource(traiCay.getHinh());

        return view;
    }
}
