package n2exercici2;

import java.util.*;

import static n2exercici2.Tools.getInt;
import static n2exercici2.Tools.getString;

public class Main {

    public static void main(String[] args ){

        int klk;
        //Set<Restaurant> restaurantHashSet = new HashSet<>();
        Set<Restaurant> restaurantTreeSet = new TreeSet<>(new objectComparator());

        do {
            System.out.println("What do you want to do?\n" +
                    "1. Add a restaurant.\n" +
                    "2. Display all restaurants. \n" +
                    "0. Exit.");
            klk = getInt("Choose an option");

            switch (klk){
                case 0:
                    System.out.println("Arrivederchi!");
                    break;
                case 1:
                    addRestaurant(restaurantTreeSet);
                    break;
                case 2:
                    displayRestaurants(restaurantTreeSet);
                    break;
            }
        } while (klk != 0);

    }


    public static void addRestaurant(Set<Restaurant> restaurantTreeSet){

        Restaurant rest = new Restaurant(getString("What's the restaurant name?"),
                getInt("What's it's punctuation?"));

        if(restaurantExist(rest, restaurantTreeSet)) {
            System.out.println("This restaurant is already at our database. Try again.");
        } else {
            restaurantTreeSet.add(rest);
            System.out.println("Restaurant added successfully.");
        }

    }

    private static boolean restaurantExist(Restaurant restaurant, Set<Restaurant> restaurantTreeSet) {
        boolean exist = false;

        Iterator <Restaurant> it = restaurantTreeSet.iterator();

        while (it.hasNext() && !exist){
            Restaurant rest1 = it.next();
            if(rest1.getName().equalsIgnoreCase(restaurant.getName()) && rest1.getPunctuation() == restaurant.getPunctuation()){
                exist = true;
            }
        }

        return exist;
    }

    private static void displayRestaurants(Set<Restaurant> restaurantTreeSet){

        System.out.println("Those are all the restaurants:\n");
        for (Restaurant res : restaurantTreeSet){
            System.out.print(res.getName() + " " + res.getPunctuation());
            System.out.println();
        }

    }
}
