package com.example.reddit;

import java.util.UUID;

public class Post implements Comparable<Post> {

    private String title;
    private String text;
    private int upvotes;
    private int comments;
    private String key;

    public Post() {
        this.title = "";
        this.text = "";
        this.upvotes = 0;
        this.comments = 0;
        this.key = UUID.randomUUID().toString();
    }

    public Post(String title, String text, int upvotes, int comments, String key) {
        this.title = title;
        this.text = text;
        this.upvotes = upvotes;
        this.comments = comments;
        this.key = UUID.randomUUID().toString();

    }

    public String getTitle() {
        return title;
    }

    public String getText() { return text; }

    public String getKey() { return key; }

    public int getUpvotes() {
        return upvotes;
    }

    public void upvote() {
        upvotes++;
    }

    public void downvote() {
        upvotes--;
    }

    public int getComments() {
        return comments;
    }

    public String toString() {
        return key;
    }

    @Override
    public int compareTo(Post p) {
        return p.getUpvotes() - upvotes;
    }
}
