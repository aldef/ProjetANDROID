package fr.upjv.projetandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewPojosActivity extends AppCompatActivity {

    private ArrayList<Contact> contacts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pojos);

        Intent intent = getIntent();
        contacts = (ArrayList<Contact>)intent.getSerializableExtra("pojoList");

        //Les évènements sont récupérés sous forme de chaines de caractère (ToString()) et ajoutés dans la ListView
        ListView listView = findViewById(R.id.list_view);
        ArrayAdapter<Contact> adapter = new ArrayAdapter<Contact>(this, android.R.layout.simple_list_item_1, contacts);
        listView.setAdapter(adapter);

        Button backButton = findViewById(R.id.backButtonView);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

    }


}