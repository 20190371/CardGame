package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageButton startButton;
    private ImageView firstMan1;
    private ImageView firstMan2;
    private ImageView secondMan1;
    private ImageView secondMan2;
    private TextView winRate;
    private TextView result;
    private int firstPlayerScore;
    private int secondPlayerScore;

    private int totalgames = 0;
    private int p1winrate = 0;


    private Random rand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = findViewById(R.id.gamestart);
        firstMan1 = findViewById(R.id.firstman1);
        firstMan2 = findViewById(R.id.firstman2);
        secondMan1 = findViewById(R.id.secondman1);
        secondMan2 = findViewById(R.id.secondman2);
        winRate = findViewById(R.id.winrate);
        result = findViewById(R.id.result);
        firstPlayerScore = 0;
        secondPlayerScore = 0;
        rand = new Random();


        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startGame();
                totalgames++;
            }
        });

    }

    private void startGame() {
        shuffleArray();
        int firstManCard1 = rand.nextInt(3) + 1;
        int firstManCard2 = rand.nextInt(3) + 1;
        int secondManCard1 = rand.nextInt(3) + 1;
        int secondManCard2 = rand.nextInt(3) + 1;

        switch (firstManCard1) {
            case 1:
                firstMan1.setImageResource(R.drawable.one);
                break;
            case 2:
                firstMan1.setImageResource(R.drawable.two);
                break;
            case 3:
                firstMan1.setImageResource(R.drawable.three);
                break;
        }

        switch (firstManCard2) {
            case 1:
                firstMan2.setImageResource(R.drawable.one);
                break;
            case 2:
                firstMan2.setImageResource(R.drawable.two);
                break;
            case 3:
                firstMan2.setImageResource(R.drawable.three);
                break;
        }

        switch (secondManCard1) {
            case 1:
                secondMan1.setImageResource(R.drawable.one);
                break;
            case 2:
                secondMan1.setImageResource(R.drawable.two);
                break;
            case 3:
                secondMan1.setImageResource(R.drawable.three);
                break;
        }

        switch (secondManCard2) {
            case 1:
                secondMan2.setImageResource(R.drawable.one);
                break;
            case 2:
                secondMan2.setImageResource(R.drawable.two);
                break;
            case 3:
                secondMan2.setImageResource(R.drawable.three);
                break;
        }

        firstPlayerScore = firstManCard1 + firstManCard2;
        secondPlayerScore = secondManCard1 + secondManCard2;
        if (firstPlayerScore > secondPlayerScore) {
            result.setText("플레이어1 승리");
            p1winrate++;
        } else if (firstPlayerScore < secondPlayerScore) {
            result.setText("플레이어2 승리");
        } else {
            result.setText("무승부");
            totalgames--;
        }
        double winRateValue = totalgames == 0 ? 0.0 : ((double) p1winrate / totalgames) * 100;
        winRate.setText(String.format("승률: %.2f%%", winRateValue));
    }


    void shuffleArray() {
        int[] array = {1, 2, 3, 1, 2, 3};

        for (int i = 0; i < array.length; i++) {
            int randomIndexToSwap = rand.nextInt(array.length);
            int temp = array[randomIndexToSwap];
            array[randomIndexToSwap] = array[i];
            array[i] = temp;
        }
    }
}
