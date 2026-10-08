package com.S356.myapply;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Agenda_medico extends AppCompatActivity {

    private Button btnIniciarConsulta;
    private Button btnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_agenda_medico);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnIniciarConsulta = findViewById(R.id.btnIniciarConsulta);

        if (btnIniciarConsulta != null) {
            btnIniciarConsulta.setOnClickListener(v -> {
                Intent intent = new Intent(Agenda_medico.this, Consulta_medico.class);
                startActivity(intent);
            });
        }
    }
}