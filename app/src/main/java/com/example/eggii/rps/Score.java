package com.example.eggii.rps;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Map;

/**
 * Class for game high score
 * */
public class Score extends AppCompatActivity {

    ListView lv_score;
    ArrayList<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        //Get score from shared preferences and show it to user
        SharedPreferences pref = getApplicationContext().getSharedPreferences("score", MODE_PRIVATE);

        lv_score = findViewById(R.id.lv_score);

        Map<String, ?> allEntries = pref.getAll();
            for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            list.add(entry.getKey() + " " + entry.getValue().toString());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        lv_score.setAdapter(adapter);
    }
}
