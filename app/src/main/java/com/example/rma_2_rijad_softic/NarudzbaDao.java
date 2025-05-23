package com.example.rma_2_rijad_softic;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface NarudzbaDao {

    @Insert
    void insert(NarudzbaEntity narudzba);

    @Query("SELECT * FROM narudzbe ORDER BY id DESC")
    LiveData<List<NarudzbaEntity>> getSveNarudzbe();

    @Query("DELETE FROM narudzbe")
    void deleteAll();
}
