package com.shreshthsrivastava.happ.database.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")
public class Note {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;

    private String description;

    private int rating;

    private String date;

    public Note(String title, String description, int rating, String date) {
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.date = date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getRating() {
        return rating;
    }

    public String getDate() {
        return date;
    }
}
