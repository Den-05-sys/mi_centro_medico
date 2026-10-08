package com.S356.myapply;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Consulta_medico extends AppCompatActivity {

    private Button btnGuardar;
    private Button btnFinalizar;
    private ImageView btnHistorial;
    private ImageView btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_consulta_medico);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnGuardar = findViewById(R.id.btnGuardar);
        btnFinalizar = findViewById(R.id.btnFinalizar);
        btnHistorial = findViewById(R.id.btnHistorial);
        btnVolver = findViewById(R.id.btnVolver);

        // Botón Guardar: Notifica que el diagnóstico y tratamiento han sido guardados
        if (btnGuardar != null) {
            btnGuardar.setOnClickListener(v -> {
                Toast.makeText(Consulta_medico.this, "Consulta guardada correctamente", Toast.LENGTH_SHORT).show();
            });
        }

        // Botón Finalizar: Guarda la consulta y navega directamente a Historial_medi
        if (btnFinalizar != null) {
            btnFinalizar.setOnClickListener(v -> {
                Toast.makeText(Consulta_medico.this, "Consulta finalizada. Redirigiendo a Historial Médico...", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Consulta_medico.this, Historial_medi.class);
                startActivity(intent);
                finish();
            });
        }

        // Botón de icono de Historial en la parte superior derecha
        if (btnHistorial != null) {
            btnHistorial.setOnClickListener(v -> {
                Intent intent = new Intent(Consulta_medico.this, Historial_medi.class);
                startActivity(intent);
            });
        }

        // Botón Volver
        if (btnVolver != null) {
            btnVolver.setOnClickListener(v -> finish());
        }
    }
}