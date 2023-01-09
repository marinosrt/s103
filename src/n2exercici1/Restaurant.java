package n2exercici1;

import n1exercici1.Month;

import java.util.Objects;

public class Restaurant {

    private String name;
    private int punctuation;

    public Restaurant(String name, int punctuation) {
        this.name = name;
        this.punctuation = punctuation;
    }

    public String getName() {
        return name;
    }

    public int getPunctuation() {
        return punctuation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        //return punctuation == that.punctuation && name.equals(that.name);
        return Objects.equals(name, that.name) && punctuation == that.punctuation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, punctuation);
    }
}
