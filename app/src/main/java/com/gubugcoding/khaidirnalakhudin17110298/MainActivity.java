package com.gubugcoding.khaidirnalakhudin17110298;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by Khaidir on 11/05/2019.
 */

public class MainActivity extends AppCompatActivity {
    private RadioGroup radGrup;
    private RadioButton Pria, Wanita;
    private CheckBox Indonesia, Inggris, Arab, Mandarin, Sunda, Jawa;
    private Spinner spnNegara;
    private Button btnTampil,btnHapus;
    private EditText nama;

    //Membuat EXTRA_MESSAGE untuk menampilkan di SecondActivity
    //Sesuaikan "com.gubugcoding.khaidirnalakhudin17110298" dengan package name kalian
    public static final String EXTRA_MESSAGE = "com.gubugcoding.khaidirnalakhudin17110298.extra.MESSAGE";
    public static final int TEXT_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //mendeklarasikan EditText
        nama = (EditText) findViewById(R.id.isinama);

        //mendeklarasikan RadioButton
        Pria = (RadioButton) findViewById(R.id.radioButton1);
        Wanita = (RadioButton) findViewById(R.id.radioButton2);

        //mendeklarasikan Spiner
        spnNegara = (Spinner) findViewById(R.id.negara);

        //mendeklarasikan RadioGrup
        radGrup = (RadioGroup) findViewById(R.id.grupradio);

        //mendeklarasikan CheckBox
        Indonesia = (CheckBox) findViewById(R.id.chkindonesia);
        Inggris = (CheckBox) findViewById(R.id.chkinggris);
        Arab = (CheckBox) findViewById(R.id.chkarab);
        Mandarin = (CheckBox) findViewById(R.id.chkmandarin);
        Sunda = (CheckBox) findViewById(R.id.chksunda);
        Jawa = (CheckBox) findViewById(R.id.chkjawa);

        //mendeklarasikan Button
        btnTampil = (Button) findViewById(R.id.btntampilkan);
        btnHapus = (Button) findViewById(R.id.btnreset);

    }

    //Jika tombol tampilkan ditekan / klik
    public void tampilData(View view) {
        //Membuat intent baru
        Intent intent = new Intent(this, SecondActivity.class);

        //Untuk mendapatkan value dari inputan editText dan menampilkannya ke string
        String inputnama = String.valueOf(nama.getText().toString());

        //Untuk mendapatkan value dari radioButton yang dipilih dan menampilkannya ke string
        int gender = radGrup.getCheckedRadioButtonId();
        RadioButton jk = (RadioButton) findViewById(gender);
        String inputjk = String.valueOf(jk.getText().toString());

        //Untuk mendapatkan value dari Spiner yang dipilih dan menampilkannya ke string
        Spinner neg = (Spinner) findViewById(R.id.negara);
        String inputneg = String.valueOf(spnNegara.getSelectedItem().toString());

        //Untuk mendapatkan value dari CheckBox yang dipilih dan menampilkannya ke string
        String inputbahasa = "";
        if (Indonesia.isChecked())
            inputbahasa+="-\tIndonesia\n";
        if (Inggris.isChecked())
            inputbahasa+="-\tInggris\n";
        if (Arab.isChecked())
            inputbahasa+="-\tArab\n";
        if (Mandarin.isChecked())
            inputbahasa+="-\tMandarin\n";
        if (Sunda.isChecked())
            inputbahasa+="-\tSunda\n";
        if (Jawa.isChecked())
            inputbahasa+="-\tJawa\n";


        //Menambahkan data dari masing-masing value ke EXTRA_MESSAGE
        intent.putExtra(EXTRA_MESSAGE, "Nama\t\t\t\t\t\t\t\t : " + inputnama + "\n" +
                "Jenis Kelamin \t: " + inputjk + "\n" +
                "Negara Asal\t\t\t : " + inputneg + "\n" +
                "Kemampuan Bahasa : " + "\n" + inputbahasa + "\n");
        startActivityForResult(intent, TEXT_REQUEST);

    }
    //Fungsi membersihkan value/inputan dengan menggunakan switch case
    public void hapusData(View view) {
         switch (view.getId()){
             case R.id.btnreset:
                 //membersihkan value EditText
                 nama.setText("");
                 //membersihkan value spinner
                 spnNegara.getSelectedItem();
                 //membersihkan value RadioGroup
                 radGrup.clearCheck();
                 if (Indonesia.isChecked()){
                     Indonesia.setChecked(false);
                 }
                 if (Inggris.isChecked()){
                     Inggris.setChecked(false);
                 }
                 if (Arab.isChecked()){
                     Arab.setChecked(false);
                 }
                 if (Mandarin.isChecked()){
                     Mandarin.setChecked(false);
                 }
                 if (Sunda.isChecked()){
                     Sunda.setChecked(false);
                 }
                 if (Jawa.isChecked()){
                     Jawa.setChecked(false);
                 }
                 //Menampilkan Toast ketika menekan tombol Kosongkan
                 Toast.makeText(this, "Data Dikosongkan", Toast.LENGTH_SHORT).show();
        }
    }
}
