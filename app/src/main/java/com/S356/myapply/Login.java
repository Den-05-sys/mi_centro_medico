package com.S356.myapply;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {

    private EditText correo;
    private EditText password;
    private CardView cardMedico;
    private CardView cardEnfermero;
    private CardView cardAdministrativo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        correo = findViewById(R.id.editTextTextEmailAddress);
        password = findViewById(R.id.editTextTextPassword);

        cardMedico = findViewById(R.id.cardMedico);
        cardEnfermero = findViewById(R.id.cardEnfermero);
        cardAdministrativo = findViewById(R.id.cardAdministrativo);

        // Configurar clics en las tarjetas de rol para validar credenciales e ingresar
        if (cardMedico != null) {
            cardMedico.setOnClickListener(v -> intentarIngresar(MainActivity.class));
        }
        if (cardEnfermero != null) {
            cardEnfermero.setOnClickListener(v -> intentarIngresar(MainActivity.class));
        }
        if (cardAdministrativo != null) {
            cardAdministrativo.setOnClickListener(v -> intentarIngresar(MainActivity.class));
        }
    }

    private void intentarIngresar(Class<?> targetClass) {
        String correoIngresado = correo != null ? correo.getText().toString().trim() : "";
        String passwordIngresada = password != null ? password.getText().toString().trim() : "";

        if (correoIngresado.isEmpty() || passwordIngresada.isEmpty()) {
            Toast.makeText(Login.this, "Por favor ingrese correo y contraseña", Toast.LENGTH_SHORT).show();
            return;
        }

        if (correoIngresado.equals("usuario@gmail.com") && passwordIngresada.equals("lavidaesbella")) {
            Toast.makeText(Login.this, "Inicio de sesión correcto", Toast.LENGTH_SHORT).show();
            navegarA(targetClass);
        } else {
            Toast.makeText(Login.this, "Correo o contraseña incorrectos", Toast.LENGTH_SHORT).show();
        }
    }

    private void navegarA(Class<?> targetClass) {
        Intent intent = new Intent(Login.this, targetClass);
        startActivity(intent);
    }
}
