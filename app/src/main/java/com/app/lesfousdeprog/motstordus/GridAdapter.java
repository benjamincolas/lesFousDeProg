package com.app.lesfousdeprog.motstordus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import java.util.ArrayList;

public class GridAdapter extends BaseAdapter {

    private ArrayList<Integer> images;
    private Context context;
    private LayoutInflater inflater;

    GridAdapter(Context context, ArrayList<Integer> images){
        this.context=context;
        this.images=images;
    }


    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public Object getItem(int position) {
        return images.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View gridView = convertView;

        if(convertView == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            gridView = inflater.inflate(R.layout.custom_layout,null);
        }

        ImageView image = (ImageView) gridView.findViewById(R.id.customImageView);
        if(getCount() ==8){
            image.getLayoutParams().width = 450;
            image.getLayoutParams().height = 450;
            image.requestLayout();
        }
        else if(getCount() == 12){
            image.getLayoutParams().width = 325;
            image.getLayoutParams().height = 325;
            image.requestLayout();
        }

        gridView.setBackgroundResource(R.mipmap.pow);

        return gridView;
    }
}
