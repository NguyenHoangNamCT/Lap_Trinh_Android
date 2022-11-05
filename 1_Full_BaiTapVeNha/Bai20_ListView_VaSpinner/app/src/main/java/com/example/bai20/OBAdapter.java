package com.example.bai20;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class OBAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<ob> obList;

    public OBAdapter(Context context, int layout, List<ob> obList) {
        this.context = context;
        this.layout = layout;
        this.obList = obList;
    }

    @Override
    public int getCount() {
        return obList.size();
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
        TextView txtTen = (TextView) view.findViewById(R.id.textViewdt);
        ImageView img = (ImageView) view.findViewById(R.id.imageViewdt);
        ob object = obList.get(i);
        txtTen.setText(object.getTen());
        img.setImageResource(object.getHinh());
        return view;
    }
}
