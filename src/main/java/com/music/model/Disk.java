package com.music.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;

public class Disk {

    private ArrayList<PlayList> disk = new ArrayList<PlayList>();
    private String name;
    private final static Logger LOGGER = LoggerFactory.getLogger(Disk.class);

    public ArrayList<PlayList> getDisk() {
        return disk;
    }

    public Disk(String name){
        this.name = name;
    }

    public void addToDisk(PlayList playlist){
        LOGGER.debug("MODEL: Adding playlist with name: {} to disk with name: {}", playlist.getName(),
                this.name);
        disk.add(playlist);
        LOGGER.info("MODEL: Playlist with name: {}, successfully added to the disk", playlist.getName());
    }

    public ArrayList<PlayList> sortSongsByGenre(){
        LOGGER.debug("MODEL: Sorting songs on the disk with name: {}", this.name);
        ArrayList<PlayList> sortedPlayList = new ArrayList<PlayList>();

        for(PlayList playList : this.disk){
            Collections.sort(playList.getPlayList());
            sortedPlayList.add(playList);
        }
        LOGGER.info("MODEL: Songs in disk were successfully sorted");
        return sortedPlayList;
    }
}
