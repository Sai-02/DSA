import java.util.*;

class HashMap<K, V> {

    private class HMNode {
        K key;
        V value;

        HMNode(K key, V value) {
            this.key = key;
            this.value = value;

        }
    }

    private int size;
    private LinkedList<HMNode>[] buckets;

    public HashMap() {
        initbuckets(4);
        size = 0;
    }

    private void initbuckets(int N) {
        buckets = new LinkedList[N];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    public void put(K key, V value) {
        int bi = hashfnc(key);
        int di = getIndexWithInBucket(key, bi);
        if (di != -1) {
            HMNode node = buckets[bi].get(di);
            node.value = value;
        } else {
            buckets[bi].add(new HMNode(key, value));
            size++;
        }
        double lambda = size * 1.0 / buckets.length;
        if (lambda > 2.0)
            rehash();
    }

    private void rehash() {
        LinkedList<HMNode>[] oba = buckets;
        initbuckets(oba.length * 2);
        size = 0;
        for (int i = 0; i < oba.length; i++) {
            for (HMNode node : oba[i]) {
                put(node.key, node.value);
            }
        }
    }

    private int hashfnc(K key) {
        int hc = key.hashCode();
        return Math.abs(hc) % buckets.length;
    }

    private int getIndexWithInBucket(K key, int bi) {
        int di = 0;
        for (HMNode node : buckets[bi]) {
            if (node.key.equals(key))
                return di;
            di++;
        }
        return -1;
    }

    public V get(K key) throws Exception {
        int bi = hashfnc(key);
        int di = getIndexWithInBucket(key, bi);
        if (di == -1)
            throw new Exception("Key is not present");
        return buckets[bi].get(di).value;
    }

    public boolean containsKey(K key) {
        int bi = hashfnc(key);
        int di = getIndexWithInBucket(key, bi);
        if (di == -1)
            return false;
        return true;
    }

    public V remove(K key) throws Exception {
        int bi = hashfnc(key);
        int di = getIndexWithInBucket(key, bi);
        if (di == -1)
            throw new Exception("No such key is present");
        else {
            V val = buckets[bi].get(di).value;
            buckets[bi].remove(di);
            return val;

        }
    }

    public ArrayList<K> keyset() {
        ArrayList<K> keys = new ArrayList<>();
        for (int bi = 0; bi < buckets.length; bi++) {
            for (HMNode node : buckets[bi]) {
                keys.add(node.key);
            }
        }
        return keys;
    }

    public int size() {
        return size;
    }
}