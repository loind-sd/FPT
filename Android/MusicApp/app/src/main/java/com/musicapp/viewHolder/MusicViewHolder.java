package com.musicapp.viewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.musicapp.R;

public class MusicViewHolder extends RecyclerView.ViewHolder {

    TextView txtFileName;
    ImageView img,menuMore;

    public TextView getTxtFileName() {
        return txtFileName;
    }

    public ImageView getImg() {
        return img;
    }

    public ImageView getMenuMore() {
        return menuMore;
    }

    public MusicViewHolder(@NonNull View itemView) {
        super(itemView);
        bindingView(itemView);
    }

    private void bindingView(View itemView) {
        txtFileName = itemView.findViewById(R.id.music_fileName);
        img = itemView.findViewById(R.id.music_img);
        menuMore = itemView.findViewById(R.id.menuMore);
    }
}
