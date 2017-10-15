package com.mah.mybroadcastex;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

public class Catcher extends BroadcastReceiver {
    /*
    * Multiply in 1000 to convert time from milli to second :D
    * */
    private static final int PERIOD=5*1000;
    public Catcher() {}

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
            Toast.makeText(context, "you restart you phone now =)))) ", Toast.LENGTH_LONG).show();

            // do any thing you want
            Intent intent1=new Intent(context, MainActivity.class);
            intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent1);
        }
        if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            Toast.makeText(context, " internet connection changed ", Toast.LENGTH_LONG).show();

            /**
             *  for example i set the alarm to work when user open wifi if my app depends on web :)
             */
            ///ALARM
            scheduleAlarms(context);

        }

        if (intent.getAction().equals("android.location.PROVIDERS_CHANGED")) {
            Toast.makeText(context, "in android.location.PROVIDERS_CHANGED", Toast.LENGTH_LONG).show();

        }


    }

    /**
     *
     * Init my alarm , it static to call it from any activity or services
     */
    static void scheduleAlarms(Context ctxt) {
        AlarmManager mgr=
                (AlarmManager)ctxt.getSystemService(Context.ALARM_SERVICE);
        Intent i=new Intent(ctxt, ScheduledService.class);
        PendingIntent pi=PendingIntent.getService(ctxt, 0, i, 0);

        mgr.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                SystemClock.elapsedRealtime() + PERIOD, PERIOD, pi);
    }
}
