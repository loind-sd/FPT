package com.musicapp.service;

import static com.musicapp.ApplicationClass.ACTION_NEXT;
import static com.musicapp.ApplicationClass.ACTION_PLAY;
import static com.musicapp.ApplicationClass.ACTION_PREVIOUS;
import static com.musicapp.ApplicationClass.ARTIST_NAME;
import static com.musicapp.ApplicationClass.CHANNEL_ID_2;
import static com.musicapp.ApplicationClass.MUSIC_FILE;
import static com.musicapp.ApplicationClass.MUSIC_FILE_LAST_PLAYED;
import static com.musicapp.ApplicationClass.SONG_NAME;
import static com.musicapp.ApplicationClass.listSongs;
import static com.musicapp.ApplicationClass.nowPlayingFragment;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import com.musicapp.ActionPlaying;
import com.musicapp.MainActivity;
import com.musicapp.PlayerActivity;
import com.musicapp.R;
import com.musicapp.model.MusicFiles;
import com.musicapp.receiver.NotificationReceiver;

import java.util.ArrayList;
import java.util.List;

public class MusicService extends Service implements MediaPlayer.OnCompletionListener{
    IBinder myBinder = new MyBinder();
    MediaPlayer mediaPlayer;
    public List<MusicFiles> musicFiles = new ArrayList<>();
    Uri uri;
    public int position = -1;
    ActionPlaying actionPlaying;
    MediaSessionCompat mediaSessionCompat;


    @Override
    public void onCreate() {
        super.onCreate();
        mediaSessionCompat = new MediaSessionCompat(getBaseContext(), "My Audio");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("Bind", "Method");
        return myBinder;
    }

    public class MyBinder extends Binder {
        public MusicService geService(){
            return MusicService.this;
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int myPosition = intent.getIntExtra("servicePosition",  -1);
        String actionName = intent.getStringExtra("ActionName");

        if(myPosition != -1){
            playMedia(myPosition);
        }
        if (actionName != null) {
            switch (actionName) {
                case "playPause":
                    playPauseBtnClick();
                    break;

                case "next":
                    nextBtnClick();
                    break;

                case "previous":
                    previousBtnClick();
                    break;
            }
        }

        return START_STICKY;
    }

    private void playMedia(int startPosition) {
        musicFiles = listSongs;
        position = startPosition;
        if(mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer.release();
            if(musicFiles != null){
                createMediaPlayer(position);
                mediaPlayer.start();
            }
        }else{
            createMediaPlayer(position);
            mediaPlayer.start();
        }
    }

    public void start(){
        mediaPlayer.start();
    }
    public boolean isPlaying(){
        if (mediaPlayer == null) {
            return false;
        }
        return mediaPlayer.isPlaying();
    }
    public void stop(){
        mediaPlayer.stop();
    }
    public void release(){
        mediaPlayer.release();
    }
    public int getDuration(){
        return mediaPlayer.getDuration();
    }
    public void seekTo(int position){
        mediaPlayer.seekTo(position);
    }
    public void createMediaPlayer(int positionInner){
        position = positionInner;
        uri = Uri.parse(musicFiles.get(position).getPath());
        SharedPreferences.Editor editor = getSharedPreferences(MUSIC_FILE_LAST_PLAYED, MODE_PRIVATE).edit();
        editor.putString(MUSIC_FILE, uri.toString());
        editor.putString(ARTIST_NAME, musicFiles.get(positionInner).getArtist());
        editor.putString(SONG_NAME, musicFiles.get(positionInner).getTitle());
        editor.apply();

        mediaPlayer = MediaPlayer.create(getBaseContext(), uri);
    }
    public int getCurrentPosition(){
        return mediaPlayer.getCurrentPosition();
    }
    public void pause(){
        mediaPlayer.pause();
    }
    public void onCompleted(){
        mediaPlayer.setOnCompletionListener(this);
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer1) {
        if (actionPlaying != null) {
            actionPlaying.nextBtnClicked();
            if (mediaPlayer != null) {
                createMediaPlayer(position);
                mediaPlayer.start();
                nowPlayingFragment.playPauseBtn.setImageResource(R.drawable.ic_pause);
                showNotification(R.drawable.ic_pause);
                onCompleted();
            }
        }

    }

    public void setCallBack(ActionPlaying actionPlaying) {
        this.actionPlaying = actionPlaying;
    }

    public void showNotification(int btnPlayPause) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("position", position);
        PendingIntent pendingIntent = PendingIntent.getActivity(getBaseContext(), 0, intent, 0);

        Intent preIntent = new Intent(this, NotificationReceiver.class)
                .setAction(ACTION_PREVIOUS);
        PendingIntent prePending = PendingIntent.getBroadcast(this, 0, preIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        Intent pauseIntent = new Intent(this, NotificationReceiver.class)
                .setAction(ACTION_PLAY);
        PendingIntent pausePending = PendingIntent.getBroadcast(this, 0, pauseIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        Intent nextIntent = new Intent(this, NotificationReceiver.class)
                .setAction(ACTION_NEXT);
        PendingIntent nextPending = PendingIntent.getBroadcast(this, 0, nextIntent, PendingIntent.FLAG_UPDATE_CURRENT);

//        Intent closeIntent = new Intent(this, NotificationReceiver.class)
//                .setAction("close");
//        PendingIntent closePending = PendingIntent.getBroadcast(this, 0, closeIntent, PendingIntent.FLAG_CANCEL_CURRENT);

        byte[] picture = null;
        picture = getAlbumArt(musicFiles.get(position).getPath());
        Bitmap thumb = null;
        if (picture != null) {
            thumb = BitmapFactory.decodeByteArray(picture, 0 , picture.length);
        }
        else {
            thumb = BitmapFactory.decodeResource(getResources(), R.drawable.image);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID_2);

        Notification notification = builder
                .setSmallIcon(R.mipmap.logo)
                .setLargeIcon(thumb)
                .setContentTitle(musicFiles.get(position).getTitle())
                .setContentText(musicFiles.get(position).getArtist())
                .setContentIntent(pendingIntent)
                .addAction(R.drawable.ic_skip_previous, "Previous", prePending)
                .addAction(btnPlayPause, "Pause", pausePending)
                .addAction(R.drawable.ic_skip_next, "Next", nextPending)
//                .addAction(R.drawable.ic_close, "Close", closePending)
                .setStyle(new androidx.media.app.NotificationCompat.MediaStyle())
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setOnlyAlertOnce(true)
                .setSound(null)
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                .build();

        startForeground(1, notification);
    }


    private byte[] getAlbumArt(String uri) {
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        retriever.setDataSource(uri);
        byte[] img = retriever.getEmbeddedPicture();
        retriever.release();
        return img;
    }

    public void nextBtnClick() {
        if (actionPlaying != null) {
            actionPlaying.nextBtnClicked();
        }
    }

    public void previousBtnClick() {
        if (actionPlaying != null) {
            actionPlaying.prevBtnClicked();
        }
    }

    public void playPauseBtnClick() {
        if (actionPlaying != null) {
            actionPlaying.playPauseBtnClicked();
        }
    }
}
