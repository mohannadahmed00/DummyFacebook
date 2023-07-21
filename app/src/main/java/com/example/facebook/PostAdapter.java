package com.example.facebook;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    ArrayList<PostData> posts;

    public PostAdapter(ArrayList<PostData> posts) {
        this.posts = posts;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.post_item, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        PostData post = posts.get(position);
        int color = Color.parseColor(post.colorCode);
        holder.userImg.setBackgroundTintList(ColorStateList.valueOf(color));
        holder.tvAuthor.setText(post.author);
        holder.tvTime.setText(post.time);
        holder.tvContent.setText(post.content);
        holder.postImg.setBackgroundTintList(ColorStateList.valueOf(color));
        holder.tvNumOfLikes.setText(String.valueOf(post.numOfLikes));
        holder.tvNumOfShares.setText(String.valueOf(post.numOfShares));
    }


    @Override
    public int getItemCount() {
        return posts.size();
    }

    static class PostViewHolder extends RecyclerView.ViewHolder {

        ImageView userImg;
        TextView tvAuthor;
        TextView tvTime;
        TextView tvContent;
        ImageView postImg;
        TextView tvNumOfLikes;
        TextView tvNumOfShares;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            userImg = itemView.findViewById(R.id.user_img);
            tvAuthor = itemView.findViewById(R.id.author);
            tvTime = itemView.findViewById(R.id.time);
            tvContent = itemView.findViewById(R.id.content);
            postImg = itemView.findViewById(R.id.post_img);
            tvNumOfLikes = itemView.findViewById(R.id.num_of_likes);
            tvNumOfShares = itemView.findViewById(R.id.num_of_shares);
        }
    }

}
