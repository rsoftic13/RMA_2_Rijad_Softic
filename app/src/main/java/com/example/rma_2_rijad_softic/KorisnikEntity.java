package com.example.rma_2_rijad_softic;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "korisnik")
public class KorisnikEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String ime, prezime, telefon, adresa, postanskiBroj, opcina;

    public KorisnikEntity(String ime, String prezime, String telefon, String adresa, String postanskiBroj, String opcina) {
        this.ime = ime;
        this.prezime = prezime;
        this.telefon = telefon;
        this.adresa = adresa;
        this.postanskiBroj = postanskiBroj;
        this.opcina = opcina;
    }
}