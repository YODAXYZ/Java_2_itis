package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class Multiset<T> implements Setter<T> {
    private ArrayList<T> arrayList;

    public Multiset(T[] array) {
        arrayList = new ArrayList<T>(Arrays.asList(array));
    }

    @Override
    public void add(T el) {
        arrayList.add(el);
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

    private T get(int index) {
        return arrayList.get(index);
    }

    private void merge(Multiset<T> set) {
        for (int i = 0; i < set.size(); i++) {
            arrayList.add(set.get(i));
        }
    }

    private int countOf(T el) {
        int count = 0;
        for (T t : arrayList) {
            if (el == t) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] arrayString = new String[]{"1", "fff"};
        String[] arrayString2 = new String[]{"2", "fff"};
        Multiset<String> stringSet = new Multiset<>(arrayString);
        Multiset<String> stringSet2 = new Multiset<>(arrayString);
        System.out.println(stringSet.has("1"));
        System.out.println(stringSet.size());
        stringSet.add("fff");
        System.out.println(stringSet.has("fff"));
        System.out.println(stringSet.has("f"));
        stringSet.merge(stringSet2);
        System.out.println(stringSet.size());
        System.out.println(stringSet.countOf("fff"));
    }
}
