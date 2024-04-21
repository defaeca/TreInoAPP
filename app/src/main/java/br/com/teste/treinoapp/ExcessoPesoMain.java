package br.com.teste.treinoapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ExcessoPesoMain extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_peso_normal_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initExcessoPesoBraco();
        initExcessoPesoPerna();
        initExcessoPesoCostas();
        initExcessoPesoPeito();
        initExcessoPesoOmbro();


    }

    private void initExcessoPesoBraco() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Excesso_Braco, android.R.layout.simple_list_item_checked);
        ListView listView = findViewById(R.id.listViewExcessoBraco);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }

    private void initExcessoPesoPerna()
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Excesso_Perna, android.R.layout.simple_list_item_checked);
        ListView listView = findViewById(R.id.listViewExcessoPerna);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }

    private void initExcessoPesoCostas() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Excesso_Costas, android.R.layout.simple_list_item_checked);
        ListView listView = findViewById(R.id.listViewExcessoCostas);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }

    private void initExcessoPesoPeito() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Excesso_Peito, android.R.layout.simple_list_item_checked);
        ListView listView = findViewById(R.id.listViewExcessoPeito);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }

    private void initExcessoPesoOmbro() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Excesso_Ombro, android.R.layout.simple_list_item_checked);
        ListView listView = findViewById(R.id.listViewExcessoOmbro);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }

}