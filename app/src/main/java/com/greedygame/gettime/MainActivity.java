package com.greedygame.gettime;

import android.content.Context;
import android.content.SharedPreferences;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.icu.util.TimeZone;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.textView);
        TextView currentTime = (TextView) findViewById(R.id.textView1);
        TextView closeTime = (TextView) findViewById(R.id.textView3);
        TextView newTime = (TextView) findViewById(R.id.textView2);
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+1:00"));
        Date currentLocalTime = cal.getTime();
        DateFormat date = new SimpleDateFormat("HH:mm a");
        date.setTimeZone(TimeZone.getTimeZone("GMT+5:30"));
        String localTime = date.format(currentLocalTime);
        currentTime.setText(localTime);
        SharedPreferences prefs = this.getSharedPreferences(
                "com.greedygame.gettime", Context.MODE_PRIVATE);

        String dateTimeKey = "com.greedygame.gettime";
        String l = prefs.getString(dateTimeKey, "no data exists");

        newTime.setText(l);
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onPause() {
        super.onPause();
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+1:00"));
        Date currentLocalTime = cal.getTime();
        DateFormat date = new SimpleDateFormat("HH:mm a");
        date.setTimeZone(TimeZone.getTimeZone("GMT+5:30"));
        String localTime = date.format(currentLocalTime);
        SharedPreferences prefs = this.getSharedPreferences(
                "com.greedygame.gettime", Context.MODE_PRIVATE);
        String dateTimeKey = "com.greedygame.gettime";
        prefs.edit().putString(dateTimeKey,localTime.toString()).commit();
    }
}


