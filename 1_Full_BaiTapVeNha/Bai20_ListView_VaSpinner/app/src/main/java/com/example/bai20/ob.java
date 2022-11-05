package com.example.bai20;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ob {
    private String ten, phanLoai;
    private int hinh;

    public ob(String ten, int hinh, String loai) {
        this.ten = ten;
        this.hinh = hinh;
        this.phanLoai = loai;
    }

    public String getTen() {
        return ten;
    }

    public int getHinh() {
        return hinh;
    }

    public String getLoai() {
        return phanLoai;
    }
}
