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

    String totalKcal = "0";
    String newKcal = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        TextView totalKcalView = findViewById(R.id.totalKcal);

        ArrayList<String> kcalList = new ArrayList<>();
        ListView lw = findViewById(R.id.listKcal);

        ArrayAdapter<String> arr = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, kcalList);
        lw.setAdapter(arr);

        Button reset = findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                totalKcal = "0";
                newKcal = "";
                totalKcalView.setText("0");
                kcalList.clear();
                arr.clear();
                lw.setAdapter(arr);
            }
        });

        // Get the buttons
        Button button0 = findViewById(R.id.button0);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button[] buttons = {
                button0, button1, button2, button3, button4,
                button5, button6, button7, button8, button9
        };


        for (int i=0; i<10; i++) {
            Button b = buttons[i];
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String number = b.getText().toString();
                    if (number.equals("0") && newKcal.equals("")) {
                        // No leading zero
                    }
                    else if (newKcal.length() > 3) {
                        // Don't want to overfill the screen
                    }
                    else {
                        newKcal += number;
                        totalKcalView.setText(totalKcal+ "+(" + newKcal + ")");
                    }
                }
            });
        }

        // Add button
        Button add = findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!newKcal.equals("")) {
                    totalKcal = addIntStrings(totalKcal, newKcal);
                    totalKcalView.setText(totalKcal);
                    kcalList.add(newKcal);
                    lw.setAdapter(arr);
                    newKcal = "";
                }
            }
        });

    }
    public String addIntStrings(String s1, String s2) {
        int i1 = Integer.parseInt(s1);
        int i2 = Integer.parseInt(s2);
        int tot = i1 + i2;
        return "" + tot;
    }
}