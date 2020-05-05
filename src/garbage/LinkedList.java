package garbage;


import java.util.ArrayList;

public class LinkedList<T> {
    private int size = 0;
    private Node<T> head;

    public LinkedList(T[] elements) {
        addAll(elements);
    }

    public LinkedList() {
    }

    public LinkedList(ArrayList<T> arrayList1) {
        addAll(arrayList1);
    }

    private boolean add(T el) {
        head = new Node<T>(el, head);
        size++;
        return true;
    }

    private boolean addAll(T[] array) {
        for (int i = 0; i < array.length; i++) {
            add(array[i]);
            size++;
        }
        return true;
    }

    private boolean addAll(ArrayList array) {
        for (int i = 0; i < array.size(); i++) {
            add((T) array.get(i));
            size++;
        }
        return true;
    }

    public LinkedList removeAlternating() {
        Node<T> node = head;
        int i = 0;
        ArrayList<T> arrayList1 = new ArrayList();
        ArrayList<T> arrayList2 = new ArrayList();
        ArrayList pos_del = new ArrayList();
        while (node != null) {
            i++;
            if (i % 4 == 1 || i % 4 == 2) {
                arrayList1.add(node.item);
            }
            else {
                pos_del.add(i - 1);
            }
            node = node.next;
        }
        for (int j = 0; j < pos_del.size()- 1; j++) {
            remove((T) pos_del.get(i));
        }
        return new LinkedList<T>(arrayList1);
    }

    public boolean addAfter(T el) {
        Node<T> node = head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = new Node<T>(el, null);
        size++;
        return true;
    }

    public int size() {
        return size;
    }

    public void get() {
        Node<T> node = head;
        while (node != null) {
            System.out.println(node.item);
            node = node.next;
        }
    }

    private class Node<T> {
        T item;
        Node next;

        Node(T element, Node<T> next) {
            this.item = element;
            this.next = next;
        }
    }

    private boolean remove(int index) {
        Node<T> node = head;
        for (int i = 0; i < index - 1; i++) {
            node = node.next;
        }
        node.next = node.next.next;
        return true;
    }

    private boolean remove(T el) {
        Node<T> node = head;
        for (int i = 0; i < size; i++) {
            if (node.item.equals(el)) {
                node.next = node.next.next;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        LinkedList<Integer> linkedList = new LinkedList<Integer>(array);
        LinkedList<Integer> linkedList2 = linkedList.removeAlternating();
        linkedList2.get();
    }
}
