package Generic;

public class Some_example {
    static class Student<T1, T2> {

        public T2 get_count(T2 count){
            return count;
        }

        public T1  some_ficha(T1 world){
            return world;
        }
    }

    public static void main(String[] args) {
        Student student = new Student<String, Integer>();
        System.out.println(student.get_count(21));
        System.out.println(student.some_ficha("Hello"));
    }
}
