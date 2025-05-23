package com.example.rma_2_rijad_softic;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;

public class ProfilActivity extends BaseActivity {

    private EditText imeInput, prezimeInput, telefonInput, adresaInput, postanskiBrojInput, opcinaInput;
    private Button sacuvajBtn, promjenaSifreBtn, narudzbeBtn;
    private ProfilViewModel viewModel;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_profil);

            imeInput = findViewById(R.id.inputIme);
            prezimeInput = findViewById(R.id.inputPrezime);
            telefonInput = findViewById(R.id.inputTelefon);
            adresaInput = findViewById(R.id.inputAdresa);
            postanskiBrojInput = findViewById(R.id.inputPostanskiBroj);
            opcinaInput = findViewById(R.id.inputOpcina);
            sacuvajBtn = findViewById(R.id.btnSacuvaj);
            promjenaSifreBtn = findViewById(R.id.btnPromjenaSifre);
            narudzbeBtn = findViewById(R.id.btnNarudzbe);

            viewModel = new ViewModelProvider(this,
                    ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())
            ).get(ProfilViewModel.class);

        viewModel.getKorisnik().observe(this, korisnik -> {
            if (korisnik != null) {
                imeInput.setText(korisnik.ime);
                prezimeInput.setText(korisnik.prezime);
                telefonInput.setText(korisnik.telefon);
                adresaInput.setText(korisnik.adresa);
                postanskiBrojInput.setText(korisnik.postanskiBroj);
                opcinaInput.setText(korisnik.opcina);
            }
        });

        sacuvajBtn.setOnClickListener(v -> {
            String ime = imeInput.getText().toString().trim();
            String prezime = prezimeInput.getText().toString().trim();
            String telefon = telefonInput.getText().toString().trim();
            String adresa = adresaInput.getText().toString().trim();
            String postanski = postanskiBrojInput.getText().toString().trim();
            String opcina = opcinaInput.getText().toString().trim();

            viewModel.sacuvajKorisnika(new KorisnikEntity(ime, prezime, telefon, adresa, postanski, opcina));

            Toast.makeText(this, "Podaci su sačuvani.", Toast.LENGTH_SHORT).show();
        });

        promjenaSifreBtn.setOnClickListener(v ->
                startActivity(new Intent(this, PromjenaSifreActivity.class))
        );

        narudzbeBtn.setOnClickListener(v ->
                startActivity(new Intent(this, NarudzbeActivity.class))
        );
    }
}
