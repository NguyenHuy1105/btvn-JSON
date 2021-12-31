package com.example.baitapvenha;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ItemViewHolder> {

    List<IteamModel> items;
    private ViewGroup parent;
    private int viewType;

    public Adapter(List<IteamModel> jsonArray) {
        this.items=items;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        IteamModel item = items.get(position);
        holder.textName.setText(item.getName());
        holder.textEmail.setText(item.getEmail());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView textName;
        TextView textEmail;
        TextView textphone;
        TextView textaddress;
        TextView textconpany;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            textName = itemView.findViewById(R.id.text_name);
            textEmail = itemView.findViewById(R.id.text_email);
            textphone = itemView.findViewById(R.id.phone);
            textaddress = itemView.findViewById(R.id.address);
            textconpany = itemView.findViewById(R.id.company);
        }
    }
}