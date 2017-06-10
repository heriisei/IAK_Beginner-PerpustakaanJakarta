package com.risnanto.heri.perpustakaanjakarta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    ImageView gambarDetail;
    TextView titleItem, textDetail, textDetailOpr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        gambarDetail = (ImageView) findViewById(R.id.gbr_item_detail);
        titleItem = (TextView) findViewById(R.id.title_item_detail);
        textDetail = (TextView) findViewById(R.id.text_detail);
        textDetailOpr = (TextView) findViewById(R.id.text_detail_operasional);

        Intent terimaintent = getIntent();

        gambarDetail.setImageResource(terimaintent.getIntExtra("gP", 0));
        titleItem.setText(terimaintent.getStringExtra("nP"));
        textDetail.setText(terimaintent.getIntExtra("dP", 0));
        textDetailOpr.setText(terimaintent.getIntExtra("dOP", 0));

        gambarDetail.setAdjustViewBounds(true);
        gambarDetail.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
}
