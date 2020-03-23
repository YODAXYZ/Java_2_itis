package Project;

import java.util.*;

public class ReallyNewHashMap<K,V> extends AbstractMap<K,V> {
    private HashMapper[] table;
    private final int INITIAL_CAPASITY = 75;
    private int capacity;
    private double loadfactor;
    private double treshold;
    private int lenght;

    public ReallyNewHashMap() {
        loadfactor = 0.75;
        capacity = INITIAL_CAPASITY;
        table = new HashMapper[INITIAL_CAPASITY];
        treshold = INITIAL_CAPASITY * loadfactor;

    }
    public void insert(K key,V value){
        int hs =hash(key.hashCode()); // вычисляем хэш-код значения в таблице
        int idx = indexFor(key.hashCode(),capacity); //вычисляем индекс Ноды в таблице
        HashMapper e = new HashMapper(hs,key,value,null); // создаем ноду
        if(table[idx] == null){
            table[idx] = e;
            lenght+=1;
            refresh();
        }else{
            HashMapper temp  = table[idx];
            while(temp!=null){
                if(e.hash== temp.hash &&(e.key == temp.key||(e.key).equals(temp.key) )){ /// ситуация если ключи не совпадают а хэши совпадают обработана здесь
                    temp.value = e.value;

                    return;
                }
                if(temp.next==null){
                    break;
                }
                temp = temp.next;
            }
            temp.next = e;
            refresh();
        }
    }
    public Set<V> uniqSet(){
        Set set = new TreeSet();
        for(int i = 0;i<capacity;i++){
            if(table[i]!=null){
                HashMapper temp = table[i];
                while(temp!=null){
                    set.add(temp.value);
                    if(temp.next ==null){
                        continue;
                    }
                    temp = temp.next;
                }
            }
        }
        return set;
    }
    public V get(Object key){
        K keym = (K) key;
        int hs = hash(keym.hashCode());
        int idx = indexFor(keym.hashCode(),capacity);
        HashMapper temp = table[idx];
        while(temp.next!=null){
            if (temp.key.equals(keym)&&temp.hash ==hs){
                return (V) temp.value;
            }
            temp = temp.next;
        }
        return null;
    }

    public void delete(V value){
        for(int i = 0;i<capacity;i++) {
            if (table[i] != null) {
                while (table[i]!= null && table[i].value.equals(value)) {  // Если первый элемент и все за ним следующие совпадают по value
                    if(table[i].next==null){
                        table[i]=null;
                        continue;
                    }
                    table[i] = table[i].next;
                }
            }
        }
    }

    private  static int indexFor(int h, int length)   //h = key.hashCode() lenght = capacity
    {
        return h & (length - 1);
    }


    private  static int hash(int h)
    {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }


    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
    public void refresh(){
        if(lenght==capacity){
            capacity*=2;
            //HashMapper[] core = new HashMapper[capacity];

            HashMapper[] core = Arrays.copyOf(table,capacity);
            table = new HashMapper[capacity*2];
            for(int i = 0;i<core.length;i++){
                HashMapper temp =core[i];
                while(core[i]!=null){
                    this.insert((K)core[i].key,(V)core[i].value);
                    if(core[i].next!=null) {
                        core[i] = core[i].next;
                    }
                }
            }
        }
    }


    private class HashMapper<K, V> implements Map.Entry<K, V> {
        private   int hash;
        private final K key;
        private   V value;
        private HashMapper<K, V> next;

        HashMapper(int hash, K key, V value, HashMapper<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }


        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }
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

    public static void main(String[] args) {
        ReallyNewHashMap<String, String> map = new ReallyNewHashMap<>();
        map.insert("Rem","Glom");
        map.insert("Rem","Gloria");
        map.insert("BENDER","GIRONIMK");
        map.insert("BENDER","GIRONIMK");
        map.insert("BENDERwe","GIRONIMK");map.insert("BENDER1","GIRONIMK");map.insert("BENDER2","GIRONIMK");map.insert("BENDER3","GIRONIMK");
        map.delete("GIRONIMK");
        System.out.println(map.get("Rem"));

        map.insert("REVELATION","Raxer");
        System.out.println(Arrays.toString(map.table));
    }


}

