package com.example.rma_2_rijad_softic;

public class Artikal {
    private String naziv;
    private String cijena;
    private String kategorija;
    private int slikaResurs;
    private Class<?> aktivnost;

    public Artikal(String naziv, String cijena, String kategorija, int slikaResurs, Class<?> aktivnost) {
        this.naziv = naziv;
        this.cijena = cijena;
        this.kategorija = kategorija;
        this.slikaResurs = slikaResurs;
        this.aktivnost = aktivnost;
    }

    public String getNaziv() { return naziv; }
    public String getCijena() { return cijena; }
    public String getKategorija() { return kategorija; }
    public int getSlikaResurs() { return slikaResurs; }
    public Class<?> getAktivnost() { return aktivnost; }
}
