package br.com.teste.treinoapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class ObesidadePesoMain extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_obesidade_peso_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.ObesidadePesoMain), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initObesidadePesoBraco();
        initObesidadePesoPerna();
        initObesidadePesoCostas();
        initObesidadePesoPeito();
        initObesidadePesoOmbro();
    }

    private void initObesidadePesoBraco() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Obesidade_Braco, android.R.layout.simple_list_item_checked);
        ListView listView = findViewById(R.id.listViewBracoObesidade);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }

    private void initObesidadePesoPerna(){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Obesidade_Perna, android.R.layout.simple_list_item_checked);
        ListView listView = findViewById(R.id.listViewPernaObesidade);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }

    private void initObesidadePesoCostas() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Obesidade_Costas, android.R.layout.simple_list_item_checked);
        ListView listView = findViewById(R.id.listViewCostasObesidade);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }

    private void initObesidadePesoPeito() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Obesidade_Peito, android.R.layout.simple_list_item_checked);
        ListView listView = findViewById(R.id.listViewPeitoObesidade);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }

    private void initObesidadePesoOmbro() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Obesidade_Ombro, android.R.layout.simple_list_item_checked);
        ListView listView = findViewById(R.id.listViewOmbroObesidade);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }
}
