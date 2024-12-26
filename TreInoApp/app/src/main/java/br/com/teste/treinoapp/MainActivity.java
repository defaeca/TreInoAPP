package br.com.teste.treinoapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
    }
    public void irRegistro(View v) {
        Intent intent = new Intent(MainActivity.this, Registrar.class);
        startActivity(intent);
    }
    public void logar(View v) {
        //Recuperar os campos da Tela
        EditText loginET = findViewById(R.id.editTextLogin);
        EditText senhaET = findViewById(R.id.editTextSenha);
        EditText ipServidorET = findViewById(R.id.editTextIpServidor);

        String login = loginET.getText().toString();
        String senha = senhaET.getText().toString();

        //recuperar os valores da tela
        Login l = new Login();
        l.login = login;
        l.senha = senha;
        l.imc = imc;

        String ip = ipServidorET.getText().toString();
        try {
            String url = "http://" + ip + ":8081/login";
            String json = l.toJSON();
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                    s -> tratarOK(s), s -> tratarErro(s)) {
                @Override
                public String getBodyContentType() {
                    return "application/json; charset=utf-8";
                }
                @Override public byte[] getBody() throws AuthFailureError {
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
            //Mostrar a outra tela.
            Toast.makeText(this, "Sucesso", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Erro " + resp.erro, Toast.LENGTH_SHORT).show();
        }
    }

    private void tratarErro(VolleyError s) {
        Toast.makeText(this, s.getMessage(), Toast.LENGTH_SHORT).show();
    }
}

//    public void login(View v) {
//
//        EditText loginET = findViewById(R.id.editTextLogin);
//        EditText senhaET = findViewById(R.id.editTextSenha);
//        EditText ipServidorET = findViewById(R.id.editTextIpServidor);
//
//        //recuperar os valores da tela
//        Login l = new Login();
//        l.login = loginET.getText().toString();
//        l.senha = senhaET.getText().toString();
//
//        String ip = ipServidorET.getText().toString();
//        try {
//            String url = "http://" + ip + ":8081/login";
//            String json = l.toJSON();
//            RequestQueue requestQueue = Volley.newRequestQueue(this);
//            StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
//                    s -> tratarOK(s), s -> tratarErro(s)) {
//                @Override
//                public String getBodyContentType() {
//                    return "application/json; charset=utf-8";
//                }
//                @Override public byte[] getBody() throws AuthFailureError {
//                    return json.getBytes();
//                }
//            };
//            requestQueue.add(stringRequest);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            Toast.makeText(this, "Erro:" + ex.getMessage(), Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    private void tratarOK(String json) {
//        RespostaServer resp = new RespostaServer();
//        resp.fromJson(json);
//        if (resp.validacao.equals("OK")) {
//            //Mostrar a outra tela.
//            Toast.makeText(this, "Sucesso", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(this, "Erro" + resp.erro, Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    private void tratarErro(VolleyError s) {
//        s.printStackTrace();
//        Toast.makeText(this, s.getMessage() != null ? s.getMessage() : "Erro geral", Toast.LENGTH_SHORT).show();
//    }
