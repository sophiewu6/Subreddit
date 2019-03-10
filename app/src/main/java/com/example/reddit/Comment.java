package com.example.reddit;

public class Comment {

    private String text;
    private int upvotes;

    public Comment(String text, int upvotes) {
        this.text = text;
        this.upvotes = upvotes;
    }

    public String getText() {
        return text;
    }

    public int getUpvotes() {
        return upvotes;
    }
}
