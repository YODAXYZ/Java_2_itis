package Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class RandomArray implements Iterator<Integer> {
    private int count = 0;
    ArrayList<Integer> randomArray = new ArrayList<>();

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override

    public Integer next() {
        Random r = new Random();
        randomArray.add(r.nextInt(101) + 1);
        Integer el = randomArray.get(count);
        count++;
        return el;
    }

    public static void main(String[] args) {
        RandomArray randomArray = new RandomArray();
        System.out.println(randomArray.next());
        System.out.println(randomArray.next());
        System.out.println(randomArray.hasNext());
    }
}
