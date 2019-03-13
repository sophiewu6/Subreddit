package com.example.reddit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SubredditAdapter extends ArrayAdapter<SubredditObject> {
    private Context mContext;
    private List<SubredditObject> subredditList = new ArrayList<SubredditObject>();

    public SubredditAdapter( Context context, ArrayList<SubredditObject> list)
    {
        super( context, 0, list);
        mContext = context;
        subredditList = list;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;

        // Associates the list with the XML Layout file "contact_view"
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.subreddit_view ,parent,false);

        SubredditObject currentSubreddit = subredditList.get(position);

        TextView title = (TextView) listItem.findViewById(R.id.textView_title);
        title.setText(currentSubreddit.getTitle());

        return listItem;
    }
}
