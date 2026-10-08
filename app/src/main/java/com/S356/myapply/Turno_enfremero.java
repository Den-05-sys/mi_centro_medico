package com.S356.myapply;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Turno_enfremero extends AppCompatActivity {
    private Button btnSignos;
    private Button btnMedicar;
    private ImageView btnCerrarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_turno_enfremero);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnSignos = findViewById(R.id.btnSignos);
        btnMedicar = findViewById(R.id.btnMedicar);
        btnCerrarSesion = findViewById(R.id.btnCerrarSesion);

        if (btnSignos != null) {
            btnSignos.setOnClickListener(v -> {
                Intent intent = new Intent(Turno_enfremero.this, Signos_vitales.class);
                startActivity(intent);
            });
        }
        if (btnMedicar != null) {
            btnMedicar.setOnClickListener(v -> {
                Intent intent = new Intent(Turno_enfremero.this, Administrar_medicamento.class);
                startActivity(intent);
            });
        }
        if (btnCerrarSesion != null) {
            btnCerrarSesion.setOnClickListener(v -> finish());
        }
    }
}