package Blatt02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * @author Samuel Gröner
 * Blatt 02
 * Tut 3
 * for a more detailed overview ->
 * @see Blatt02
 * */

public class Main {

    public static void main(String[] args){

        /* 2.2
         * a ArrayList of 32 Pairs is crated, sorted and than printed
         * */
        //List creation
        ArrayList<Pair> pairList = new ArrayList<>();
        pairList.add(new Pair(1,2));
        pairList.add(new Pair(2,2));
        pairList.add(new Pair(2,1));
        pairList.add(new Pair(2,2));
        pairList.add(new Pair(3,2));
        pairList.add(new Pair(3,3));
        pairList.add(new Pair(2,3));
        for (int i = 0; i < 25; i++) {
            pairList.add(new Pair(i,25-i));
        }
        //sorting the List
        Collections.sort(pairList);
        //printing the List
        pairList.forEach((Pair value) -> System.out.println(value.toString()));
        /* 2.3
         * the ArrayList is in a HashSet inserted, duplicate data is printed
         * */
        System.out.println("HashSet:");
        HashSet<Pair> pairHashSet = new HashSet<>();
        for (Pair pair: pairList) {
            if (pairHashSet.contains(pair)) {
                System.out.println(pair.toString());
            }
            pairHashSet.add(pair);
        }
    }
}
