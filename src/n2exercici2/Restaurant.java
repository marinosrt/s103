package n2exercici2;

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


}
