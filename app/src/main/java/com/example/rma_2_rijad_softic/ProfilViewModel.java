package com.example.rma_2_rijad_softic;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class ProfilViewModel extends AndroidViewModel {

    private final AppDatabase db;
    private final LiveData<KorisnikEntity> korisnik;

    public ProfilViewModel(@NonNull Application application) {
        super(application);
        db = AppDatabase.getInstance(application);
        korisnik = db.korisnikDao().getKorisnik();
    }

    public LiveData<KorisnikEntity> getKorisnik() {
        return korisnik;
    }

    public void sacuvajKorisnika(KorisnikEntity novi) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            db.korisnikDao().deleteAll();
            db.korisnikDao().insert(novi);
        });
    }
}
