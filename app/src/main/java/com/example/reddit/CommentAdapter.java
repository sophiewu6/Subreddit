package com.example.reddit;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

class CommentAdapter extends android.support.v7.widget.RecyclerView.Adapter<CommentAdapter.ViewHolder> {
    ArrayList<Comment> mThreads;
    public MyAdapterListener onClickListener;

    public interface MyAdapterListener {

        void deleteButtonOnClick(View v, int position);
        void iconImageViewOnClick(View v, int position);
    }


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
    }

    @Override
    public int getItemCount() {
        return mThreads.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView comment;
        public Button deleteButton;

        public ViewHolder(View itemView) {
            super(itemView);
            comment = (TextView) itemView.findViewById(R.id.comment);
            deleteButton = (Button) itemView.findViewById(R.id.delete);

            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.deleteButtonOnClick(v, getAdapterPosition());
                }
            });
        }
    }
}
