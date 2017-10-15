package com.mah.mybroadcastex;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class ScheduledService extends IntentService {

    public ScheduledService() {
        super("ScheduledService");
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d("HI I'M SERVICE :::  ", "I ran! :DD");

    }
}
