package br.com.teste.treinoapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.text.BreakIterator;

public class Registrar extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registrar);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
    }

        public void voltar(View v) {
            Intent intent = new Intent(br.com.teste.treinoapp.Registrar.this, MainActivity.class);
            startActivity(intent);
        }
        public void login(View v) {

            EditText loginET = findViewById(R.id.editTextLogin);
            EditText senhaET = findViewById(R.id.editTextSenha);
            EditText ipServidorET = findViewById(R.id.editTextIpServidor);
            EditText alturaET = findViewById(R.id.editTextAltura);
            EditText pesoET = findViewById(R.id.editTextPeso);

            String login = loginET.getText().toString();
            String senha = senhaET.getText().toString();
            float altura = Float.parseFloat(alturaET.getText().toString());
            float peso = Float.parseFloat(pesoET.getText().toString());
            float imc = peso / (altura * altura);

            Login l = new Login();
            l.login = login;
            l.senha = senha;
            l.altura = altura;
            l.peso = peso;
            l.imc = imc;


            try {
                String ip = ipServidorET.getText().toString();

                String url = "http://" + ip + ":8081/login";
                String json = l.toJSON();
                RequestQueue requestQueue = Volley.newRequestQueue(this);
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        this::tratarOK, this::tratarErro) {
                    @Override
                    public String getBodyContentType() {
                        return "application/json; charset=utf-8";
                    }

                    @Override
                    public byte[] getBody() throws AuthFailureError {
                        return json.getBytes();
                    }
                };
                requestQueue.add(stringRequest);
            } catch (Exception ex) {
                ex.printStackTrace();
                Toast.makeText(this, "Erro:" + ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }


        private void tratarOK(String json) {
            RespostaServer resp = new RespostaServer();
            resp.fromJson(json);
            if (resp.validacao.equals("OK")) {
                Toast.makeText(this, "Criação de conta bem sucedida", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(br.com.teste.treinoapp.Registrar.this, MainActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Erro" + resp.erro, Toast.LENGTH_SHORT).show();
            }
        }
        private void tratarErro(VolleyError s) {
            s.printStackTrace();
            Toast.makeText(this, s.getMessage() != null ? s.getMessage() : "Erro geral", Toast.LENGTH_SHORT).show();
        }
}