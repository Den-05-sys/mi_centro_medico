package com.S356.myapply;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.card.MaterialCardView;

public class Admin_inicio extends AppCompatActivity {

    private MaterialCardView cardRegistrarPaciente;
    private MaterialCardView cardAgendarCita;
    private MaterialCardView cardVerPacientes;
    private MaterialCardView cardGenerarFactura;
    private MaterialToolbar toolbar;
    private BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_admin_inicio);

        View mainView = findViewById(R.id.main);
        if (mainView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(mainView, (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }

        cardRegistrarPaciente = findViewById(R.id.cardRegistrarPaciente);
        cardAgendarCita = findViewById(R.id.cardAgendarCita);
        cardVerPacientes = findViewById(R.id.cardVerPacientes);
        cardGenerarFactura = findViewById(R.id.cardGenerarFactura);
        toolbar = findViewById(R.id.toolbar);
        bottomNav = findViewById(R.id.bottomNav);

        if (cardRegistrarPaciente != null) {
            cardRegistrarPaciente.setOnClickListener(v -> {
                Intent intent = new Intent(Admin_inicio.this, Registrar_paciente.class);
                startActivity(intent);
            });
        }

        if (cardAgendarCita != null) {
            cardAgendarCita.setOnClickListener(v -> {
                Intent intent = new Intent(Admin_inicio.this, Agendar_cita.class);
                startActivity(intent);
            });
        }

        if (cardVerPacientes != null) {
            cardVerPacientes.setOnClickListener(v -> {
                Intent intent = new Intent(Admin_inicio.this, Pacientes.class);
                startActivity(intent);
            });
        }

        if (cardGenerarFactura != null) {
            cardGenerarFactura.setOnClickListener(v -> {
                Intent intent = new Intent(Admin_inicio.this, Factura.class);
                startActivity(intent);
            });
        }
    }
}
