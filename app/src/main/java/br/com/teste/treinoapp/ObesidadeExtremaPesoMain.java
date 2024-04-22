package br.com.teste.treinoapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class ObesidadeExtremaPesoMain  extends  AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_obesidade_extrema_peso_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.ObesidadeExtremaPesoMain), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initObesidadeExtremaPesoBraco();
        initObesidadeExtremaPesoPerna();
        initObesidadeExtremaPesoCostas();
        initObesidadeExtremaPesoPeito();
        initObesidadeExtremaPesoOmbro();


    }

    private void initObesidadeExtremaPesoBraco() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Obesidade_Extrema_Braco, android.R.layout.simple_list_item_checked);
        ListView listView = findViewById(R.id.listViewBracoObesidadeExtrema);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }

    private void initObesidadeExtremaPesoPerna(){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Obesidade_Extrema_Perna, android.R.layout.simple_list_item_checked);
        ListView listView = findViewById(R.id.listViewPernaObesidadeExtrema);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }

    private void initObesidadeExtremaPesoCostas() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Obesidade_Extrema_Costas, android.R.layout.simple_list_item_checked);
        ListView listView = findViewById(R.id.listViewCostasObesidadeExtrema);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }

    private void initObesidadeExtremaPesoPeito() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Obesidade_Extrema_Peito, android.R.layout.simple_list_item_checked);
        ListView listView = findViewById(R.id.listViewPeitoObesidadeExtrema);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }

    private void initObesidadeExtremaPesoOmbro() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Obesidade_Extrema_Ombro, android.R.layout.simple_list_item_checked);
        ListView listView = findViewById(R.id.listViewOmbroObesidadeExtrema);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }

}
