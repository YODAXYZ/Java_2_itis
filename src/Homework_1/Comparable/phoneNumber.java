package Homework_1.Comparable;

public class phoneNumber implements Comparable<phoneNumber>{
    private int region;

    public phoneNumber(int region) {
        this.region = region;
    }

    @Override
    public int compareTo(phoneNumber o) {
        if (this.region == 0) return 1;
        else return -1;
    }
}
