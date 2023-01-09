package n2exercici1;

import java.util.*;

import static n2exercici1.Tools.getInt;
import static n2exercici1.Tools.getString;

public class Main {

    public static void main(String[] args ){

        int klk;
        Set<Restaurant> restaurantHashSet = new HashSet<>();

        do {
            System.out.println("What do you want to do?\n" +
                    "1. Add a restaurant.\n" +
                    "2. Exit.");
            klk = getInt("Choose an option");

            switch (klk){
                case 1:
                    addRestaurant(restaurantHashSet);
                    break;
                case 2:
                    System.out.println("Arrivederchi!");
                    break;
            }
        } while (klk != 2);

    }

    public static void addRestaurant(Set<Restaurant> restaurantHashSet){

        Restaurant rest = new Restaurant(getString("What's the restaurant name?"),
                getInt("What's it's punctuation?"));

        //IF PER A MOSTRAR MISSATGE SI S'HA AFEGIT O NO.
        if(restaurantExist(rest, restaurantHashSet)) {
            System.out.println("This restaurant is already at our database.");
        } else {
            restaurantHashSet.add(rest);
            System.out.println("Restaurant successfully added.");
        }



    }

    private static boolean restaurantExist(Restaurant restaurant, Set<Restaurant> restaurantHashSet) {
        boolean exist = false;

        Iterator <Restaurant> it = restaurantHashSet.iterator();

        while (it.hasNext() && !exist){
            Restaurant rest1 = it.next();
            if (rest1.equals(restaurant)){
                exist = true;
            }
        }

        return exist;
    }
}
