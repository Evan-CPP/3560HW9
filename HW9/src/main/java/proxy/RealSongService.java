package proxy;

import java.util.ArrayList;
import java.util.List;

public class RealSongService implements SongService {
    private final List<Song> database;

    public RealSongService() {
        database = new ArrayList<>();
        database.add(new Song(1, "still feel.", "Half Alive", "Now, Not Yet", 247));
        database.add(new Song(2, "Runaway", "Half Alive", "Now, Not Yet", 195));
        database.add(new Song(3, "Stressed Out", "Twenty One Pilots", "Blurryface", 202));
        database.add(new Song(4, "Chlorine", "Twenty One Pilots", "Trench", 324));
        database.add(new Song(5, "I / Me / Myself", "Will Wood", "The Normal Album", 291));
        database.add(new Song(6, "Laplace's Angel", "Will Wood", "The Normal Album", 241));
    }

    private void simulateNetworkDelay() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}
    }

    @Override
    public Song searchById(Integer songID) {
        simulateNetworkDelay();
        for (Song song : database) {
            if (song.getId().equals(songID)) {
                return song;
            }
        }
        return null;
    }

    @Override
    public List<Song> searchByTitle(String title) {
        simulateNetworkDelay();
        List<Song> results = new ArrayList<>();
        for (Song song : database) {
            if (song.getTitle().equalsIgnoreCase(title)) {
                results.add(song);
            }
        }
        return results;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        simulateNetworkDelay();
        List<Song> results = new ArrayList<>();
        for (Song song : database) {
            if (song.getAlbum().equalsIgnoreCase(album)) {
                results.add(song);
            }
        }
        return results;
    }
}