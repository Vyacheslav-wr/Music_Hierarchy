package com.music.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Song implements Comparable<Song>{

    private String name;
    private int duration;
    private String author;
    private Genres genre;
    private final static Logger LOGGER = LoggerFactory.getLogger(PlayList.class);

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public double getDuration() { return duration; }

    public void setDuration(int duration) { this.duration = duration; }

    public String getAuthor() { return author; }

    public void setAuthor(String author) { this.author = author; }

    public Genres getGenre() { return genre; }

    public void setGenre(Genres genre) { this.genre = genre; }

    public void updateSong(String authorName, Integer duration, Genres genre, String name){
        LOGGER.debug("MODEL: Song with name: {} updateOperation()",
                this.getName());
        this.setAuthor(authorName);
        this.setDuration(duration);
        this.setGenre(genre);
        this.setName(name);
        LOGGER.info("MODEL: Song with name: {} was successfully updated",
                this.getName());
    }

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
