package Blatt02_2020;

/*
* 2.: Man kann ein immutable Object frei benutzen, über mehere thrads hinweg und kann sicher sein das sich nichts
*     geändert hat. Keine Objecte die auf so etwas referenziren, können einen unterschied feststellen.
* */

import java.util.Objects;

public final class Pair<F extends Comparable,S extends Comparable> implements Comparable<Pair<F,S>>{

    private final F first;
    private final S second;

    Pair(F first, S second){
        this.first = first;
        this.second = second;
    }
    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    public F getFirst() {
        return first;
    }
    public S getSecond() {
        return second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return first.equals(pair.first) &&
                second.equals(pair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public int compareTo(Pair<F, S> pairToCompare) {
        F firstToCompare = pairToCompare.first;
        S secondToCompare = pairToCompare.getSecond();

        int firstCompared = first.compareTo(firstToCompare);
        int secondCompared = second.compareTo(secondToCompare);

        return (firstCompared != 0) ? firstCompared : secondCompared;
    }

}
