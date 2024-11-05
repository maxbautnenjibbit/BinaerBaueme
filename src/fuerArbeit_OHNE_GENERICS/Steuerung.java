package fuerArbeit_OHNE_GENERICS;

public class Steuerung {

    public static void main(String[] args) {
        FBinaerbaum fahrradBaum = new FBinaerbaum();

        System.out.println("IST LEER: " + fahrradBaum.istLeer());

        fahrradBaum.einfuegen(new FKnoten("Ghost", 7375));
        fahrradBaum.einfuegen(new FKnoten("Ghost", 2344));
        fahrradBaum.einfuegen(new FKnoten("Ghost", 6346));
        fahrradBaum.einfuegen(new FKnoten("Ghost", 3754));

        fahrradBaum.ausgebenBaumStruktur();

        fahrradBaum.ausgebenDatenPreorder();
        System.out.println(); // Platzhalter ( Leere Zeile )
        fahrradBaum.ausgebenDatenInorder();
        System.out.println(); // Platzhalter ( Leere Zeile )
        fahrradBaum.ausgebenDatenPostorder();
        System.out.println(); // Platzhalter ( Leere Zeile )

        System.out.println("MIN WERT: " + fahrradBaum.getMinWert());
        System.out.println("MAX WERT: " + fahrradBaum.getMaxWert());
        System.out.println("BLAETTER: " + fahrradBaum.anzahlBlaetter());
        System.out.println("ENTHAELT 7375: "+ fahrradBaum.enthaelt(7375));
        System.out.println("ENTHAELT 7376: "+ fahrradBaum.enthaelt(7376));
        System.out.println("IST LEER: " + fahrradBaum.istLeer());
        System.out.println("TIEFE: " + fahrradBaum.tiefe());

    }

}
