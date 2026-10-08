package com.S356.myapply;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Personal extends AppCompatActivity {
    private Button btnContratar;
    private LinearLayout btnTodo;
    private LinearLayout btnEnfermeros;
    private LinearLayout btnMedicos;
    private TextView btnAdministrativos;
    private ImageView btnCerrarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_personal);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnContratar = findViewById(R.id.btnContratar);
        btnCerrarSesion = findViewById(R.id.btnCerrarSesion);
        btnTodo = findViewById(R.id.btnTodo);
        btnEnfermeros = findViewById(R.id.btnEnfermeros);
        btnMedicos = findViewById(R.id.btnMedicos);
        btnAdministrativos = findViewById(R.id.btnAdministrativos);


        if (btnContratar != null) {
            btnContratar.setOnClickListener(v -> {
                Intent intent = new Intent(Personal.this, Contrartar_empleado.class);
                startActivity(intent);
            });
        }

        if (btnTodo != null) {
            btnTodo.setOnClickListener(v -> {
                Intent intent = new Intent(Personal.this, Contrartar_empleado.class);
                startActivity(intent);
            });
        }


        // Botón Volver
        if (btnCerrarSesion != null) {
            btnCerrarSesion.setOnClickListener(v -> finish());
        }
    }
}