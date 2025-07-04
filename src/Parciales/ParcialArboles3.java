package Parciales;

import java.util.Iterator;

import TP3.Ejercicio1y2.GeneralTree;

public class ParcialArboles3 {

  public static boolean esDeSeleccion(GeneralTree<Integer> arbol) {
    boolean cumple = false;
    if (arbol != null && !arbol.isEmpty()) {
      cumple = esDeSeleccionRec(arbol);
    }
    return cumple;
  }

  private static boolean esDeSeleccionRec(GeneralTree<Integer> nodo) {
    boolean cumple = true;

    if (nodo.isLeaf()) {
      return true;
    }

    else {
      int hijoMenor = obtenerHijoMenor(nodo);
      if (hijoMenor == nodo.getData()) {
        Iterator<GeneralTree<Integer>> it = nodo.getChildren().iterator();
        while (cumple && it.hasNext()) {
          cumple = esDeSeleccionRec(it.next());
        }
      } else {
        cumple = false;
      }
    }

    return cumple;
  }

  private static int obtenerHijoMenor(GeneralTree<Integer> nodo) {
    int menor = Integer.MAX_VALUE;
    for (GeneralTree<Integer> child : nodo.getChildren()) {
      if (child.getData() < menor) {
        menor = child.getData();
      }
    }
    return menor;
  }

  public static void main(String args[]) {

    GeneralTree<Integer> raiz = new GeneralTree<Integer>(12);

    GeneralTree<Integer> n11 = new GeneralTree<Integer>(12);
    GeneralTree<Integer> n12 = new GeneralTree<Integer>(25);

    GeneralTree<Integer> n21 = new GeneralTree<Integer>(35);
    GeneralTree<Integer> n22 = new GeneralTree<Integer>(18);
    GeneralTree<Integer> n23 = new GeneralTree<Integer>(25);

    GeneralTree<Integer> n31 = new GeneralTree<Integer>(35);
    GeneralTree<Integer> n32 = new GeneralTree<Integer>(14);
    GeneralTree<Integer> n33 = new GeneralTree<Integer>(12);
    GeneralTree<Integer> n34 = new GeneralTree<Integer>(33);

    GeneralTree<Integer> n41 = new GeneralTree<Integer>(35);
    GeneralTree<Integer> n42 = new GeneralTree<Integer>(35);
    GeneralTree<Integer> n43 = new GeneralTree<Integer>(83);
    GeneralTree<Integer> n44 = new GeneralTree<Integer>(90);
    GeneralTree<Integer> n45 = new GeneralTree<Integer>(33);

    raiz.addChild(n11);
    raiz.addChild(n12);

    n11.addChild(n21);
    n11.addChild(n22);

    n12.addChild(n23);

    n21.addChild(n31);

    n22.addChild(n32);
    n22.addChild(n33);
    n22.addChild(n34);

    n31.addChild(n41);

    n34.addChild(n42);
    n34.addChild(n43);
    n34.addChild(n44);
    n34.addChild(n45);

    System.out.println((esDeSeleccion(raiz) ? "El arbol es de selección." : "El arbol no es de selección."));

  }

}
