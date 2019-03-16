package com.example.reddit;

import java.util.UUID;

public class Comment implements Comparable<Comment>{

    private String text;
    private int upvotes;
    private String key;

    public Comment() {
        this.text = "chicken nugget";
        this.upvotes = 0;
        this.key = UUID.randomUUID().toString();
    }

    public Comment(String text, int upvotes, String key) {
        this.text = text;
        this.upvotes = upvotes;
        this.key = UUID.randomUUID().toString();
    }

    public void upvote() {
        upvotes++;
    }

    public void downvote() {
        upvotes--;
    }

    public String getText() {
        return text;
    }
    public String getKey() {
        return key;
    }

    public int getUpvotes() {
        return upvotes;
    }

    @Override
    public int compareTo(Comment c) {
        return c.getUpvotes() - upvotes;
    }
}
