package com.example.register_form;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void onBtnClick(View view) {
        TextView txtFirstName = findViewById(R.id.txtFirstName);
        TextView txtLastName = findViewById(R.id.txtLastName);
        TextView txtEmail = findViewById(R.id.txtEmail);

        EditText editFirstName = findViewById(R.id.editFirstName);
        EditText editLastName = findViewById(R.id.editLastName);
        EditText editEmail = findViewById(R.id.editEmail);

        String editFirstNameContent = editFirstName.getText().toString();
        String editLastNameContent = editLastName.getText().toString();
        String editEmailContent = editEmail.getText().toString();

        txtFirstName.setText("First Name: " + editFirstNameContent);
        txtLastName.setText("Last Name: " + editLastNameContent);
        txtEmail.setText("Email: " + editEmailContent);
    }
}