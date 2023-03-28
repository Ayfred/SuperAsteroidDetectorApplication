package com.example.superasterioddetector.model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.superasterioddetector.R;
import com.example.superasterioddetector.activity.Asteriod_Info;

import java.util.List;

public class CustomAdapter1 extends BaseAdapter implements View.OnClickListener{
    private final Context mContext;
    private final List<Asteroids> mItems;
    private LayoutInflater inflater;


    public CustomAdapter1(Context context, List<Asteroids> items) {
        mContext = context;
        mItems = items;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Asteroids getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public void onClick(View view) {
        Intent switchActivityIntent = new Intent(this.mContext, Asteriod_Info.class);
        switchActivityIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        switchActivityIntent.putExtra("asteroid", (Asteroids) view.getTag());
        CustomAdapter1.this.mContext.startActivity(switchActivityIntent);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.row_xml, parent, false);
        }

        Asteroids item = getItem(position);

        TextView nameTextView = convertView.findViewById(R.id.textName);
        TextView magnitudeTextView = convertView.findViewById(R.id.textMagnitude);
        TextView distanceTextView = convertView.findViewById(R.id.textDistance);

        nameTextView.setText(String.format(mContext.getString(R.string.name_asteroid), item.getName()));
        magnitudeTextView.setText(String.format(mContext.getString(R.string.magnitude), item.getMagnitude()));
        distanceTextView.setText(String.format(mContext.getString(R.string.distance), item.getDistance()));
        convertView.setTag(item);
        convertView.setOnClickListener(this);

        return convertView;
    }
}
