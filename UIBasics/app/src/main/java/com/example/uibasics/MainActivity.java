package com.example.uibasics;

import androidx.annotation.UiThread;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener,
        CompoundButton.OnCheckedChangeListener, RadioGroup.OnCheckedChangeListener {

    private TextView txtWelcome;
    private EditText editTextName;
    private Button btnHello;
    private CheckBox checkBoxHarryPotter, checkBoxMatrix, checkBoxArmageddon;
    private RadioGroup radioGroupMaritalStatus;
    private ProgressBar progressBar;

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnHello) {
            txtWelcome.setText("Hello " + editTextName.getText().toString());
            Toast.makeText(this, "Hello from a toast", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public boolean onLongClick(View v) {
        if (v.getId() == R.id.btnHello) {
            Toast.makeText(this, "Long Hello from a toast", Toast.LENGTH_LONG).show();
        }
        return true;

    }

    /**
     * For check boxes
     */
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (buttonView.getId() == R.id.checkBoxArmageddon) {
            if (isChecked) {
                Toast.makeText(this, "Nice choice", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Think again", Toast.LENGTH_SHORT).show();
            }
        }

    }

    /**
     * For radio groups
     */
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (group.getId() == R.id.radioGroupMaritalStatus) {
            if (checkedId == R.id.radioButtonSingle) {
                Toast.makeText(this, "You are single", Toast.LENGTH_SHORT).show();
                //progressBar.setVisibility(View.VISIBLE);
            } else if (checkedId == R.id.radioButtonMarried) {
                Toast.makeText(this, "You are married", Toast.LENGTH_SHORT).show();
                //progressBar.setVisibility(View.GONE);
            } else if (checkedId == R.id.radioButtonDivorced) {
                Toast.makeText(this, "You are divorced", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHello = findViewById(R.id.btnHello);
        txtWelcome = findViewById(R.id.txtWelcome);
        editTextName = findViewById(R.id.editTextName);
        checkBoxArmageddon = findViewById(R.id.checkBoxArmageddon);
        checkBoxHarryPotter = findViewById(R.id.checkBoxHarryPotter);
        checkBoxMatrix = findViewById(R.id.checkBoxMatrix);
        radioGroupMaritalStatus = findViewById(R.id.radioGroupMaritalStatus);
        progressBar = findViewById(R.id.progressBar);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    progressBar.incrementProgressBy(10);
                    SystemClock.sleep(500);
                }

                try {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (progressBar.getProgress() == 100) {
                                Toast.makeText(MainActivity.this, "Download Completed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        thread.start();

        btnHello.setOnClickListener(this);
        btnHello.setOnLongClickListener(this);

        checkBoxArmageddon.setOnCheckedChangeListener(this);
        checkBoxMatrix.setOnCheckedChangeListener(this);
        checkBoxHarryPotter.setOnCheckedChangeListener(this);

        radioGroupMaritalStatus.setOnCheckedChangeListener(this);

        int checkedRadioButton = radioGroupMaritalStatus.getCheckedRadioButtonId();

        if (checkedRadioButton == R.id.radioButtonSingle) {
            Toast.makeText(this, "You are single", Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.VISIBLE);
        } else if (checkedRadioButton == R.id.radioButtonMarried) {
            Toast.makeText(this, "You are married", Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.GONE);
        } else if (checkedRadioButton == R.id.radioButtonDivorced) {
            Toast.makeText(this, "You are divorced", Toast.LENGTH_SHORT).show();
        }


    }


    /**
     * First way to create click listener
     public void onHelloBtnClick(View view){
     TextView txtWelcome = findViewById(R.id.txtWelcome);
     txtWelcome.setText("Hello Jorge. Way 1!");
     }
     */

}