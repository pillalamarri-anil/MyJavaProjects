package HashMapInternals;

import java.util.ArrayList;



public class MyHashMap {

    private int capacity;
    private  int loadFactor;
    private  int size;
    private ArrayList<HMNode> [] buckets;

    public boolean ContainsKey(int key) {
        int hash = key % capacity;
        ArrayList<HMNode> bucket = buckets[hash];

        for(HMNode node : bucket) {
            if(node.key == key) {
                return true; // Key found
            }
        }
        return false; // Key not found
    }

    public void remove(int key) {
        int hash = key % capacity;
        ArrayList<HMNode> bucket = buckets[hash];

        for(HMNode node : bucket) {
            if(node.key == key) {
                size--;
                bucket.remove(node); // Remove the key-value pair
                return;
            }
        }
    }

    public int size() {
        return size;
    }

    // Initialize the hash map with the given capacity
    public MyHashMap(int capacity, int loadFactor) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;

        buckets = new ArrayList[capacity];
        for(int i = 0; i < capacity; i++) {
            buckets[i] = new ArrayList<HMNode>();
        }
    }

    public void put(int key, String value) {

        if(loadFactor * capacity <= size) {
            rehash();
        }

        int hash = key % capacity;
        ArrayList<HMNode> bucket = buckets[hash];

        for(HMNode node : bucket) {
            if(node.key == key) {
                node.value = value; // Update existing key
                return;
            }
        }
        size++;
        bucket.add(new HMNode(key, value)); // Add new key-value pair
    }

    private void rehash() {

        capacity *= 2;
        ArrayList<HMNode> [] newBuckets = new ArrayList[capacity];
        for(int i = 0; i < capacity; i++) {
            newBuckets[i] = new ArrayList<HMNode>();
        }

        for(ArrayList<HMNode> bucket : buckets) {
            for(HMNode node : bucket) {
                int hash = node.key % capacity;
                newBuckets[hash].add(node);
            }
        }
    }

    public String get(int key) {
        int hash = key % capacity;
        ArrayList<HMNode> bucket = buckets[hash];

        for(HMNode node : bucket) {
            if(node.key == key) {
                return node.value; // Return value for the key
            }
        }
        return null; // Key not found
    }
}
