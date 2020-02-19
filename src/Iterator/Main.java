package Iterator;

public class Main {
    public static void main(String[] args) {
        String[] arr = new String[]{null, null, null, "3", "3"};
        ArrayIteration2<String>  arrayIteration2 = new ArrayIteration2<>(arr);
        System.out.println(arrayIteration2.hasNext());
        System.out.println(arrayIteration2.next());
    }
}
