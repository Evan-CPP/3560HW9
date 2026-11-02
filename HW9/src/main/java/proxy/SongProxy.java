package proxy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SongProxy implements SongService {
    private final RealSongService realServer;

    private final Map<Integer, Song> idCache;
    private final Map<String, List<Song>> titleCache;
    private final Map<String, List<Song>> albumCache;

    public SongProxy() {
        this.realServer = new RealSongService();
        this.idCache = new HashMap<>();
        this.titleCache = new HashMap<>();
        this.albumCache = new HashMap<>();
    }

    @Override
    public Song searchById(Integer songID) {
        if (idCache.containsKey(songID)) {
            System.out.println("Found by proxy cache: " + songID);
            return idCache.get(songID);
        }

        System.out.println("Not cached. Searching server for: " + songID);
        Song song = realServer.searchById(songID);

        if (song != null) {
            idCache.put(songID, song);
        }
        return song;
    }

    @Override
    public List<Song> searchByTitle(String title) {
        String cacheKey = title.toLowerCase();

        if (titleCache.containsKey(cacheKey)) {
            System.out.println("Found by proxy cache: " + title);
            return titleCache.get(cacheKey);
        }

        System.out.println("Not cached. Searching server for: " + title);
        List<Song> songs = realServer.searchByTitle(title);
        titleCache.put(cacheKey, songs);

        return songs;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        String cacheKey = album.toLowerCase();

        if (albumCache.containsKey(cacheKey)) {
            System.out.println("Found by proxy cache: " + album);
            return albumCache.get(cacheKey);
        }

        System.out.println("Not cached. Searching server for: " + album);
        List<Song> songs = realServer.searchByAlbum(album);
        albumCache.put(cacheKey, songs);

        return songs;
    }
}