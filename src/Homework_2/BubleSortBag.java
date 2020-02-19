package Homework_2;

import java.util.Comparator;

public class BubleSortBag implements Comparator<Bag> {
    @Override
    public int compare(Bag o1, Bag o2) {
        if (o1.getWidth() == o2.getWidth()) return 0;
        if (o1.getWidth() < o2.getWidth()) return 1;
        return -1;
    }

    public Bag[] sort(Bag[] bags) {
        for (int i = 0; i < bags.length; i++) {
            Bag pivot;
            for (int j = 0; j < bags.length - 1; j++) {
                if(compare(bags[i], bags[j]) > 0)  {
                    pivot = bags[i];
                    bags[i] = bags[j];
                    bags[j] = pivot;
                }
            }
        }
        return bags;
    }
    public static void main(String[] args) {
        Bag bag3 = new Bag("r+", "adidas", 15);
        Bag bag1 = new Bag("r", "adidas", 11);
        Bag bag2 = new Bag("r", "nike", 10);
        Bag[] bags = new Bag[]{bag3, bag2, bag1};

       BubleSortBag bubleSortBag = new BubleSortBag();
       Bag[] sortBags = bubleSortBag.sort(bags);
        for (int i = 0; i < bags.length; i++) {
            System.out.println(i  + ": " + bags[i]);
        }
        System.out.println(bubleSortBag.compare(bag1, bag2));
        System.out.println("Sort bag ");
        for (int i = 0; i < sortBags.length; i++) {
            System.out.println(i  + ": " + sortBags[i].getWidth());
        }
    }
}
