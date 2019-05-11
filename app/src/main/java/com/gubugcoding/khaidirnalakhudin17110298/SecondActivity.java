package com.gubugcoding.khaidirnalakhudin17110298;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Khaidir on 11/05/2019.
 */

public class SecondActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //Mengambil data dari Intent pada MainActivity di EXTRA_MESSAGE
        Intent intent = getIntent();
        String pesan = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView textView = (TextView) findViewById(R.id.text_data);
        if (textView != null) {
            textView.setText(pesan);

        }
        //Menampilkan toast ketika tombol Tampilkan diklik
        Toast.makeText(this, "Data Berhasil Dimasukan", Toast.LENGTH_SHORT).show();
    }
}
