package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class ContactsRecyclerViewAdapter extends RecyclerView.Adapter<ContactsRecyclerViewAdapter.ViewHolder> {

    private ArrayList<Contact> contacts = new ArrayList<>();
    private Context context;

    public ContactsRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contacts_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtContactName.setText(contacts.get(position).getName());
        holder.txtContactEmail.setText(contacts.get(position).getEmail());
        holder.contactCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, contacts.get(holder.getAdapterPosition()).getName() + " Selected", Toast.LENGTH_SHORT).show();
            }
        });

        Glide.with(context)
                .asBitmap()
                .load(contacts.get(position).getImageUrl())
                .into(holder.imageContact);

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txtContactName, txtContactEmail;
        private ImageView imageContact;
        private MaterialCardView contactCardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtContactName = itemView.findViewById(R.id.txtContactName);
            txtContactEmail = itemView.findViewById(R.id.txtContactEmail);
            imageContact = itemView.findViewById(R.id.imageContact);
            contactCardView = itemView.findViewById(R.id.contactCardView);
        }
    }
}
