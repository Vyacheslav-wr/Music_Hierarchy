package com.example.model;

import com.example.model.Genres;

public class Song implements Comparable<Song>{

    private String name;
    private int duration;
    private String author;
    private Genres genre;

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public double getDuration() { return duration; }

    public void setDuration(int duration) { this.duration = duration; }

    public String getAuthor() { return author; }

    public void setAuthor(String author) { this.author = author; }

    public Genres getGenre() { return genre; }

    public void setGenre(Genres genre) { this.genre = genre; }

    @Override
    public int compareTo(Song o) {
        if(o.getGenre().ordinal() < this.getGenre().ordinal()){
            return 1;
        }
        if(o.getGenre().ordinal() > this.getGenre().ordinal()){
            return -1;
        }
        else{
            return 1;
        }
    }
}
