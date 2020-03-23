package Map;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class Map<K, V> extends AbstractMap<K, V> implements java.util.Map<K, V> {

    private ArrayList<Mapper<K, V>> mappers;
    private int count = 0;

    public Map() {
        mappers = new ArrayList<>();
    }

    public void soutArray() {
        for (int i = 0; i < mappers.size(); i++) {
            System.out.println("Key: " + mappers.get(i).key + "; Value: " + mappers.get(i).value);
        }
    }

    public ArrayList<Mapper<K, V>> getMappers() {
        return mappers;
    }


    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return mappers.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        for (Mapper mapper : mappers) {
            if (mapper.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (Mapper mapper : mappers) {
            if (mapper.value.equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public V get(Object key) {
        for (Mapper mapper : mappers) {
            if (mapper.key.equals(key)) {
                if (mapper.value == null) {
                    throw new NullPointerException();
                }
                return (V) mapper.value;
            }
        }
        throw new UnsupportedOperationException();
    }


    @Override
    public V put(K key, V value) {
        Mapper<K, V> mapper = new Mapper<K, V>(key, value);
        mappers.add(mapper);
        count++;
        return (V) mappers.get(count - 1);
    }

    @Override
    public V remove(Object key) {
        for (int i = 0; i < mappers.size(); i++) {
            if (mappers.get(i).key.equals(key)) {
                mappers.remove(i);
            }
        }
        count--;
        throw new UnsupportedOperationException();
    }

    @Override
    public void putAll(java.util.Map<? extends K, ? extends V> m) {
        for (Entry map : m.entrySet()) {
            mappers.add((Mapper) map);
        }
    }

    @Override
    public void clear() {
        mappers = new ArrayList<>();
        count = 0;
    }

    @Override
    public Set<K> keySet() {
        Set set = null;
        for (Mapper mapper : mappers) {
            set.add(mapper.key);
        }
        return set;
    }

    @Override
    public Collection<V> values() {
        Collection collection = null;
        for (Mapper mapper : mappers) {
            collection.add(mapper.value);
        }
        return collection;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        ArrayList<Entry<K, V>> set = null;
        for (Mapper mapper : mappers) {
            set.add(mapper);
        }
        return (Set<Entry<K, V>>) set;
    }


    public static class Mapper<K, V> implements Entry<K, V>{
        K key;
        V value;
        public Mapper(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            return this.value=value;
        }
    }

//    public static void main(String[] args) {
//        Map<String, String> map = new Map<String, String>();
//        map.put("l", "ll");
//        System.out.println(map.size());
//        map.soutArray();
//    }
}
