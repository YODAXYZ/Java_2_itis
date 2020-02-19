package comparator_comparable;

import java.util.Comparator;

public class Book implements Comparator<Book> {
    private int str_count;
    private String material;

    public Book(int str_count, String material) {
        this.str_count = str_count;
        this.material = material;
    }

    @Override
    public int compare(Book o1, Book o2) {
        return Math.abs(o1.str_count - o2.str_count);
}
}
