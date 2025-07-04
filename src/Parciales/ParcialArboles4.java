package Parciales;

import java.util.Iterator;

import TP1.Ejercicio8.Queue;
import TP3.Ejercicio1y2.GeneralTree;

public class ParcialArboles4 {

  public static boolean resolver(GeneralTree<Integer> arbol) {
    boolean cumple = true;

    Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
    cola.enqueue(arbol);
    cola.enqueue(null);
    int nodosPorNivel = 1;
    int cantNodosActual = 0;
    while (cumple && !cola.isEmpty()) {
      GeneralTree<Integer> nodoActual = cola.dequeue();
      if (nodoActual != null) {
        Iterator<GeneralTree<Integer>> it = nodoActual.getChildren().iterator();
        while (it.hasNext()) {
          cola.enqueue(it.next());
          cantNodosActual++;
        }
      } else if (!cola.isEmpty()) {
        cola.enqueue(null);
        cumple = (nodosPorNivel + 1 == cantNodosActual);
        nodosPorNivel++;
        cantNodosActual = 0;
      }
    }
    return cumple;
  }

  public static void main(String args[]) {

    GeneralTree<Integer> raiz = new GeneralTree<Integer>(2);

    GeneralTree<Integer> n11 = new GeneralTree<Integer>(1);
    GeneralTree<Integer> n12 = new GeneralTree<Integer>(25);

    GeneralTree<Integer> n21 = new GeneralTree<Integer>(5);
    GeneralTree<Integer> n22 = new GeneralTree<Integer>(4);
    GeneralTree<Integer> n23 = new GeneralTree<Integer>(13);

    GeneralTree<Integer> n31 = new GeneralTree<Integer>(18);
    GeneralTree<Integer> n32 = new GeneralTree<Integer>(7);
    GeneralTree<Integer> n33 = new GeneralTree<Integer>(11);
    GeneralTree<Integer> n34 = new GeneralTree<Integer>(3);

    //GeneralTree<Integer> n41 = new GeneralTree<Integer>(83);
    GeneralTree<Integer> n42 = new GeneralTree<Integer>(33);
    GeneralTree<Integer> n43 = new GeneralTree<Integer>(12);
    GeneralTree<Integer> n44 = new GeneralTree<Integer>(17);
    GeneralTree<Integer> n45 = new GeneralTree<Integer>(9);

    raiz.addChild(n11);
    raiz.addChild(n12);

    n11.addChild(n21);
    n11.addChild(n22);

    n12.addChild(n23);

    n21.addChild(n31);

    n22.addChild(n32);
    n22.addChild(n33);
    n22.addChild(n34);

    //n31.addChild(n41);

    n34.addChild(n42);
    n34.addChild(n43);
    n34.addChild(n44);
    n34.addChild(n45);

    System.out.println("El arbol analizado " + (resolver(raiz) ? "" : "no ") + "es creciente");
  }

}
