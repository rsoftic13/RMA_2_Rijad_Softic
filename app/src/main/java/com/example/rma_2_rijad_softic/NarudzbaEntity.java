package com.example.rma_2_rijad_softic;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "narudzbe")
public class NarudzbaEntity {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String nazivArtikla;
    public String cijenaArtikla;

    public String imeKupca;
    public String prezimeKupca;
    public String telefonKupca;
    public String adresaKupca;
    public String postanskiBrojKupca;
    public String opcinaKupca;

    public NarudzbaEntity(String nazivArtikla, String cijenaArtikla,
                          String imeKupca, String prezimeKupca, String telefonKupca,
                          String adresaKupca, String postanskiBrojKupca, String opcinaKupca) {
        this.nazivArtikla = nazivArtikla;
        this.cijenaArtikla = cijenaArtikla;
        this.imeKupca = imeKupca;
        this.prezimeKupca = prezimeKupca;
        this.telefonKupca = telefonKupca;
        this.adresaKupca = adresaKupca;
        this.postanskiBrojKupca = postanskiBrojKupca;
        this.opcinaKupca = opcinaKupca;
    }
}
