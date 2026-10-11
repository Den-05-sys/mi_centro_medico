package com.S356.myapply;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
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
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Personal extends AppCompatActivity {

    private Button btnContratar;
    private LinearLayout btnTodo;
    private LinearLayout btnEnfermeros;
    private LinearLayout btnMedicos;
    private TextView btnAdministrativos;
    private MaterialToolbar toolbar;
    private BottomNavigationView bottomNav;

    private RecyclerView rvEmpleados;
    private Empleado_adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_personal);

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

        btnContratar = findViewById(R.id.btnContratar);
        btnTodo = findViewById(R.id.btnTodo);
        btnEnfermeros = findViewById(R.id.btnEnfermeros);
        btnMedicos = findViewById(R.id.btnMedicos);
        btnAdministrativos = findViewById(R.id.btnAdministrativos);
        rvEmpleados = findViewById(R.id.rvEmpleados);
        bottomNav = findViewById(R.id.bottomNav);

        if (btnContratar != null) {
            btnContratar.setOnClickListener(v -> {
                Intent intent = new Intent(Personal.this, Contrartar_empleado.class);
                startActivity(intent);
            });
        }

        // Configuración de Navegación del BottomNavigationView
        if (bottomNav != null) {
            bottomNav.setSelectedItemId(R.id.nav_personal);
            bottomNav.setOnItemSelectedListener(item -> {
                int itemId = item.getItemId();
                if (itemId == R.id.nav_home) {
                    startActivity(new Intent(Personal.this, Admin_inicio.class));
                    finish();
                    return true;
                } else if (itemId == R.id.nav_pacientes) {
                    startActivity(new Intent(Personal.this, Pacientes.class));
                    finish();
                    return true;
                } else if (itemId == R.id.nav_citas) {
                    startActivity(new Intent(Personal.this, Agendar_cita.class));
                    finish();
                    return true;
                } else if (itemId == R.id.nav_personal) {
                    return true;
                }
                return false;
            });
        }

        // Configuración del RecyclerView
        if (rvEmpleados != null) {
            rvEmpleados.setLayoutManager(new LinearLayoutManager(this));
            cargarEmpleados();
        }

        // Configuración de Filtros
        if (btnTodo != null) {
            btnTodo.setOnClickListener(v -> {
                if (adapter != null) {
                    adapter.filtrar("Todos");
                }
            });
        }

        if (btnEnfermeros != null) {
            btnEnfermeros.setOnClickListener(v -> {
                if (adapter != null) {
                    adapter.filtrar("Enfermero");
                }
            });
        }

        if (btnMedicos != null) {
            btnMedicos.setOnClickListener(v -> {
                if (adapter != null) {
                    adapter.filtrar("Medico");
                }
            });
        }

        if (btnAdministrativos != null) {
            btnAdministrativos.setOnClickListener(v -> {
                if (adapter != null) {
                    adapter.filtrar("Administrativo");
                }
            });
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        cargarEmpleados();
    }

    private void cargarEmpleados() {
        if (rvEmpleados != null) {
            ArrayList<Empleado> listaEmpleados = new ArrayList<>(Datos_app.centroMedico.getEmpleados());
            adapter = new Empleado_adapter(listaEmpleados, empleado -> {
                Toast.makeText(Personal.this, "Seleccionado: " + empleado.getNombreCompleto(), Toast.LENGTH_SHORT).show();
            });
            rvEmpleados.setAdapter(adapter);
        }
    }
}
