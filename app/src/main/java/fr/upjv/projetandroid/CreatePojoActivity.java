package fr.upjv.projetandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreatePojoActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText phoneNumberEditText;
    private EditText emailEditText;
    private EditText addressEditText;
    private EditText companyEditText;

    //Les chmaps de textes sont récupérés pour instancier un nouvel objet Contact
    //Ce même objet est ensuite renvoyé à l'activité principale

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_pojo);

        nameEditText = findViewById(R.id.pojo_name_edittext);
        phoneNumberEditText = findViewById(R.id.pojo_phonenumber_edittext);
        emailEditText = findViewById(R.id.pojo_email_edittext);
        addressEditText = findViewById(R.id.pojo_address_edittext);
        companyEditText = findViewById(R.id.pojo_company_edittext);

        Button backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

        Button saveButton = findViewById(R.id.save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveContact();
            }
        });
    }

    private void saveContact() {
        String name = nameEditText.getText().toString();
        String phonenumber = phoneNumberEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String address = addressEditText.getText().toString();
        String company = companyEditText.getText().toString();

        Contact contact = new Contact(name, phonenumber, email, address, company);

        Intent resultIntent = new Intent();
        resultIntent.putExtra("contact", contact);

        setResult(RESULT_OK, resultIntent);
        finish();
    }


}