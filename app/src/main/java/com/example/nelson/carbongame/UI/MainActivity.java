package com.example.nelson.carbongame.UI;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;


import com.example.nelson.carbongame.R;
import com.example.nelson.carbongame.UI.Activity2;

import java.util.concurrent.TimeUnit;
public class MainActivity extends ActionBarActivity {
    private Chronometer chronometer;
    public TextView theScore;
    public int totalScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chronometer = (Chronometer) findViewById(R.id.chronometer);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void buttonOnClick (View v ) {
        Button button = (Button) v;
        startActivity (new Intent(getApplicationContext(), Activity2.class));

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setTheScore() {
        theScore = (TextView) findViewById(R.id.scoretext);
        theScore.setText(Integer.toString(Score.getScore()));
    }
}