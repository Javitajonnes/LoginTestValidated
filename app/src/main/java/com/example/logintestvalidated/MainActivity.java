package com.example.logintestvalidated;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button btnLogin;
    private TextView tvAttempts;
    private int attemptCounter = 3; // Número de intentos permitidos
    private final String USERNAME = "admin"; // Nombre de usuario predeterminado
    private final String PASSWORD = "1234"; // Contraseña predeterminada

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvAttempts = findViewById(R.id.tvAttempts);

        // Configurar el botón de validación
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateCredentials();
            }
        });
    }

    private void validateCredentials() {
        String enteredUsername = etUsername.getText().toString();
        String enteredPassword = etPassword.getText().toString();

        if (enteredUsername.equals(USERNAME) && enteredPassword.equals(PASSWORD)) {
            // Credenciales correctas, navega a la segunda actividad
            Toast.makeText(this, "Login exitoso", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, SuccessActivity.class);
            startActivity(intent);
            finish(); // Finaliza la actividad actual
        } else {
            attemptCounter--; // Resta un intento
            tvAttempts.setText("Intentos restantes: " + attemptCounter);
            if (attemptCounter == 0) {
                // Si no quedan intentos, deshabilitar el botón
                btnLogin.setEnabled(false);
                Toast.makeText(this, "Se han agotado los intentos", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
            }
        }
    }
}