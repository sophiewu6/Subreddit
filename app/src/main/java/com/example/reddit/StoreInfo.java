package com.example.reddit;

public class StoreInfo {
    private String subreddit;
    private int post;

    public StoreInfo() {
        this.subreddit = "";
        this.post = 0;
    }

    public String getSubreddit() {
        return subreddit;
    }

    public int getPost() {
        return post;
    }

    public void setSubreddit(String subreddit) {
        this.subreddit = subreddit;
    }

    public void setPost(int post) {
        this.post = post;
    }
}
