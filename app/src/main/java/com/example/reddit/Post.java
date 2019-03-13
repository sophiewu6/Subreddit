package com.example.reddit;

import java.util.UUID;

public class Post {

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
        this.key = "";
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

    public int getComments() {
        return comments;
    }

    public String toString() {
        return key;
    }
}
