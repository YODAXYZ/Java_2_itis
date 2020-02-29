package Collection;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

public class Collection_self<T> extends AbstractCollection<T> {
    private T[] array;
    private int cursor;


    public Collection_self(T[] array) {
        this.array = array;
        this.cursor = 0;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator iterator = new Iterator() {
            @Override
            public boolean hasNext() {
                return array.length > cursor;
            }

            @Override
            public Object next() {
                try {
                    T el = array[cursor];
                    cursor++;
                    return el;
                }catch (ArrayIndexOutOfBoundsException e) {
                    throw new java.util.NoSuchElementException();
                }
            }
        };
        return iterator;
    }

    @Override
    public int size() {
        return array.length;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 3};
        Collection_self<Integer> collection_self = new Collection_self<Integer>(arr);
        System.out.println(collection_self.iterator().next());
    }
}
