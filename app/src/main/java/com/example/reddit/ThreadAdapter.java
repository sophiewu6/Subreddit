package com.example.reddit;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

class ThreadAdapter extends android.support.v7.widget.RecyclerView.Adapter<ThreadAdapter.ViewHolder> {
    ArrayList<Post> mThreads;

    public ThreadAdapter(ArrayList<Post> threads) {
        mThreads = threads;
    }

    @Override
    public ThreadAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ThreadAdapter.ViewHolder viewHolder, int i) {
        viewHolder.title.setText(mThreads.get(i).getTitle());
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
        }
    }
}
