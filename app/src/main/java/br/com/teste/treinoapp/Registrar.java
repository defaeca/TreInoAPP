package br.com.teste.treinoapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Registrar extends AppCompatActivity {

    private EditText usuarioEditText;
    private EditText senhaEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        usuarioEditText = findViewById(R.id.usuario);
        senhaEditText = findViewById(R.id.senha);
        Button registerButton = findViewById(R.id.registrarb);
        Button backButton = findViewById(R.id.backButton);

        registerButton.setOnClickListener(v -> registerUser());
        backButton.setOnClickListener(v -> voltar());
    }

    private void registerUser() {
        SharedPreferences sharedPreferences = getSharedPreferences("UserInfo", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("usuario", usuarioEditText.getText().toString());
        editor.putString("senha", senhaEditText.getText().toString());
        editor.apply();

        Toast.makeText(this, "Usuário registrado com sucesso!", Toast.LENGTH_SHORT).show();
    }
    private void voltar(){
        Intent intent = new Intent(Registrar.this, MainActivity.class);
        startActivity(intent);
    }
}