package com.xuganwen.testnotification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.nio.channels.Channel;

import static android.app.NotificationManager.IMPORTANCE_HIGH;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.btn_notify)
    private Button btn_notify;


    private Uri sound;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        sound = Uri.parse("android.resource://" + getPackageName() + "/raw/alarm_voice");
        BindHelper.bindView(this);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        final NotificationManager notificationManager= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        btn_notify.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://developer.android.com/reference/android/app/Notification.html"));
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, intent,  PendingIntent.FLAG_NO_CREATE);
                // END_INCLUDE(build_action)

                /*// BEGIN_INCLUDE (build_notification)
                *//**
                 * Use NotificationCompat.Builder to set up our notification.
                 *//*
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);

                *//** Set the icon that will appear in the notification bar. This icon also appears
                 * in the lower right hand corner of the notification itself.
                 *
                 * Important note: although you can use any drawable as the small icon, Android
                 * design guidelines state that the icon should be simple and monochrome. Full-color
                 * bitmaps or busy images don't render well on smaller screens and can end up
                 * confusing the user.
                 *//*
                builder.setSmallIcon(R.drawable.ic_launcher_background);

                // Set the intent that will fire when the user taps the notification.
                builder.setContentIntent(pendingIntent);

                // Set the notification to auto-cancel. This means that the notification will disappear
                // after the user taps it, rather than remaining until it's explicitly dismissed.
                builder.setAutoCancel(false);

                *//**
                 *Build the notification's appearance.
                 * Set the large icon, which appears on the left of the notification. In this
                 * sample we'll set the large icon to be the same as our app icon. The app icon is a
                 * reasonable default if you don't have anything more compelling to use as an icon.
                 *//*
                builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_foreground));

                *//**
                 * Set the text of the notification. This sample sets the three most commononly used
                 * text areas:
                 * 1. The content title, which appears in large type at the top of the notification
                 * 2. The content text, which appears in smaller text below the title
                 * 3. The subtext, which appears under the text on newer devices. Devices running
                 *    versions of Android prior to 4.2 will ignore this field, so don't use it for
                 *    anything vital!
                 *//*
                builder.setContentTitle("BasicNotifications Sample");
                builder.setContentText("Time to learn about notifications!");
                builder.setSubText("Tap to view documentation about notifications.");
                builder.setCategory(Notification.CATEGORY_REMINDER);
                builder.setSound(sound,5);*/


                NotificationChannel mChannel = new NotificationChannel("channel_1", "aaa", NotificationManager.IMPORTANCE_LOW);
                mChannel.setSound(sound, Notification.AUDIO_ATTRIBUTES_DEFAULT);
                notificationManager.createNotificationChannel(mChannel);
                Notification notification = new Notification.Builder(MainActivity.this)
                        .setChannelId("channel_1")
                        .setContentTitle("hehe")
                        .setContentText("heheh")
                        .setContentIntent(pendingIntent)
                        .setSmallIcon(R.mipmap.ic_launcher).build();


                notificationManager.notify(	0,notification);
            }
        });
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
}
