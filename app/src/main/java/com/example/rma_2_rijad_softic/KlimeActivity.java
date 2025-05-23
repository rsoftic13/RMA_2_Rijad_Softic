package com.example.rma_2_rijad_softic;

import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class KlimeActivity extends BaseActivity {

    private RecyclerView recyclerView;
    private ArtikalAdapter adapter;
    private List<Artikal> listaArtikala;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_klime);

        recyclerView = findViewById(R.id.recyclerKlime);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listaArtikala = new ArrayList<>();

        listaArtikala.add(new Artikal("Klima uređaj TCL TAC-12CHSD/UG11V3AH inverter", "887 KM", "Klime", R.drawable.klima1, Klima1Activity.class));
        listaArtikala.add(new Artikal("Klima uređaj Tesla TM53EP11-1832IHWT inverter", "1399 KM", "Klime", R.drawable.klima2, Klima2Activity.class));

        adapter = new ArtikalAdapter(this, listaArtikala);
        recyclerView.setAdapter(adapter);
    }
}
