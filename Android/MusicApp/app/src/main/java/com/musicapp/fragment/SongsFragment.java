package com.musicapp.fragment;


import static com.musicapp.ApplicationClass.musicFilesList;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.musicapp.R;
import com.musicapp.adapter.MusicAdapter;

public class SongsFragment extends Fragment {

    RecyclerView recyclerView;
    public static MusicAdapter musicAdapter;

    public SongsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_songs, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        if (!(musicFilesList.size() < 1)) {
            musicAdapter = new MusicAdapter(getContext(), musicFilesList);
            recyclerView.setAdapter(musicAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        }
        return view;
    }
}