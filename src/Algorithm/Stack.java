package Algorithm;

import java.util.ArrayList;

public class Stack<T> {
    private ArrayList<T> arrayList = new ArrayList<>();
    private int top = 0;

    public void add(T elem) {
        arrayList.add(elem);
        top++;
    }

    public T pop() {
        --top;
        T value = arrayList.get(top);
        arrayList.remove(top);
        return value;
    }

    public T peek() {
        return arrayList.get(top - 1);
    }

    public int size() {
        return top;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.add(1);
        stack.add(3);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println("Size:" + stack.size());
        System.out.println(stack.peek());
        System.out.println(stack.peek());

    }
}


