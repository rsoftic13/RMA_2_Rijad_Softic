package com.example.rma_2_rijad_softic;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private EditText emailEditText, confirmEmailEditText, passwordEditText, confirmPasswordEditText;
    private Button registerButton;
    private TextView goToLogin;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        emailEditText = findViewById(R.id.emailEditText);
        confirmEmailEditText = findViewById(R.id.confirmEmailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText);
        registerButton = findViewById(R.id.registerButton);
        goToLogin = findViewById(R.id.goToLogin);

        Animation fadeAnim = AnimationUtils.loadAnimation(this, R.anim.fade_anim);

        goToLogin.setOnClickListener(v -> {
            v.startAnimation(fadeAnim);
            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            finish();
        });

        mAuth = FirebaseAuth.getInstance();

        registerButton.setOnClickListener(v -> {
            String email = emailEditText.getText().toString().trim();
            String confirmEmail = confirmEmailEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();
            String confirmPassword = confirmPasswordEditText.getText().toString().trim();

            // Provjera email polja
            if (TextUtils.isEmpty(email) || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                emailEditText.setError("Unesite validnu email adresu");
                Toast.makeText(this, "Greška: Neispravna email adresa", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!email.equals(confirmEmail)) {
                Toast.makeText(this, "Greška: Email adrese se ne podudaraju", Toast.LENGTH_LONG).show();
                return;
            }

            // Provjera lozinke
            if (TextUtils.isEmpty(password) || password.length() < 6) {
                passwordEditText.setError("Lozinka mora imati najmanje 6 znakova");
                Toast.makeText(this, "Lozinka mora imati najmanje 6 znakova", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!password.equals(confirmPassword)) {
                Toast.makeText(this, "Greška: Lozinke se ne podudaraju", Toast.LENGTH_LONG).show();
                return;
            }

            // Registracija u Firebase sa provjerom da li email već postoji
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            Toast.makeText(RegisterActivity.this, "Registracija uspješna", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                            finish();
                        } else {
                            String errorMessage = "Greška pri registraciji";
                            if (task.getException() != null) {
                                String error = task.getException().getMessage();
                                if (error.contains("The email address is already in use")) {
                                    errorMessage = "Greška: Račun sa ovim emailom već postoji";
                                } else {
                                    errorMessage = error;
                                }
                            }
                            Toast.makeText(RegisterActivity.this, errorMessage, Toast.LENGTH_LONG).show();
                        }
                    });
        });
    }
}
