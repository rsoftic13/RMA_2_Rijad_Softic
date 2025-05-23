package com.example.rma_2_rijad_softic;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class PromjenaSifreActivity extends AppCompatActivity {

    private EditText editTextCurrentPassword, editTextNewPassword;
    private Button buttonChangePassword;

    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promjena_sifre);

        editTextCurrentPassword = findViewById(R.id.editTextCurrentPassword);
        editTextNewPassword = findViewById(R.id.editTextNewPassword);
        buttonChangePassword = findViewById(R.id.buttonChangePassword);

        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();

        if (currentUser == null) {
            // Nije prijavljen, vrati na login
            Toast.makeText(this, "Niste prijavljeni.", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        buttonChangePassword.setOnClickListener(v -> promijeniSifru());
    }

    private void promijeniSifru() {
        String currentPass = editTextCurrentPassword.getText().toString().trim();
        String newPass = editTextNewPassword.getText().toString().trim();

        if (TextUtils.isEmpty(currentPass) || TextUtils.isEmpty(newPass)) {
            Toast.makeText(this, "Molimo unesite obje šifre.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Re-autentifikacija korisnika sa trenutnom šifrom
        AuthCredential credential = EmailAuthProvider.getCredential(currentUser.getEmail(), currentPass);

        currentUser.reauthenticate(credential).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                // Re-autentifikacija uspješna, sada mijenjamo šifru
                currentUser.updatePassword(newPass).addOnCompleteListener(updateTask -> {
                    if (updateTask.isSuccessful()) {
                        Toast.makeText(PromjenaSifreActivity.this, "Šifra uspješno promijenjena. Prijavite se ponovo.", Toast.LENGTH_LONG).show();

                        // Logout i vraćanje na LoginActivity
                        mAuth.signOut();
                        Intent intent = new Intent(PromjenaSifreActivity.this, LoginActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(PromjenaSifreActivity.this, "Greška pri promjeni šifre: " + updateTask.getException().getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            } else {
                Toast.makeText(PromjenaSifreActivity.this, "Trenutna šifra nije tačna.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
