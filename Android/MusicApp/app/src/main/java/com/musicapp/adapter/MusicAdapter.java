package com.musicapp.adapter;

import android.annotation.SuppressLint;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.snackbar.Snackbar;
import com.musicapp.PlayerActivity;
import com.musicapp.R;
import com.musicapp.model.MusicFiles;
import com.musicapp.viewHolder.MusicViewHolder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MusicAdapter extends RecyclerView.Adapter<MusicViewHolder> {

    private Context mContext;
    public static List<MusicFiles> mFiles;

    public MusicAdapter(Context mContext, List<MusicFiles> mFiles) {
        this.mContext = mContext;
        this.mFiles = mFiles;
    }

    @NonNull
    @Override
    public MusicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.music_item, parent, false);
        return new MusicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.getTxtFileName().setText(mFiles.get(position).getTitle());
        byte[] img = getAlbumArt(mFiles.get(position).getPath());
        if (img != null) {
            Glide.with(mContext).asBitmap()
                    .load(img)
                    .into(holder.getImg());
        } else {
            Glide.with(mContext).asBitmap()
                    .load(R.drawable.image)
                    .into(holder.getImg());
        }
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(mContext, PlayerActivity.class);
            intent.putExtra("position", position);
            mContext.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return mFiles.size();
    }

    private byte[] getAlbumArt(String uri) {
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        retriever.setDataSource(uri);
        byte[] img = retriever.getEmbeddedPicture();
        retriever.release();
        return img;
    }

    public void updateList(List<MusicFiles> list){
        mFiles = new ArrayList<>();
        mFiles.addAll(list);
        notifyDataSetChanged();
    }
}
