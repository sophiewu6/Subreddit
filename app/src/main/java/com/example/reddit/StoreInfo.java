package com.example.reddit;

public class StoreInfo {
    private SubredditObject subreddit;
    private int post;

    public StoreInfo() {
        this.post = 0;
    }

    public SubredditObject getSubreddit() {
        return subreddit;
    }

    public int getPost() {
        return post;
    }

    public void setSubreddit(SubredditObject subreddit) {
        this.subreddit = subreddit;
    }

    public void setPost(int post) {
        this.post = post;
    }
}
