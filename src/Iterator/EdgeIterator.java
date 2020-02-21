package Iterator;

import java.util.Iterator;

public class EdgeIterator<T> implements Iterator<T> {
    private T[] arr;
    private int last_cursor;
    private int cursor = 0;
    private int parity = 0;

    public EdgeIterator(T[] arr) {
        this.arr = arr;
        this.last_cursor = arr.length;
    }

    @Override
    public boolean hasNext() {
        return last_cursor - cursor > 0;
    }

    @Override
    public T next() {
        try {
            if (hasNext()) {
                if (parity % 2 == 0) {
                    T el = arr[cursor];
                    cursor++;
                    parity++;
                    return el;
                } else {
                    last_cursor--;
                    T el = arr[last_cursor];
                    parity++;
                    return el;
                }
            }
            else {
                throw new java.util.NoSuchElementException();
            }
        }catch (ArrayIndexOutOfBoundsException e) {
            throw new java.util.NoSuchElementException();
        }
    }

    public static void main(String[] args) {
        String[] arr = new String[]{"f", "c", "l"};
        EdgeIterator<String> edgeIterator = new EdgeIterator<>(arr);
        System.out.println(edgeIterator.hasNext());
        System.out.println(edgeIterator.next());
        System.out.println(edgeIterator.next());
        System.out.println(edgeIterator.hasNext());
        System.out.println(edgeIterator.next());
        System.out.println(edgeIterator.hasNext());
        System.out.println(edgeIterator.next());
    }
}
