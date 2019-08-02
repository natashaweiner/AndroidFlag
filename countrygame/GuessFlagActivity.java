package com.example.countrygame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GuessFlagActivity extends AppCompatActivity {

    String corranw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_flag);

        ImageView fl1 = findViewById(R.id.flag1);
        ImageView fl2 = findViewById(R.id.flag2);
        ImageView fl3 = findViewById(R.id.flag3);
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

        corranw = countries[r2];
        TextView x = this.findViewById(R.id.fname);
        x.setText(corranw);
        x.setVisibility(View.VISIBLE);



    }

    public void flag1clicked(View view) {
        TextView w = this.findViewById(R.id.wrong);
        w.setVisibility(View.VISIBLE);
    }

    public void flag2clicked(View view) {
        TextView w = this.findViewById(R.id.corr);
        w.setVisibility(View.VISIBLE);
    }

    public void flag3clicked(View view) {
        TextView w = this.findViewById(R.id.wrong);
        w.setVisibility(View.VISIBLE);
    }

    public void res(View view) {
        this.recreate();
    }
}
