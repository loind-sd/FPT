package com.musicapp.fragment;

import static android.content.Context.MODE_PRIVATE;
import static com.musicapp.ApplicationClass.*;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.musicapp.R;
import com.musicapp.model.MusicFiles;
import com.musicapp.service.MusicService;

public class NowPlayingFragment extends Fragment implements ServiceConnection {

    public ImageView nextBtn, albumArt, previousBtn;
    public TextView artist, songName;
    public FloatingActionButton playPauseBtn;
    View view;
    MusicService musicService;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    public NowPlayingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_now_playing, container, false);

        bindingView();
        bindingAction();
        return view;
    }

    private void bindingView() {
        artist = view.findViewById(R.id.song_artist_miniPlayer);
        songName = view.findViewById(R.id.song_name_miniPlayer);
        albumArt = view.findViewById(R.id.bottom_album_art);
        nextBtn = view.findViewById(R.id.skip_next_bottom);
        previousBtn = view.findViewById(R.id.skip_previous_bottom);
        playPauseBtn = view.findViewById(R.id.play_pause_miniPlayer);
    }

    private void bindingAction() {
        nextBtn.setOnClickListener(this::nextBtnClick);
        playPauseBtn.setOnClickListener(this::playPauseBtnClick);
        previousBtn.setOnClickListener(this::previousBtnClick);
    }

    private void playPauseBtnClick(View view) {
        if (musicService != null) {
            musicService.playPauseBtnClick();
//            if (musicService.isPlaying()) {
//                playPauseBtn.setImageResource(R.drawable.ic_pause);
//            } else {
//                playPauseBtn.setImageResource(R.drawable.ic_play);
//            }
        }
    }

    private void nextBtnClick(View view) {
        if (musicService != null) {
            musicService.nextBtnClick();

            if (getActivity() != null) {
                setValueWhenChange();
            }
        }
    }

    private void previousBtnClick(View view) {
        if (musicService != null) {
            musicService.previousBtnClick();

            if (getActivity() != null) {
                setValueWhenChange();
            }
        }
    }

    private void setValueWhenChange() {
        preferences = getActivity().getSharedPreferences(MUSIC_FILE_LAST_PLAYED, MODE_PRIVATE);
        editor = preferences.edit();

        editor.putString(MUSIC_FILE, musicService.musicFiles.get(musicService.position).getPath());
        editor.putString(ARTIST_NAME, musicService.musicFiles.get(musicService.position).getArtist());
        editor.putString(SONG_NAME, musicService.musicFiles.get(musicService.position).getTitle());
        editor.apply();

        String path = preferences.getString(MUSIC_FILE, null);
        String artistName = preferences.getString(ARTIST_NAME, null);
        String song_name = preferences.getString(SONG_NAME, null);
        if (path != null) {
            SHOW_MINI_PLAYER = true;
            PATH_TO_FRAG = path;
            ARTIST_TO_FRAG = artistName;
            SONG_NAME_TO_FRAG = song_name;
        }
        else {
            SHOW_MINI_PLAYER = false;
            PATH_TO_FRAG = null;
            ARTIST_TO_FRAG = null;
            SONG_NAME_TO_FRAG = null;
        }

        if (SHOW_MINI_PLAYER) {
            if (PATH_TO_FRAG != null) {
                byte[] art = getAlbumArt(PATH_TO_FRAG);
                if (art != null) {
                    Glide.with(getContext()).load(art)
                            .into(albumArt);
                }
                else {
                    Glide.with(getContext()).load(R.drawable.image)
                            .into(albumArt);
                }
                songName.setText(SONG_NAME_TO_FRAG);
                artist.setText(ARTIST_TO_FRAG);
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (SHOW_MINI_PLAYER) {
            if (PATH_TO_FRAG != null) {
                byte[] art = getAlbumArt(PATH_TO_FRAG);
                if (art != null) {
                    Glide.with(getContext()).load(art)
                            .into(albumArt);
                }
                else {
                    Glide.with(getContext()).load(R.drawable.image)
                            .into(albumArt);
                }
                songName.setText(SONG_NAME_TO_FRAG);
                artist.setText(ARTIST_TO_FRAG);

                if (musicService != null && musicService.isPlaying()) {
                    playPauseBtn.setImageResource(R.drawable.ic_pause);
                }

                Intent intent = new Intent(getContext(), MusicService.class);
                if (getContext() != null) {
                    getContext().bindService(intent, this, Context.BIND_AUTO_CREATE);
                }
            }
        }
    }

    private byte[] getAlbumArt(String uri) {
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        retriever.setDataSource(uri);
        byte[] img = retriever.getEmbeddedPicture();
        retriever.release();
        return img;
    }

    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        MusicService.MyBinder myBinder = (MusicService.MyBinder) iBinder;
        musicService = myBinder.geService();
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {
        musicService = null;
    }
}