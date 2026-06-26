import java.util.*;

public class LRUCache {

    private int capacity;
    private Map<Integer, Integer> cache;
    private LinkedList<Integer> order;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        order = new LinkedList<>();
    }

    public int get(int key) {

        if (!cache.containsKey(key)) {
            return -1;
        }

        order.remove((Integer) key);
        order.addLast(key);

        return cache.get(key);
    }

    public void put(int key, int value) {

        if (cache.containsKey(key)) {

            order.remove((Integer) key);

        } else if (cache.size() == capacity) {

            int lru = order.removeFirst();
            cache.remove(lru);
        }

        cache.put(key, value);
        order.addLast(key);
    }

    public static void main(String[] args) {

        LRUCache lru = new LRUCache(2);

        lru.put(1, 1);
        lru.put(2, 2);

        System.out.println(lru.get(1));

        lru.put(3, 3);

        System.out.println(lru.get(2));

        lru.put(4, 4);

        System.out.println(lru.get(1));
        System.out.println(lru.get(3));
        System.out.println(lru.get(4));
    }
}
