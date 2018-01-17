package com.example.csaba.sharedpreferences7;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    public static final String mypreference = "mypref";
    public SharedPreferences sharedpreferences;

    public int quantityTwo;
    public int quantityThree;
    public int valueTwo;
    public int valueThree;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("main page");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**inicialization*/
        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

        /**get sharedpreferences from page 2*/
        valueTwo = sharedpreferences.getInt("saved", 0);
        if (valueTwo > 0) {
            TextView second = (TextView) findViewById(R.id.scorePageTwo);
            second.setText("" + valueTwo);
        } else {}

        /**get sharedpreferences from page 2*/
        valueThree = sharedpreferences.getInt("saved3", 0);
        if (valueThree > 0) {
            TextView second = (TextView) findViewById(R.id.scorePageThree);
            second.setText("" + valueThree);
        } else {}

        /**count total*/
        int totalValue = valueTwo + valueThree;
        TextView total = (TextView) findViewById(R.id.totalScore);
        total.setText("" + totalValue);


    }


    public void page2 (View view){
        Intent i = new Intent(this, PageTwo.class);
        startActivity(i);
    }

    public void page3 (View view){
        Intent i = new Intent(this, PageThree.class);
        startActivity(i);
    }

    public void clearTotal (View view){
        valueTwo = 0;
        valueThree = 0;
        TextView clear2 = (TextView) findViewById(R.id.scorePageTwo);
        clear2.setText("0");
        TextView clear3 = (TextView) findViewById(R.id.scorePageThree);
        clear3.setText("0");
        TextView clear = (TextView) findViewById(R.id.totalScore);
        clear.setText("0");

        /**make sharedpreferences values 0!!!*/
        quantityTwo = 0;
        quantityThree = 0;
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putInt("saved", quantityTwo);
        editor.putInt("saved3", quantityThree);
        editor.commit();

    }

}
