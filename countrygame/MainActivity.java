package com.example.countrygame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG =
            MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Button (guess country) clicked!");
        Intent i = new Intent (this, guess_country.class);
        startActivity(i);

    }

    public void guessHintActivity(View view) {
        Log.d(LOG_TAG, "Button (guess hint) clicked!");
        Intent x = new Intent (this, GuessHintActivity.class);
        startActivity(x);
    }

    public void guessFlagActivity(View view) {
        Log.d(LOG_TAG, "Button (guess flag) clicked!");
        Intent y = new Intent (this, GuessFlagActivity.class);
        startActivity(y);

    }

    public void guessAllFlagActivity(View view) {
        Log.d(LOG_TAG, "Button (guess all flag) clicked!");
        Intent z = new Intent (this, AllFlagActivity.class);
        startActivity(z);

    }
}
