package com.example.reddit;

import java.util.UUID;

public class Comment {

    private String text;
    private int upvotes;
    private String key;

    public Comment() {
        this.text = "";
        this.upvotes = 0;
        this.key = UUID.randomUUID().toString();
    }

    public Comment(String text, int upvotes, String key) {
        this.text = text;
        this.upvotes = upvotes;
        this.key = UUID.randomUUID().toString();
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
}
