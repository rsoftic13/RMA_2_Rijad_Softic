package com.example.rma_2_rijad_softic;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PC1Activity extends BaseActivity {

    private String naziv = "Gaming računar AMD Ryzen 7 9800X3D, 32GB, 1TB, RTX 5070 12GB";
    private String kategorija = "Računari";
    private String cijena = "4000.00";
    private int slikaResId = R.drawable.pc1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pc1);

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