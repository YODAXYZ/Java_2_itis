package Iterator;

import java.util.Iterator;

public class ArrayIteration2<T> implements Iterator<T> {
    private int cursor;
    private T[] arr;

    public ArrayIteration2(T[] arr) {
        this.arr = arr;
    }

    @Override
    public boolean hasNext() {
        int pivot = cursor;
        while (arr.length - 2 > pivot) {
            pivot += 2;
            if (arr[pivot] != null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public T next() {
        try {
            while (arr.length > cursor) {
                cursor += 2;
                T el = arr[cursor];
                if (arr[cursor] != null) {
                    return el;
                }
            }
        }catch (ArrayIndexOutOfBoundsException e) {
            throw new java.util.NoSuchElementException();
        }
        return null;
    }
}
