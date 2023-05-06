package Blatt02;

import java.time.LocalDate;

/* Aufgabe 3
 * 3.1
 *      2021-05-03
 * 3.2
 *      2021-04-03 != 2021-04-05 also nein
 * 3.3
 *      MONDAY
 *      SATURDAY
 *      MONDAY
 * */

public class LocalDates {

    public static void main(String[] args){

        //3.1
        System.out.println(LocalDate.now());
        //3.2
        System.out.println(LocalDate.now().minusMonths(1));
        System.out.println(LocalDate.now().minusWeeks(4));
        //3.3
        System.out.println(LocalDate.now().getDayOfWeek());
        System.out.println(LocalDate.now().minusMonths(1).getDayOfWeek());
        System.out.println(LocalDate.now().minusWeeks(4).getDayOfWeek());
    }
}
