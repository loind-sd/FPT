package com.musicapp;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

import com.musicapp.fragment.NowPlayingFragment;
import com.musicapp.model.MusicFiles;

import java.util.ArrayList;
import java.util.List;

public class ApplicationClass extends Application {

    public static final String CHANNEL_ID_1 = "channel1";
    public static final String CHANNEL_ID_2 = "channel2";
    public static final String ACTION_PREVIOUS = "actionPrevious";
    public static final String ACTION_NEXT = "actionNext";
    public static final String ACTION_PLAY = "actionPlay";
    public static final String MUSIC_FILE_LAST_PLAYED = "LAST_PLAYED";
    public static final String MUSIC_FILE = "STORE_MUSIC";
    public static boolean SHOW_MINI_PLAYER = false;
    public static String PATH_TO_FRAG = null;
    public static String ARTIST_TO_FRAG = null;
    public static String SONG_NAME_TO_FRAG = null;
    public static final String ARTIST_NAME = "ARTIST_NAME";
    public static final String SONG_NAME = "SONG_NAME";
    public static List<MusicFiles> listSongs = new ArrayList<>();
    public static  List<MusicFiles> albums = new ArrayList<>();
    public static List<MusicFiles> musicFilesList;
    public static NowPlayingFragment nowPlayingFragment = new NowPlayingFragment();
    public static final Integer REQUEST_CODE = 100;

    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChanel();
    }

    private void createNotificationChanel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel1 =
                    new NotificationChannel(CHANNEL_ID_1, "Channel(1)"
                            , NotificationManager.IMPORTANCE_LOW);
            channel1.setDescription("Channel 1 Desc ...");

            NotificationChannel channel2 =
                    new NotificationChannel(CHANNEL_ID_2, "Channel(2)"
                            , NotificationManager.IMPORTANCE_LOW);
            channel1.setDescription("Channel 2 Desc ...");

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
            manager.createNotificationChannel(channel2);
        }
    }
}
