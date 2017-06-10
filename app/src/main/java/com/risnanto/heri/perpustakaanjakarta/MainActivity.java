package com.risnanto.heri.perpustakaanjakarta;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String nama_perpus[] = {"Perpustakaan Nasional RI",
            "Perpustakaan Umum Daerah Provinsi DKI Jakarta",
            "Perpustakaan Freedom Institute",
            "Perpustakaan UI",
            "Perpustakaan The Japan Foundation"
    };

    int gambar_perpus[] = {R.drawable.perpus_nasional,
            R.drawable.perpus_daerah_dki,
            R.drawable.perpus_freedom_institute,
            R.drawable.perpus_ui,
            R.drawable.perpus_jf
    };

    int detail_perpus[] = {R.string.p1,
            R.string.p2,
            R.string.p3,
            R.string.p4,
            R.string.p5
    };

    int detail_perpus_opr[] = {R.string.opr1,
            R.string.opr2,
            R.string.opr3,
            R.string.opr4,
            R.string.opr5
    };

    ListView list_perpus;
    MediaPlayer suaraWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list_perpus = (ListView) findViewById(R.id.listPerpus);
        AdapterPerpus perpus = new AdapterPerpus(MainActivity.this, nama_perpus, gambar_perpus);
        list_perpus.setAdapter(perpus);
        list_perpus.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent kirimintent = new Intent(MainActivity.this, DetailActivity.class);
                kirimintent.putExtra("nP", nama_perpus[position]);
                kirimintent.putExtra("gP", gambar_perpus[position]);
                kirimintent.putExtra("dP", detail_perpus[position]);
                kirimintent.putExtra("dOP", detail_perpus_opr[position]);
                startActivity(kirimintent);
            }
        });

        suaraWelcome = MediaPlayer.create(getApplicationContext(), R.raw.welcome);

        suaraWelcome.start();
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Keluar");
        builder.setMessage("Apakah kamu yakin ingin keluar?");
        builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                moveTaskToBack(true);
                System.exit(0);
            }
        });
        builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }
}
