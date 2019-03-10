package com.example.reddit;

public class Post {

    private String title;
    private String text;
    private int upvotes;
    private int comments;

    public Post(String title, String text, int upvotes, int comments) {
        this.title = title;
        this.text = text;
        this.upvotes = upvotes;
        this.comments = comments;
    }

    public String getTitle() {
        return title;
    }

    public int getUpvotes() {
        return upvotes;
    }

    public int getComments() {
        return comments;
    }
}
