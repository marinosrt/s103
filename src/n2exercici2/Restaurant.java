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

    @Override
    public boolean equals(Object o) {
        /*if (this == o) return true;
        if (!(o instanceof Restaurant restaurant)) return false;
        return Objects.equals(name, restaurant.name);*/


        if (o == null) {   return false;  }
        if (getClass() != o.getClass()) {  return false;   }
        final Restaurant other = (Restaurant) o;
        if (!Objects.equals(this.name, other.name)) {    return false;     }
        if (this.punctuation != other.punctuation) {     return false;   }
        return true;

    }

    @Override
    public int hashCode() {
        //return Objects.hash(name);
        return punctuation + name.hashCode();
    }
}
