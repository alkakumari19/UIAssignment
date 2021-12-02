package com.example.stopwatch;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Chronometer;
import android.widget.TextView;

import com.example.stopwatch.databinding.ActivityMainBinding;
import com.google.android.filament.View;

public class MainActivity extends Activity {

    //creating variable that we will be using for the stopwatch
    private Chronometer chronometer;
    // this line of code will check if the chronometer is running or not
    private boolean running;

    private TextView mTextView;
    private ActivityMainBinding binding;
    //this variable will be used to start the timer at zero
    private long pauseOffset;
    private Object v;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //assigning the chronometer
        chronometer = findViewById(R.id.chronometer);
        //This changes the format of the chronometer
        chronometer.setFormat("Time: %s");



        //creating the buttons

        public void startTheChronometer(View v) {
            //checking if the time is running or not
            //if it is not running then it won't work
            //this is checking if running is false then make running = true
            if (!running) {
                //This line is making the chronometer start the time at zero
                //we also do - pauseOffset i because it pushes the base furthur into the path
                chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
                chronometer.start();
                running = true;
            }
        }

        public void pauseTheChronometer(View v) {
            // checks if running is true
            // then if running is true than we set running to false
            if (running) {
                //
                chronometer.stop();
                //calculating the offset
                pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase();
                running = false;
            }
        }

        public void resetTheChronometer(View v){
            //this line sets the time back to zero
            chronometer.setBase(SystemClock.elapsedRealtime());
            //we reset the chrometer by setting to back to zero
            pauseOffset = 0;
        }


        mTextView = binding.button;
    }
}