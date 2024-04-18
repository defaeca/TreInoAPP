package br.com.teste.treinoapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class IMCMain extends AppCompatActivity {

    private EditText etPeso;
    private  EditText etAltura;
    private TextView tResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imcmain);
        etPeso = findViewById(R.id.Peso);
        etAltura = findViewById(R.id.Altura);
        tResultado = findViewById(R.id.tResultado);
    }
    public void somas (View view){
        float valor1 = Float.parseFloat(etPeso.getText().toString());
        float valor2 = Float.parseFloat(etAltura.getText().toString());
        float Resultado = valor1/(valor2*valor2);
        String resultadoCalculoFinal = String.valueOf(Resultado);
        tResultado.setText(resultadoCalculoFinal);
    }
}
