package com.example.reddit;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

class CommentAdapter extends android.support.v7.widget.RecyclerView.Adapter<CommentAdapter.ViewHolder> {
    ArrayList<Comment> mThreads;
    public MyAdapterListener onClickListener;

    public interface MyAdapterListener {
        void upvoteImageViewOnClick(View v, int position);
        void downvoteImageViewOnClick(View v, int position);
        void commentTextViewOnClick(View v, int position);

        void deleteButtonOnClick(View v, int position);}


    public CommentAdapter(ArrayList<Comment> threads, MyAdapterListener listener) {
        mThreads = threads;
        onClickListener = listener;
    }

    public void clearComments() {
        int size = this.mThreads.size();
        this.mThreads.clear();
        notifyItemRangeRemoved(0, size);
    }

    @Override
    public CommentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.comment_view, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentAdapter.ViewHolder viewHolder, int i) {
        viewHolder.comment.setText(mThreads.get(i).getText());
        viewHolder.score.setText(mThreads.get(i).getUpvotes()+"");

    }

    @Override
    public int getItemCount() {
        return mThreads.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView comment;
        public ImageButton upvote;
        public ImageButton downvote;
        public TextView score;
        public Button deleteButton;


        public ViewHolder(View itemView) {
            super(itemView);
            score = (TextView) itemView.findViewById(R.id.score);
            this.upvote = itemView.findViewById(R.id.upvote);
            downvote = itemView.findViewById(R.id.downvote);
            comment = (TextView) itemView.findViewById(R.id.title);
            deleteButton = (Button) itemView.findViewById(R.id.delete);


            comment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.commentTextViewOnClick(v, getAdapterPosition());
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

            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.deleteButtonOnClick(v, getAdapterPosition());
                }

            });
        }
    }
}
