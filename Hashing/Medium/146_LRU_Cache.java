
/**
 * Design a data structure that follows the constraints of a Least Recently Used
 * (LRU) cache.
 * 
 * Implement the LRUCache class:
 * 
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise
 * return -1.
 * void put(int key, int value) Update the value of the key if the key exists.
 * Otherwise, add the key-value pair to the cache. If the number of keys exceeds
 * the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * 
 * Explanation
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // cache is {1=1}
 * lRUCache.put(2, 2); // cache is {1=1, 2=2}
 * lRUCache.get(1); // return 1
 * lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
 * lRUCache.get(2); // returns -1 (not found)
 * lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
 * lRUCache.get(1); // return -1 (not found)
 * lRUCache.get(3); // return 3
 * lRUCache.get(4); // return 4
 * 
 * 
 * Constraints:
 * 
 * 1 <= capacity <= 3000
 * 0 <= key <= 104
 * 0 <= value <= 105
 * At most 2 * 105 calls will be made to get and put.
 * Accepted
 * 1,240,824
 * Submissions
 * 3,064,251
 */

import java.util.*;

class LRUCache {
    class Node {
        int val, key;
        Node next, prev;

        Node(int val, int key) {
            this.val = val;
            this.key = key;
        }
    }

    Node head, tail;

    private void addNode(Node node) {
        Node prev = tail.prev;
        prev.next = node;
        node.next = tail;
        tail.prev = node;
        node.prev = prev;
    }

    private void deleteNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void deleteLRU() {
        if (head.next == tail)
            return;
        Node node = head.next;
        head.next = head.next.next;
        head.next.prev = head;
        hm.remove(node.key);
    }

    HashMap<Integer, Node> hm = new HashMap<>();
    int capacity;

    public LRUCache(int capacity) {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!hm.containsKey(key))
            return -1;
        deleteNode(hm.get(key));
        addNode(hm.get(key));
        return hm.get(key).val;
    }

    public void put(int key, int value) {
        if (!hm.containsKey(key)) {
            Node node = new Node(value, key);
            hm.put(key, node);
            addNode(node);
        } else {
            Node node = new Node(value, key);
            deleteNode(hm.get(key));
            hm.put(key, node);
            addNode(hm.get(key));
        }
        if (hm.size() > capacity) {
            deleteLRU();
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */