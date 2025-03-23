package com.example.sae_partiemohamed;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Page2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recherche);
        View mainMenu = findViewById(R.id.page2);

        // Configuration de la SearchView
        SearchView sv = findViewById(R.id.searchView);
        // Correction: Ne pas rechercher directement les éléments internes de SearchView par ID
        // Utiliser les méthodes de l'API SearchView à la place
        sv.setQueryHint("Rechercher...");

        // Personnaliser la couleur du texte (si nécessaire, utiliser un autre approche)
        int id = sv.getContext().getResources().getIdentifier("android:id/search_src_text", null, null);
        TextView textView = sv.findViewById(id);
        if (textView != null) {
            textView.setTextColor(getResources().getColor(R.color.white));
            textView.setHintTextColor(getResources().getColor(R.color.white));
        }

        // Personnaliser l'icône de recherche
        int searchIconId = sv.getContext().getResources().getIdentifier("android:id/search_button", null, null);
        ImageView searchIcon = sv.findViewById(searchIconId);
        if (searchIcon != null) {
            searchIcon.setScaleType(ImageView.ScaleType.FIT_END);
            searchIcon.setColorFilter(Color.WHITE);
            searchIcon.setPadding(0, 0, 20, 0);
        }

        // Configuration du TextView avec soulignement
        TextView filterText = findViewById(R.id.textFilter);
        filterText.setPaintFlags(filterText.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        // Configuration du RecyclerView
        RecyclerView recyclerView = findViewById(R.id.listedons);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

// Ajouter un décorateur d'item pour ajouter des marges uniforme
        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.grid_spacing);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, spacingInPixels, true));

// Définir l'adaptateur
        List<association> associations = getAssociations();
        recyclerView.setAdapter(new AssociationAdapter(associations));



        // Configuration des insets pour la gestion des barres système
        ViewCompat.setOnApplyWindowInsetsListener(mainMenu, (v, insets) -> {
            int left = insets.getInsets(WindowInsetsCompat.Type.systemBars()).left;
            int top = insets.getInsets(WindowInsetsCompat.Type.systemBars()).top;
            int right = insets.getInsets(WindowInsetsCompat.Type.systemBars()).right;
            int bottom = insets.getInsets(WindowInsetsCompat.Type.systemBars()).bottom;

            v.setPadding(left, top, right, bottom);
            return insets;
        });
        TextView addFiltersText = findViewById(R.id.textFilter);
        addFiltersText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Page2.this, filtre.class);
                startActivity(intent);
            }
        });
             ImageView retour = findViewById(R.id.backbutton);
             retour.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     finish();
                 }
             });


    }

    // Correction de la méthode: type de retour spécifique, nom de classe avec majuscule, et ajout du troisième élément manquant
    public List<association> getAssociations() {
        List<association> liste = new ArrayList<>();
        liste.add(new association("Ami", R.drawable.ami));
        liste.add(new association("AAAVAM", R.drawable.aaavam));
        liste.add(new association("Association 3", R.drawable.ami)); // Ajout d'un nom pour la troisième association

        return liste;
    }
}