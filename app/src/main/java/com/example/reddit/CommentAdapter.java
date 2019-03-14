package com.example.reddit;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

class CommentAdapter extends android.support.v7.widget.RecyclerView.Adapter<CommentAdapter.ViewHolder> {
    ArrayList<Comment> mThreads;
    public MyAdapterListener onClickListener;

    public interface MyAdapterListener {

        void iconTextViewOnClick(View v, int position);
        void iconImageViewOnClick(View v, int position);
    }


    public CommentAdapter(ArrayList<Comment> threads, MyAdapterListener listener) {
        mThreads = threads;
        onClickListener = listener;
    }

    @Override
    public CommentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentAdapter.ViewHolder viewHolder, int i) {
        viewHolder.title.setText(mThreads.get(i).getText());
    }

    @Override
    public int getItemCount() {
        return mThreads.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);

            title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.iconTextViewOnClick(v, getAdapterPosition());
                }
            });
        }
    }
}
