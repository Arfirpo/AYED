package Parciales;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import TP3.Ejercicio1y2.GeneralTree;

public class ParcialArbol2 {

  public static List<Integer> contarHojasPares(GeneralTree<Integer> arbol) {
    List<Integer> resultado = new LinkedList<>();

    if (arbol != null && !arbol.isEmpty()) {
      contarHojasRecursivo(arbol, resultado);
    }

    return resultado;
  }

  private static void contarHojasRecursivo(GeneralTree<Integer> nodo, List<Integer> resultado) {
    if (nodo != null && !nodo.isEmpty()) {
      if (nodo.isLeaf()) {
        if (nodo.getData() % 2 == 0) {
          resultado.add(nodo.getData());
        }
      }
      if (nodo.hasChildren()) {
        List<GeneralTree<Integer>> hijos = nodo.getChildren();
        Iterator<GeneralTree<Integer>> Iter = hijos.iterator();
        while (Iter.hasNext()) {
          contarHojasRecursivo(Iter.next(), resultado);
        }
      }
    }
  }

  public static void main(String args[]) {

    GeneralTree<Integer> raiz = new GeneralTree<Integer>(4);
    GeneralTree<Integer> n11 = new GeneralTree<Integer>(2);
    GeneralTree<Integer> n12 = new GeneralTree<Integer>(8);
    GeneralTree<Integer> n13 = new GeneralTree<Integer>(7);
    GeneralTree<Integer> n21 = new GeneralTree<Integer>(6);
    GeneralTree<Integer> n22 = new GeneralTree<Integer>(3);
    GeneralTree<Integer> n23 = new GeneralTree<Integer>(2);
    GeneralTree<Integer> n24 = new GeneralTree<Integer>(4);

    raiz.addChild(n11);
    raiz.addChild(n12);
    raiz.addChild(n13);

    n11.addChild(n21);
    n11.addChild(n22);
    n11.addChild(n23);

    n13.addChild(n24);

    List<Integer> res = contarHojasPares(raiz);

    for (Integer Int : res) {
      System.out.print(Int);
    }

  }

}
