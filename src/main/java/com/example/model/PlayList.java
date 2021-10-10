package com.example.model;

import com.example.Console.ConsoleFunctions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class PlayList{

    private ArrayList<Song> playList = new ArrayList<Song>();
    private final static Logger LOGGER = LoggerFactory.getLogger(PlayList.class);

    private String name;

    public PlayList(String name){
        this.name = name;
    }

    public ArrayList<Song> getPlayList() {
        return this.playList;
    }

    public String getName() { return name; }

    public void addToPlaylist(Song song){
        LOGGER.debug("MODEL: Adding song with name: {} to the playlist with name: {}", song.getName(), this.name);
        this.playList.add(song);
        LOGGER.info("MODEL: Song {} was successfully added to the disk", song.getName());
    }

    public void deleteFromPlaylist(Song song){
        LOGGER.debug("MODEL: Deleting song with name: {} from the playlist with name: {}", song.getName(), this.name);
        this.playList.remove(song);
        LOGGER.info("MODEL: Song {} was successfully deleted from the disk", song.getName());
    }

    public Song getSongFromPlaylist(String name){
        LOGGER.debug("MODEL: Playlist with name: {} getOperation()", this.name);
        for(Song currentSong : this.playList){
            if(currentSong.getName().equals(name)){
                LOGGER.info("MODEL: Song with name {} was found in playlist with name: {}",
                        name, this.name);
                return currentSong;
            }
        }
        LOGGER.warn("MODEL: Song with name {} was not found in playlist with name: {}",
                name, this.name);
        return null;
    }

    public double evaluateDuration(){
        LOGGER.debug("MODEL: Playlist with name: {} evaluateDuration()", this.name);
        double duration = 0;

        for(Song song : this.playList){
            duration += song.getDuration();
        }
        LOGGER.info("MODEL: Playlist with name: {} retrieved value: {}", this.name, duration);
        return duration;
    }

    public ArrayList<Song> findSongsByDurationRange(Integer minLength, Integer maxLength){
        LOGGER.debug("MODEL: Playlist with name: {} findSongsByDurationRange()", this.name);
        ArrayList<Song> songs = new ArrayList<Song>();
        for(Song song : this.playList){
            if(song.getDuration() >= minLength && song.getDuration() <= maxLength){
                songs.add(song);
            }
        }
        LOGGER.info("MODEL:  Playlist with name: {} retrieved list with {} song(s)", this.name, songs.size());
        return songs;
    }
}
