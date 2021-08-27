package com.example.listview_and_spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener,
        AdapterView.OnItemSelectedListener {

    private ListView citiesList;
    private Spinner studentsSpinner;
    private ArrayList<String> cities, students;

    /**
     * For the list view
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId() == R.id.citiesList) {
            Toast.makeText(this, cities.get(position) + " Selected", Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * For the spinner - dropdown list
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId() == R.id.studentsSpinner) {
            //Toast.makeText(this, students.get(position) + " Selected", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, studentsSpinner.getSelectedItem().toString() + " Selected", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        if (parent.getId() == R.id.studentsSpinner) {
            Toast.makeText(this, "Nothing Selected", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        studentsSpinner = findViewById(R.id.studentsSpinner);

        /**
         * Using @strings/students
         students = new ArrayList<>();
         students.add("George");
         students.add("John");
         students.add("Jorge");
         students.add("Mike");

         ArrayAdapter<String> studentsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, students);
         studentsSpinner.setAdapter(studentsAdapter);
         */
        studentsSpinner.setOnItemSelectedListener(this);

        citiesList = findViewById(R.id.citiesList);

        cities = new ArrayList<>();
        cities.add("Nicosia");
        cities.add("Athens");
        cities.add("Rome");
        cities.add("Kabul");

        ArrayAdapter<String> citiesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cities);
        citiesList.setAdapter(citiesAdapter);
        citiesList.setOnItemClickListener(this);
    }


}