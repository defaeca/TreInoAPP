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
        try{
        float valor1 = Float.parseFloat(etPeso.getText().toString());
        float valor2 = Float.parseFloat(etAltura.getText().toString());
        float Resultado = valor1/(valor2*valor2);
        String resultadoCalculoFinal = String.valueOf(imc);
        tResultado.setText(resultadoCalculoFinal);

        navegarParaTelaApropriada(imc);
    } catch (NumberFormatException e) {
        tResultado.setText("Por favor, insira valores válidos.");
        }
    }

    private void navegarParaTelaApropriada(float imc) {
        if (imc < 18.5) {
            Intent intent = new Intent(this, AbaixoPesoMain.class);
            startActivity(intent);
        } else if (imc >= 18.5 && imc < 25) {
            startActivity(new Intent(this, PesoNormalMain.class));
        } else if (imc >= 25 && imc < 30) {
            startActivity(new Intent(this, ExcessoPesoMain.class));
        } else if (imc >= 30 && imc < 40) {
            startActivity(new Intent(this, ObesidadePesoMain.class));
        } else if (imc >= 40) {
            startActivity(new Intent(this, ObesidadeExtremaPesoMain.class));
        }
    }
}
    
