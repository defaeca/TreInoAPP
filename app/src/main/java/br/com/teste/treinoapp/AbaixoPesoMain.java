package br.com.teste.treinoapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AbaixoPesoMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_abaixo_peso_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.AbaixoPesoMain), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initAbaixoPesoBraco();
        initAbaixoPesoPerna();
        initAbaixoPesoCostas();
        initAbaixoPesoPeito();
        initAbaixoPesoOmbro();
    }

    private void initAbaixoPesoBraco() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Abaixo_Braco, android.R.layout.simple_list_item_checked);
        ListView listView = findViewById(R.id.listViewBracoAbaixo);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }

    private void initAbaixoPesoPerna(){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Excesso_Perna, android.R.layout.simple_list_item_checked);
        ListView listView = findViewById(R.id.listViewPernaExcesso);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }

    private void initAbaixoPesoCostas() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Abaixo_Costas, android.R.layout.simple_list_item_checked);
        ListView listView = findViewById(R.id.listViewCostasAbaixo);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }

    private void initAbaixoPesoPeito() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Abaixo_Peito, android.R.layout.simple_list_item_checked);
        ListView listView = findViewById(R.id.listViewPeitoAbaixo);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }

    private void initAbaixoPesoOmbro() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Abaixo_Ombro, android.R.layout.simple_list_item_checked);
        ListView listView = findViewById(R.id.listViewOmbroAbaixo);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }

}
