package Navigableset;

import javax.xml.namespace.QName;
import java.util.*;

public class NavigableSet<E> implements SortedSet<E> {
    ArrayList<E> arrayList;
    Comparator<E> comparator;

    public NavigableSet(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public NavigableSet(Collection<E> collection, Comparator<E> comparator) {
        this.arrayList = (ArrayList<E>) collection;
        this.comparator = comparator;
        sort_navigable();
    }

//    public NavigableSet(ArrayList<E> collection, Comparator<E> comparator) {
//        this.arrayList = collection;
//        this.comparator = comparator;
//        sort_navigable();
//    }

    private void sort_navigable() {
        for (int i = 0; i < arrayList.size() - 1; i++) {
            for (int j = i; j < arrayList.size(); j++) {
                if (comparator.compare(arrayList.get(i), arrayList.get(j)) < 0) {
                    E pivot = arrayList.get(i);
                    arrayList.set(i, arrayList.get(j));
                    arrayList.set(j, pivot);
                }
            }
        }
    }

    @Override
    public Comparator<? super E> comparator() {
        return comparator;
    }

    @Override
    public SortedSet<E> subSet(E fromElement, E toElement) {
        NavigableSet<E> edge = null;
        boolean hasLastElem = false;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) == fromElement) {
                for (int j = i; j < arrayList.size(); j++) {
                    edge.add(arrayList.get(j));
                    if (arrayList.get(j) == toElement) {
                        hasLastElem = true;
                        break;
                    }
                }
            }
        }
        if (!hasLastElem) {
            throw new NullPointerException();
        }
        if (edge == null) {
            throw new IllegalArgumentException();
        }
        return (SortedSet<E>) edge;
    }

    @Override
    public SortedSet<E> headSet(E toElement) {
        NavigableSet<E> edge = null;
        boolean hasLastElem = false;
        for (int i = 0; i < arrayList.size(); i++) {
            edge.add(arrayList.get(i));
            if (arrayList.get(i) == toElement) {
                hasLastElem = true;
                break;
            }
        }
        if (edge == null) {
            throw new IllegalArgumentException();
        }
        if (!hasLastElem) {
            throw new NullPointerException();
        }
        return (SortedSet<E>) edge;
    }

    @Override
    public SortedSet<E> tailSet(E fromElement) {
        NavigableSet<E> edge = null;
        boolean hasFirst = false;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) == fromElement) {
                for (int j = i; j < arrayList.size(); j++) {
                    edge.add(arrayList.get(i));
                }
                hasFirst = true;
                break;
            }
        }
        if (edge == null) {
            throw new IllegalArgumentException();
        }
        if (!hasFirst) {
            throw new NullPointerException();
        }
        return (SortedSet<E>) edge;
    }

    @Override
    public E first() {
        return arrayList.get(0);
    }

    @Override
    public E last() {
        return arrayList.get(arrayList.size());
    }

    @Override
    public int size() {
        return arrayList.size();
    }

    @Override
    public boolean isEmpty() {
        return arrayList.size() > 0;
    }

    @Override
    public boolean contains(Object o) {
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return arrayList.iterator();
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            array[i] = arrayList.get(i);
        }
        return array;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return arrayList.toArray(a);
    }

    @Override
    public boolean add(E e) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (comparator.compare(arrayList.get(i), e) == 0) {
                return false;
            }
        }
        arrayList.add(e);
        sort_navigable();
        return true;
    }

    @Override
    public boolean remove(Object o) {
        arrayList.remove(o);
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        Map<E, Integer> contain = null;
        ArrayList<E> collection = (ArrayList<E>) c;

        for (int i = 0; i < c.size(); i++) {
            contain.put(((ArrayList<E>) c).get(i), 0);
        }

        int size_contain = contain.size();
        for (int i = 0; i < arrayList.size(); i++) {
            if (contain.containsKey(arrayList.get(i))) {
                size_contain--;
            }
        }

        if (size_contain == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        ArrayList<E> collection = (ArrayList<E>) c;
        for (int i = 0; i < c.size(); i++) {
            arrayList.add(((ArrayList<E>) c).get(i));
        }
        sort_navigable();
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        Map<E, Integer> contain = null;
        ArrayList<E> collection = (ArrayList<E>) c;

        for (int i = 0; i < arrayList.size(); i++) {
            contain.put((arrayList).get(i), 0);
        }

        for (int i = 0; i < collection.size(); i++) {
            if (contain.containsKey(collection.get(i))) {
                contain.replace(collection.get(i), 1);
            }
        }

        for (int i = 0; i < contain.size(); i++) {
            if (contain.get(i) == 0) {
                arrayList.remove(contain.get(i));
            }
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        Map<E, Integer> contain = null;
        ArrayList<E> collection = (ArrayList<E>) c;

        for (int i = 0; i < arrayList.size(); i++) {
            contain.put((arrayList).get(i), 0);
        }

        for (int i = 0; i < collection.size(); i++) {
            if (contain.containsKey(collection.get(i))) {
                contain.replace(collection.get(i), 1);
            }
        }

        for (int i = 0; i < contain.size(); i++) {
            if (contain.get(i) == 1) {
                arrayList.remove(contain.get(i));
            }
        }
        return true;
    }

    @Override
    public void clear() {
        arrayList = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return arrayList.hashCode();
    }

    public void sout() {
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i) + " ");
        }
        System.out.println();
    }

//    public static void main(String[] args) {
//        Comparator comparator = new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                if (o1 == o2) {
//                    return 0;
//                }
//                if ((Integer) o1 > (Integer) o2) {
//                    return -1;
//                }
//                return 1;
//            }
//        };
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        for (int i = 1; i < 5; i++) {
//            arrayList.add(i);
//        }
//        NavigableSet navigableSet = new NavigableSet(arrayList, comparator);
//        navigableSet.add(10);
//        navigableSet.add(0);
//        navigableSet.add(0);
//        navigableSet.sout();
//    }
}
