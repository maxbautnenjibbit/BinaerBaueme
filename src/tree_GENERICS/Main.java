package tree_GENERICS;

public class Main {
    public static void main(String[] args) {
        Binaerbaum<Integer> integerBinaerbaum = new Binaerbaum<>();

        Knoten<Integer> wurzel = new Knoten<>(11);
        Knoten<Integer> k5 = new Knoten<>(5);
        Knoten<Integer> k15 = new Knoten<>(15);
        Knoten<Integer> k2 = new Knoten<>(2);
        Knoten<Integer> k7 = new Knoten<>(7);
        Knoten<Integer> k14 = new Knoten<>(14);
        Knoten<Integer> k20 = new Knoten<>(20);
        Knoten<Integer> k8 = new Knoten<>(8);

        wurzel.setzeLinkenKnoten(k5);
        wurzel.setzeRechtenKnoten(k15);

        k5.setzeLinkenKnoten(k2);
        k5.setzeRechtenKnoten(k7);

        k7.setzeRechtenKnoten(k8);

        k15.setzeLinkenKnoten(k14);
        k15.setzeRechtenKnoten(k20);

        integerBinaerbaum.setzeWurzel(wurzel);

        integerBinaerbaum.ausgebenBaumStruktur();
    }
}