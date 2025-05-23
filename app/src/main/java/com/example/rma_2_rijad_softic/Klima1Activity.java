package com.example.rma_2_rijad_softic;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Klima1Activity extends BaseActivity {

    private String naziv = "Klima uređaj TCL TAC-12CHSD/UG11V3AH inverter";
    private String kategorija = "Klime";
    private String cijena = "887.00";
    private int slikaResId = R.drawable.klima1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_klima1);

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