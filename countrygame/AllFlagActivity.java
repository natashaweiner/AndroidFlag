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

public class AllFlagActivity extends AppCompatActivity {

    // This will hold the correct answers of the 3 boxes
    String corranw1;
    String corranw2;
    String corranw3;
    EditText e;
    EditText e2;
    EditText e3;
    int counter;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_flag);

        ImageView fl1 = findViewById(R.id.one);
        ImageView fl2 = findViewById(R.id.two);
        ImageView fl3 = findViewById(R.id.three);
        //set up arrays
        String [] countries = getResources().getStringArray(R.array.countries_array);
        String [] corr = getResources().getStringArray(R.array.corresponding);
        //generates a random ID and puts the image into temp
        int r =  (int) (Math.random() * 255);
        int r2 =  (int) (Math.random() * 255);
        int r3 =  (int) (Math.random() * 255);

        int temp = getResources().getIdentifier(corr[r], "drawable", "com.example.countrygame");
        fl1.setImageResource(temp);
        int temp2 = getResources().getIdentifier(corr[r2], "drawable", "com.example.countrygame");
        fl2.setImageResource(temp2);
        int temp3 = getResources().getIdentifier(corr[r3], "drawable", "com.example.countrygame");
        fl3.setImageResource(temp3);

        corranw1 = countries[r];
        corranw2 = countries[r2];
        corranw3 = countries[r3];
        counter = 0;
        score = 0;
        e = findViewById(R.id.inputText1);
        e2 = findViewById(R.id.inputText2);
        e3 = findViewById(R.id.inputText3);
        Log.d("guess country anw", corranw1 + corranw2 + corranw3);



    }

    public void subThree(View view) {
        Log.d("guess country", "Button (submit a guessed country clicked!" + corranw1 + corranw2 + corranw3);
        //will hold users first input
        TextView trfl = this.findViewById(R.id.tf);
        Button ball = (Button) findViewById(R.id.buttall);

        TextView c1 = this.findViewById(R.id.count1);
        TextView c2 = this.findViewById(R.id.count2);
        TextView c3 = this.findViewById(R.id.count3);

        TextView sc = this.findViewById(R.id.numb);

        counter++;
        // strings will hold the text that the user types into the plain text editor
        String s = e.getText().toString();

        String s2 = e2.getText().toString();

        String s3 = e3.getText().toString();

        if (ball.getText().toString().equals("Next")) {
            this.recreate();
        } else {

            if ((s.equals(corranw1)) && (s2.equals(corranw2)) && (s3.equals(corranw3))) {
                trfl.setVisibility(View.VISIBLE);
                e.setTextColor(Color.GREEN);
                e.setEnabled(false);
                e2.setTextColor(Color.GREEN);
                e2.setEnabled(false);
                e3.setTextColor(Color.GREEN);
                e3.setEnabled(false);
                score = 3;
                sc.setText(score);
                ball.setText("Next");
            }
            // if any of them are wrong
            else if (!(s.equals(corranw1)) || !(s2.equals(corranw2)) || !(s3.equals(corranw3))){
                if (counter == 3){
                    trfl.setText("WRONG!");
                    trfl.setTextColor(Color.RED);
                    trfl.setVisibility(View.VISIBLE);
                    if (!(s.equals(corranw1))){
                        c1.setText(corranw1);
                    }
                    if (!(s2.equals(corranw2))){
                        c2.setText(corranw2);
                    }
                    if (!(s3.equals(corranw3))){
                        c3.setText(corranw3);
                    }
                    ball.setText("Next");
                }
                if ((s.equals(corranw1))){
                    e.setTextColor(Color.GREEN);
                    e.setEnabled(false);
                    score +=1;
                    if (s2.equals(corranw2)){
                        e2.setTextColor(Color.GREEN);
                        e2.setEnabled(false);
                        e3.setTextColor(Color.RED);
                        score += 1;
                    }
                    else {
                        e2.setTextColor(Color.RED);
                        e3.setTextColor(Color.RED);
                    }
                }
               else if ((s2.equals(corranw2))){
                    e2.setTextColor(Color.GREEN);
                    e2.setEnabled(false);
                    score +=1;
                    if (s3.equals(corranw3)){
                        e3.setTextColor(Color.GREEN);
                        e3.setEnabled(false);
                        score+=1;
                    }
                    else{
                        e3.setTextColor(Color.RED);
                    }
                    e.setTextColor(Color.RED);
                }
              else if ((s3.equals(corranw3))){
                    e3.setTextColor(Color.GREEN);
                    e3.setEnabled(false);
                    e.setTextColor(Color.RED);
                    e2.setTextColor(Color.RED);
                    score+=1;
                }
                else {
                    e.setTextColor(Color.RED);
                    e2.setTextColor(Color.RED);
                    e3.setTextColor(Color.RED);
                }
                sc.setText("" +score);
            }
        }
    }

    // the following 3 methods will clear text from a field
    public void clear1(View view) {
        e.setText("");

    }

    public void clear2(View view) {
        e2.setText("");
    }

    public void clear3(View view) {
        e3.setText("");

    }
}
