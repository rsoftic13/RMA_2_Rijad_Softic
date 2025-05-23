package com.example.rma_2_rijad_softic;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class KupovinaActivity extends BaseActivity {

    private TextView tvNazivArtikla, tvCijenaArtikla;
    private EditText imeInput, prezimeInput, telefonInput, adresaInput, postanskiBrojInput, opcinaInput;
    private Button potvrdiBtn;
    private ProfilViewModel profilViewModel;
    private NarudzbaViewModel narudzbaViewModel;

    private String nazivArtikla;
    private String cijenaArtikla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kupovina);

        tvNazivArtikla = findViewById(R.id.tvNazivArtikla);
        tvCijenaArtikla = findViewById(R.id.tvCijenaArtikla);
        imeInput = findViewById(R.id.inputIme);
        prezimeInput = findViewById(R.id.inputPrezime);
        telefonInput = findViewById(R.id.inputTelefon);
        adresaInput = findViewById(R.id.inputAdresa);
        postanskiBrojInput = findViewById(R.id.inputPostanskiBroj);
        opcinaInput = findViewById(R.id.inputOpcina);
        potvrdiBtn = findViewById(R.id.btnPotvrdiKupovinu);

        // Dohvati naziv i cijenu iz intent-a
        nazivArtikla = getIntent().getStringExtra("naziv");
        cijenaArtikla = getIntent().getStringExtra("cijena");

        tvNazivArtikla.setText(nazivArtikla);
        tvCijenaArtikla.setText(cijenaArtikla);

        // Inicijalizacija ViewModel-a za profil i narudžbe
        profilViewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())).get(ProfilViewModel.class);
        narudzbaViewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())).get(NarudzbaViewModel.class);

        // Učitaj podatke korisnika i popuni polja
        profilViewModel.getKorisnik().observe(this, korisnik -> {
            if (korisnik != null) {
                imeInput.setText(korisnik.ime);
                prezimeInput.setText(korisnik.prezime);
                telefonInput.setText(korisnik.telefon);
                adresaInput.setText(korisnik.adresa);
                postanskiBrojInput.setText(korisnik.postanskiBroj);
                opcinaInput.setText(korisnik.opcina);
            }
        });

        potvrdiBtn.setOnClickListener(v -> {
            String ime = imeInput.getText().toString().trim();
            String prezime = prezimeInput.getText().toString().trim();
            String telefon = telefonInput.getText().toString().trim();
            String adresa = adresaInput.getText().toString().trim();
            String postanski = postanskiBrojInput.getText().toString().trim();
            String opcina = opcinaInput.getText().toString().trim();

            if (ime.isEmpty() || prezime.isEmpty() || telefon.isEmpty() || adresa.isEmpty()
                    || postanski.isEmpty() || opcina.isEmpty()) {
                Toast.makeText(this, "Molimo popunite sva polja.", Toast.LENGTH_SHORT).show();
                return;
            }

            NarudzbaEntity narudzba = new NarudzbaEntity(nazivArtikla, cijenaArtikla, ime, prezime, telefon, adresa, postanski, opcina);

            narudzbaViewModel.sacuvajNarudzbu(narudzba);

            Toast.makeText(this, "Narudžba je uspješno kreirana.", Toast.LENGTH_SHORT).show();

            finish();
        });
    }
}
