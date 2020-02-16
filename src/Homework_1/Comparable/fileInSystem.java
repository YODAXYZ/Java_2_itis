package Homework_1.Comparable;

public class fileInSystem implements Comparable<fileInSystem>{
    private int size;
    private String name;
    private String pathToFile;

    public fileInSystem(int size, String name, String pathToFile) {
        this.size = size;
        this.name = name;
        this.pathToFile = pathToFile;
    }

    @Override
    public int compareTo(fileInSystem o) {
        if (this.size == o.size) return 1;
        else {
            if (pathToFile.equals(o.pathToFile)) return 1;
            else if (name.equals(o.name)) return -1;
        }
        return 0;
    }
}
