package Collection;

import javax.swing.*;
import java.util.AbstractCollection;
import java.util.Iterator;

public class ModCollection<T> extends AbstractCollection<T> {
    private T[] array;
    private int last;


    public ModCollection(T[] array) {
        this.array = array;
        this.last = 0;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> iterator = new Iterator<>() {
            private int cursor = 0;

            @Override
            public boolean hasNext() {
                return array.length > cursor;
            }

            @Override
            public T next() {
                try {
                    T el = array[cursor];
                    cursor++;
                    return el;
                }catch (ArrayIndexOutOfBoundsException e) {
                    throw new java.util.NoSuchElementException();
                }
            }

            @Override
            public void remove() {
                T[] new_array = (T[]) new Object[array.length - 1];

                for (int i = 0; i < array.length - 1; i++) {
                    new_array[i] = array[i];
                }
                array = new_array;
            }
        };
        return iterator;
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public boolean add(T t) {
        T[] new_array = (T[]) new Object[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            new_array[i] = array[i];
        }
        new_array[array.length] = t;
        array = new_array;
        return true;
    }

    public void printer() {
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }


    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 3, 4};
        ModCollection<Integer> modCollection = new ModCollection<>(arr);
        modCollection.iterator().remove();
        modCollection.iterator().remove();
        modCollection.printer();
        modCollection.add(3);
        modCollection.printer();
    }
}
