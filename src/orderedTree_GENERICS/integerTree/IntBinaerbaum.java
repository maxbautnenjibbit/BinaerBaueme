package orderedTree_GENERICS.integerTree;

import orderedTree_GENERICS.Binaerbaum;
import orderedTree_GENERICS.Knoten;

public class IntBinaerbaum extends Binaerbaum<Integer> {

    /*
     * Ab hier geordneter Binaerbaum
     */

    public void einfuegen_int(int pInhalt) {
        Knoten<Integer> toAdd = new Knoten<>(pInhalt);

        if (istLeer()) {
            setzeWurzel(toAdd);
            return;
        }

        Knoten<Integer> toCheck = gibWurzel();
        Knoten<Integer> addPosition = null;
        boolean wouldPutRight = false;

        while (toCheck != null) {
            int valueFromCheck = toCheck.gibInhalt();

            if (valueFromCheck == pInhalt)
                return; // Inhalt ist bereits im Baum

            addPosition = toCheck;

            if (pInhalt < valueFromCheck) {
                toCheck = toCheck.gibLinkenKnoten();
                wouldPutRight = false;
            } else {
                toCheck = toCheck.gibRechtenKnoten();
                wouldPutRight = true;
            }
        }

        if (addPosition != null) {
            if (wouldPutRight) {
                addPosition.setzeRechtenKnoten(toAdd);
            } else {
                addPosition.setzeLinkenKnoten(toAdd);
            }
        }
    }

    public boolean enthealt_int(int pInteger) {
        if (istLeer()) {
            return false;
        }

        Knoten<Integer> toCheck = gibWurzel();

        while (toCheck != null) {
            int valueFromCheck = toCheck.gibInhalt();

            if (valueFromCheck == pInteger)
                return true;

            if (pInteger < valueFromCheck) {
                toCheck = toCheck.gibLinkenKnoten();
            } else {
                toCheck = toCheck.gibRechtenKnoten();
            }
        }

        return false;
    }

    public int getMaxWert_int() {
        if (istLeer()) return -1;

        Knoten<Integer> toCheck = gibWurzel();

        //Man muss irgendwas definieren obwohl der Fall nicht eintreten kann..
        //Kann auch die Wurzel als Vergleich nehmen
        int currMax = Integer.MIN_VALUE;
        while (toCheck != null) {
            currMax = toCheck.gibInhalt();
            Knoten<Integer> nextBiggerOne = toCheck.gibRechtenKnoten();

            if (nextBiggerOne != null) {
                toCheck = nextBiggerOne;
            } else {
                return currMax;
            }
        }

        return currMax;
    }

    public int getMinWert_int() {
        if (istLeer()) return -1;

        Knoten<Integer> toCheck = gibWurzel();

        //Man muss irgendwas definieren obwohl der Fall nicht eintreten kann..
        //Kann auch die Wurzel als Vergleich nehmen
        int currMin = Integer.MAX_VALUE;
        while (toCheck != null) {
            currMin = toCheck.gibInhalt();
            Knoten<Integer> nextSmallerOne = toCheck.gibLinkenKnoten();

            if (nextSmallerOne != null) {
                toCheck = nextSmallerOne;
            } else {
                return currMin;
            }
        }

        return currMin;
    }


}
