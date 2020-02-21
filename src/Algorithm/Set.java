package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class Set<T> implements Setter<T>{
    private ArrayList<T> arrayList;

    public Set(T[] array) {
        arrayList = new ArrayList<T>(Arrays.asList(array));
        for (int i = 0; i < arrayList.size() - 1; i++) {
            for (int j = i + 1; j < arrayList.size(); j++) {
                if (arrayList.get(i) == arrayList.get(j)) {
                    arrayList.remove(j);
                }
            }
        }
    }

    @Override
    public void add(T el) {
        boolean has = false;
        for (T t : arrayList) {
            if (t.equals(el)) {
                has = true;
            }
        }
        if (!has){
            arrayList.add(el);
        }
    }

    @Override
    public boolean has(T el) {
        for (T t : arrayList) {
            if (el == t) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return arrayList.size();
    }

    @Override
    public void delete(T el) {
        arrayList.remove(el);
    }

    public T get(int index) {
        return arrayList.get(index);
    }

    private void merge(Set<T> set) {
        for (int i = 0; i < set.size(); i++) {
            arrayList.add(set.get(i));
        }
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"222", "222", "ttt", "ttt"};
        Set<String> stringSet = new Set<>(strings);

        System.out.println(stringSet.size());
        stringSet.add("222");
        stringSet.add("111");
        System.out.println(stringSet.size());
    }
}
