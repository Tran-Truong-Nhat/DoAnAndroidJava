package com.trantruongnhat.doanandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MenuAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<DongMenuActivity> list;

    public MenuAdapter(Context context, int layout, List<DongMenuActivity> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
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
        LayoutInflater layoutInflater =(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(layout,null);

        TextView txtTen = view.findViewById(R.id.ThuMucID);
        ImageView imgIcon = view.findViewById(R.id.SettingID);

        DongMenuActivity dongMenuActivity = list.get(i);
        txtTen.setText(dongMenuActivity.getStrTen());
        imgIcon.setImageResource(dongMenuActivity.getIntIcon());
        return view;
    }
}
