package com.example.touni.umpirebuddy;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView strikeText;
    TextView ballText;
    int strikeInt = 0;
    int ballInt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        strikeText = findViewById(R.id.strikeCount);
        ballText = findViewById(R.id.ballCount);
    }

    public void ballInc (View view) {
        if (ballInt < 3) {
            ballInt++;
            ballText.setText(String.valueOf(ballInt));
        } else {
            AlertDialog.Builder mWalkBuilder = new AlertDialog.Builder(MainActivity.this);

            mWalkBuilder.setMessage("WALK!").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ballInt = 0;
                    strikeInt = 0;
                    ballText.setText(String.valueOf(ballInt));
                    strikeText.setText(String.valueOf(strikeInt));
                }
            }).setNegativeButton("", null).setCancelable(false);

            AlertDialog alert = mWalkBuilder.create();
            alert.show();
        }
    }

    public void strikeInc (View view) {
        if (strikeInt < 2) {
            strikeInt++;
            strikeText.setText(String.valueOf(strikeInt));
        } else {
            AlertDialog.Builder mStrikeBuilder = new AlertDialog.Builder(MainActivity.this);

            mStrikeBuilder.setMessage("OUT!").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    strikeInt = 0;
                    ballInt = 0;
                    strikeText.setText(String.valueOf(strikeInt));
                    ballText.setText(String.valueOf(ballInt));
                }
            }).setNegativeButton("", null).setCancelable(false);

            AlertDialog alert = mStrikeBuilder.create();
            alert.show();
        }
    }
}
