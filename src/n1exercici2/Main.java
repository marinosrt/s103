package n1exercici2;
import java.util.*;

public class Main {

    public static void main(String[] args){

        List <Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);
        list1.add(7);
        list1.add(8);
        list1.add(9);
        list1.add(10);

        List<Integer> list2 = new ArrayList<>();


        ListIterator<Integer> it = list1.listIterator(list1.size());


        while (it.hasPrevious()){
            list2.add(it.previous());
        }

        System.out.println("\nPrimera llista:");
        for (int i : list1){
            System.out.print(i + " - ");
        }

        System.out.println("\nSegona llista:");
        for (int i : list2){
            System.out.print(i + " - ");
        }

    }

}