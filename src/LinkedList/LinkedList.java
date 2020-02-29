package LinkedList;

public class LinkedList<T> {
    private int size = 0;
    private Node<T> head;

    public LinkedList(T[] elements) {
        addAll(elements);
    }

    public LinkedList() {
    }

    private boolean add(T el) {
        head = new Node<T>(el, head);
        size++;
        return true;
//        Node n = new Node<T>(el, null);
//        if(head == null){
//            head = n;
//        }
//        else{
//            Node node = head;
//            while (true){
//                if(node.next == null){
//                    node.next=n;
//                    break;
//                }else {
//                    node=node.next;
//                }
//            }
//        }
//        return true;
    }

    private boolean addAll(T[] array) {
        for (int i = 0;  i < array.length; i++) {
            add(array[i]);
            size++;
        }
        return true;
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
        while (node != null){
            System.out.println(node.item);
            node = node.next;
        }
    }

    private class Node<T>{
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

    private T getLast() {
        Node<T> node = head;
        while (node.next != null) {
            node = node.next;
        }
        return node.item;
    }

    private void merge(LinkedList l) {
        size += l.size;
        Node<T> node = head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = l.head;
    }

    public static void main(String[] args) {
        Integer[] array  = new Integer[]{1, 2, 3};
        LinkedList<Integer> linkedList = new LinkedList<Integer>(array);
        LinkedList<Integer> linkedList2 = new LinkedList<Integer>(array);
        linkedList.add(5);
        linkedList.addAfter(3);
        linkedList.get();
        linkedList.merge(linkedList2);
        System.out.println();
        linkedList.get();
    }
}
