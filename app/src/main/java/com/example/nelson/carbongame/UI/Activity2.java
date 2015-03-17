package com.example.nelson.carbongame.UI;
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
import com.example.nelson.carbongame.R;
import com.example.nelson.carbongame.model.ButtonYesNo;
import com.example.nelson.carbongame.model.Score;
import com.example.nelson.carbongame.model.TimeBased;
public class Activity2 extends ActionBarActivity {
    private Chronometer chronometerBus;
    private Chronometer chronometerWalk;
    private Chronometer chronometerBike;
    public TextView theScore;
    public int totalScore;
    public Timer busTime;
    public Timer walkTime;
    public Timer bikeTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);
        chronometerBus = (Chronometer) findViewById(R.id.chronometer11);
        chronometerBike = (Chronometer) findViewById(R.id.chronometer12);
        chronometerWalk = (Chronometer) findViewById(R.id.chronometer13);
        totalScore = Score.getScore();
        setTheScore();
        busTime = new Timer();
        bikeTime = new Timer();
        walkTime = new Timer();
        ButtonYesNo.Button10 = false;
        ButtonYesNo.Button11 = false;
        ButtonYesNo.Button12 = false;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity2, menu);
        return true;
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
        theScore = (TextView) findViewById(R.id.scoretext2);
        theScore.setText(Integer.toString(Score.getScore()));
    }
    public void BusButton (View v) {
        Button button = (Button) v;
        if(ButtonYesNo.Button10 == false) {
            chronometerBus.setBase(SystemClock.elapsedRealtime());
            chronometerBus.start();
            busTime.startTimer();
            ButtonYesNo.Button10 = true;
        } else {
            chronometerBus.stop();
            chronometerBus.setBase(SystemClock.elapsedRealtime());
            busTime.stopTimer();
            Score.calculateScore(TimeBased.calcScore(busTime.getDuration(),
                    TimeBased.getBusRate()));
            setTheScore();
            ButtonYesNo.Button10 = false;
        }
    }
    public void BikeButton (View v) {
        Button button = (Button) v;
        if(ButtonYesNo.Button11 == false) {
            chronometerBike.setBase(SystemClock.elapsedRealtime());
            chronometerBike.start();
            bikeTime.startTimer();
            ButtonYesNo.Button11 = true;
        } else {
            chronometerBike.stop();
            chronometerBike.setBase(SystemClock.elapsedRealtime());
            bikeTime.stopTimer();
            Score.calculateScore(TimeBased.calcScore(bikeTime.getDuration(),
                    TimeBased.getBikeRate()));
            setTheScore();
            ButtonYesNo.Button11 = false;
        }
    }
    public void WalkButton (View v) {
        Button button = (Button) v;
        if(ButtonYesNo.Button12 == false) {
            chronometerWalk.setBase(SystemClock.elapsedRealtime());
            chronometerWalk.start();
            walkTime.startTimer();
            ButtonYesNo.Button12 = true;
        } else {
            chronometerWalk.stop();
            chronometerWalk.setBase(SystemClock.elapsedRealtime());
            walkTime.stopTimer();
            Score.calculateScore(TimeBased.calcScore(walkTime.getDuration(),
                    TimeBased.getWalkRate()));
            setTheScore();
            ButtonYesNo.Button12 = false;
        }
    }
}