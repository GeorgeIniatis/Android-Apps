package com.example.advanced_register_form;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";

    private Button buttonUploadProfileImage, buttonRegister;
    private EditText editName, editEmail, editPassword, editConfirmPassword;
    private TextView textErrorName, textErrorEmail, textErrorPassword, textErrorConfirmPassword;
    private RadioGroup radiogroupGender;
    private RadioButton radioButton;
    private Spinner spinnerCountry;
    private CheckBox checkBoxAcceptPrivacyPolicy;
    private ConstraintLayout constraintLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        buttonUploadProfileImage.setOnClickListener(this);
        buttonRegister.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonUploadProfileImage) {
            Toast.makeText(this, "Uploading Image", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.buttonRegister) {
            initRegister();
        }

    }

    private void initRegister() {
        Log.d(TAG, "initRegister: Started");

        if (validateData()) {
            if (checkBoxAcceptPrivacyPolicy.isChecked()) {
                showSnackBar();
            } else {
                Toast.makeText(this, "Please accept our agreement policy", Toast.LENGTH_SHORT).show();
            }
        } else {
            return;
        }

    }

    private void showSnackBar() {
        Log.d(TAG, "showSnackBar: Started");

        textErrorName.setVisibility(View.GONE);
        textErrorEmail.setVisibility(View.GONE);
        textErrorPassword.setVisibility(View.GONE);
        textErrorConfirmPassword.setVisibility(View.GONE);

        String name = editName.getText().toString();
        String email = editEmail.getText().toString();
        String country = spinnerCountry.getSelectedItem().toString();
        String gender = "";

        radioButton = findViewById(radiogroupGender.getCheckedRadioButtonId());
        gender = radioButton.getText().toString();

        String snackBarText = "Name: " + name +
                "\nEmail: " + email +
                "\nCountry: " + country +
                "\nGender: " + gender;

        Snackbar.make(constraintLayout, snackBarText, Snackbar.LENGTH_INDEFINITE)
                .setAction("Dismiss", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        editName.setText("");
                        editEmail.setText("");
                        editPassword.setText("");
                        editConfirmPassword.setText("");
                        checkBoxAcceptPrivacyPolicy.setChecked(false);
                        radioButton = findViewById(radiogroupGender.getCheckedRadioButtonId());
                        radioButton.setChecked(false);

                    }
                })
                .show();
    }

    private boolean validateData() {
        Log.d(TAG, "validateData: Stared");

        textErrorName.setVisibility(View.GONE);
        textErrorEmail.setVisibility(View.GONE);
        textErrorPassword.setVisibility(View.GONE);
        textErrorConfirmPassword.setVisibility(View.GONE);

        if (editName.getText().toString().equals("")) {
            textErrorName.setVisibility(View.VISIBLE);
            textErrorName.setText("Name cannot be blank");
            return false;
        }

        if (editEmail.getText().toString().equals("")) {
            textErrorEmail.setVisibility(View.VISIBLE);
            textErrorEmail.setText("Email cannot be blank");
            return false;
        }

        if (editPassword.getText().toString().equals("")) {
            textErrorPassword.setVisibility(View.VISIBLE);
            textErrorPassword.setText("Password cannot be blank");
            return false;
        }

        if (editConfirmPassword.getText().toString().equals("")) {
            textErrorConfirmPassword.setVisibility(View.VISIBLE);
            textErrorConfirmPassword.setText("Password cannot be blank");
            return false;
        }

        if (!editPassword.getText().toString().equals(editConfirmPassword.getText().toString())) {
            textErrorConfirmPassword.setVisibility(View.VISIBLE);
            textErrorConfirmPassword.setText("Passwords do not match!");
            return false;
        }

        if (radiogroupGender.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Please choose a gender", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void initViews() {
        Log.d(TAG, "initViews: Started");

        buttonUploadProfileImage = findViewById(R.id.buttonUploadProfileImage);
        buttonRegister = findViewById(R.id.buttonRegister);

        editName = findViewById(R.id.editName);
        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);
        editConfirmPassword = findViewById(R.id.editConfirmPassword);

        textErrorName = findViewById(R.id.textErrorName);
        textErrorEmail = findViewById(R.id.textErrorEmail);
        textErrorPassword = findViewById(R.id.textErrorPassword);
        textErrorConfirmPassword = findViewById(R.id.textErrorConfirmPassword);

        radiogroupGender = findViewById(R.id.radiogroupGender);

        spinnerCountry = findViewById(R.id.spinnerCountry);

        checkBoxAcceptPrivacyPolicy = findViewById(R.id.checkBoxAcceptPrivacyPolicy);

        constraintLayout = findViewById(R.id.constraintLayout);
    }


}