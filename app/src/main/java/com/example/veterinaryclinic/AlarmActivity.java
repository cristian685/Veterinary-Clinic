package com.example.veterinaryclinic;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Date;

public class AlarmActivity extends AppCompatActivity {

    TimePicker timePicker;
    TextView textView;
    int mHour;
    int mMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        timePicker = findViewById(R.id.timePicker);
        textView = findViewById(R.id.setTV);

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int hourOfDay, int minute) {
                 mHour = hourOfDay;
                 mMinute = minute;
                 textView.setText("");
                 textView.setText(textView.getText().toString() + " " + mHour + ":"  + mMinute);
            }
        });
    }

    public void setTimer(View view){
        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        Date date = new Date();

        Calendar calendarNow = Calendar.getInstance();
        Calendar calendarAlarm = Calendar.getInstance();

        calendarNow.setTime(date);
        calendarAlarm.setTime(date);

        calendarAlarm.set(Calendar.HOUR_OF_DAY, mHour);
        calendarAlarm.set(Calendar.MINUTE, mMinute);
        calendarAlarm.set(Calendar.SECOND, 0);

        if(calendarAlarm.before(calendarNow)){
            calendarAlarm.add(Calendar.DATE, 1);
        }

        Intent intent = new Intent(AlarmActivity.this, MyBroadCastReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(AlarmActivity.this, 24444, intent, 0);
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendarAlarm.getTimeInMillis(), pendingIntent);
    }
}