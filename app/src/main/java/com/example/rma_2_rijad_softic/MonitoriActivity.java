package com.example.rma_2_rijad_softic;

import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MonitoriActivity extends BaseActivity {

    private RecyclerView recyclerView;
    private ArtikalAdapter adapter;
    private List<Artikal> listaArtikala;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitori);

        recyclerView = findViewById(R.id.recyclerMonitori);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listaArtikala = new ArrayList<>();

        listaArtikala.add(new Artikal("27'' WQHD Odyssey Gaming G55C 165Hz", "578 KM", "Monitori", R.drawable.monitor1, Monitor1Activity.class));
        listaArtikala.add(new Artikal("Monitor Xiaomi Mi 1C 23.8’’ Full HD, 6ms, 60Hz", "170 KM", "Monitori", R.drawable.monitor2, Monitor2Activity.class));

        adapter = new ArtikalAdapter(this, listaArtikala);
        recyclerView.setAdapter(adapter);
    }
}
