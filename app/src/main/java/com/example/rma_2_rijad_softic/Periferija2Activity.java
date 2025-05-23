package com.example.rma_2_rijad_softic;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Periferija2Activity extends BaseActivity {

    private String naziv = "Miš Razer Basilisk V3 Pro - Ergonomic Wireless Gaming Mouse";
    private String kategorija = "Periferija";
    private String cijena = "319.00";
    private int slikaResId = R.drawable.periferija2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_periferija2);

        TextView naslov = findViewById(R.id.naslovArtikla);
        ImageView slika = findViewById(R.id.slikaArtikla);
        TextView kategorijaTxt = findViewById(R.id.kategorijaText);
        TextView cijenaTxt = findViewById(R.id.cijenaText);
        Button kupiBtn = findViewById(R.id.kupiBtn);

        naslov.setText(naziv);
        slika.setImageResource(slikaResId);
        kategorijaTxt.setText(kategorija);
        cijenaTxt.setText(cijena + " KM");

        kupiBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, KupovinaActivity.class);
            intent.putExtra("naziv", naziv);
            intent.putExtra("kategorija", kategorija);
            intent.putExtra("cijena", cijena);
            startActivity(intent);
        });
    }
}