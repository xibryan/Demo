package sample.algorithm.leetcode;

import org.junit.jupiter.api.Test;

class LRUCacheTest {

    @Test
    void get() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.print();
        cache.get(1);
        cache.print();
        cache.put(3, 3);
        cache.print();
        cache.get(2);
        cache.print();
        cache.put(4, 4);
        cache.print();
        cache.get(1);
        cache.print();
        cache.get(3);
        cache.print();
        cache.get(4);
        cache.print();
    }
}