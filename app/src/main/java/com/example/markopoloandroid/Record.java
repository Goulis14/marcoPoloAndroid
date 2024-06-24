package com.example.markopoloandroid;

public class Record {
    private String title;
    private String category;
    private String description;
    private String location;

    public Record(String title, String category, String description, String location) {
        this.title = title;
        this.category = category;
        this.description = description;
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }
}