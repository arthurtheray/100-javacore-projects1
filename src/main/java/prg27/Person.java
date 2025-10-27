package prg27;

import java.util.Objects;

public class Person {
    private final int age;
    private final String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        int result = this.age != 0 ? Integer.hashCode(this.age) : 0;
        result = 31 * result + (this.name != null ? this.name.hashCode() : 0);
        return result;
    }


}
