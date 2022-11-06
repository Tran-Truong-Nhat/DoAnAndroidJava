package com.trantruongnhat.doanandroid;

import android.widget.ImageView;

public class GridviewKhachSanActivity {
    private int imageViewKhachSan;
    private String strMoTa;

    public GridviewKhachSanActivity(int imageViewKhachSan, String strMoTa) {
        this.imageViewKhachSan = imageViewKhachSan;
        this.strMoTa = strMoTa;
    }

    public int getImageViewKhachSan() {
        return imageViewKhachSan;
    }

    public void setImageViewKhachSan(int imageViewKhachSan) {
        this.imageViewKhachSan = imageViewKhachSan;
    }

    public String getStrMoTa() {
        return strMoTa;
    }

    public void setStrMoTa(String strMoTa) {
        this.strMoTa = strMoTa;
    }
}
