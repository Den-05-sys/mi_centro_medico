package com.S356.myapply;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class Agenda_medico extends AppCompatActivity {

    private Button btnIniciarConsulta;
    private MaterialToolbar toolbar;

    private TextInputLayout tilPaciente;
    private TextInputEditText etPaciente;
    private RecyclerView rvPacientes;
    private TextView tvResumenCita;

    private Paciente pacienteSeleccionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_agenda_medico);

        View mainView = findViewById(R.id.main);
        if (mainView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(mainView, (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }

        btnIniciarConsulta = findViewById(R.id.btnIniciarConsulta);
        toolbar = findViewById(R.id.toolbar);
        tilPaciente = findViewById(R.id.tilPaciente);
        etPaciente = findViewById(R.id.etPaciente);
        rvPacientes = findViewById(R.id.rvPacientes);
        tvResumenCita = findViewById(R.id.tvResumenCita);

        if (btnIniciarConsulta != null) {
            btnIniciarConsulta.setOnClickListener(v -> {
                if (pacienteSeleccionado == null) {
                    Toast.makeText(Agenda_medico.this, "Por favor seleccione un paciente", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(Agenda_medico.this, Consulta_medico.class);
                startActivity(intent);
            });
        }

        if (toolbar != null) {
            toolbar.setNavigationOnClickListener(v -> finish());
        }

        if (rvPacientes != null) {
            rvPacientes.setLayoutManager(new LinearLayoutManager(this));
        }

        cargarPacientes();

        View.OnClickListener togglePacientesListener = v -> {
            if (rvPacientes != null) {
                if (rvPacientes.getVisibility() == View.VISIBLE) {
                    rvPacientes.setVisibility(View.GONE);
                } else {
                    rvPacientes.setVisibility(View.VISIBLE);
                }
            }
        };

        if (etPaciente != null) etPaciente.setOnClickListener(togglePacientesListener);
        if (tilPaciente != null) tilPaciente.setOnClickListener(togglePacientesListener);
    }

    @Override
    protected void onResume() {
        super.onResume();
        cargarPacientes();
    }

    private void cargarPacientes() {
        if (rvPacientes != null) {
            ArrayList<Paciente> listaPacientes = new ArrayList<>(Datos_app.centroMedico.getPacientes());

            Paciente_adapter adapter = new Paciente_adapter(listaPacientes, paciente -> {
                pacienteSeleccionado = paciente;
                if (etPaciente != null) {
                    etPaciente.setText(paciente.getNombreCompleto());
                }
                rvPacientes.setVisibility(View.GONE);
                actualizarResumen();
            });
            rvPacientes.setAdapter(adapter);
        }
    }

    private void actualizarResumen() {
        if (tvResumenCita != null && pacienteSeleccionado != null) {
            tvResumenCita.setText(pacienteSeleccionado.getNombreCompleto() + " con Dra. Laura Gómez");
        }
    }
}
