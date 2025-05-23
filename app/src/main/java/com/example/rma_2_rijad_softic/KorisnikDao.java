package com.example.rma_2_rijad_softic;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface KorisnikDao {
    @Insert
    void insert(KorisnikEntity korisnik);

    @Query("DELETE FROM korisnik")
    void deleteAll();

    @Query("SELECT * FROM korisnik LIMIT 1")
    LiveData<KorisnikEntity> getKorisnik();
}