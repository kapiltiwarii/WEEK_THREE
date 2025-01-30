// Implementing HashMap with Separate Chaining (Linked List) for Collision Handling

import java.util.LinkedList;

public class HashMap<K, V> {
    // Define the size of the hash map (initial capacity)
    private static final int INITIAL_CAPACITY = 16;
    private LinkedList<Entry<K, V>>[] table;

    // Constructor to initialize the hash map
    public HashMap() {
        table = new LinkedList[INITIAL_CAPACITY];
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // Entry class to hold key-value pairs
    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Hash function to compute the index for the key
    private int hash(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    // Insert a key-value pair into the hash map
    public void put(K key, V value) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        // Check if the key already exists in the bucket and update value
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }

        // If the key does not exist, add a new entry
        bucket.add(new Entry<>(key, value));
    }

    // Retrieve the value associated with the key
    public V get(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }

        // Return null if the key is not found
        return null;
    }

    // Remove the key-value pair from the hash map
    public void remove(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                bucket.remove(entry);
                return;
            }
        }
    }

    // Check if the hash map contains a key
    public boolean containsKey(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return true;
            }
        }

        return false;
    }

    // Main method to test the HashMap implementation
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        // Insert some key-value pairs
        map.put("Alice", 25);
        map.put("Bob", 30);
        map.put("Charlie", 35);

        // Retrieve values
        System.out.println("Alice's age: " + map.get("Alice"));  // Output: 25
        System.out.println("Bob's age: " + map.get("Bob"));  // Output: 30

        // Remove a key-value pair
        map.remove("Alice");
        System.out.println("Alice's age after removal: " + map.get("Alice"));  // Output: null

        // Check if the map contains a key
        System.out.println("Contains 'Bob': " + map.containsKey("Bob"));  // Output: true
        System.out.println("Contains 'Alice': " + map.containsKey("Alice"));  // Output: false
    }
}
