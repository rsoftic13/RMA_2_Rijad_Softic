package com.example.rma_2_rijad_softic;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends BaseActivity {

    private Spinner spinnerKategorija;
    private EditText editMinCijena, editMaxCijena, editNaziv;
    private Button btnTrazi;
    private RecyclerView recyclerView;

    private List<Artikal> sviArtikli;
    private List<Artikal> filtriraniArtikli;
    private ArtikalAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        spinnerKategorija = findViewById(R.id.spinnerKategorija);
        editMinCijena = findViewById(R.id.editMinCijena);
        editMaxCijena = findViewById(R.id.editMaxCijena);
        editNaziv = findViewById(R.id.editNaziv);
        btnTrazi = findViewById(R.id.btnTrazi);
        recyclerView = findViewById(R.id.recyclerViewSearch);

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,
                new String[]{"Sve kategorije", "Računari", "Periferija", "Monitori", "Klime"});
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerKategorija.setAdapter(spinnerAdapter);

        sviArtikli = getSviArtikli();

        filtriraniArtikli = new ArrayList<>(sviArtikli);
        adapter = new ArtikalAdapter(this, filtriraniArtikli);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        btnTrazi.setOnClickListener(v -> filtrirajArtikle());
    }

    private void filtrirajArtikle() {
        String trazeniNaziv = editNaziv.getText().toString().trim().toLowerCase();
        String odabranaKategorija = spinnerKategorija.getSelectedItem().toString();
        String minCijenaStr = editMinCijena.getText().toString().trim();
        String maxCijenaStr = editMaxCijena.getText().toString().trim();

        double minCijena = Double.MIN_VALUE;
        double maxCijena = Double.MAX_VALUE;

        if (!TextUtils.isEmpty(minCijenaStr)) {
            try {
                minCijena = Double.parseDouble(minCijenaStr);
            } catch (NumberFormatException ignored) {}
        }

        if (!TextUtils.isEmpty(maxCijenaStr)) {
            try {
                maxCijena = Double.parseDouble(maxCijenaStr);
            } catch (NumberFormatException ignored) {}
        }

        filtriraniArtikli.clear();
        for (Artikal a : sviArtikli) {
            String nazivLower = a.getNaziv().toLowerCase();
            double cijena = Double.parseDouble(a.getCijena());

            boolean nazivOk = nazivLower.contains(trazeniNaziv);
            boolean kategorijaOk = odabranaKategorija.equals("Sve kategorije") || a.getKategorija().equals(odabranaKategorija);
            boolean cijenaOk = (cijena >= minCijena) && (cijena <= maxCijena);

            if (nazivOk && kategorijaOk && cijenaOk) {
                filtriraniArtikli.add(a);
            }
        }

        adapter.notifyDataSetChanged();
    }

    private List<Artikal> getSviArtikli() {
        List<Artikal> lista = new ArrayList<>();

        lista.add(new Artikal("Gaming računar AMD Ryzen 7 9800X3D, 32GB, 1TB, RTX 5070 12GB", "4000.00", "Računari", R.drawable.pc1, PC1Activity.class));
        lista.add(new Artikal("Gaming računar Ryzen 7 5700X3D, 16GB, 1TB, RTX 3060 12GB", "1915.00", "Računari", R.drawable.pc2, PC2Activity.class));

        lista.add(new Artikal("Trust GXT 929 Helox ultralagani wireless gaming miš,4800 dpi, bijeli", "31.00", "Periferija", R.drawable.periferija1, Periferija1Activity.class));
        lista.add(new Artikal("Miš Razer Basilisk V3 Pro - Ergonomic Wireless Gaming Mouse", "319.00", "Periferija", R.drawable.periferija2, Periferija2Activity.class));

        lista.add(new Artikal("27'' WQHD Odyssey Gaming G55C 165Hz", "578.00", "Monitori", R.drawable.monitor1, Monitor1Activity.class));
        lista.add(new Artikal("Monitor Xiaomi Mi 1C 23.8’’ Full HD, 6ms, 60Hz", "170.00", "Monitori", R.drawable.monitor2, Monitor2Activity.class));

        lista.add(new Artikal("Klima uređaj TCL TAC-12CHSD/UG11V3AH inverter", "887.00", "Klime", R.drawable.klima1, Klima1Activity.class));
        lista.add(new Artikal("Klima uređaj Tesla TM53EP11-1832IHWT inverter", "1399.00", "Klime", R.drawable.klima2, Klima2Activity.class));

        return lista;
    }
}
