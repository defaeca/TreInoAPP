package br.com.teste.treinoapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PesoNormalMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_peso_normal_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.PesoNormalMain), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initPesoNormalBraco();
        initPesoNormalPerna();
        initPesoNormalCostas();
        initPesoNormalPeito();
        initPesoNormalOmbro();


    }

    private void initPesoNormalBraco() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Normal_Braco, android.R.layout.simple_list_item_checked);
        ListView listView = findViewById(R.id.listViewBracoNormal);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }

    private void initPesoNormalPerna() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Normal_Perna, android.R.layout.simple_list_item_checked);
        ListView listView = findViewById(R.id.listViewPernaNormal);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }

    private void initPesoNormalCostas() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Normal_Costas, android.R.layout.simple_list_item_checked);
        ListView listView = findViewById(R.id.listViewCostasNormal);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }

    private void initPesoNormalPeito() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Normal_Peito, android.R.layout.simple_list_item_checked);
        ListView listView = findViewById(R.id.listViewPeitoNormal);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }

    private void initPesoNormalOmbro() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Normal_Ombro, android.R.layout.simple_list_item_checked);
        ListView listView = findViewById(R.id.listViewOmbroNormal);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }
}
