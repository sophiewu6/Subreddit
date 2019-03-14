package com.example.reddit;

public class StoreInfo {
    private SubredditObject subreddit;
    private Post post;

    public StoreInfo() {
    }

    public SubredditObject getSubreddit() {
        return subreddit;
    }

    public Post getPost() {
        return post;
    }

    public void setSubreddit(SubredditObject subreddit) {
        this.subreddit = subreddit;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
