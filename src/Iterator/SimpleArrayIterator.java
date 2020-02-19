package Iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArrayIterator implements Iterator<String> {
    protected String[] data;
    protected int cursor;

    @Override
    public boolean hasNext() {
        return data.length > cursor;
    }




    @Override
    public String next() {
//        if (data.length <= cursor) {
//            throw new java.util.NoSuchElementException();
//        }

        try {
            String el = data[cursor];
            cursor++;
            return el;
        }catch (ArrayIndexOutOfBoundsException e) {
            throw new java.util.NoSuchElementException();
        }
    }
}
