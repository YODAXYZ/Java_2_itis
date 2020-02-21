package Algorithm;

public interface Setter<T> {
    public void add(T el);
    public boolean has(T el);
    public int size();
    public void delete(T el);
}
