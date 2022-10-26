package com.example.contactapproom.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactapproom.MainActivity;
import com.example.contactapproom.R;
import com.example.contactapproom.db.entity.Contact;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.MyViewHolder> {

    ArrayList<Contact> contactArrayList = new ArrayList<>();
    private Context context ;
    private MainActivity mainActivity ;


    public ContactsAdapter( Context context,ArrayList<Contact> contactArrayList, MainActivity mainActivity) {
        this.contactArrayList = contactArrayList;
        this.context = context;
        this.mainActivity = mainActivity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_list_item,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int positions) {
        Contact c = contactArrayList.get(positions);
        holder.name.setText(c.getName());
        holder.email.setText(c.getEmail());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.addAndEditContacts(true,c,positions);
            }
        });

    }

    @Override
    public int getItemCount() {
        return contactArrayList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView name ;
        private TextView email ;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.name = itemView.findViewById(R.id.name);
            this.email = itemView.findViewById(R.id.email);

        }
    }

}
