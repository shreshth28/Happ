package com.shreshthsrivastava.happ.application;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application {

    public static final String CHANNEL_1_ID="channel1";

    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannel();
    }

    private void createNotificationChannel() {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel1=new NotificationChannel(
                    CHANNEL_1_ID,
                    "Quotes Channel",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel1.setDescription("A sample Quote To make you feel better");
            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);

        }
    }
}
