package com.example.reddit;

public class Post {

    private String title;
    private String text;
    private int upvotes;
    private int comments;
    private int key;

    public Post(String title, String text, int upvotes, int comments, int key) {
        this.title = title;
        this.text = text;
        this.upvotes = upvotes;
        this.comments = comments;
        this.key = key;
    }

    public String getTitle() {
        return title;
    }

    public String getText() { return text; }

    public int getKey() { return key; }

    public int getUpvotes() {
        return upvotes;
    }

    public int getComments() {
        return comments;
    }
}
