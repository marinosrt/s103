package n2exercici1;

import n1exercici1.Month;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static n2exercici1.Tools.getInt;
import static n2exercici1.Tools.getString;

public class Main {

    public static void main(String[] args ){

        int klk;
        ArrayList<Restaurant> restaurantArrayList = new ArrayList<>();
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


        if(clientExist(rest, restaurantHashSet)) {
            //Ya existe
        } else {
            //Se inserta
        }

    }

    private static boolean clientExist(Restaurant restaurant, Set<Restaurant> restaurantHashSet) {
        boolean existe = false;

        for(int i = 0; i < restaurantHashSet.size(); i++) {
            if(restaurantHashSet.get(i).punctuation == restaurant.punctuation) {
                existe = true;
                break;
            }
        }

        return existe;
    }
}
