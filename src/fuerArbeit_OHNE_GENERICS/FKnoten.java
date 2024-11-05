package fuerArbeit_OHNE_GENERICS;

public class FKnoten {

    /*
     * Irgendwelche Paramter... Hier kann man alles nnehmen
     * bzw. was in der Aufabge ist
     */
    private String marke;
    private int modellNummer;

    // KONSTRUKTOR "INITALISIERUNG VON DEN VARIABLEN"
    public FKnoten(String pMarke, int pModellNummer) {
        marke = pMarke;
        modellNummer = pModellNummer;
    }


    /*
     * Die ganz normalen Getter / Setter für die Parameter...
     */

    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }

    public int getModellNummer() {
        return modellNummer;
    }

    public void setModellNummer(int modellNummer) {
        this.modellNummer = modellNummer;
    }

    // AB HIER NORMALER KNOTEN FUER BINAERBAUM

    private FKnoten linkerFKnoten;
    private FKnoten rechterFKnoten;


    public FKnoten gibLinkenKnoten() {
        return linkerFKnoten;
    }

    public FKnoten gibRechtenKnoten() {
        return rechterFKnoten;
    }

    public void setzeLinkenKnoten(FKnoten pLinks) {
        linkerFKnoten = pLinks;
    }

    public void setzeRechtenKnoten(FKnoten pRechts) {
        rechterFKnoten = pRechts;
    }


    // WICHTIG FUER DIE ARBEIT
    public boolean istBlatt() {
        return linkerFKnoten == null && rechterFKnoten == null;
    }

    public void ausgebenDatenInorder() {
        if (linkerFKnoten != null) {
            linkerFKnoten.ausgebenDatenInorder();
        }

        //Nur ein Beispiel, kann hier auch wieder alles sein
        System.out.print(modellNummer + " MARKE: " + marke + " ");

        if (rechterFKnoten != null) {
            rechterFKnoten.ausgebenDatenInorder();
        }
    }

    public void ausgebenDatenPreorder() {
        //Nur ein Beispiel, kann hier auch wieder alles sein
        System.out.print(modellNummer + " MARKE: " + marke + " ");

        if (linkerFKnoten != null) {
            linkerFKnoten.ausgebenDatenPreorder();
        }

        if (rechterFKnoten != null) {
            rechterFKnoten.ausgebenDatenPreorder();
        }
    }

    public void ausgebenDatenPostorder() {
        if (linkerFKnoten != null) {
            linkerFKnoten.ausgebenDatenPostorder();
        }

        if (rechterFKnoten != null) {
            rechterFKnoten.ausgebenDatenPostorder();
        }

        //Nur ein Beispiel, kann hier auch wieder alles sein
        System.out.print(modellNummer + " MARKE: " + marke + " ");
    }

    public int anzahlKnoten() {
        int sum = 1; // Der Knoten selbst

        if (linkerFKnoten != null) {
            sum += linkerFKnoten.anzahlKnoten();
        }

        if (rechterFKnoten != null) {
            sum += rechterFKnoten.anzahlKnoten();
        }

        return sum;
    }

    public int anzahlBlaetter() {
        if (istBlatt()) {
            return 1;
        }

        int sum = 0;

        if (linkerFKnoten != null) {
            sum += linkerFKnoten.anzahlBlaetter();
        }

        if (rechterFKnoten != null) {
            sum += rechterFKnoten.anzahlBlaetter();
        }

        return sum;
    }

    public int tiefe() {
        // Initial Wert ist 1, da man immer eins "tiefer" geht
        int depthLeft = 1;
        int depthRight = 1;

        if (linkerFKnoten != null) {
            depthLeft += linkerFKnoten.tiefe();
        }

        if (rechterFKnoten != null) {
            depthRight += rechterFKnoten.tiefe();
        }

        if (depthLeft > depthRight) {
            return depthLeft;
        } else {
            return depthRight;
        }
    }

}
