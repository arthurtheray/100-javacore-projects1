package prg37;

import java.util.Objects;

public class Student implements Comparable<Student> {

    private final String name;
    private final String group;

    public Student(String name, String group) {
        this.name = Objects.requireNonNull(name);
        this.group = Objects.requireNonNull(group);
    }

    @Override
    public int compareTo(Student o) {
        if (o == null) {
            throw new NullPointerException();
        }

        int byName = name.compareTo(o.name);

        if (byName != 0) {
            return byName;
        }
        return group.compareTo(o.group);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Student student = (Student) object;
        return Objects.equals(name, student.name) && Objects.equals(group, student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, group);
    }
}
