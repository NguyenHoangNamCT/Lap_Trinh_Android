package com.example.listviewnangcao;

public class TraiCay {
    private String ten, moTa;
    private int hinh;

    public TraiCay(String ten, String moTa, int hinh) {
        this.ten = ten;
        this.moTa = moTa;
        this.hinh = hinh;
    }

    public String getTen() {
        return ten;
    }

    public String getMoTa() {
        return moTa;
    }

    public int getHinh() {
        return hinh;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }
}
