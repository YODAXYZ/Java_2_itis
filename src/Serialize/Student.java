package Serialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;

public class Student implements Serializable {
    private String name;
    private char sex;
    private String group;
    private String birthDate;
    private int byteLen;

    public Student(String name, String group, String birthDate, char sex) {
        this.name = name;
        this.sex = sex;
        this.group = group;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public char getSex() {
        return sex;
    }

    public String getGroup() {
        return group;
    }

    public String getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", group=" + group +
                ", birthDate=" + birthDate +
                '}';
    }

    public static void serialize(Collection<Student> students, String path) {
        try (FileOutputStream out = new FileOutputStream(path)) {
            ByteBuffer buffer = ByteBuffer.allocate(4);
            buffer.putInt(students.size());
            out.write(buffer.array());
            out.flush();

            for (Student student : students) {

                int nameLen = student.getName().getBytes().length;
                int groupLen = student.getGroup().getBytes().length;
                int birthLen = student.getBirthDate().getBytes().length;
                buffer = ByteBuffer.allocate(12);
                buffer.putInt(nameLen);
                buffer.putInt(groupLen);
                buffer.putInt(birthLen);
                out.write(buffer.array());
                out.flush();

                buffer = ByteBuffer.allocate(groupLen + birthLen + nameLen + 2);

                buffer.put(student.getName().getBytes());
                buffer.put(student.getGroup().getBytes());
                buffer.put(student.getBirthDate().getBytes());
                buffer.putChar(student.getSex());
                out.write(buffer.array());
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Collection<Student> deserialize(String path) {
        try (FileInputStream in = new FileInputStream(path)) {
            ByteBuffer buffer = ByteBuffer.allocate(4);
            in.read(buffer.array());
            int size = buffer.getInt();

            Collection<Student> students = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                buffer = ByteBuffer.allocate(4);
                in.read(buffer.array());
                byte[] name = new byte[buffer.getInt()];

                buffer = ByteBuffer.allocate(4);
                in.read(buffer.array());
                byte[] group = new byte[buffer.getInt()];

                buffer = ByteBuffer.allocate(4);
                in.read(buffer.array());
                byte[] birth = new byte[buffer.getInt()];

                buffer = ByteBuffer.allocate(2);
                in.read(name);
                in.read(group);
                in.read(birth);
                in.read(buffer.array());
                students.add(new Student(
                        new String(name),
                        new String(group),
                        new String(birth),
                        buffer.getChar()));
            }
            return students;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        ArrayList<Student> arr = new ArrayList<>();
        arr.add(new Student("Alex", "11-902", "27.03.2002", 'M'));
        arr.add(new Student("Alexey", "11-902", "27.03.2001", 'M'));

        Student.serialize(arr, "students.txt");
        ArrayList<Student> arr1 = (ArrayList<Student>) Student.deserialize("students.txt");
        for (Student student : arr1) {
            System.out.println(student);
        }

        try (StudentDataOutputStream outer = new StudentDataOutputStream(new FileOutputStream("student.txt"));
             StudentDataInputStream inner = new StudentDataInputStream(new FileInputStream("student.txt"))) {
            Student s1 = new Student("Alex", "11-908", "11.03.2002", 'M');
            outer.writeStudent(s1);
            Student s2 = inner.readStudent();
            System.out.println(s2.getName() + "-" + s2.getGroup() + "-" + s2.getSex() + "-" + s2.getBirthDate());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (StudentObjectOutputStream outer = new StudentObjectOutputStream(new FileOutputStream("studentObj.txt"));
             StudentObjectInputStream inner = new StudentObjectInputStream(new FileInputStream("studentObj.txt"))) {
            Student s1 = new Student("Alex", "11-908", "11.03.2002", 'M');
            outer.writeStudent(s1);
            Student s2 = inner.readStudent();
            System.out.println(s2.getName() + "-" + s2.getGroup() + "-" + s2.getSex() + "-" + s2.getBirthDate());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
