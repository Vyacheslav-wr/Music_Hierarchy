package ModelFunctionsTests;

import com.music.model.Disk;
import com.music.model.Genres;
import com.music.model.PlayList;
import com.music.model.Song;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class DiskFunctionsTests {

    @Test
    public void addPlaylistToDiskTest(){
        Disk disk = new Disk("1");
        PlayList playList = new PlayList("Cool");
        disk.addToDisk(playList);
        Assertions.assertEquals(1, disk.getDisk().size());
        PlayList playList1 = new PlayList("Songs");
        disk.addToDisk(playList1);
        Assertions.assertEquals(2,disk.getDisk().size());
    }

    @ParameterizedTest
    @MethodSource("compareParameters")
    public void sortingSongsOnPlaylistTest(Song song1, Song song2, Integer result){
        Assertions.assertEquals(result, song1.compareTo(song2));
    }

    public static Stream compareParameters(){
        Song song1 = new Song();
        Song song2 = new Song();
        Song song3 = new Song();
        Song song4 = new Song();

        song1.setGenre(Genres.Metal);
        song2.setGenre(Genres.Pop);
        song3.setGenre(Genres.Rap);
        song4.setGenre(Genres.EDM);
        return Stream.of(
                Arguments.of(song1,song2, 1),
                Arguments.of(song4,song3, -1)
        );
    }

}
