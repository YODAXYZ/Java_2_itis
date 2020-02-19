package Homework_2;

import java.util.Comparator;

public class Bag implements Comparator<Bag> {
    private String bagType;
    private String model;
    private int width;

    public Bag(String bagType, String model, int width) {
        this.bagType = bagType;
        this.model = model;
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public int compare(Bag o1, Bag o2) {
        if (o1.width == o2.width) return 0;
        else return 1;
    }
}
