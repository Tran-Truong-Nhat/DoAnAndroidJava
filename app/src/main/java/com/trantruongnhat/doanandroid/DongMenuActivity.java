package com.trantruongnhat.doanandroid;

public class DongMenuActivity {
    private String strTen;
    private int intIcon;


    public DongMenuActivity(String strTen, int intIcon) {
        this.strTen = strTen;
        this.intIcon = intIcon;
    }

    public String getStrTen() {
        return strTen;
    }

    public void setStrTen(String strTen) {
        this.strTen = strTen;
    }

    public int getIntIcon() {
        return intIcon;
    }

    public void setIntIcon(int intIcon) {
        this.intIcon = intIcon;
    }
}
