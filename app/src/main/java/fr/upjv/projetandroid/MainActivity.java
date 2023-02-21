package fr.upjv.projetandroid;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Contact> pojoList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button createPojoButton = findViewById(R.id.createPojoMainButton);
        createPojoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreatePojoActivity.class);
                addContactLauncher.launch(intent);
            }
        });

        Button viewPojosButton = findViewById(R.id.viewPojosMainButton);
        viewPojosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewPojosActivity.class);
                intent.putExtra("pojoList", pojoList);
                startActivity(intent);
            }
        });
    }

    private ActivityResultLauncher<Intent> addContactLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK) {
                        Contact contact = (Contact) result.getData().getSerializableExtra("contact");
                        pojoList.add(contact);

                        Snackbar.make(findViewById(android.R.id.content), getResources().getString(R.string.savedcontact_alert), Snackbar.LENGTH_SHORT).show();
                    }
                }
            });


}