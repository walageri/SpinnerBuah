package com.spinner.function;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.spinner.R;

public class MyFunction extends AppCompatActivity {
    Context context;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=MyFunction.this; }
//        akses kelas
        public void akseskelas(Class kelastujuan){
        startActivity(new Intent(context,kelastujuan));}

//        metode toast inflater
        public void costumToast(String stringPesan){
            LayoutInflater inflater=getLayoutInflater();
            // untuk menampilkan
            View v=inflater.inflate(R.layout.isipesan,null);
            TextView isipesan=v.findViewById(R.id.txtisipesan);
            isipesan.setText(stringPesan);
            Toast t=new Toast(this);
            t.setView(v);
            t.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL,0,0);
            t.show();}
            public void pesan(String ispesan){
                Toast.makeText(context, ispesan, Toast.LENGTH_LONG).show();
            }

}
