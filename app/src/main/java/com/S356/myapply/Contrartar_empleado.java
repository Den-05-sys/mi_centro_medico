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

public class Contrartar_empleado extends AppCompatActivity {
    private Button btnContratar;
    private ImageView btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_contrartar_empleado);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnContratar = findViewById(R.id.btnContratar);
        btnVolver = findViewById(R.id.btnVolver);

        // Botón Guardar: Notifica que el diagnóstico y tratamiento han sido guardados
        if (btnContratar != null) {
            btnContratar.setOnClickListener(v -> {
                Toast.makeText(Contrartar_empleado.this, "Empleado agregado correctamente", Toast.LENGTH_SHORT).show();
            });
        }


        // Botón Volver
        if (btnVolver != null) {
            btnVolver.setOnClickListener(v -> finish());
        }
    }
}