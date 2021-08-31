package com.example.fonts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtHello;
    private Button buttonChangeFont;
    private Typeface typeface;

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonChangeFont)

            txtHello.setTypeface(typeface);
            Toast.makeText(this, "Font Changed!", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        typeface = ResourcesCompat.getFont(this, R.font.opensans_bold);

        txtHello = findViewById(R.id.txtHello);
        buttonChangeFont = findViewById(R.id.buttonChangeFont);
        buttonChangeFont.setOnClickListener(this);
    }


}