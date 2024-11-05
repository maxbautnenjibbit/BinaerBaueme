package tree_GENERICS;

public class Knoten<Typ> {

    private Typ inhalt;

    private Knoten<Typ> linkerKnoten;
    private Knoten<Typ> rechterKnoten;

    public Knoten(Typ pInhalt) {
        inhalt = pInhalt;
    }

    public Typ gibInhalt() {
        return inhalt;
    }

    public void setzeInhalt(Typ pInhalt) {
        inhalt = pInhalt;
    }

    public Knoten<Typ> gibLinkenKnoten() {
        return linkerKnoten;
    }

    public Knoten<Typ> gibRechtenKnoten() {
        return rechterKnoten;
    }

    public void setzeLinkenKnoten(Knoten<Typ> pLinks) {
        linkerKnoten = pLinks;
    }

    public void setzeRechtenKnoten(Knoten<Typ> pRechts) {
        rechterKnoten = pRechts;
    }

    public boolean istBlatt() {
        return linkerKnoten == null && rechterKnoten == null;
    }

    public void ausgebenDatenInorder() {
        if (linkerKnoten != null) {
            linkerKnoten.ausgebenDatenInorder();
        }

        System.out.println(inhalt);

        if (rechterKnoten != null) {
            rechterKnoten.ausgebenDatenInorder();
        }
    }

    public void ausgebenDatenPreorder() {
        System.out.println(inhalt);

        if (linkerKnoten != null) {
            linkerKnoten.ausgebenDatenPreorder();
        }

        if (rechterKnoten != null) {
            rechterKnoten.ausgebenDatenPreorder();
        }
    }

    public void ausgebenDatenPostorder() {
        if (linkerKnoten != null) {
            linkerKnoten.ausgebenDatenPostorder();
        }

        if (rechterKnoten != null) {
            rechterKnoten.ausgebenDatenPostorder();
        }

        System.out.println(inhalt);
    }

    /*
     * Ab hier steht nichts mehr in der Formelsammlung ???
     * Im Unterricht aber alles so mit Rekression programmiert
     */

    public int anzahlKnoten() {
        int sum = 1; // Der Knoten selbst

        if (linkerKnoten != null) {
            sum += linkerKnoten.anzahlKnoten();
        }

        if (rechterKnoten != null) {
            sum += rechterKnoten.anzahlKnoten();
        }

        return sum;
    }

    public int anzahlBlaetter() {
        if (istBlatt()) {
            return 1;
        }

        int sum = 0;

        if (linkerKnoten != null) {
            sum += linkerKnoten.anzahlBlaetter();
        }

        if (rechterKnoten != null) {
            sum += rechterKnoten.anzahlBlaetter();
        }

        return sum;
    }

    public int tiefe() {
        // Initial Wert ist 1, da man immer eins "tiefer" geht
        int depthLeft = 1;
        int depthRight = 1;

        if (linkerKnoten != null) {
            depthLeft += linkerKnoten.tiefe();
        }

        if (rechterKnoten != null) {
            depthRight += rechterKnoten.tiefe();
        }

        if (depthLeft > depthRight) {
            return depthLeft;
        } else {
            return depthRight;
        }
    }

}
