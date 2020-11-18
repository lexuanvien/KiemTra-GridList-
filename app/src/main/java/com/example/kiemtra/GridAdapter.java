package com.example.kiemtra;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class GridAdapter extends ArrayAdapter {
    Activity activity;
    int item_layout;
    ArrayList<LS> lsArrayList;

    public GridAdapter(@NonNull Activity activity, int row_layout, @NonNull ArrayList<LS> lsArrayList) {
        super(activity, row_layout, lsArrayList);
        this.activity=activity;
        this.item_layout=row_layout;
        this.lsArrayList=lsArrayList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=activity.getLayoutInflater();
        convertView=layoutInflater.inflate(item_layout,null);
        ImageView avata=(ImageView) convertView.findViewById(R.id.imageview);
        TextView title=(TextView) convertView.findViewById(R.id.TextView1);
        TextView description=(TextView) convertView.findViewById(R.id.TextView2);

        avata.setImageResource(lsArrayList.get(position).getImage());
        title.setText(lsArrayList.get(position).getTitle());
        return convertView;
    }
    public  void removeItem(List<LS> items){
        for(LS item: items ){
            lsArrayList.remove(item);
        }
        notifyDataSetChanged();
    }
}
