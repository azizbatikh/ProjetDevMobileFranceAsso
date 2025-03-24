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
        liste.add(new association("Adepa", R.drawable.adepa));
        liste.add(new association("Alcool addiction vie libre", R.drawable.aavl));
        liste.add(new association("AFA", R.drawable.afa));
        liste.add(new association("Afdoc", R.drawable.afdoc));
        liste.add(new association("Afsetrics", R.drawable.afsetrics));
        liste.add(new association("ASBH", R.drawable.asbh));
        liste.add(new association("Autisme France", R.drawable.autismefrance));
        liste.add(new association("Endo", R.drawable.endo));
        liste.add(new association("Fibromyalgie", R.drawable.fibromyalgie));
        liste.add(new association("France Rein", R.drawable.francerein));
        liste.add(new association("Ligue Contre le Cancer", R.drawable.liguecontrelecancer));
        liste.add(new association("Marfans", R.drawable.marfans));
        liste.add(new association("Petits Frères des Pauvres", R.drawable.petitsfreresdespauvres));
        liste.add(new association("Planning Familial", R.drawable.planningfamilial));
        liste.add(new association("Renaldo", R.drawable.renaldo));
        liste.add(new association("RES", R.drawable.res));
        liste.add(new association("Réseau DES France", R.drawable.reseaudesfrance));
        liste.add(new association("Retour", R.drawable.retour));
        liste.add(new association("Schizo Oui", R.drawable.schizooui));
        liste.add(new association("Sos Hépatite", R.drawable.soshepatite));
        liste.add(new association("Transhépate", R.drawable.transhepate));
        liste.add(new association("UFAL", R.drawable.ufal));
        liste.add(new association("UFC", R.drawable.ufc));
        liste.add(new association("UNAF", R.drawable.unaf));
        liste.add(new association("UNAFAM", R.drawable.unafam));
        liste.add(new association("UNAFTC", R.drawable.unaftc));
        liste.add(new association("UNAPECLE", R.drawable.unapecle));
        liste.add(new association("UNAPEI", R.drawable.unapei));
        liste.add(new association("Vaincre la Mucoviscidose", R.drawable.vaincrelamuco));
        liste.add(new association("VMEH", R.drawable.vmeh));
        liste.add(new association("AAVL", R.drawable.aavl));
        liste.add(new association("ADEPA", R.drawable.adepa));
        liste.add(new association("ADM", R.drawable.adm));
        liste.add(new association("ADMD", R.drawable.admd));
        liste.add(new association("AFA", R.drawable.afa));
        liste.add(new association("AFSEP", R.drawable.afsep));
        liste.add(new association("AFVD", R.drawable.afvd));
        liste.add(new association("AINP", R.drawable.ainp));
        liste.add(new association("AMADYS", R.drawable.amadys));
        liste.add(new association("AMALYSTE", R.drawable.amalyste));
        liste.add(new association("AMIS DE LA SANTÉ", R.drawable.amisdelasante));
        liste.add(new association("ANDARREAL", R.drawable.andarreal));
        liste.add(new association("APAJH", R.drawable.apajh));
        liste.add(new association("APODEC", R.drawable.apodec));
        liste.add(new association("ASSOCIATION DES BRÛLÉS DE FRANCE", R.drawable.associationdesbrulesdefrance));
        liste.add(new association("AVIAM", R.drawable.aviam));
        liste.add(new association("CADUS", R.drawable.cadus));
        liste.add(new association("CNAFAL", R.drawable.cnafal));
        liste.add(new association("CNAFC", R.drawable.cnafc));
        liste.add(new association("CNAO", R.drawable.cnao));
        liste.add(new association("E3M", R.drawable.e3m));
        liste.add(new association("EFAPPE", R.drawable.efappe));
        liste.add(new association("EPILEPSIE", R.drawable.epilepsie));
        liste.add(new association("FFD", R.drawable.ffd));
        liste.add(new association("FFDSP", R.drawable.ffdsp));
        liste.add(new association("FNAR", R.drawable.fnar));
        liste.add(new association("FRANCE ALZHEIMER", R.drawable.francealzheimer));
        liste.add(new association("FRANCE COEUR POUMON", R.drawable.francecoeurpoumon));
        liste.add(new association("FRANCE DÉPRESSION", R.drawable.francedepression));
        liste.add(new association("FRANCE LYME", R.drawable.francelyme));
        liste.add(new association("FRANCE PARKINSON", R.drawable.franceparkinson));
        liste.add(new association("HSP", R.drawable.hsp));
        liste.add(new association("JAMALV", R.drawable.jamalv));
        liste.add(new association("LE LIEN", R.drawable.lelien));
        liste.add(new association("PRIARTEM", R.drawable.priartem));
        liste.add(new association("SCLÉRODERMIE", R.drawable.sclerodermie));
        liste.add(new association("SESAME AUTISME", R.drawable.sesameautisme));
        liste.add(new association("UFMV", R.drawable.ufmv));
        liste.add(new association("VIVRE COMME AVANT", R.drawable.vivrecommeavant));

        return liste;
    }
}