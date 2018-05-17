package Cache;



import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by yongchangli on 2017/5/15.
 */
public class Cache {
    /* One disadvantage of using Maps for caching is that you have to implement the eviction of entries yourself,
    e.g. to keep the size to a given limit.
    When you develop for a concurrent environment the task gets more complicated and a simple Map is not sufficient.
    You need to switch to a thread safe solution, e.g. a ConcurrentHashMap.
    ConcurrentHashMaps solve the concurrency problem, but the code gets ugly.
    You have to deal with the fact that keys can be added multiple times from different threads concurrently.
    */
    private static final long MAX_SIZE = 100;

    private final ConcurrentHashMap<String, String> map;

    public Cache(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    private String createChacheEntry(String key) {
        String result = map.get(key);
        if (result == null) {
            String putResult = map.putIfAbsent(key, createRandom());
            if (putResult != null) {
                result = putResult;
            }
        }
        return result;
    }

    private void removeOldestCacheEntryIfNecessary() {
        if (map.size() > MAX_SIZE) {
            String keyToDelete = map.keys().nextElement(); // very effective ;)
            map.remove(keyToDelete);
        }
    }

    private String createRandom() {
        return "I'm a random string or resource... Be creative ;)";
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }
}
