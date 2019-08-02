package com.example.countrygame;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class GuessHintActivity extends AppCompatActivity {

    String corranw;
    int l;
    TextView d;
    int counter;
    TextView q;
    String [] arr;
    String [] danw;
    String [] s2;
    String s;
    String tempr;
    String t;
    EditText e;
    Button subm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guess_hint);

        //places the image on the random flag spot
        ImageView image = findViewById(R.id.RandFlag);
        //set up arrays
        String [] countries = getResources().getStringArray(R.array.countries_array);
        String [] corr = getResources().getStringArray(R.array.corresponding);
        //generates a random ID and puts the image into temp
        int r =  (int) (Math.random() * 255);
        // holds the name of the country and the length (l)
        corranw =  countries[r];
         l = corranw.length();
         counter = 0;
        int temp = getResources().getIdentifier(corr[r], "drawable", "com.example.countrygame");
        image.setImageResource(temp);
        arr = new String[corranw.length()];

        // holds the textbox w dashes
        d = this.findViewById(R.id.dashes);
        t = "";

        for (int i =0; i< l; i++){
            t = t + "-";
        }

        danw = new String[t.length()];
        s2 = new String[1];
        d.setText(t);
         e = findViewById(R.id.editText);

         danw = t.split("");
         arr = corranw.split("");
         q = findViewById(R.id.w);
        Log.d("guess country", "Button (submit a guessed country clicked!" + corranw );
        //intialize
        tempr ="";

        subm = findViewById(R.id.sub);

    }

    public void subm(View view) {

        s = e.getText().toString();
        s2 = s.split("");
        tempr = "";


        // if next button is clicked restart game
        if (subm.getText().toString().equals("Next")) {
            this.recreate();
        }
        else {
            if (corranw.contains(s)) {
                for (int i = 0; i <= corranw.length(); i++) {
                    if ((arr[i]).equals(s)) {
                        danw[i] = s;
                    }
                }
                // to string essentially
                for (int j = 0; j < danw.length; j++) {
                    tempr = tempr + danw[j];
                }
                d.setText(tempr);

                // check if the dashes are all filled and equal the final answer
                if (corranw.equals(tempr)) {
                    q.setTextColor(Color.GREEN);
                    q.setText("CORRECT!");
                    q.setVisibility(View.VISIBLE);
                    subm.setText("Next");
                }

            } else {
                counter++;
                if (counter == 3) {
                    q.setVisibility(View.VISIBLE);
                    subm.setText("Next");
                }
            }
        }
    }
}
