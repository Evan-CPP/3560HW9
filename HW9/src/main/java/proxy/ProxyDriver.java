package proxy;

public class ProxyDriver {
    public static void main(String[] args) {
        SongService proxy = new SongProxy();
        long start, end;


        System.out.println("--------- Search By ID ---------");

        start = System.currentTimeMillis();
        proxy.searchById(4);
        end = System.currentTimeMillis();
        System.out.println("Time elapsed: " + (end - start) + "ms\n");

        start = System.currentTimeMillis();
        proxy.searchById(4);
        end = System.currentTimeMillis();
        System.out.println("Time elapsed: " + (end - start) + "ms\n");


        System.out.println("--------- Search By Title ---------");

        start = System.currentTimeMillis();
        proxy.searchByTitle("I / Me / Myself");
        end = System.currentTimeMillis();
        System.out.println("Time elapsed: " + (end - start) + "ms\n");

        start = System.currentTimeMillis();
        proxy.searchByTitle("I / Me / Myself");
        end = System.currentTimeMillis();
        System.out.println("Time elapsed: " + (end - start) + "ms\n");
        

        System.out.println("--------- Search By Album ---------");

        start = System.currentTimeMillis();
        proxy.searchByAlbum("Now, Not Yet");
        end = System.currentTimeMillis();
        System.out.println("Time elapsed: " + (end - start) + "ms\n");

        start = System.currentTimeMillis();
        proxy.searchByAlbum("Now, Not Yet");
        end = System.currentTimeMillis();
        System.out.println("Time elapsed: " + (end - start) + "ms");
    }
}