package com.example.x0;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean ga=true;
    int active =0;
    int [] game ={2,2,2,2,2,2,2,2,2};
    int [][] win = {{0,1,2},{3,4,5},{6,7,8},
                    {0,3,6},{1,4,7},{2,5,8},
                    {0,4,8},{2,4,6}} ;


    public void tap (View view ) {
        ImageView img = (ImageView) view;
        int tapped = Integer.parseInt(img.getTag().toString());
        if (game[tapped] == 2) {
            if (!ga) {
                reset(view);
            }
            game[tapped] = active;
            img.setTranslationY(-1000f);
            if (active == 0) {
                img.setImageResource(R.drawable.triangle);
                active = 1;
                TextView status = findViewById(R.id.status);
                status.setText("Player 2");
            } else {
                img.setImageResource(R.drawable.heart);
                active = 0;
                TextView status = findViewById(R.id.status);
                status.setText("Player 1");
            }

            img.animate().translationYBy(1000f).setDuration(300);
        }

        for (int[] win : win) {

            if (game[win[0]] == game[win[1]] && game[win[1]] == game[win[2]] && game[win[0]] != 2) {

                String winner;
                ga = false;
                if (game[win[0]] == 0) {
                    winner = "Player 1 Won ";

                } else {
                    winner = "Player 2 Won ";

                }


                TextView status = findViewById(R.id.status);
                status.setText(winner);

            }
        }


    }


    public void reset (View view)
    {
        ga =true;
        active=0;
        for(int i=0;i<game.length;i++)
            game[i]=2;


        ((ImageView)findViewById(R.id.img1)).setImageResource(0);
        ((ImageView)findViewById(R.id.img2)).setImageResource(0);
        ((ImageView)findViewById(R.id.img3)).setImageResource(0);
        ((ImageView)findViewById(R.id.img4)).setImageResource(0);
        ((ImageView)findViewById(R.id.img5)).setImageResource(0);
        ((ImageView)findViewById(R.id.img6)).setImageResource(0);
        ((ImageView)findViewById(R.id.img7)).setImageResource(0);
        ((ImageView)findViewById(R.id.img8)).setImageResource(0);
        ((ImageView)findViewById(R.id.img9)).setImageResource(0);
    }


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
