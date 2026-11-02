package proxy;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

public class SongProxyTest {

    @Test
    public void testProxyCachesIdSearch() {
        SongService proxy = new SongProxy();

        Song firstSearch = proxy.searchById(3);
        Song secondSearch = proxy.searchById(3);

        assertNotNull(firstSearch);
        assertSame(firstSearch, secondSearch);
    }

    @Test
    public void testProxyCachesTitleSearch() {
        SongService proxy = new SongProxy();

        List<Song> firstSearch = proxy.searchByTitle("I / Me / Myself");
        List<Song> secondSearch = proxy.searchByTitle("I / Me / Myself");

        assertNotNull(firstSearch);
        assertSame(firstSearch, secondSearch);
    }
}