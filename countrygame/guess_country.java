package com.example.countrygame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.util.Log;
import android.widget.TextView;

public class guess_country extends AppCompatActivity {
    Spinner spin;
    private static final String LOG_TAG =
            guess_country.class.getSimpleName();

    //holds the correct anwser
    String corranw;
    String userSelectedCountry;

    Button s;
    TextView c;
    int r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_country);
        s = (Button) findViewById(R.id.sub);
        c = this.findViewById(R.id.countname);

        ImageView image = findViewById(R.id.flag);
        String [] countries = getResources().getStringArray(R.array.countries_array);
        String [] corr = getResources().getStringArray(R.array.corresponding);
        r =  (int) (Math.random() * 255);
        int temp = getResources().getIdentifier(corr[r], "drawable", "com.example.countrygame");
        image.setImageResource(temp);

        //placing the correct answer into string will be used to compare later
       corranw = countries[r];
        Log.d("guess country anw", corranw);

        spin = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> x = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,countries );
        spin.setAdapter(x);




    }

    public void submitResponse(View view) {

        //if statements

        Log.d("guess country", "Button (submit a guessed country clicked!" + corranw);
        s = (Button) findViewById(R.id.sub);
        c = this.findViewById(R.id.countname);
        String h = corranw;
        userSelectedCountry = spin.getSelectedItem().toString();
        if (s.getText().toString().equals("Next")){
            this.recreate();
        }
        else {
            if (h.equals(userSelectedCountry)) {
                TextView x = this.findViewById(R.id.correct);
                x.setVisibility(View.VISIBLE);
                s.setText("Next");
            } else {
                TextView y = this.findViewById(R.id.wrong);
                y.setVisibility(View.VISIBLE);
                c.setText(h);
                c.setVisibility(View.VISIBLE);
                s.setText("Next");
            }
        }
    }
}

