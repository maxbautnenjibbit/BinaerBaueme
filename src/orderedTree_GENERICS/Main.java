package orderedTree_GENERICS;

import orderedTree_GENERICS.integerTree.IntBinaerbaum;

public class Main {

    public static void main(String[] args) {
        IntBinaerbaum integerBinaerbaum = new IntBinaerbaum();

        integerBinaerbaum.einfuegen_int(11);
        integerBinaerbaum.einfuegen_int(5);
        integerBinaerbaum.einfuegen_int(15);
        integerBinaerbaum.einfuegen_int(2);
        integerBinaerbaum.einfuegen_int(7);
        integerBinaerbaum.einfuegen_int(14);
        integerBinaerbaum.einfuegen_int(20);
        integerBinaerbaum.einfuegen_int(8);
        integerBinaerbaum.einfuegen_int(10);

        integerBinaerbaum.einfuegen_int(9);
        integerBinaerbaum.einfuegen_int(12);

        integerBinaerbaum.ausgebenDatenPreorder();
        System.out.println();
        integerBinaerbaum.ausgebenDatenInorder();
        System.out.println();
        integerBinaerbaum.ausgebenDatenPostorder();
        System.out.println();
        
        integerBinaerbaum.ausgebenBaumStruktur();

        System.out.println(integerBinaerbaum.getMinWert_int());
        System.out.println(integerBinaerbaum.getMaxWert_int());
    }

}
