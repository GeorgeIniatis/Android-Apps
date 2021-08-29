package com.example.snackbar_and_cardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ConstraintLayout parent;
    private Button buttonShowSnackbar;
    private MaterialCardView cardView;

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonShowSnackbar) {
            showSnackBar();
        }else if(v.getId() == R.id.cardView){
            Toast.makeText(this, "Card View Clicked", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parent = findViewById(R.id.parent);
        buttonShowSnackbar = findViewById(R.id.buttonShowSnackbar);
        cardView = findViewById(R.id.cardView);

        buttonShowSnackbar.setOnClickListener(this);
        cardView.setOnClickListener(this);
    }

    private void showSnackBar() {
        Snackbar.make(parent, "This is a snackbar", Snackbar.LENGTH_INDEFINITE)
                .setAction("Retry", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Clicked on Retry", Toast.LENGTH_SHORT).show();
                    }
                })
                .setActionTextColor(Color.RED)
                .setTextColor(Color.YELLOW)
                .show();
    }


}