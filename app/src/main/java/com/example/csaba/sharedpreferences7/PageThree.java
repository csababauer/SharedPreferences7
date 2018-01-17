package com.example.csaba.sharedpreferences7;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by csaba on 1/11/2018.
 */

public class PageThree extends AppCompatActivity {

    public int quantityThree = 0;
    public static final String mypreference = "mypref";
    public SharedPreferences sharedpreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("page 3");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page3);

        /**inicialization*/
        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

    }


    public void increment (View view){
        quantityThree = quantityThree + 1;
        displayScore(quantityThree);
    }

    public void decrement (View view){
        quantityThree = quantityThree - 1;
        displayScore(quantityThree);
    }

    public void displayScore (int number){
        TextView quantityView = (TextView) findViewById(R.id.score);
        quantityView.setText("" + number);
    }

    public void clear (View view){
        save();
        displayScore(0);
        quantityThree = 0;
    }


    public void save () {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putInt("saved3", quantityThree);
        editor.commit();
    }
    public void revert (View view) {
        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

        int saved = sharedpreferences.getInt("saved3", 0);
        quantityThree = saved;
        displayScore(quantityThree);
    }


    public void back (View view){
        Intent iThree = new Intent(this, MainActivity.class);
        startActivity(iThree);
    }
}