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

public class secondguidedquestion extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_secondguide);
        View mainMenu = findViewById(R.id.secondguidedquestion);

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
        liste.add(new question("Avez Vous des problemes physiques"));
        liste.add(new question("Avez Vous des problemes liés au cours ?"));
        liste.add(new question("Avez vous des problemes de concentration "));
        liste.add((new question("Avez vous des problemes de communication ?")));
        liste.add(new question("Avez vous des problemes de fatigue repetés  ?"));
        return liste;

    }

}

