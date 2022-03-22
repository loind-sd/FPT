package com.musicapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.musicapp.AlbumDetails;
import com.musicapp.PlayerActivity;
import com.musicapp.R;
import com.musicapp.model.MusicFiles;

import java.util.ArrayList;
import java.util.List;

public class AlbumDetailAdapter extends RecyclerView.Adapter<AlbumDetailAdapter.MyViewHolder> {
    private Context mContext;
    public static List<MusicFiles> albumFiles;
    View view;

    public AlbumDetailAdapter(Context mContext, List<MusicFiles> albumFiles) {
        this.mContext = mContext;
        this.albumFiles = albumFiles;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(mContext).inflate(R.layout.music_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.album_name.setText(albumFiles.get(position).getTitle());
        byte[] img = getAlbumArt(albumFiles.get(position).getPath());
        if (img != null) {
            Glide.with(mContext).asBitmap()
                    .load(img)
                    .into(holder.album_image);
        } else {
            Glide.with(mContext).asBitmap()
                    .load(R.drawable.image)
                    .into(holder.album_image);
        }
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(mContext, PlayerActivity.class);
            intent.putExtra("sender", "albumDetails");
            intent.putExtra("position", position);
            mContext.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return albumFiles.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView album_image;
        TextView album_name;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            album_image = itemView.findViewById(R.id.music_img);
            album_name = itemView.findViewById(R.id.music_fileName);
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

