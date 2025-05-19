package TP3.Ejercicio11;

import java.util.List;

import TP1.Ejercicio8.Queue;
import TP3.Ejercicio1y2.GeneralTree;

public class PArcialArboles {

  public static boolean resolver(GeneralTree<Integer> arbol) {
    if (arbol == null || arbol.isEmpty())
      return false;
    if (arbol.isLeaf())
      return true;
    Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
    cola.enqueue(arbol);
    cola.enqueue(null);
    int nodosNivelAnterior = 0;
    int nodosNivelActual = 0;
    boolean cumple = true;
    while (!cola.isEmpty() && cumple) {
      GeneralTree<Integer> nodoActual = cola.dequeue();
      if (nodoActual != null) {
        nodosNivelActual++;
        List<GeneralTree<Integer>> children = nodoActual.getChildren();
        children.forEach(child -> cola.enqueue(child));
      } else {
        cumple = nodosNivelActual - nodosNivelAnterior == 1;
        if (cumple) {
          nodosNivelAnterior = nodosNivelActual;
          nodosNivelActual = 0;
          if (!cola.isEmpty()) {
            cola.enqueue(null);
          }
        }
      }
    }
    return cumple;
  }

  public static void main(String[] args) {
    // arbol prueba 1
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

    GeneralTree<Integer> n41 = new GeneralTree<Integer>(83);
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

    n31.addChild(n41);

    n34.addChild(n42);
    n34.addChild(n43);
    n34.addChild(n44);
    n34.addChild(n45);

    System.out.println("El arbol dado es creciente ? " + (resolver(raiz) ? "Sí." : "No."));

    // arbol prueba 2
    GeneralTree<Integer> ab = new GeneralTree<Integer>(2);

    GeneralTree<Integer> nodo11 = new GeneralTree<Integer>(1);
    GeneralTree<Integer> nodo12 = new GeneralTree<Integer>(25);

    GeneralTree<Integer> nodo21 = new GeneralTree<Integer>(5);
    GeneralTree<Integer> nodo22 = new GeneralTree<Integer>(4);
    GeneralTree<Integer> nodo23 = new GeneralTree<Integer>(13);

    GeneralTree<Integer> nodo31 = new GeneralTree<Integer>(18);
    GeneralTree<Integer> nodo32 = new GeneralTree<Integer>(7);
    GeneralTree<Integer> nodo34 = new GeneralTree<Integer>(3);

    GeneralTree<Integer> nodo41 = new GeneralTree<Integer>(83);
    GeneralTree<Integer> nodo42 = new GeneralTree<Integer>(33);
    GeneralTree<Integer> nodo43 = new GeneralTree<Integer>(12);
    GeneralTree<Integer> nodo44 = new GeneralTree<Integer>(17);
    GeneralTree<Integer> nodo45 = new GeneralTree<Integer>(9);

    ab.addChild(nodo11);
    ab.addChild(nodo12);

    nodo11.addChild(nodo21);
    nodo11.addChild(nodo22);

    nodo12.addChild(nodo23);

    nodo21.addChild(nodo31);

    nodo22.addChild(nodo32);
    nodo22.addChild(nodo34);

    nodo31.addChild(nodo41);

    nodo34.addChild(nodo42);
    nodo34.addChild(nodo43);
    nodo34.addChild(nodo44);
    nodo34.addChild(nodo45);

    System.out.println("El arbol dado es creciente ? " + (resolver(ab) ? "Sí." : "No."));

  }

}
