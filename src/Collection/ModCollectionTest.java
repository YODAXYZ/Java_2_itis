package Collection;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class ModCollectionTest {

    @org.junit.jupiter.api.Test
    void size() {
        Integer[] mas = new Integer[]{1,2,3,4};
        ModCollection<Integer> arr = new ModCollection<Integer>(mas);
        ModCollection<Integer> arr1 = new ModCollection<Integer>(mas);
        Assert.assertEquals(arr.size(), arr1.size());
    }

    @Test
    void size_err() {
        Integer[] mas = new Integer[]{1,2,3,4};
        ModCollection<Integer> arr = new ModCollection<Integer>(mas);
        ModCollection<Integer> arr1 = new ModCollection<Integer>(mas);
        Assert.assertEquals(arr.size_err(), arr1.size_err());
        Assert.assertEquals(arr.size_err(), 4);
    }

    @org.junit.jupiter.api.Test
    void add() {
        Integer[] mas = new Integer[]{1,2,3};
        Integer[] mas1 = new Integer[]{4314,123,3};
        ModCollection<Integer> arr = new ModCollection<Integer>(mas);
        ModCollection<Integer> arr1 = new ModCollection<Integer>(mas1);
        Assert.assertEquals(arr.getLast(), arr1.getLast());
    }



}