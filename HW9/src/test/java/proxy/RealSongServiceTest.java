package proxy;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RealSongServiceTest {

    @Test
    public void testSearchById() {
        SongService server = new RealSongService();
        Song song = server.searchById(1);

        assertEquals("still feel.", song.getTitle());
        assertEquals("Half Alive", song.getArtist());
    }

    @Test
    public void testSearchByTitle() {
        SongService server = new RealSongService();
        List<Song> results = server.searchByTitle("Chlorine");

        assertEquals(1, results.size());
        assertEquals("Twenty One Pilots", results.get(0).getArtist());
    }

    @Test
    public void testSearchByAlbum() {
        SongService server = new RealSongService();
        List<Song> results = server.searchByAlbum("Trench");

        assertEquals(1, results.size());
        assertEquals("Twenty One Pilots", results.get(0).getArtist());
    }
}