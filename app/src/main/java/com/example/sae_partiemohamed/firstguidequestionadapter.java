package com.example.sae_partiemohamed;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class firstguidequestionadapter extends RecyclerView.Adapter<firstguidequestionadapter.questionview>{
    private List<question> firstguidequestions;

    public firstguidequestionadapter(List<question> firstguidequestions) {
        this.firstguidequestions = firstguidequestions;
    }

    @NonNull
    @Override
    public questionview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragmentquestion, parent, false);
        return new questionview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull questionview holder, int position) {
        question question = firstguidequestions.get(position);
        holder.nameTextView.setText(question.getQuestion());
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), result.class);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return firstguidequestions.size();
    }


    static class questionview extends RecyclerView.ViewHolder {
        TextView nameTextView;
        LinearLayout container;

        public questionview(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.question);
            container = itemView.findViewById(R.id.questioncontainer);
        }
    }

}
