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
        if (!(o instanceof Restaurant restaurant)) return false;
        return Objects.equals(name, restaurant.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
