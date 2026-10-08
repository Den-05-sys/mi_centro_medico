package com.S356.myapply;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class Pacientes extends AppCompatActivity {

    private MaterialToolbar toolbar;
    private ExtendedFloatingActionButton fabRegistrarPaciente;

    private TextInputEditText etBuscarPaciente;
    private RecyclerView rvListPacientes;
    private List_adapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pacientes);

        View mainView = findViewById(R.id.main);
        if (mainView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(mainView, (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }

        toolbar = findViewById(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setNavigationOnClickListener(v -> finish());
        }

        fabRegistrarPaciente = findViewById(R.id.fabRegistrarPaciente);
        if (fabRegistrarPaciente != null) {
            fabRegistrarPaciente.setOnClickListener(v -> {
                Intent intent = new Intent(Pacientes.this, Registrar_paciente.class);
                startActivity(intent);
            });
        }

        etBuscarPaciente = findViewById(R.id.etBuscarPaciente);
        rvListPacientes = findViewById(R.id.rvListPacientes);

        if (rvListPacientes != null) {
            rvListPacientes.setLayoutManager(new LinearLayoutManager(this));
            cargarPacientes();
        }

        View.OnClickListener listenerMostrarLista = v -> {
            if (rvListPacientes != null) {
                rvListPacientes.setVisibility(View.VISIBLE);
            }
        };

        if (etBuscarPaciente != null) {
            etBuscarPaciente.setOnClickListener(listenerMostrarLista);
            etBuscarPaciente.setOnFocusChangeListener((v, hasFocus) -> {
                if (hasFocus && rvListPacientes != null) {
                    rvListPacientes.setVisibility(View.VISIBLE);
                }
            });

            etBuscarPaciente.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (rvListPacientes != null) {
                        rvListPacientes.setVisibility(View.VISIBLE);
                    }
                    if (listAdapter != null) {
                        listAdapter.filtrar(s.toString());
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {}
            });
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        cargarPacientes();
    }

    private void cargarPacientes() {
        if (rvListPacientes != null) {
            ArrayList<Paciente> pacientesData = new ArrayList<>(Datos_app.centroMedico.getPacientes());

            listAdapter = new List_adapter(pacientesData, paciente -> {
                if (etBuscarPaciente != null) {
                    etBuscarPaciente.setText(paciente.getNombreCompleto());
                }
                rvListPacientes.setVisibility(View.GONE);
            });
            rvListPacientes.setAdapter(listAdapter);
        }
    }
}
