package Homework_1.Comparable;

public class People implements Comparable<People>{
    private char gender;

    public People(char gender) {
        this.gender = gender;
    }

    @Override
    public int compareTo (People anotherPeople) {
        if (this.gender == anotherPeople.gender) return 1;
        else return -1;
    }
}
