package com.example.a3lab3_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Tamagotchi.MyInterface {

    LinearLayout layout1;
    LinearLayout layout2;
    LinearLayout layout3;
    LinearLayout layout4;

    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;

    ArrayList<Tamagotchi> tamagotchis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout1 = findViewById(R.id.tama1);
        layout2 = findViewById(R.id.tama2);
        layout3 = findViewById(R.id.tama3);
        layout4 = findViewById(R.id.tama4);

        textView1 = findViewById(R.id.text1);
        textView2 = findViewById(R.id.text2);
        textView3 = findViewById(R.id.text3);
        textView4 = findViewById(R.id.text4);



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
    public void updateStatus(int foodLeft, int id) {

        switch (id) {
            case 0:
                textView1.setText("Food Left: " + foodLeft);
                break;

            case 1:
                textView2.setText("Food Left: " + foodLeft);
                break;

            case 2:
                textView3.setText("Food Left: " + foodLeft);
                break;

            case 3:
                textView4.setText("Food Left: " + foodLeft);
                break;
        }

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
        }

    }
}
