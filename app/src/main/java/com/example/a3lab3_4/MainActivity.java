package com.example.a3lab3_4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Tamagotchi.MyInterface {


    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;

    LinearLayout layout1;
    LinearLayout layout2;
    LinearLayout layout3;
    LinearLayout layout4;

    int counter = 0;


    ArrayList<Tamagotchi> tamagotchis;
    ArrayList<TextView> textViews;
    ArrayList<LinearLayout> layouts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout1 = findViewById(R.id.tama1);
        layout2 = findViewById(R.id.tama2);
        layout3 = findViewById(R.id.tama3);
        layout4 = findViewById(R.id.tama4);

        layouts = new ArrayList<>();

        layouts.add(layout1);
        layouts.add(layout2);
        layouts.add(layout3);
        layouts.add(layout4);

        textView1 = findViewById(R.id.text1);
        textView2 = findViewById(R.id.text2);
        textView3 = findViewById(R.id.text3);
        textView4 = findViewById(R.id.text4);

        textViews = new ArrayList<>();

        textViews.add(textView1);
        textViews.add(textView2);
        textViews.add(textView3);
        textViews.add(textView4);

        createFarm();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.tama1:
                tamagotchis.get(0).setFood();
                break;

            case R.id.tama2:
                tamagotchis.get(1).setFood();
                break;

            case R.id.tama3:
                tamagotchis.get(2).setFood();
                break;

            case R.id.tama4:
                tamagotchis.get(3).setFood();
                break;
        }

    }

    @Override
    public void updateStatus(final int foodLeft, final int id) {

        MainActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {

                if (foodLeft < 1 ||  foodLeft > 20) {
                    layouts.get(id).setBackgroundColor(Color.parseColor("red"));
                    counter--;
                }

                textViews.get(id).setText("Food Left: " + foodLeft);

                if (counter == 0) {
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Game Over")
                            .setPositiveButton(android.R.string.yes, null)
                            .show();
                }

            }
        });

    }

    public void createFarm() {

        tamagotchis = new ArrayList<Tamagotchi>();
        Tamagotchi tamagotchi1 = new Tamagotchi(this, 0);
        Tamagotchi tamagotchi2 = new Tamagotchi(this, 1);
        Tamagotchi tamagotchi3 = new Tamagotchi(this, 2);
        Tamagotchi tamagotchi4 = new Tamagotchi(this, 3);

        tamagotchis.add(tamagotchi1);
        tamagotchis.add(tamagotchi2);
        tamagotchis.add(tamagotchi3);
        tamagotchis.add(tamagotchi4);

        for (Tamagotchi tamagotchi : tamagotchis) {
            tamagotchi.start();
            counter++;
        }

    }
}
