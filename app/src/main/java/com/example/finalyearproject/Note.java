package com.example.finalyearproject;


import com.google.firebase.Timestamp;

public class Note
{
    private String text;
    private Timestamp created;
    private String userId;

    public Note(String text, boolean b, Timestamp timestamp, String userId) {
    }

    public Note(String text, Timestamp created, String userId) {
        this.text = text;
        this.created = created;
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Note{" +
                "text='" + text + '\'' +
                ", created=" + created +
                ", userId='" + userId + '\'' +
                '}';
    }
}
