package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView contactsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactsRecyclerView = findViewById(R.id.contactsRecyclerView);

        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Jorge", "jogeo98@hotmail.com", "https://images.all-free-download.com/images/graphiclarge/the_kitten_514202.jpg"));
        contacts.add(new Contact("Mike", "mike@hotmail.com", "https://images.all-free-download.com/images/graphiclarge/the_kitten_514202.jpg"));
        contacts.add(new Contact("Nick", "nick@hotmail.com", "https://images.all-free-download.com/images/graphiclarge/the_kitten_514202.jpg"));

        ContactsRecyclerViewAdapter adapter = new ContactsRecyclerViewAdapter(this);
        adapter.setContacts(contacts);

        contactsRecyclerView.setAdapter(adapter);
        contactsRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }
}