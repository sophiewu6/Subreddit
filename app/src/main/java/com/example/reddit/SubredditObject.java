package com.example.reddit;

public class SubredditObject {
    private String title;
    private String description;

    public SubredditObject(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
