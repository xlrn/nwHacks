package com.example.nelson.carbongame.UI;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
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
import com.example.nelson.carbongame.model.HighScoreManager.HighScoreManager;
import com.example.nelson.carbongame.model.HighScoreManager.Scores;
import com.example.nelson.carbongame.model.Score;
import com.example.nelson.carbongame.model.TimeBased;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class MainActivity extends ActionBarActivity {

    private Chronometer chronometerElec;
    private Chronometer chronometerApp;
    private Chronometer chronometerLight;
    private Chronometer chronometerCar;
    private Chronometer chronometerWater;
    private Chronometer actualTime;
    public TextView theScore;
    public int totalScore;
    public Timer lightTime;
    public Timer elecTime;
    public Timer carTime;
    public Timer waterTime;
    public Timer appTime;
    public Timer bikeTime;
    public Timer busTime;
    public Timer walkTime;
    private Chronometer.OnChronometerTickListener ChronoTick;
    private HighScoreManager hsm;
    public Scores newScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chronometerLight = (Chronometer) findViewById(R.id.chronometer2);
        chronometerCar = (Chronometer) findViewById(R.id.chronometer4);
        chronometerWater = (Chronometer) findViewById(R.id.chronometer5);
        chronometerElec = (Chronometer) findViewById(R.id.chronometer);
        chronometerApp = (Chronometer) findViewById(R.id.chronometer3);
        actualTime = (Chronometer) findViewById(R.id.chronometer7);
        actualTime.start();
        //stopTime();
        totalScore = Score.getScore();
        setTheScore();
        lightTime = new Timer();
        elecTime = new Timer();
        appTime = new Timer();
        carTime = new Timer();
        waterTime = new Timer();
        bikeTime = new Timer();
        busTime = new Timer();
        walkTime = new Timer();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
        theScore = (TextView) findViewById(R.id.scoretext);
        theScore.setText(Integer.toString(Score.getScore()));
    }
    public void LightButton (View v) {
        Button button = (Button) v;
        if(ButtonYesNo.Button1 == false) {
            chronometerLight.setBase(SystemClock.elapsedRealtime());
            chronometerLight.start();
            lightTime.startTimer();
            ButtonYesNo.Button1 = true;
        } else {
            chronometerLight.stop();
            chronometerLight.setBase(SystemClock.elapsedRealtime());
            lightTime.stopTimer();
            Score.calculateScore(TimeBased.calcScore(lightTime.getDuration(),
                    TimeBased.getLightRate()));
            setTheScore();
            ButtonYesNo.Button1 = false;
        }
    }
    public void ElectronicsButton (View v) {
        Button button = (Button) v;
        if(ButtonYesNo.Button2 == false) {
            chronometerElec.setBase(SystemClock.elapsedRealtime());
            chronometerElec.start();
            elecTime.startTimer();
            ButtonYesNo.Button2 = true;
        } else {
            chronometerElec.stop();
            chronometerElec.setBase(SystemClock.elapsedRealtime());
            elecTime.stopTimer();
            Score.calculateScore(TimeBased.calcScore(elecTime.getDuration(),
                    TimeBased.getElecRate()));
            setTheScore();
            ButtonYesNo.Button2 = false;
        }
    }
    public void ApplianceButton (View v) {
        Button button = (Button) v;
        if(ButtonYesNo.Button3 == false) {
            chronometerApp.setBase(SystemClock.elapsedRealtime());
            chronometerApp.start();
            appTime.startTimer();
            ButtonYesNo.Button3 = true;
        } else {
            chronometerApp.stop();
            chronometerApp.setBase(SystemClock.elapsedRealtime());
            appTime.stopTimer();
            Score.calculateScore(TimeBased.calcScore(appTime.getDuration(),
                    TimeBased.getLightRate()));
            setTheScore();
            ButtonYesNo.Button3 = false;
        }
    }
    public void CarButton (View v) {
        Button button = (Button) v;
        if(ButtonYesNo.Button4 == false) {
            chronometerCar.setBase(SystemClock.elapsedRealtime());
            chronometerCar.start();
            carTime.startTimer();
            ButtonYesNo.Button4 = true;
        } else {
            chronometerCar.stop();
            chronometerCar.setBase(SystemClock.elapsedRealtime());
            carTime.stopTimer();
            Score.calculateScore(TimeBased.calcScore(carTime.getDuration(),
                    TimeBased.getCarRate()));
            setTheScore();
            ButtonYesNo.Button4 = false;
        }
    }
    public void WaterButton (View v) {
        Button button = (Button) v;
        if(ButtonYesNo.Button5 == false) {
            chronometerWater.setBase(SystemClock.elapsedRealtime());
            chronometerWater.start();
            waterTime.startTimer();
            ButtonYesNo.Button5 = true;
        } else {
            chronometerWater.stop();
            chronometerWater.setBase(SystemClock.elapsedRealtime());
            waterTime.stopTimer();
            Score.calculateScore(TimeBased.calcScore(waterTime.getDuration(),
                    TimeBased.getWaterRate()));
            setTheScore();
            ButtonYesNo.Button5 = false;
        }
    }
    public void PaperButton (View v) {
        Button button = (Button) v;
        Score.calculateScore(2);
        setTheScore();
    }
    public void CansButton (View v) {
        Button button = (Button) v;
        Score.calculateScore(10);
        setTheScore();
    }
    public void PlantsButton (View v) {
        Button button = (Button) v;
        Score.calculateScore(15);
        setTheScore();
    }
    /*
    public void stopTime() {
        ChronoTick.onChronometerTick(actualTime);
        if(actualTime.getBase() + TimeUnit.MILLISECONDS.toHours(24)
                == SystemClock.elapsedRealtime()) {
            actualTime.stop();
            hsm.addScore(Score.getScore());
            actualTime.setBase(SystemClock.elapsedRealtime());
        }
    } */

    public void HighScoreMaker(View v) {
        Button more = (Button) v;
        //hsm.addScore(Score.getScore());
        more.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("High Scores");
                alert.setMessage("DRINK WATER");
                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // User cancelled the dialog
                    }
                });

                AlertDialog msg = alert.create();
                msg.show();
            }
        });
    }

    public void Activity2Go(View v) {
        Button stuff = (Button) v;
        Intent myIntent = new Intent (MainActivity.this, Activity2.class);
        MainActivity.this.startActivity(myIntent);
    }
}