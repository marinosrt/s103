package n2exercici2;

import java.util.Comparator;

public class objectComparator implements Comparator <Restaurant> {


    //RETURNS
    // a negative integer, zero, or a positive integer
    // as the first argument
    // is less than, equal to, or greater than the second.


    @Override
    public int compare(Restaurant o1, Restaurant o2) {
        if (o1.getName().compareTo(o2.getName()) == 0) {
            if (o1.getPunctuation() < o2.getPunctuation()) {
                return 1;
            } else if (o1.getPunctuation() > o2.getPunctuation()) {
                return -1;
            } else {
                return 0;
            }
        } else {
            return o1.getName().compareTo(o2.getName());
        }
    }
}
