package com.spinner;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.spinner.function.MyFunction;

import java.io.IOException;

public class SpinnerActivity extends MyFunction {
    //array data atau pengelompokan data yang akan di panggil
    String nama_buah[]={"alpukat","apel","ceri","durian","jambu air","manggis","strawberry"};
    int gambar_buah[]={R.drawable.alpukat, R.drawable.apel, R.drawable.ceri,
            R.drawable.durian, R.drawable.jambuair, R.drawable.manggis, R.drawable.strawberry,};
    int suara_buah[]={R.raw.alpukat, R.raw.apel, R.raw.ceri, R.raw.durian,
            R.raw.jambuair, R.raw.manggis, R.raw.strawberry,};
    //variable object
    Spinner spinbuah;
    ImageView imgbuah;
    TextView txtbuah;
//    posisi
    int gambar_terpilih;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        //inisialisasi
        spinbuah=findViewById(R.id.spnbuah);
        imgbuah=findViewById(R.id.imgbuah);
        txtbuah=findViewById(R.id.txbuah);
        //bikin adapter untuk memanggil data berurutan
        ArrayAdapter adapterspin=new ArrayAdapter(getApplicationContext(),
                android.R.layout.simple_spinner_item,nama_buah);
        adapterspin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //adapter di set kepada spin object
        spinbuah.setAdapter(adapterspin);
        //apa yang terjadi saat spiner di klik
        spinbuah.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                gambar_terpilih=position;
                txtbuah.setText(nama_buah[position]);
                imgbuah.setImageResource(gambar_buah[position]);
                pesan("Silahkan pilih dahulu"+nama_buah[position]);
                playaudio();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){}
        });
    }
    public void playaudio(){
        MediaPlayer mp=new MediaPlayer();
        Uri lokasi=Uri.parse("android.resource://"+getPackageName()+"/"+suara_buah[gambar_terpilih]);
        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mp.setDataSource(getApplicationContext(),lokasi);
            mp.prepare();
            mp.start();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void audioimg(View view) {
        playaudio();
    }
}
