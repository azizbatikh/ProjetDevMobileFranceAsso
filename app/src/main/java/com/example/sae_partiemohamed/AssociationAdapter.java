package com.example.sae_partiemohamed;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AssociationAdapter extends RecyclerView.Adapter<AssociationAdapter.AssociationViewHolder> {
    private List<association> associations;

    public AssociationAdapter(List<association> associations) {
        this.associations = associations;
    }

    @NonNull
    @Override
    public AssociationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragmentassociation, parent, false);
        return new AssociationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AssociationViewHolder holder, int position) {
        association association = associations.get(position);
        holder.nameTextView.setText(association.getNom());
        holder.imageView.setImageResource(association.getNumimage());
    }

    @Override
    public int getItemCount() {
        return associations.size();
    }

    static class AssociationViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView nameTextView;
        LinearLayout container;

        public AssociationViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.associationImage);
            nameTextView = itemView.findViewById(R.id.associationName);
            container = itemView.findViewById(R.id.associationContainer);
        }
    }
}