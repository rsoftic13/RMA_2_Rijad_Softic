package com.example.rma_2_rijad_softic;

import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.widget.ImageView;

public class InfoActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        ImageView facebookIcon = findViewById(R.id.facebookIcon);
        ImageView instagramIcon = findViewById(R.id.instagramIcon);

        facebookIcon.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/procomp.ba"));
            startActivity(browserIntent);
        });

        instagramIcon.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/procomp.ba/"));
            startActivity(browserIntent);
        });
    }
}
