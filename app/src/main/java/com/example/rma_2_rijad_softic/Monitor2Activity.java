package com.example.rma_2_rijad_softic;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Monitor2Activity extends BaseActivity {

    private String naziv = "Monitor Xiaomi Mi 1C 23.8’’ Full HD, 6ms, 60Hz";
    private String kategorija = "Monitori";
    private String cijena = "170.00";
    private int slikaResId = R.drawable.monitor2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor2);

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