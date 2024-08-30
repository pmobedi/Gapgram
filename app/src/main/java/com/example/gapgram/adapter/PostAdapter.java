package com.example.gapgram.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gapgram.R;
import com.example.gapgram.model.Post;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    private List<Post> postList;
    private Context context;

    public PostAdapter(Context context, List<Post> posts) {
        this.context = context;
        this.postList = posts;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Post post = postList.get(position);

        // تنظیم پیام پست
        holder.messageTextView.setText(post.getMessage());

        // تنظیم تعداد لایک‌ها و نظرات
        holder.likesTextView.setText(context.getString(R.string.likes_format, post.getLikes_count()));
        holder.commentsTextView.setText(context.getString(R.string.comments_format, post.getComments_count()));

        // بارگذاری تصویر پروفایل و تصویر پست با استفاده از Picasso
        Picasso.get().load(post.getProfileImage()).placeholder(R.drawable.profile_icon).into(holder.profileImageView);
        Picasso.get().load(post.getImage()).placeholder(R.drawable.profile_icon).into(holder.postImageView);

        // تنظیم آیکون‌های لایک، کامنت و اشتراک‌گذاری
        holder.likeButton.setOnClickListener(v -> {
            // افزودن منطق برای لایک کردن
        });

        holder.commentButton.setOnClickListener(v -> {
            // افزودن منطق برای ارسال کامنت
        });

        holder.shareButton.setOnClickListener(v -> {
            // افزودن منطق برای اشتراک‌گذاری
        });
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder {
        TextView messageTextView;
        TextView likesTextView;
        TextView commentsTextView;
        ImageView profileImageView;
        ImageView postImageView;
        ImageView likeButton;
        ImageView commentButton;
        ImageView shareButton;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            profileImageView = itemView.findViewById(R.id.profileImageView);
            postImageView = itemView.findViewById(R.id.imageView);
            likeButton = itemView.findViewById(R.id.likeButton);
            commentButton = itemView.findViewById(R.id.commentButton);
            shareButton = itemView.findViewById(R.id.shareButton);
            messageTextView = itemView.findViewById(R.id.messageTextView);
            likesTextView = itemView.findViewById(R.id.likesTextView);
            commentsTextView = itemView.findViewById(R.id.commentsTextView);
        }
    }

    public void updatePosts(List<Post> posts) {
        this.postList = posts;
        System.out.println("Updating posts in adapter with " + posts.size() + " items.");
        notifyDataSetChanged();
    }
}
