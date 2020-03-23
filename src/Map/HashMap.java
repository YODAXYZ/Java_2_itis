package Map;

import java.util.*;

public class HashMap<K, V> extends AbstractMap {
    private int capacity = 75;
    private Entry[] table;
    private int length;


    public HashMap(int capacity) {
        this.capacity = capacity;
        this.length = 1;
        table = new HashMapper[capacity];
    }
    public HashMap(){
        this.length = 1;
        table = new HashMapper[capacity];
    }

    public HashMap(Map<K, V> map) {
        this.length = 1;
        table = new HashMapper[capacity];

    }

    public HashMap(int capacity, Entry[] table) {
        this.capacity = capacity;
        this.table = table;
        this.length = 1;
    }

    @Override
    public Set<Entry> entrySet() {
        return null;
    }

    static int indexFor(int h, int length) {
        return h & (length - 1);
    }

    public int hash(K key) {
        return 7;
    }
    private void expansionMap(){
        table =Arrays.copyOf(table,table.length *2);
    }

    public void insert(K key, V value) {
        if (key == null) {
            throw new NullPointerException();
        }

        int index  = indexFor(key.hashCode(), capacity);

        if (length > capacity){
            expansionMap();
        }

        if (table[index] != null) {
            table[index] = new HashMapper(key.hashCode(), key, value, (HashMapper) table[index]);
        }
        else {
            table[index] = new HashMapper(key.hashCode(), key, value, null);
        }
        capacity--;
    }

//    void delete(String k): удаление элементов словаря, в которых значение - k

    public void delete(K key) {
        int index  = indexFor(key.hashCode(), length);
//        if ()
    }

    private class HashMapper<K, V> implements Entry<K, V> {
        int hash;
        final K key;
        V value;
        HashMapper<K,V> next;

        HashMapper(int hash, K key, V value, HashMapper<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }


        public final K getKey()        { return key; }
        public final V getValue()      { return value; }

        public final int hashCode() {
            hash = 31;
            hash = hash * 17 + key.hashCode();
            return hash;
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }
    }

    public void sout() {
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) {
                continue;
            }
            else {
                System.out.println(i + " " + table[i]);
            }
        }
    }

    public static void main(String[] args) {
        HashMap<String,String> rem = new HashMap<String, String>();
        rem.insert("Sand","Origin");
        rem.insert("mbcxnnlskn", "rrr");
        rem.sout();
        System.out.println("Sand".hashCode());
        System.out.println(indexFor("Sand".hashCode(), 18));
    }

}
