package com.S356.myapply;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Signos_vitales extends AppCompatActivity {
    private Button btnGuardarSignos;
    private ImageView btnCerrarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signos_vitales);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnGuardarSignos = findViewById(R.id.btnGuardarSignos);
        btnCerrarSesion = findViewById(R.id.btnCerrarSesion);

        // Botón Guardar: Notifica que el medicamento ha sido guardado
        if (btnGuardarSignos != null) {
            btnGuardarSignos.setOnClickListener(v -> {
                Toast.makeText(Signos_vitales.this, "Se guardo correctamente los signos vitales", Toast.LENGTH_SHORT).show();
            });
        }

        if (btnCerrarSesion != null) {
            btnCerrarSesion.setOnClickListener(v -> finish());
        }
    }
}