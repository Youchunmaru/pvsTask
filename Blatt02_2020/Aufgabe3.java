package Blatt02_2020;

import java.time.LocalDate;

public class Aufgabe3 {

    public static void main(String[] args){

        System.out.println(LocalDate.now());
        System.out.println(LocalDate.now().minusMonths(1));
        System.out.println(LocalDate.now().minusWeeks(4));
        System.out.println(LocalDate.now().getDayOfWeek());
        System.out.println(LocalDate.now().minusMonths(1).getDayOfWeek());
        System.out.println(LocalDate.now().minusWeeks(4).getDayOfWeek());
    }
    //Aufgabe 3:
    //2. Nein
    /*
    * Out:
      2020-05-10
      2020-04-10
      2020-04-12
      SUNDAY
      FRIDAY
      SUNDAY
    * */
}
