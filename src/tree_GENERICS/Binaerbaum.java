package tree_GENERICS;

public class Binaerbaum<Typ> {

    private Knoten<Typ> wurzel = null;

    public Binaerbaum() {
        // Formelsammlung sagt, es gibt auch einen leeren Konstruktor
    }

    public Binaerbaum(Knoten<Typ> pWurzel) {
        wurzel = pWurzel;
    }

    public Knoten<Typ> gibWurzel() {
        return wurzel;
    }

    public void setzeWurzel(Knoten<Typ> pWurzel) {
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

    //DAS HIER IST NUR VISUELL
    public void ausgebenBaumStruktur() {
        if (istLeer()) {
            System.out.println("Der Baum ist leer.");
        } else {
            ausgebenBaumStruktur(wurzel, 0);
        }
    }

    //DAS HIER IST NUR VISUELL
    private void ausgebenBaumStruktur(Knoten<Typ> knoten, int ebene) {
        if (knoten == null) {
            return;
        }

        ausgebenBaumStruktur(knoten.gibRechtenKnoten(), ebene + 1);

        for (int i = 0; i < ebene; i++) {
            System.out.print("\t");
        }

        System.out.println(knoten.gibInhalt());

        ausgebenBaumStruktur(knoten.gibLinkenKnoten(), ebene + 1);
    }

}
