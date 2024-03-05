package com.example.kaloriapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final int[] totalKalori = {0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        TextView totalKaloriVisning = findViewById(R.id.totalKaloriView);

        ArrayList<String> kaloriListe = new ArrayList<>();

        ListView listeVisning = findViewById(R.id.listeVisning);
        ArrayAdapter<String> arr = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, kaloriListe);
        listeVisning.setAdapter(arr);

        EditText kalorier = findViewById(R.id.kalorier);
        kalorier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String kalori = kalorier.getText().toString();
                if (!kalori.equals("")) {
                    kaloriListe.add(kalori);
                    listeVisning.setAdapter(arr);

                    totalKalori[0] = 0;
                    for (String k : kaloriListe) {
                        int kInt = Integer.parseInt(k);
                        totalKalori[0] += kInt;
                    }

                }
                kalorier.setText("");

                String tot = Integer.toString(totalKalori[0]);
                totalKaloriVisning.setText(tot);
            }
        });

        Button reset = findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                totalKalori[0] = 0;
                String tot = Integer.toString(totalKalori[0]);
                totalKaloriVisning.setText(tot);
                kaloriListe.clear();
                arr.clear();
                listeVisning.setAdapter(arr);
            }
        });


    }
}