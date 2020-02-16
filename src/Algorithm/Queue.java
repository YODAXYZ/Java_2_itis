package Algorithm;

public class Queue<T>{
    private Object[] arr;
    private int size;
    private int maxSize;
    private int delete_elem = 0;


    public Queue(int maxSize) {
        this.arr  = new Object[maxSize + 1];
        this.size = -1;
        this.maxSize = maxSize;
    }

    public void add(T elem) {
        size++;
        arr[size] = elem;
    }

    public T pop() {
        T elem = (T) arr[delete_elem];
        delete_elem++;
        return elem;
    }

    public int size() {
        return size + 1;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>(3);
        queue.add(1);
        queue.add(3);
        queue.add(4);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println();

    }
}
