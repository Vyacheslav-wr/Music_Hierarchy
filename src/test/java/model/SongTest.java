package model;

import com.music.model.Genres;
import com.music.model.Song;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SongTest {

    @Test
    public void updateSongTest(){
        Song song = new Song();
        String firstName = "First";
        song.setName(firstName);

        song.updateSong("Gregor", 7657, Genres.Pop, "Second");
        Assertions.assertNotEquals(song.getName(), firstName);
    }
}
