package br.com.teste.treinoapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private EditText usuarioEditText;
    private EditText senhaEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuarioEditText = findViewById(R.id.usuario);
        senhaEditText = findViewById(R.id.senha);
        Button loginButton = findViewById(R.id.loginButton);
        Button registerButton = findViewById(R.id.registerButton);

        loginButton.setOnClickListener(v -> Logar());
        registerButton.setOnClickListener(v -> irRegistro());
    }


    private void Logar() {
        SharedPreferences sharedPreferences = getSharedPreferences("UserInfo", MODE_PRIVATE);
        String savedUser = sharedPreferences.getString("usuario", "");
        String savedPass = sharedPreferences.getString("senha", "");

        if (usuarioEditText.getText().toString().equals(savedUser) && senhaEditText.getText().toString().equals(savedPass)) {
            Toast.makeText(this, "Login bem-sucedido!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, IMCMain.class);
            startActivity(intent);


        } else {
            Toast.makeText(this, "Erro no login! Usuário ou senha incorretos.", Toast.LENGTH_SHORT).show();
        }
    }

    private void irRegistro() {
        Intent intent = new Intent(MainActivity.this, Registrar.class);
        startActivity(intent);
    }
}

