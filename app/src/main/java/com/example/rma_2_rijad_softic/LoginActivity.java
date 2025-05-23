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

public class LoginActivity extends AppCompatActivity {

    private EditText emailEditText, passwordEditText;
    private Button loginButton;
    private TextView goToRegister;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        goToRegister = findViewById(R.id.goToRegister);

        Animation fadeAnim = AnimationUtils.loadAnimation(this, R.anim.fade_anim);

        goToRegister = findViewById(R.id.goToRegister);
        goToRegister.setOnClickListener(v -> {
            v.startAnimation(fadeAnim);
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            finish();
        });

        mAuth = FirebaseAuth.getInstance();

        loginButton.setOnClickListener(v -> {
            String email = emailEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();

            if (TextUtils.isEmpty(email) || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                emailEditText.setError("Unesite validan email");
                Toast.makeText(this, "Neispravan email", Toast.LENGTH_SHORT).show();
                return;
            }

            if (TextUtils.isEmpty(password) || password.length() < 6) {
                passwordEditText.setError("Lozinka mora imati najmanje 6 znakova");
                Toast.makeText(this, "Lozinka mora imati najmanje 6 znakova", Toast.LENGTH_SHORT).show();
                return;
            }

            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, "Login uspješan. Dobrodošli!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                            finish();
                        } else {
                            String error = task.getException() != null ? task.getException().getMessage() : "Greška pri prijavi";
                            Toast.makeText(LoginActivity.this, "Greška: " + error, Toast.LENGTH_LONG).show();
                        }
                    });
        });
    }
}
