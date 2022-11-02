package com.example.listviewnangcao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class traiCayAdapter extends BaseAdapter {
    private Context context; //là màn hình hiển thị
    private int layout; //dạng layout muốn hiển thị
    private List<TraiCay> traiCayList;

    public traiCayAdapter(Context context, int layout, List<TraiCay> traiCayList) {
        this.context = context;
        this.layout = layout;
        this.traiCayList = traiCayList;
    }

    @Override
    public int getCount() //trả về số dòng để nó hiển thị cho list view
    {
        //return 0;
        return traiCayList.size();
    }

    @Override
    public Object getItem(int i)
    {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) //trả về mỗi trên cái item của mình
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        view = inflater.inflate(layout, null);

        //ánh xạ
        TextView txtTen = (TextView) view.findViewById(R.id.textViewTen);
        TextView txtMoTa = (TextView) view.findViewById(R.id.textViewMoTa);
        ImageView imgHinh = (ImageView) view.findViewById(R.id.imageViewHinhAnh);

        TraiCay traiCay = traiCayList.get(i);

        txtTen.setText(traiCay.getTen());
        txtMoTa.setText(traiCay.getMoTa());
        imgHinh.setImageResource(traiCay.getHinh());
        return view;
    }
}
