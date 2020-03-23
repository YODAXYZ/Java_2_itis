package Map;

import java.util.*;

public class NewHashMap<K, V> extends AbstractMap {
    private int capacity = 75;
    private HashMapper[] table;
    private int length;
    private float treshold;

    public NewHashMap(){
        this.length = 0;
        table = new HashMapper[capacity];
        treshold = (float) (capacity * 0.75);
    }

    /**
     * @param key
     * @apiNote
     * @return hash_code
     */
    public int hash(final K key){ // Индекс ячейки в массиве entry[]
        int hash = 37;
        hash = hash *17 + key.hashCode();
        return hash % table.length;
    }

    private int hash(Entry<K,V> node){
        return node.hashCode() % table.length;
    }

    private void insert(K key, V value) {
        if (length + 1 >= treshold) {
            treshold *= 2;
            // increase kolizium
        }
        HashMapper<K, V> newMapper = new HashMapper<>(key.hashCode(), key, value);
        int index =  Math.abs(hash(newMapper));
        if (table[index] == null) {
            table[index] = newMapper;
            length++;
        }
        else {
            LinkedList<HashMapper<K, V>> linkedList = table[index].getNodes();
            linkedList.addFirst(newMapper);
            newMapper.setNodes(linkedList);
            table[index] = newMapper;
            boolean has = false;
            for (int i = 0; i < linkedList.size(); i++) {
               if (linkedList.get(i).getKey().equals(key)) {
                   linkedList.set(i, newMapper);
                   has = true;
                   break;
               }
            }
            if (!has) {
                linkedList.addFirst(newMapper);
                length++;
            }
        }
    }

//    public void simpleAdd(int index, HashMapper<K, V> newNode) {
//        table[index] = new HashMapper(0, null, null);
//        table[index].getNodes().add(newNode);
//    }

    @Override
    public Set<Entry> entrySet() {
        return null;
    }

    public class HashMapper<K, V> implements Entry<K, V> {

        int hash;
        final K key;
        V value;
        LinkedList<HashMapper<K,V>> nodes;

        /**
         * @param hash
         * @param key
         * @param value
         */
        HashMapper(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            nodes= new LinkedList<HashMapper<K, V>>();
        }

        public LinkedList<HashMapper<K, V>> getNodes() {
            return nodes;
        }

        public final K getKey()        { return key; }
        public final V getValue()      { return value; }

        public final int hashCode() {
            hash = 31;
            hash = hash *17 + key.hashCode();
            return hash;
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public void setNodes(LinkedList<HashMapper<K, V>> nodes) {
            this.nodes = nodes;
        }
    }

    public void sout() {
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) {
                // System.out.println("EEWQ");
            }
            else {
                System.out.print(i + " " + table[i].getKey() + " ");
                System.out.println(table[i].getValue());
            }
        }
    }

    public static void main(String[] args) {
        NewHashMap<String,String> rem = new NewHashMap<String, String>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        rem.insert("RRevelation","Origin");
        rem.insert("RRevelation","ee");
        rem.insert("Motd","Rextester");
        rem.sout();

    }

}

