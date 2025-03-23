package com.example.sae_partiemohamed;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class filtre extends AppCompatActivity {
    private ImageView expandJeSuis, expandResultatPrincipal, expandSituationActuelle;
    private LinearLayout contentJeSuis, contentResultatPrincipal, contentSituationActuelle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filtre);

        // Initialiser les vues
        expandJeSuis = findViewById(R.id.expand_je_suis);
        expandResultatPrincipal = findViewById(R.id.expand_resultat_principal);
        expandSituationActuelle = findViewById(R.id.expand_situation_actuelle);

        contentJeSuis = findViewById(R.id.content_je_suis);
        contentResultatPrincipal = findViewById(R.id.content_resultat_principal);
        contentSituationActuelle = findViewById(R.id.content_situation_actuelle);

        expandJeSuis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleContent(contentJeSuis, expandJeSuis);
            }
        });

        expandResultatPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleContent(contentResultatPrincipal, expandResultatPrincipal);
            }
        });

        expandSituationActuelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleContent(contentSituationActuelle, expandSituationActuelle);
            }
        });
        ImageView close = findViewById(R.id.back_button);
        close.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
               finish();           }
        });

    }

    private void toggleContent(LinearLayout content, ImageView button) {
        if (content.getVisibility() == View.VISIBLE) {
            // Si le contenu est visible, le cacher
            content.setVisibility(View.GONE);
            button.setImageResource(R.drawable.add); // Changer l'icône pour "ajouter"
        } else {
            content.setVisibility(View.VISIBLE);
        }
        }
    }

