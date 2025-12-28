package prg55;

import java.time.LocalDate;
import java.util.Objects;

public final class Person {
    private final String name;
    private final String surname;
    private final String fathername;
    private final LocalDate birthday;

    public Person(String name, String surname, String fathername, LocalDate birthday) {
        this.name = name;
        this.surname = surname;
        this.fathername = fathername;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", fathername='" + fathername + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public String name() {
        return name;
    }

    public String surname() {
        return surname;
    }

    public String fathername() {
        return fathername;
    }

    public LocalDate birthday() {
        return birthday;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Person) obj;
        return Objects.equals(this.name, that.name) &&
                Objects.equals(this.surname, that.surname) &&
                Objects.equals(this.fathername, that.fathername) &&
                Objects.equals(this.birthday, that.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, fathername, birthday);
    }

}
