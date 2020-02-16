package Homework_1;

public class Pair <T1, T2>{
    public final T1 t1;
    public final T2 t2;

    public Pair(T1 t1, T2 t2) {
        this.t1 = t1;
        this.t2 = t2;
    }

    public T1 getT1() {
        return t1;
    }

    public T2 getT2() {
        return t2;
    }

    public static void main(String[] args) {
        Pair<String, String> pair = new Pair<>("s", "s1");
        System.out.println(pair.getT1());
    }
}


