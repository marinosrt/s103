package n1exercici1;

import java.util.ArrayList;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        int i = 0;

        ArrayList<Month> monthArrayList = new ArrayList<>();

        monthArrayList.add(new Month("January"));
        monthArrayList.add(new Month("February"));
        monthArrayList.add(new Month("March"));
        monthArrayList.add(new Month("April"));
        monthArrayList.add(new Month("May"));
        monthArrayList.add(new Month("June"));
        monthArrayList.add(new Month("July"));
        monthArrayList.add(new Month("September"));
        monthArrayList.add(new Month("October"));
        monthArrayList.add(new Month("November"));
        monthArrayList.add(new Month("November"));
        monthArrayList.add(new Month("December"));


        //AFEGIR AGOST CONSERVANT ORDRE
        while (!monthArrayList.get(i).getName().equalsIgnoreCase("July")){
            i++;
            if (monthArrayList.get(i).getName().equalsIgnoreCase("July")){
                monthArrayList.add(i+1, new Month("August"));
            }
        }

        //PRINT LLISTA PROVANT ORDRE
        System.out.println("LLISTA ORIGINAL DE ARRAYLIST: ");
        for (Month month : monthArrayList){
            System.out.print(month.getName() + ", ");
        }

        //CONVERTIR ARRAYLIST EN HASHSET I RECORRE-LA AMB FOREACH.
        Set <Month> monthList = new HashSet<>();
        /* Set<Month> monthList = new HashSet<>(monthArrayList);*/

        for (int k = 0; k < monthArrayList.size(); k++){
            monthList.add(monthArrayList.get(k));
        }

        /* TAMBÉ PUC FER-HO AIXÍ
        Iterator <Month> it2 = monthArrayList.iterator();
        while (it2.hasNext()){
            monthList.add(it2.next());
        }*/

        System.out.println("\nImprimint amb FOR-EACH: ");
        for (Month month : monthList){
            System.out.print(month.getName() + ", ");
        }


        //RECORRER LLISTA AMB ITERATOR
        Iterator <Month> it = monthList.iterator();

        System.out.println("\nImprimint amb ITERATOR: ");
        while (it.hasNext()){
            System.out.print(it.next().getName() + ", ");
        }

    }
}