package Map;

import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.Set;

public class HashMapNadya<K, V> extends AbstractMap<K, V> {
    private int capacity = 75;
    private float treshold;
    private int length;
    private LinkedList<NadyaMapper<K, V>>[] table;

    public HashMapNadya() {
        treshold = (float) (capacity * 0.75);
        table = new LinkedList[capacity];
        length = 0;
    }

    public int hash(final K key){ // Индекс ячейки в массиве entry[]
        int hash = 37;
        hash = hash *17 + key.hashCode();
        return hash % table.length;
    }

    private int hash(Entry<K,V> node){
        return node.hashCode() % table.length;
    }

    public void insert(K key, V value) {
        int index = hash(key);
        NadyaMapper<K, V> nadyaMapper = new NadyaMapper<K, V>(key, value);
        LinkedList<NadyaMapper<K, V>> linkedList = new LinkedList<>();
//        linkedList.add(nadyaMapper.nadyaMappers)
        boolean has = false;
        if (table[index] == null) {
            table[index] = nadyaMapper.getNode();
            length++;
        }
        else {
            for (int i = 0; i < table[index].size(); i++) {
                if (table[index].get(i).getKey().equals(key)) {
                    table[index].set(i, nadyaMapper);
                }
            }
            if (!has) {
                table[index].addFirst(nadyaMapper);
            }
        }
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    public class NadyaMapper<K, V> {
        private K key;
        private V value;
        private LinkedList<NadyaMapper<K, V>> node;

        public NadyaMapper(K key, V value) {
            this.key = key;
            this.value = value;
            node = new LinkedList<>();
        }

        public LinkedList<NadyaMapper<K, V>> getNode() {
            return node;
        }

        public void setNode(LinkedList<NadyaMapper<K, V>> node) {
            this.node = node;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
    public void sout() {
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) {
                // System.out.println("EEWQ");
            }
            else {
                System.out.print(i + " " + table[i].get(i).getKey() + " ");
                System.out.println(table[i].get(i).getValue());
            }
        }
    }


    public static void main(String[] args) {
        HashMapNadya<String, String>  nadya = new HashMapNadya<String, String>();
        nadya.insert("TO", "ttt");
        nadya.insert("TO", "ttt");
    }
}


