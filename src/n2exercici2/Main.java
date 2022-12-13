package n2exercici2;

import java.util.*;

import static n2exercici2.Tools.getInt;
import static n2exercici2.Tools.getString;

public class Main {

    public static void main(String[] args ){

        int klk;
        Set<Restaurant> restaurantHashSet = new HashSet<>();
        Set<Restaurant> restaurantHash = new HashSet<Restaurant>();
        SortedSet<Restaurant> sortedRestaurants = new TreeSet<Restaurant>();

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
                    addRestaurant(restaurantHashSet, sortedRestaurants, restaurantHash);
                    break;
                case 2:
                    /*restaurantList = new ArrayList<Restaurant>(restaurantHashSet);
                    Collections.sort(restaurantList);
                    System.out.println(restaurantList);*/
                    System.out.println(sortedRestaurants);
                    break;
            }
        } while (klk != 0);

    }


    public static void addRestaurant(Set<Restaurant> restaurantHashSet, SortedSet<Restaurant> sortedRestaurants, Set<Restaurant> restaurantHash){

        Restaurant rest = new Restaurant(getString("What's the restaurant name?"),
                getInt("What's it's punctuation?"));

        if(restaurantExist(rest, restaurantHashSet)) {
            System.out.println("This restaurant is already at our database. Try again.");
        } else {
            restaurantHashSet.add(rest);
            restaurantHash.add(rest);
            sortedRestaurants.add(rest);
            System.out.println("Restaurant added successfully.");
        }

    }

    private static boolean restaurantExist(Restaurant restaurant, Set<Restaurant> restaurantHashSet) {
        boolean exist = false;

        Iterator <Restaurant> it = restaurantHashSet.iterator();

        while (it.hasNext() && !exist){
            Restaurant rest1 = it.next();
            if(rest1.getName().equalsIgnoreCase(restaurant.getName()) && rest1.getPunctuation() == restaurant.getPunctuation()){
                exist = true;
            }
        }

        return exist;
    }
}
