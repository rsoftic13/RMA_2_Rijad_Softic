package com.example.rma_2_rijad_softic;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class NarudzbaViewModel extends AndroidViewModel {

    private final AppDatabase db;
    private final LiveData<List<NarudzbaEntity>> sveNarudzbe;

    public NarudzbaViewModel(@NonNull Application application) {
        super(application);
        db = AppDatabase.getInstance(application);
        sveNarudzbe = db.narudzbaDao().getSveNarudzbe();
    }

    public LiveData<List<NarudzbaEntity>> getSveNarudzbe() {
        return sveNarudzbe;
    }

    public void sacuvajNarudzbu(NarudzbaEntity narudzba) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            db.narudzbaDao().insert(narudzba);
        });
    }
}
