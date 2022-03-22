package com.musicapp;

import static com.musicapp.ApplicationClass.listSongs;
import static com.musicapp.ApplicationClass.nowPlayingFragment;
import static com.musicapp.MainActivity.repeatBoolean;
import static com.musicapp.MainActivity.shuffleBoolean;
import static com.musicapp.adapter.AlbumDetailAdapter.albumFiles;
import static com.musicapp.adapter.MusicAdapter.mFiles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.palette.graphics.Palette;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.musicapp.service.MusicService;
import com.musicapp.model.MusicFiles;
import com.musicapp.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlayerActivity extends AppCompatActivity implements ActionPlaying, ServiceConnection {

    TextView song_name, artist_name, duration_played, duration_total;
    ImageView cover_art, nextBnt, prevBtn, backBtn, shuffleBtn, repeatBtn;
    FloatingActionButton playPauseBtn;
    SeekBar seekBar;
    int position = -1;
    static Uri uri;
    //    static MediaPlayer mediaPlayer;
    private Handler handler = new Handler();
    private Thread playThread, prevThread, nextThread;
    MusicService musicService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setFullScreen();
        setContentView(R.layout.activity_player);
        getSupportActionBar().hide();
        bindingView();
        getIntentMethod();
        bindingAction();
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (musicService != null && fromUser) {
                    musicService.seekTo(progress * 1000);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        PlayerActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (musicService != null) {
                    int mCurrentPosition = musicService.getCurrentPosition() / 1000;
                    seekBar.setProgress(mCurrentPosition);
                    duration_played.setText(Utils.formattedTime(mCurrentPosition));
                }
                handler.postDelayed(this, 1000);
            }
        });
    }

    private void bindingView() {
        song_name = findViewById(R.id.song_name);
        artist_name = findViewById(R.id.song_artist);
        duration_played = findViewById(R.id.durationPlayed);
        duration_total = findViewById(R.id.durationTotal);
        cover_art = findViewById(R.id.cover_art);
        nextBnt = findViewById(R.id.id_next);
        prevBtn = findViewById(R.id.id_prev);
        backBtn = findViewById(R.id.back_btn);
        shuffleBtn = findViewById(R.id.id_shuffle);
        repeatBtn = findViewById(R.id.id_repeat);
        playPauseBtn = findViewById(R.id.play_pause);
        seekBar = findViewById(R.id.seekBar);

        shuffleBoolean = false;
        repeatBoolean = false;
    }

    private void bindingAction() {
        backBtn.setOnClickListener(this::backBtnClick);
        shuffleBtn.setOnClickListener(this::shuffleBtnClick);
        repeatBtn.setOnClickListener(this::repeatBtnClick);
    }

    private void setFullScreen() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    protected void onResume() {
        Intent intent = new Intent(this, MusicService.class);
        bindService(intent, this, BIND_AUTO_CREATE);
        playThreadBtn();
        nextThreadBtn();
        prevThreadBtn();
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        unbindService(this);
    }

    private void prevThreadBtn() {
        prevThread = new Thread() {
            @Override
            public void run() {
                super.run();
                prevBtn.setOnClickListener(view -> prevBtnClicked());
            }
        };
        prevThread.start();
    }

    private void nextThreadBtn() {
        nextThread = new Thread() {
            @Override
            public void run() {
                super.run();
                nextBnt.setOnClickListener(view -> nextBtnClicked());
            }
        };
        nextThread.start();
    }

    private void playThreadBtn() {
        playThread = new Thread() {
            @Override
            public void run() {
                super.run();
                playPauseBtn.setOnClickListener(view -> playPauseBtnClicked());
            }
        };
        playThread.start();
    }

    public void nextBtnClicked() {
        if (musicService.isPlaying()) {
            musicService.stop();
            musicService.release();
            if (shuffleBoolean && !repeatBoolean) {
                position = getRandom(listSongs.size() - 1);
            } else if (!shuffleBoolean && !repeatBoolean) {
                position = (position + 1) % listSongs.size();
            }
            uri = Uri.parse(listSongs.get(position).getPath());
            musicService.createMediaPlayer(position);
            metaData(uri);

            song_name.setText(listSongs.get(position).getTitle());
            artist_name.setText(listSongs.get(position).getArtist());
            nowPlayingFragment.songName.setText(listSongs.get(position).getTitle());
            nowPlayingFragment.artist.setText(listSongs.get(position).getArtist());
            byte[] art = getAlbumArt(listSongs.get(position).getPath());
            if (art != null) {
                Glide.with(nowPlayingFragment.getContext()).load(art)
                        .into(nowPlayingFragment.albumArt);
            }
            else {
                Glide.with(nowPlayingFragment.getContext()).load(R.drawable.image)
                        .into(nowPlayingFragment.albumArt);
            }
            seekBar.setMax(musicService.getDuration()/1000);
            PlayerActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (musicService != null) {
                        int mCurrentPosition = musicService.getCurrentPosition() / 1000;
                        seekBar.setProgress(mCurrentPosition);
                    }
                    handler.postDelayed(this, 1000);
                }
            });
            musicService.onCompleted();
            musicService.showNotification(R.drawable.ic_pause);
            playPauseBtn.setBackgroundResource(R.drawable.ic_pause);
            nowPlayingFragment.playPauseBtn.setImageResource(R.drawable.ic_pause);
            musicService.start();
        } else {
            musicService.stop();
            musicService.release();
            if (shuffleBoolean && !repeatBoolean) {
                position = getRandom(listSongs.size() - 1);
            } else if (!shuffleBoolean && !repeatBoolean) {
                position = (position + 1) % listSongs.size();
            }
            uri = Uri.parse(listSongs.get(position).getPath());
            musicService.createMediaPlayer(position);
            metaData(uri);

            song_name.setText(listSongs.get(position).getTitle());
            artist_name.setText(listSongs.get(position).getArtist());
            nowPlayingFragment.songName.setText(listSongs.get(position).getTitle());
            nowPlayingFragment.artist.setText(listSongs.get(position).getArtist());
            if (nowPlayingFragment.getContext() != null) {
                byte[] art = getAlbumArt(listSongs.get(position).getPath());
                if (art != null) {
                    Glide.with(nowPlayingFragment.getContext()).load(art)
                            .into(nowPlayingFragment.albumArt);
                }
                else {
                    Glide.with(nowPlayingFragment.getContext()).load(R.drawable.image)
                            .into(nowPlayingFragment.albumArt);
                }
            }
            seekBar.setMax(musicService.getDuration()/1000);
            PlayerActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (musicService != null) {
                        int mCurrentPosition = musicService.getCurrentPosition() / 1000;
                        seekBar.setProgress(mCurrentPosition);
                    }
                    handler.postDelayed(this, 1000);
                }
            });
            musicService.showNotification(R.drawable.ic_play);
            playPauseBtn.setBackgroundResource(R.drawable.ic_play);
            nowPlayingFragment.playPauseBtn.setImageResource(R.drawable.ic_play);
            musicService.onCompleted();
        }
    }

    private int getRandom(int i) {
        Random random = new Random();
        return random.nextInt(i + 1);
    }

    public void prevBtnClicked() {
        if (musicService.isPlaying()) {
            musicService.stop();
            musicService.release();
            if (shuffleBoolean && !repeatBoolean) {
                position = getRandom(listSongs.size() - 1);
            } else if (!shuffleBoolean && !repeatBoolean) {
                position = (position - 1) < 0 ? (listSongs.size() - 1) : (position - 1);
            }
            uri = Uri.parse(listSongs.get(position).getPath());
            musicService.createMediaPlayer(position);
            metaData(uri);
            song_name.setText(listSongs.get(position).getTitle());
            artist_name.setText(listSongs.get(position).getArtist());
            seekBar.setMax(musicService.getDuration()/1000);
            PlayerActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (musicService != null) {
                        int mCurrentPosition = musicService.getCurrentPosition() / 1000;
                        seekBar.setProgress(mCurrentPosition);
                    }
                    handler.postDelayed(this, 1000);
                }
            });
            musicService.onCompleted();
            musicService.showNotification(R.drawable.ic_pause);
            playPauseBtn.setBackgroundResource(R.drawable.ic_pause);
            nowPlayingFragment.playPauseBtn.setImageResource(R.drawable.ic_pause);
            musicService.start();
        } else {
            musicService.stop();
            musicService.release();
            if (shuffleBoolean && !repeatBoolean) {
                position = getRandom(listSongs.size() - 1);
            } else if (!shuffleBoolean && !repeatBoolean) {
                position = (position - 1) < 0 ? (listSongs.size() - 1) : (position - 1);
            }
            uri = Uri.parse(listSongs.get(position).getPath());
            musicService.createMediaPlayer(position);
            metaData(uri);
            song_name.setText(listSongs.get(position).getTitle());
            artist_name.setText(listSongs.get(position).getArtist());
            seekBar.setMax(musicService.getDuration()/1000);
            PlayerActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (musicService != null) {
                        int mCurrentPosition = musicService.getCurrentPosition() / 1000;
                        seekBar.setProgress(mCurrentPosition);
                    }
                    handler.postDelayed(this, 1000);
                }
            });
            musicService.onCompleted();
            musicService.showNotification(R.drawable.ic_play);
            playPauseBtn.setBackgroundResource(R.drawable.ic_play);
            nowPlayingFragment.playPauseBtn.setImageResource(R.drawable.ic_play);
        }
    }

    public void playPauseBtnClicked() {
        if (musicService.isPlaying()) {
            playPauseBtn.setImageResource(R.drawable.ic_play);
            musicService.showNotification(R.drawable.ic_play);
            nowPlayingFragment.playPauseBtn.setImageResource(R.drawable.ic_play);
            musicService.pause();
            seekBar.setMax(musicService.getDuration() / 1000);
            PlayerActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (musicService != null) {
                        int mCurrentPosition = musicService.getCurrentPosition() / 1000;
                        seekBar.setProgress(mCurrentPosition);
                    }
                    handler.postDelayed(this, 1000);
                }
            });
        } else {
            musicService.showNotification(R.drawable.ic_pause);
            playPauseBtn.setImageResource(R.drawable.ic_pause);
            nowPlayingFragment.playPauseBtn.setImageResource(R.drawable.ic_pause);
            musicService.start();
            seekBar.setMax(musicService.getDuration() / 1000);
            PlayerActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (musicService != null) {
                        int mCurrentPosition = musicService.getCurrentPosition() / 1000;
                        seekBar.setProgress(mCurrentPosition);
                    }
                    handler.postDelayed(this, 1000);
                }
            });
        }
    }

    private void getIntentMethod() {
        position = getIntent().getIntExtra("position", -1);
        String sender = getIntent().getStringExtra("sender");
        if(sender != null && sender.equals("albumDetails")){
            listSongs = albumFiles;
            if (musicService != null) {
                musicService.stop();
            }
        }else{
            listSongs = mFiles;
        }
        if (listSongs != null) {
            playPauseBtn.setImageResource(R.drawable.ic_pause);
            uri = Uri.parse(listSongs.get(position).getPath());
        }
        Intent intent = new Intent(this, MusicService.class);
        intent.putExtra("servicePosition", position);
        nowPlayingFragment.playPauseBtn.setImageResource(R.drawable.ic_pause);
        startService(intent);
    }

    private void repeatBtnClick(View view) {
        if (repeatBoolean) {
            repeatBoolean = false;
            repeatBtn.setImageResource(R.drawable.ic_repeat_off);
        } else {
            repeatBoolean = true;
            repeatBtn.setImageResource(R.drawable.ic_repeat_on);
            shuffleBoolean = false;
            shuffleBtn.setImageResource(R.drawable.ic_shuffle_off);
        }
    }

    private void shuffleBtnClick(View view) {
        if (shuffleBoolean) {
            shuffleBoolean = false;
            shuffleBtn.setImageResource(R.drawable.ic_shuffle_off);
        } else {
            shuffleBoolean = true;
            shuffleBtn.setImageResource(R.drawable.ic_shuffle_on);
            repeatBoolean = false;
            repeatBtn.setImageResource(R.drawable.ic_repeat_off);
        }
    }

    private void backBtnClick(View view) {
        onBackPressed();
    }

    private void metaData(Uri uri) {
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        retriever.setDataSource(uri.toString());
        //*
        int durationTotal = Integer.parseInt(listSongs.get(position).getDuration()) / 1000;
        duration_total.setText(Utils.formattedTime(durationTotal));
        byte[] art = retriever.getEmbeddedPicture();
        Bitmap bitmap;
        if (art != null) {
            bitmap = BitmapFactory.decodeByteArray(art, 0, art.length);
            imageAnimation(this, cover_art, bitmap);
            Palette.from(bitmap).generate(palette -> {
                Palette.Swatch swatch = palette.getDominantSwatch();
                if (swatch != null) {
                    ImageView gradient = findViewById(R.id.imageViewGradient);
                    RelativeLayout mContainer = findViewById(R.id.mContainer);
                    gradient.setBackgroundResource(R.drawable.gradient_bg);
                    mContainer.setBackgroundResource(R.drawable.main_bg);
                    GradientDrawable gradientDrawable = new GradientDrawable(
                            GradientDrawable.Orientation.BOTTOM_TOP, new int[]{0xff000000, 0x00000000});
                    gradient.setBackground(gradientDrawable);
                    GradientDrawable gradientDrawableBg = new GradientDrawable(
                            GradientDrawable.Orientation.BOTTOM_TOP, new int[]{0xff000000, 0xff000000});
                    mContainer.setBackground(gradientDrawableBg);
                    song_name.setTextColor(Color.WHITE);
                    artist_name.setTextColor(Color.DKGRAY);
                }
            });
        } else {
            if (!PlayerActivity.this.isDestroyed()) {
                Glide.with(PlayerActivity.this)
                        .asBitmap()
                        .load(R.drawable.image)
                        .into(cover_art);
                ImageView gradient = findViewById(R.id.imageViewGradient);
                RelativeLayout mContainer = findViewById(R.id.mContainer);
                gradient.setBackgroundResource(R.drawable.gradient_bg);
                mContainer.setBackgroundResource(R.drawable.main_bg);
                song_name.setTextColor(Color.WHITE);
                artist_name.setTextColor(Color.DKGRAY);
            }
        }
    }

    public void imageAnimation(Context context, ImageView imageView, Bitmap bitmap) {
        Animation animationOut = AnimationUtils.loadAnimation(context, android.R.anim.fade_out);
        Animation animationIn = AnimationUtils.loadAnimation(context, android.R.anim.fade_in);
        animationOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Glide.with(context).load(bitmap).into(imageView);
                animationIn.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                imageView.startAnimation(animationIn);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        imageView.startAnimation(animationOut);
    }

    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        MusicService.MyBinder myBinder = (MusicService.MyBinder) iBinder;
        musicService= myBinder.geService();
        musicService.setCallBack(this);
        seekBar.setMax(musicService.getDuration() / 1000);
        metaData(uri);

        song_name.setText(listSongs.get(position).getTitle());
        artist_name.setText(listSongs.get(position).getArtist());
        musicService.onCompleted();
        musicService.showNotification(R.drawable.ic_pause);
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {
        musicService = null;
    }

    private byte[] getAlbumArt(String uri) {
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        retriever.setDataSource(uri);
        byte[] img = retriever.getEmbeddedPicture();
        retriever.release();
        return img;
    }
}