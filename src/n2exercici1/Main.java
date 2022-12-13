package n2exercici1;

import java.util.*;

import static n2exercici1.Tools.getInt;
import static n2exercici1.Tools.getString;

public class Main {

    public static void main(String[] args ){

        int klk;
        Set<Restaurant> restaurantHashSet = new HashSet<>();

        do {
            System.out.println("Que vols fer?\n" +
                    "1. Afegir un restaurant.\n" +
                    "2. Sortir.");
            klk = getInt("Tria una opció");

            switch (klk){
                case 1:
                    addRestaurant(restaurantHashSet);
                    break;
                case 2:
                    System.out.println("Adeu!");
                    break;
            }
        } while (klk != 2);

    }

    public static void addRestaurant(Set<Restaurant> restaurantHashSet){

        Restaurant rest = new Restaurant(getString("What's the restaurant name?"),
                getInt("What's it's punctuation?"));

        if(restaurantExist(rest, restaurantHashSet)) {
            System.out.println("This restaurant is already at our database.");
        } else {
            restaurantHashSet.add(rest);
            System.out.println("Restaurant afegit amb exit.");
        }

    }

    private static boolean restaurantExist(Restaurant restaurant, Set<Restaurant> restaurantHashSet) {
        boolean exist = false;

        Iterator <Restaurant> it = restaurantHashSet.iterator();

        while (it.hasNext() && !exist){
            Restaurant rest1 = it.next();
            /*if (it.next().getName().equalsIgnoreCase(restaurant.getName()) && it.next().getPunctuation() == restaurant.getPunctuation()){
                //if (it.next().getPunctuation() == restaurant.getPunctuation()){
                    exist = true;
               // }
            }*/
            if(rest1.getName().equalsIgnoreCase(restaurant.getName()) && rest1.getPunctuation() == restaurant.getPunctuation()){
                exist = true;
            }
        }

        return exist;
    }
}
