package ModelFunctionsTests;

import com.music.model.PlayList;
import com.music.model.Song;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class PlaylistFunctionsTests {

    @ParameterizedTest
    @MethodSource("parametersForEvaluation")
    public void evaluateDurationTest(PlayList playList, double expectedDuration){
        double actualDuration = playList.evaluateDuration();

        Assertions.assertEquals(actualDuration, expectedDuration);
    }

    public static Stream parametersForEvaluation(){
        PlayList playList1 = new PlayList("Nice");
        PlayList playList2 = new PlayList("Nice2");
        Song song1 = new Song();
        Song song2 = new Song();
        Song song3 = new Song();
        Song song4 = new Song();

        song1.setDuration(1234);
        song2.setDuration(5674);
        playList1.addToPlaylist(song1);
        playList1.addToPlaylist(song2);

        song3.setDuration(4532);
        song4.setDuration(987);
        playList2.addToPlaylist(song3);
        playList2.addToPlaylist(song4);
        return Stream.of(
                Arguments.of(playList1, 6908.0),
                Arguments.of(playList2, 5519.0)
        );
    }


    @Test
    public void songsSearchingTest(){
        PlayList playList = new PlayList("best");
        Song song1 = new Song();
        Song song2 = new Song();
        song1.setDuration(3456);
        song2.setDuration(567);
        playList.addToPlaylist(song1);
        playList.addToPlaylist(song2);

        Assertions.assertEquals(1, playList.findSongsByDurationRange(568, 4000).size());
    }

    @Test
    public void addingSongsToPlaylistTest(){
        PlayList playList = new PlayList("Test");
        Song song1 = new Song();
        playList.addToPlaylist(song1);

        Assertions.assertEquals(1, playList.getPlayList().size());
    }

    @Test
    public void deleteSongFromPlaylistTest(){
        PlayList playList = new PlayList("Test");
        Song song1 = new Song();
        playList.addToPlaylist(song1);

        Assertions.assertEquals(1, playList.getPlayList().size());

        playList.deleteFromPlaylist(song1);

        Assertions.assertEquals(0, playList.getPlayList().size());
    }

    @Test
    public void getSongFromPlaylist(){
        PlayList playList = new PlayList("Test");
        Song song1 = new Song();
        song1.setName("First");
        playList.addToPlaylist(song1);

        Assertions.assertEquals("First", playList.getSongFromPlaylist("First").getName());
    }
}
