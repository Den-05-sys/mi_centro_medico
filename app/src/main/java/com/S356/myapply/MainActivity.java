package com.S356.myapply;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        View mainView = findViewById(R.id.main);
        if (mainView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(mainView, (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }

        Button btnPersona = findViewById(R.id.btnVerDetallePersona);
        Button btnMedico = findViewById(R.id.btnVerDetalleMedico);
        Button btnEnfermero = findViewById(R.id.btnVerDetalleEnfermero);
        Button btnAdmin = findViewById(R.id.btnVerDetalleAdministrativo);

        if (btnPersona != null) {
            btnPersona.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, Personal.class);
                startActivity(intent);
            });
        }

        if (btnMedico != null) {
            btnMedico.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, Agenda_medico.class);
                startActivity(intent);
            });
        }

        if (btnEnfermero != null) {
            btnEnfermero.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, Turno_enfremero.class);
                startActivity(intent);
            });
        }

        if (btnAdmin != null) {
            btnAdmin.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, Admin_inicio.class);
                startActivity(intent);
            });
        }
    }
}
