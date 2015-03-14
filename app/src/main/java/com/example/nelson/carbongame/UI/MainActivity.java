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

        Button button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Activity2.class);
                startActivityForResult(intent, 0);
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void buttonOnClick (View v ) {
        Button button = (Button) v;
        startActivity(new Intent(this, Activity2.class));
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
        if(ButtonYesNo.Button1 == false) {
            chronometerLight.setBase(SystemClock.elapsedRealtime());
            chronometerLight.start();
            dur.startTimer();
            ButtonYesNo.Button1 = true;
        } else {
            chronometerLight.stop();
            chronometerLight.setBase(SystemClock.elapsedRealtime());
            dur.stopTimer();
            Score.calculateScore(-100);
            setTheScore();
            ButtonYesNo.Button1 = false;
        }
    }

    public void PaperButton (View v) {
        Button button = (Button) v;
        Score.calculateScore(2);
        setTheScore();
    }
}