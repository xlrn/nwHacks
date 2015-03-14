package com.example.nelson.carbongame;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import com.example.nelson.carbongame.model.LightSwitch;

import java.util.concurrent.TimeUnit;

import static com.example.nelson.carbongame.Lights.*;

public class MainActivity extends ActionBarActivity {


    private Chronometer chronometerLight;
    public TextView theScore;
    public int totalScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chronometerLight = (Chronometer) findViewById(R.id.chronometer2);
        totalScore = Score.getScore();
        setTheScore();


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void buttonOnClick (View v ) {
        Button button = (Button) v;
        startActivity(new Intent(getApplicationContext(), Lights.class));
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

    public void LightButton (View v) {
        Button button = (Button) v;
        Timer dur = new Timer();
        if(LightSwitch.startStop == false) {
            chronometerLight.setBase(SystemClock.elapsedRealtime());
            chronometerLight.start();
            dur.startTimer();
            LightSwitch.startStop = true;
        } else {
            chronometerLight.stop();
            chronometerLight.setBase(SystemClock.elapsedRealtime());
            dur.stopTimer();
            Score.calculateScore(-100);
            setTheScore();
            LightSwitch.startStop = false;
        }
    }
}