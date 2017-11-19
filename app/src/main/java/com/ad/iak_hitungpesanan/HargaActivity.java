package com.ad.iak_hitungpesanan;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by USER on 9/27/2017.
 */

public class HargaActivity extends AppCompatActivity{
    TextView txtkuantitas, txtprice, txthasil;
    EditText edtnama;
    CheckBox cek1, cek2, cek3;
    boolean centang1, centang2, centang3= false;
    boolean kosong;
    int a,b = 0;
    int linen=3000;
    int warna=2000;
    int laminating=3000;
    String c1,c2,c3="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harga);

        txtkuantitas= (TextView) findViewById(R.id.text_quantity);
        txtprice = (TextView) findViewById(R.id.text_price);
        txthasil = (TextView) findViewById(R.id.hasil);

        edtnama = (EditText) findViewById(R.id.editnama);

        cek1 = (CheckBox) findViewById(R.id.cek1);
        cek2 = (CheckBox) findViewById(R.id.cek2);
        cek3 = (CheckBox) findViewById(R.id.cek3);

    }

    public void tombolkurang(View view) {
        a--;
        b = b - 5000;
        if (a < 0 & b < 5000) {
            Toast.makeText(this, "Quantity tidak boleh kurang dari 0", Toast.LENGTH_LONG).show();
            a = 0;
            b = 0;
            txtprice.setText("Rp " + b);
        } else {
            txtkuantitas.setText("" + a);
            linen= linen*a;
            txtprice.setText("Rp " + b);
        }
    }

    public void tomboltambah(View view) {
        a++;
        linen= linen*a;
        warna= warna*a;
        laminating= laminating*a;
        txtkuantitas.setText("" + a);
        b = b + 5000;
        txtprice.setText("Rp " + b);
    }

    public void ceksatu(View view) {
        if (cek1.isChecked()) {
            centang1 = true;
        }else{
            centang1=false;
        }
        if (cek2.isChecked()) {
            centang2 = true;
        }else{
            centang2 = false;
        }

        if (cek3.isChecked()) {
            centang3 = true;
        }else{
            centang3= false;
        }
    }

    public void ceknama(){
        if(edtnama.getText().toString().length()==0){
            kosong = false;
            edtnama.setError("Kolom ini WAJIB diisi");
        }else{
            kosong=true;
        }
    }


    public void tombol(View view) {
//        saat klik order otomatis price dan quantity nambah
//        a= a+1;
//        b*=a;
//        kuantitas.setText(""+a);
//        price.setText("Rp"+ b);
        ceknama();
        if (centang1 == true) {
            c1=" Pakai Kertas Linen";
            b += linen;
        }else{
            c1="";
        }

        if (centang2 == true) {
            c2=" Diprint Warna";
            b += warna;
        }else{
            c2="";
        }


        if (centang3 == true) {
            c3=" Laminating";
            b += laminating;
        }else{
            c3="";
        }

        txthasil.setText("Terimakasih "+edtnama.getText().toString()+"\nTambahannya :"+c1+c2+c3+
                "\nAnda memesan sebanyak "+a+"\nTotal bayar sebanyak "+b);


    }

    public void tombolsend(View view){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL,"amaliadamayanti96@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT,"Pengiriman produk kepada "+edtnama.getText().toString());
        intent.putExtra(Intent.EXTRA_TEXT, "Terimakasih "+edtnama.getText().toString()
                +"\nTambahannya :"+c1+c2+c3+"\nAnda memesan sebanyak "+a+
                "\nTotal bayar sebanyak "+b);
        if (intent.resolveActivity(getPackageManager()) !=null){
            startActivity(intent);
            Log.i("Sukses", "Yey");
        }
    }

}


//    cara IAK 2, dimana masih bisa nilainya minus
//    public void display1(int x){
//        kuantitas.setText(""+ x);
//        Log.i("coba","display1: sudah muncul");
//    }
//
//    public void display2(int y){
//        price.setText(""+y);
//    }
//
//    public void tombolkurang(View vie){
//        a=a-1;
//        display1(a);
//    }
//
//    public void tomboltambah(View view){
//        a= a+1;
//        display2(a);
//    }
//
//    public void hitungharga(){
//        b=a*5000;
//        display2(b);
//    }
//
//    public void tombol(View view){
//        hitungharga();
//    }
