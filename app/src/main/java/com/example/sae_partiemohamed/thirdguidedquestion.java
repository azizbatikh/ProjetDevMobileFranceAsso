package com.example.sae_partiemohamed;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class thirdguidedquestion extends AppCompatActivity {@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.page_thirdguiddedquestion);
    View mainMenu = findViewById(R.id.thirdguidedquestion);

    ViewCompat.setOnApplyWindowInsetsListener(mainMenu, (v, insets) -> {
        int left = insets.getInsets(WindowInsetsCompat.Type.systemBars()).left;
        int top = insets.getInsets(WindowInsetsCompat.Type.systemBars()).top;
        int right = insets.getInsets(WindowInsetsCompat.Type.systemBars()).right;
        int bottom = insets.getInsets(WindowInsetsCompat.Type.systemBars()).bottom;

        v.setPadding(left, top, right, bottom);
        return insets;
    });
    RecyclerView rv = findViewById(R.id.listefirstquestions);
    rv.setLayoutManager(new LinearLayoutManager(this));
    List<question> questions = getQuestions();
    rv.setAdapter(new firstguidequestionadapter(questions));

    ImageView back = findViewById(R.id.backbutton);
    back.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    });
}



    public List<question> getQuestions() {
        List<question> liste = new ArrayList<>();
        liste.add(new question("Les maladies chroniques ?"));
        liste.add(new question("Le handicap ?"));
        liste.add(new question("La santé mentale ? "));
        liste.add((new question("Les maladies rares ?")));
        liste.add(new question("Le cancer ?"));
        liste.add(new question("Les troubles du sommeil ?"));
        liste.add(new question("La protection des droits des patients ?"));
        return liste;

    }
}
