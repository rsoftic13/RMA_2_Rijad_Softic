package com.example.rma_2_rijad_softic;

import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class RacunariActivity extends BaseActivity {

    private RecyclerView recyclerView;
    private ArtikalAdapter adapter;
    private List<Artikal> listaArtikala;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_racunari);

        recyclerView = findViewById(R.id.recyclerRacunari);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listaArtikala = new ArrayList<>();

        listaArtikala.add(new Artikal("Gaming računar AMD Ryzen 7 9800X3D, 32GB, 1TB, RTX 5070 12GB", "4000 KM", "Računari", R.drawable.pc1, PC1Activity.class));
        listaArtikala.add(new Artikal("Gaming računar Ryzen 7 5700X3D, 16GB, 1TB, RTX 3060 12GB", "1915 KM", "Računari", R.drawable.pc2, PC2Activity.class));

        adapter = new ArtikalAdapter(this, listaArtikala);
        recyclerView.setAdapter(adapter);
    }
}
