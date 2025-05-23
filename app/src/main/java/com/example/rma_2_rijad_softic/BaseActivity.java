package com.example.rma_2_rijad_softic;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupMenu;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public abstract class BaseActivity extends AppCompatActivity {

    protected BottomNavigationView bottomNavigationView;
    protected ImageView logoImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_base);

        logoImage = findViewById(R.id.logoImage);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        setupNavigation();
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        FrameLayout contentFrame = findViewById(R.id.contentFrame);
        View view = LayoutInflater.from(this).inflate(layoutResID, contentFrame, false);
        contentFrame.addView(view);
    }

    private void setupNavigation() {
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_home) {
                if (!(this instanceof HomeActivity)) {
                    startActivity(new Intent(this, HomeActivity.class));
                }
                return true;
            } else if (id == R.id.nav_category) {
                View anchor = findViewById(R.id.nav_category);
                PopupMenu popup = new PopupMenu(this, anchor);
                popup.getMenuInflater().inflate(R.menu.kategorije_dropdown_menu, popup.getMenu());

                popup.setOnMenuItemClickListener(menuItem -> {
                    String kategorija = menuItem.getTitle().toString();
                    Class<?> targetActivity;

                    switch (kategorija) {
                        case "Računari":
                            targetActivity = RacunariActivity.class;
                            break;
                        case "Periferija":
                            targetActivity = PeriferijaActivity.class;
                            break;
                        case "Monitori":
                            targetActivity = MonitoriActivity.class;
                            break;
                        case "Klime":
                            targetActivity = KlimeActivity.class;
                            break;
                        default:
                            return false;
                    }

                    if (!this.getClass().equals(targetActivity)) {
                        Intent intent = new Intent(this, targetActivity);
                        startActivity(intent);
                    }
                    return true;
                });

                popup.show();
                return true;
            } else if (id == R.id.nav_search) {
                if (!(this instanceof SearchActivity)) {
                    startActivity(new Intent(this, SearchActivity.class));
                }
                return true;
            } else if (id == R.id.nav_info) {
                if (!(this instanceof InfoActivity)) {
                    startActivity(new Intent(this, InfoActivity.class));
                }
                return true;
            } else if (id == R.id.nav_profil) {
                if (!(this instanceof ProfilActivity)) {
                    startActivity(new Intent(this, ProfilActivity.class));
                }
                return true;
            }
            return false;
        });
    }
}
