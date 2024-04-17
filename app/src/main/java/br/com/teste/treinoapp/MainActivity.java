package br.com.teste.treinoapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText etLogin = findViewById(R.id.Login);
        EditText etSenha = findViewById(R.id.Senha);
        Button bLogin = findViewById(R.id.Logar);

        bLogin.setOnClickListener(v -> {
            String login = etLogin.getText().toString();
            String senha = etSenha.getText().toString();
            if ("Treino".equals(login) && "123456".equals(senha)){
                Intent intent;
                intent = new Intent(MainActivity.this, IMCMain.class);
                startActivities(new Intent[]{intent});
            }else{
                Snackbar.make(v, "Usuario ou Senha incorreta.", Snackbar.LENGTH_INDEFINITE)
                        .setAction("Action", null)
                        .show();

            }
        });
    }
}