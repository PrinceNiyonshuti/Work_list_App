package com.example.worklist;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    LayoutInflater inflater;
    List<Song> songs;
    Context ctx;
    public String dataTittle;

    public Adapter(Context ctx , List<Song> songs){
        this.ctx = ctx;
        this.inflater = LayoutInflater.from(ctx);
        this.songs = songs;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.custom_list_layout,parent, false);
//        View view;
//        view = LayoutInflater.from(ctx).inflate(R.layout.custom_list_layout,parent, false);
        ViewHolder viewholder = new ViewHolder(view);

        //String mTitle = songs.get(viewholder.getAdapterPosition()).getTitle();
        String Datatest = "Haydee";

        String Mu = dataTittle;



        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // bind data
        holder.songTitle.setText(songs.get(position).getTitle());
        holder.songArtists.setText(songs.get(position).getArtists());
        Picasso.get().load(songs.get(position).getCoverImage()).into(holder.songCoverImage);

        dataTittle = songs.get(position).getTitle();
    }

    @Override
    public int getItemCount() {

        return songs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout transaction_item;
        public TextView songTitle,songArtists;
        RoundedImageView songCoverImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            transaction_item = itemView.findViewById(R.id.transaction_item);
            songTitle = itemView.findViewById(R.id.songTitle);
            songArtists = itemView.findViewById(R.id.songArtist);
            songCoverImage = itemView.findViewById(R.id.coverImage);
        }

    }

}
