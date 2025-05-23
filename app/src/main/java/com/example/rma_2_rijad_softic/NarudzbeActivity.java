package com.example.rma_2_rijad_softic;

import android.os.Bundle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class NarudzbeActivity extends BaseActivity {

    private NarudzbaViewModel narudzbaViewModel;
    private RecyclerView recyclerView;
    private NarudzbaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_narudzbe);

        setTitle("Narudžbe");

        recyclerView = findViewById(R.id.recyclerViewNarudzbe);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new NarudzbaAdapter();
        recyclerView.setAdapter(adapter);

        narudzbaViewModel = new ViewModelProvider(
                this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())
        ).get(NarudzbaViewModel.class);

        narudzbaViewModel.getSveNarudzbe().observe(this, new Observer<List<NarudzbaEntity>>() {
            @Override
            public void onChanged(List<NarudzbaEntity> narudzbe) {
                adapter.setNarudzbe(narudzbe);
            }
        });
    }
}

