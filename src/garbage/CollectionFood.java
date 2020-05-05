package garbage;


import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class CollectionFood {
    HashMap<String, HashMap<String, Float>> rating_food = new HashMap<>();
    ArrayList<String> name_array = new ArrayList<>();


    public CollectionFood(String name, HashMap food) {
        rating_food.put(name, food);
        name_array.add(name);
    }
    public void addUser(String name, HashMap food) {
        rating_food.put(name, food);
        name_array.add(name);
    }


    public void favoriteFoods(Float rating) {
        System.out.print("{");
        for (int i = 0; i < name_array.size(); i++) {
            AtomicBoolean status = new AtomicBoolean(false);
            HashMap<String, Float> ans = new HashMap<>();
            rating_food.get(name_array.get(i)).forEach((key, value) -> {
                if (value >= rating) {
                    ans.put(key, value);
                    status.set(true);
                }
            });
            if (!status.get()) {
                System.out.print(" " + name_array.get(i) + "[]");
            }
            else {
                String[] ans_s = ans.keySet().toArray(new String[0]);
                Arrays.sort(ans_s);
                System.out.print(" " + name_array.get(i) + " [" );
                for (String s: ans_s) {
                    System.out.print("\"" + s +"\" ");
                }
                System.out.print("]");

            }
        }
        System.out.println(" }");
    }

    public static void main(String[] args) {
        HashMap<String, Float> hashMap = new HashMap<>();
        hashMap.put("test", (float) 0.0);
        hashMap.put("te", (float) 5.0);
        hashMap.put("a", (float) 5.0);
        HashMap<String, Float> hashMap2 = new HashMap<>();
        hashMap2.put("u", (float) 0.0);
        CollectionFood food = new CollectionFood("Valya", hashMap );
        food.addUser("Ser", hashMap2);
        food.favoriteFoods((float) 4.5);

    }
}
