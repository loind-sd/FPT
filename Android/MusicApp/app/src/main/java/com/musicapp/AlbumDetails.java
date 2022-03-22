package com.musicapp;


import static com.musicapp.ApplicationClass.musicFilesList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.musicapp.adapter.AlbumDetailAdapter;
import com.musicapp.model.MusicFiles;

import java.util.ArrayList;
import java.util.List;

public class AlbumDetails extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageView albumPhoto;
    String albumName;
    List<MusicFiles> musicSongList;
    AlbumDetailAdapter albumDetailAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_details);

        bindingView();
        int j = 0;
        for (int i = 0; i < musicFilesList.size(); i++) {
            if(albumName.equals(musicFilesList.get(i).getAlbum())){
                musicSongList.add(j, musicFilesList.get(i));
                j++;
            }
        }
        byte[] image = getAlbumArt(musicSongList.get(0).getPath());
        if (image != null) {
            Glide.with(this)
                    .load(image)
                    .into(albumPhoto);
        } else {
            Glide.with(this)
                    .load(R.drawable.image)
                    .into(albumPhoto);
        }
    }

    private void bindingView() {
        recyclerView = findViewById(R.id.recyclerView);
        albumPhoto = findViewById(R.id.albumPhoto);
        musicSongList = new ArrayList<>();

        Intent intent = getIntent();
        albumName = intent.getStringExtra("albumName");
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(!(musicSongList.size() < 1)){
            albumDetailAdapter = new AlbumDetailAdapter(this, musicSongList);
            recyclerView.setAdapter(albumDetailAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        }
    }

    private byte[] getAlbumArt(String uri) {
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        retriever.setDataSource(uri);
        byte[] img = retriever.getEmbeddedPicture();
        retriever.release();
        return img;
    }
}