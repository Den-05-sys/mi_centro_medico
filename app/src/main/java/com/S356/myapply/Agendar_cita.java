package com.S356.myapply;

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

public class Agendar_cita extends AppCompatActivity {

    private TextInputLayout tilPaciente;
    private TextInputEditText etPaciente;
    private RecyclerView rvPacientes;

    private TextInputLayout tilMedico;
    private TextInputEditText etMedico;
    private RecyclerView rvMedicos;

    private TextView tvResumenCita;
    private Button btnConfirmarCita;

    private Paciente pacienteSeleccionado;
    private Medico medicoSeleccionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_agendar_cita);

        View mainView = findViewById(R.id.main);
        if (mainView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(mainView, (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }

        View toolbar = findViewById(R.id.toolbar);
        if (toolbar instanceof MaterialToolbar) {
            ((MaterialToolbar) toolbar).setNavigationOnClickListener(v -> finish());
        }

        tilPaciente = findViewById(R.id.tilPaciente);
        etPaciente = findViewById(R.id.etPaciente);
        rvPacientes = findViewById(R.id.rvPacientes);

        tilMedico = findViewById(R.id.tilMedico);
        etMedico = findViewById(R.id.etMedico);
        rvMedicos = findViewById(R.id.rvMedicos);

        tvResumenCita = findViewById(R.id.tvResumenCita);
        btnConfirmarCita = findViewById(R.id.btnConfirmarCita);

        // --- Configuración de Pacientes ---
        if (rvPacientes != null) {
            rvPacientes.setLayoutManager(new LinearLayoutManager(this));

            ArrayList<Paciente> listaPacientes = new ArrayList<>();
            listaPacientes.add(new Paciente("Juan", "Pérez", "99887766D", 55, "col", 1.70, "HC-2024-001"));
            listaPacientes.add(new Paciente("María", "Gómez", "11223344E", 40, "col", 1.65, "HC-2024-002"));

            Paciente_adapter adapterPacientes = new Paciente_adapter(listaPacientes, paciente -> {
                pacienteSeleccionado = paciente;
                if (etPaciente != null) {
                    etPaciente.setText(paciente.getNombreCompleto());
                }
                rvPacientes.setVisibility(View.GONE);
                actualizarResumen();
            });
            rvPacientes.setAdapter(adapterPacientes);
        }

        View.OnClickListener togglePacientesListener = v -> {
            if (rvPacientes != null) {
                if (rvPacientes.getVisibility() == View.VISIBLE) {
                    rvPacientes.setVisibility(View.GONE);
                } else {
                    rvPacientes.setVisibility(View.VISIBLE);
                    if (rvMedicos != null) {
                        rvMedicos.setVisibility(View.GONE);
                    }
                }
            }
        };

        if (etPaciente != null) etPaciente.setOnClickListener(togglePacientesListener);
        if (tilPaciente != null) tilPaciente.setOnClickListener(togglePacientesListener);


        // --- Configuración de Médicos ---
        if (rvMedicos != null) {
            rvMedicos.setLayoutManager(new LinearLayoutManager(this));

            ArrayList<Medico> listaMedicos = new ArrayList<>();
            listaMedicos.add(new Medico("Laura", "Gómez", "cc", "98765", 40, "col", 1.65,
                    "Ac256", 1800.0, "Cardiología", "98543"));
            listaMedicos.add(new Medico("Carlos", "Martínez", "cc", "87654", 48, "col", 1.75,
                    "Ac257", 2000.0, "Pediatría", "98544"));

            Medico_adapter adapterMedicos = new Medico_adapter(listaMedicos, medico -> {
                medicoSeleccionado = medico;
                if (etMedico != null) {
                    etMedico.setText(medico.getNombreCompleto());
                }
                rvMedicos.setVisibility(View.GONE);
                actualizarResumen();
            });
            rvMedicos.setAdapter(adapterMedicos);
        }

        View.OnClickListener toggleMedicosListener = v -> {
            if (rvMedicos != null) {
                if (rvMedicos.getVisibility() == View.VISIBLE) {
                    rvMedicos.setVisibility(View.GONE);
                } else {
                    rvMedicos.setVisibility(View.VISIBLE);
                    if (rvPacientes != null) {
                        rvPacientes.setVisibility(View.GONE);
                    }
                }
            }
        };

        if (etMedico != null) etMedico.setOnClickListener(toggleMedicosListener);
        if (tilMedico != null) tilMedico.setOnClickListener(toggleMedicosListener);

        if (btnConfirmarCita != null) {
            btnConfirmarCita.setOnClickListener(v -> {
                if (pacienteSeleccionado == null) {
                    Toast.makeText(Agendar_cita.this, "Por favor seleccione un paciente", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (medicoSeleccionado == null) {
                    Toast.makeText(Agendar_cita.this, "Por favor seleccione un médico", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(Agendar_cita.this, "Cita agendada correctamente", Toast.LENGTH_SHORT).show();
                finish();
            });
        }
    }

    private void actualizarResumen() {
        String nombrePaciente = pacienteSeleccionado != null ? pacienteSeleccionado.getNombreCompleto() : "Paciente";
        String nombreMedico = medicoSeleccionado != null ? medicoSeleccionado.getNombreCompleto() : "Médico";
        if (tvResumenCita != null) {
            tvResumenCita.setText(nombrePaciente + " con " + nombreMedico);
        }
    }
}
