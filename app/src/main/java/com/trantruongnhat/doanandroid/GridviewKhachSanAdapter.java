package com.trantruongnhat.doanandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class GridviewKhachSanAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<GridviewKhachSanActivity> gridviewKhachSanActivityList;

    public GridviewKhachSanAdapter(Context context, int layout, List<GridviewKhachSanActivity> gridviewKhachSanActivityList) {
        this.context = context;
        this.layout = layout;
        this.gridviewKhachSanActivityList = gridviewKhachSanActivityList;
    }

    @Override
    public int getCount() {
        return gridviewKhachSanActivityList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    private class Viewholder{
        private ImageView imageViewKhachSan;
        private TextView txtMoTa;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Viewholder holder;
        if(view == null){
            holder = new Viewholder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(layout,null);

            holder.imageViewKhachSan = (ImageView) view.findViewById(R.id.imageKhachSan);
            holder.txtMoTa = (TextView) view.findViewById(R.id.MoTaID) ;
            view.setTag(holder);
        }else {
            holder = (Viewholder) view.getTag();
        }
        GridviewKhachSanActivity HinhKS =gridviewKhachSanActivityList.get(i);
        holder.imageViewKhachSan.setImageResource(HinhKS.getImageViewKhachSan());
        holder.txtMoTa.setText(HinhKS.getStrMoTa());
        return view;
    }
}
