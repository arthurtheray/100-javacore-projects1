package prg42;

import java.util.Objects;

public class Cat {

    private final String name;
    private final double weight;

    public Cat(String name, double age) {
        if (name == null) {
            throw new NullPointerException("name can't be null");
        }

        this.name = name;
        this.weight = age;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Cat cat = (Cat) object;
        return weight == cat.weight && Objects.equals(name, cat.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
