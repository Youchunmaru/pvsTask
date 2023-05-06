//package de.uulm.in.pm.test;
package Blatt01.test;


import Blatt01.api.Eagle;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Samuel Gröner
 * @Blatt 01
 * @Tut 3
 * a further documentation on where the solved task are, can be found @Blatt01.txt
 *
 * */
/** Main class. */
public class Main {

  /** Run tests. */
  public static void main(String[] args) {

    /** 3.1
     * more information -> @link Blatt01.txt(Aufgabe 3)
     * 3.2
     * 3.3
     * */
    //AbstractBird tweety = new AbstractBird(100,2);
    Eagle amos = new Eagle(100,"Amos",2);
    System.out.println(amos);
    Eagle amos2 = new Eagle(100,"Amos",2);
    System.out.println(amos==amos2);
    System.out.println(amos.equals(amos2));

    /** 5.2
     * @param wrongEagle has to many legs ->
     *                   throws exc
     * @exception IllegalArgumentException is caught and the err msg printed
     * */
    try{
      Eagle wrongEagle = new Eagle(100, "wrongEagle",1200);
    }catch (IllegalArgumentException illegalArgumentException){
      System.err.println(illegalArgumentException.getMessage());
    }

    /**6
     * without generics
     * more information -> @link Blatt01.txt(Aufgabe 6)
     * */
    List aviary = new ArrayList();
    Eagle anyEagle;
    aviary.add(new Eagle(100,"Brutus",2));
    aviary.add(new Eagle(100,"Chronos",2));

    for (int i = 0; i < aviary.size(); i++) {

      anyEagle = (Eagle) aviary.get(i);
      anyEagle.hunt();
    }
    /**6
     * with generics
     * more information -> @link Blatt01.txt(Aufgabe 6)
     * */
    List<Eagle> genericAviary = new ArrayList<Eagle>();
    Eagle genericAnyEagle;
    aviary.add(new Eagle(100,"Brutus",2));
    aviary.add(new Eagle(100,"Chronos",2));

    for (int i = 0; i < aviary.size(); i++) {

      genericAnyEagle = genericAviary.get(i);
      genericAnyEagle.hunt();
    }
  }
}
