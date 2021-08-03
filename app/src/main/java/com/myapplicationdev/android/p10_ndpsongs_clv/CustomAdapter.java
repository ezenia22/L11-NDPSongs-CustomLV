    package com.myapplicationdev.android.p10_ndpsongs_clv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Song> singerList;

    public CustomAdapter(Context context, int resource,   ArrayList<Song> objects) {
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        singerList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id, parent, false);
        TextView tvTitle = rowView.findViewById(R.id.title);
        TextView tvYear = rowView.findViewById(R.id.year);
        RatingBar rate = rowView.findViewById(R.id.ratingBar);
        ImageView ivImage = rowView.findViewById(R.id.imageView);
        TextView tvSinger = rowView.findViewById(R.id.singer);

        Song currentVersion = singerList.get(position);

        tvTitle.setText(currentVersion.getTitle());
        tvYear.setText(String.valueOf(currentVersion.getYearReleased()));
        rate.setRating(currentVersion.getStars());
        tvSinger.setText(currentVersion.getSingers());

        if (currentVersion.getYearReleased() >= 2019) {
            ivImage.setImageResource(R.drawable.newimg);
        } else if (currentVersion.getYearReleased() < 2019) {
            ivImage.setVisibility(View.INVISIBLE);
        }
        return rowView;
    }
}
