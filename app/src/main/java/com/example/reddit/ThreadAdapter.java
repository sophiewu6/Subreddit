package com.example.reddit;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

class ThreadAdapter extends android.support.v7.widget.RecyclerView.Adapter<ThreadAdapter.ViewHolder> {
    ArrayList<Post> mThreads;

    public MyAdapterListener onClickListener;

    public interface MyAdapterListener {

        void upvoteImageViewOnClick(View v, int position);
        void downvoteImageViewOnClick(View v, int position);
        void titleTextViewOnClick(View v, int position);
    }


    public ThreadAdapter(ArrayList<Post> threads, MyAdapterListener listener) {
        mThreads = threads;
        onClickListener = listener;
    }

    @Override
    public ThreadAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ThreadAdapter.ViewHolder viewHolder, int i) {
        viewHolder.title.setText(mThreads.get(i).getTitle());
        viewHolder.score.setText(mThreads.get(i).getUpvotes());
    }

    @Override
    public int getItemCount() {
        return mThreads.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView title;
        public ImageButton upvote;
        public ImageButton downvote;
        public TextView score;


        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            score = (TextView) itemView.findViewById(R.id.score);
            this.upvote = itemView.findViewById(R.id.upvote);
            downvote = itemView.findViewById(R.id.downvote);


            title.setOnClickListener(new View.OnClickListener() {
                @Override
               public void onClick(View v) {
                   onClickListener.titleTextViewOnClick(v, getAdapterPosition());
                }
            });

            upvote.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.upvoteImageViewOnClick(v, getAdapterPosition());
                }
            });

            downvote.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.downvoteImageViewOnClick(v, getAdapterPosition());
                }
            });

        }
    }
}
