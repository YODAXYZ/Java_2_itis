package lambda;

import java.util.Comparator;

class People {
    private int age;
    private char gender;

    public People(int age, char gender) {
        this.age = age;
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public char getGender() {
        return gender;
    }
}
public class Lambda_comparator {
    public static void main(String[] args) {
        Comparator<People> peopleComparator = new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                if (o1.getAge() == o2.getAge()) {
                    return 0;
                }
                if (o1.getAge() > o2.getAge()) {
                    return 1;
                }
                else {
                    return -1;
                }
            }
        };
    }
}
