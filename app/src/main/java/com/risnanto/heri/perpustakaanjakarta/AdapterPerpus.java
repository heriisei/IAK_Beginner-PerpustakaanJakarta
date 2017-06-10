package com.risnanto.heri.perpustakaanjakarta;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by heri on 16/05/17.
 */

public class AdapterPerpus extends BaseAdapter {
    String nm_perpus[];
    int gb_perpus[];

    Activity activ;

    public AdapterPerpus(MainActivity mainActivity, String[] nama_perpus, int[] gambar_perpus) {
        activ = mainActivity;
        nm_perpus = nama_perpus;
        gb_perpus = gambar_perpus;
    }


    @Override
    public int getCount() {
        return nm_perpus.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) activ.getSystemService(activ.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.custom_main_layout, null);
        ImageView gambar_item = (ImageView) convertView.findViewById(R.id.gbr_item);
        TextView title_item = (TextView) convertView.findViewById(R.id.title_item);

        title_item.setText(nm_perpus[position]);
        gambar_item.setImageResource(gb_perpus[position]);

        gambar_item.setAdjustViewBounds(true);
        gambar_item.setScaleType(ImageView.ScaleType.CENTER_CROP);

        return convertView;
    }
}
