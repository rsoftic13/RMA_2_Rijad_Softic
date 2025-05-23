package com.example.rma_2_rijad_softic;

import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class PeriferijaActivity extends BaseActivity {

    private RecyclerView recyclerView;
    private ArtikalAdapter adapter;
    private List<Artikal> listaArtikala;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_periferija);

        recyclerView = findViewById(R.id.recyclerPeriferija);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listaArtikala = new ArrayList<>();

        listaArtikala.add(new Artikal("Trust GXT 929 Helox ultralagani wireless gaming miš,4800 dpi, bijeli", "31 KM", "Periferija", R.drawable.periferija1, Periferija1Activity.class));
        listaArtikala.add(new Artikal("Miš Razer Basilisk V3 Pro - Ergonomic Wireless Gaming Mouse", "319 KM", "Periferija", R.drawable.periferija2, Periferija2Activity.class));

        adapter = new ArtikalAdapter(this, listaArtikala);
        recyclerView.setAdapter(adapter);
    }
}
