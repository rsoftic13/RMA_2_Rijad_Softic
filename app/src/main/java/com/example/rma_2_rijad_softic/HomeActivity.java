package com.example.rma_2_rijad_softic;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class HomeActivity extends BaseActivity {

    private ImageView slikaAkcijaKlime, slikaAkcijaMonitora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        slikaAkcijaKlime = findViewById(R.id.slikaAkcijaKlime);
        slikaAkcijaMonitora = findViewById(R.id.slikaAkcijaMonitora);

        slikaAkcijaKlime.setOnClickListener(v -> {
            Intent intent = new Intent(this, KlimeActivity.class);
            startActivity(intent);
        });

        slikaAkcijaMonitora.setOnClickListener(v -> {
            Intent intent = new Intent(this, MonitoriActivity.class);
            startActivity(intent);
        });

        bottomNavigationView.setSelectedItemId(R.id.nav_home);
    }
}
