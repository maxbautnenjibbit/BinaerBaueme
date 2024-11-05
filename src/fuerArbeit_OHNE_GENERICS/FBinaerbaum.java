package fuerArbeit_OHNE_GENERICS;

public class FBinaerbaum {

    private FKnoten wurzel = null;

    public FBinaerbaum() {
        // Formelsammlung sagt, es gibt auch einen leeren Konstruktor
    }

    public FBinaerbaum(FKnoten pWurzel) {
        wurzel = pWurzel;
    }

    public FKnoten gibWurzel() {
        return wurzel;
    }

    public void setzeWurzel(FKnoten pWurzel) {
        wurzel = pWurzel;
    }

    public int anzahlKnoten() {
        if (istLeer()) return -1;

        return wurzel.anzahlKnoten();
    }

    public int anzahlBlaetter() {
        if (istLeer()) return -1;

        return wurzel.anzahlBlaetter();
    }

    public int tiefe() {
        if (istLeer()) return -1;

        return wurzel.tiefe();
    }

    public boolean istLeer() {
        return wurzel == null;
    }

    public void ausgebenDatenInorder() {
        if (istLeer()) return;

        wurzel.ausgebenDatenInorder();
    }

    public void ausgebenDatenPreorder() {
        if (istLeer()) return;

        wurzel.ausgebenDatenPreorder();
    }

    public void ausgebenDatenPostorder() {
        if (istLeer()) return;

        wurzel.ausgebenDatenPostorder();
    }

    /*
     * Ab hier geordneter Binaerbaum
     * ?? Keine Ahnung ob das dran kommt
     * Denke nicht, ist komplex.. Vielleicht ein Teil davon
     */

    /*
     * Übergabewert ist ein Knoten... Je nach Parametern muss man aber auch
     * direkt in der Methode eine neuen FKnoten "erschaffen" (new FKnoten(Parameter...))
     */
    public void einfuegen(FKnoten toAdd) {
        if (istLeer()) {
            setzeWurzel(toAdd);
            return;
        }

        // Startet bei der Wurzel
        FKnoten toCheck = gibWurzel();
        FKnoten addPosition = null; // Position um nach der While Schleife einzufügen
        boolean wouldPutRight = false; // Benötigt um zu entscheiden, ob man den neuen Knoten rechts oder links einfügt

        while (toCheck != null) {
            // WICHTIG: MAN BRAUCH IRGENDWAS ZUM VERGLEICHEN.. KANN ALLES SEIN! HIER: MODELLNUMMER
            int valueFromCheck = toCheck.getModellNummer();

            if (valueFromCheck == toAdd.getModellNummer())
                return; // Inhalt ist bereits im Baum

            addPosition = toCheck;

            if (toAdd.getModellNummer() < valueFromCheck) {
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

    /*
     * Hier könnte man zwar direkt das FKnoten Objekt vergleichen,
     * denke aber eher, dass man hier einen einzelnen Integer Wert vergleichen muss
     * für enthaelt.. In dem Fall wieder die Modellnummer (KANN ALLES SEIN)
     */
    public boolean enthaelt(int modellnummer) {
        if (istLeer()) {
            return false;
        }

        FKnoten toCheck = gibWurzel();

        while (toCheck != null) {
            int valueFromCheck = toCheck.getModellNummer();

            if (valueFromCheck == modellnummer)
                return true;

            if (modellnummer < valueFromCheck) {
                toCheck = toCheck.gibLinkenKnoten();
            } else {
                toCheck = toCheck.gibRechtenKnoten();
            }
        }

        return false;
    }

    /*
     * Hier könnte man zwar direkt das FKnoten Objekt vergleichen,
     * denke aber eher, dass man hier einen einzelnen Integer Wert vergleichen muss
     * für getMaxWert.. In dem Fall wieder die Modellnummer (KANN ALLES SEIN)
     */
    public int getMaxWert() {
        if (istLeer()) return -1;

        FKnoten toCheck = gibWurzel();

        //Man muss irgendwas definieren, zum Beispiel die Wurzel
        int currMax = wurzel.getModellNummer();
        while (toCheck != null) {
            currMax = toCheck.getModellNummer();
            FKnoten nextBiggerOne = toCheck.gibRechtenKnoten(); // Dadurch, dass alles geordnet ist, ist alles was größer ist rechts

            if (nextBiggerOne != null) {
                toCheck = nextBiggerOne;
            } else {
                return currMax;
            }
        }

        return currMax;
    }

    public int getMinWert() {
        if (istLeer()) return -1;

        FKnoten toCheck = gibWurzel();

        //Man muss irgendwas definieren, zum Beispiel die Wurzel
        int currMin = wurzel.getModellNummer();
        while (toCheck != null) {
            currMin = toCheck.getModellNummer();
            FKnoten nextSmallerOne = toCheck.gibLinkenKnoten(); // Dadurch, dass alles geordnet ist, ist alles was kleiner ist links

            if (nextSmallerOne != null) {
                toCheck = nextSmallerOne;
            } else {
                return currMin;
            }
        }

        return currMin;
    }


    //DAS HIER IST NUR VISUELL UND KOMMT EIGENTLICH NICHT DRAN
    public void ausgebenBaumStruktur() {
        if (istLeer()) {
            System.out.println("Der Baum ist leer.");
        } else {
            ausgebenBaumStruktur(wurzel, 0);
        }
    }

    //DAS HIER IST NUR VISUELL UND KOMMT EIGENTLICH NICHT DRAN
    private void ausgebenBaumStruktur(FKnoten knoten, int ebene) {
        if (knoten == null) {
            return;
        }

        ausgebenBaumStruktur(knoten.gibRechtenKnoten(), ebene + 1);

        for (int i = 0; i < ebene; i++) {
            System.out.print("\t");
        }

        System.out.println(knoten.getModellNummer());

        ausgebenBaumStruktur(knoten.gibLinkenKnoten(), ebene + 1);
    }

}
