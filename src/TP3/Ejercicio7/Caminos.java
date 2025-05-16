package TP3.Ejercicio7;

import java.util.LinkedList;
import java.util.List;

import TP3.Ejercicio1y2.GeneralTree;

public class Caminos {
  private GeneralTree<Integer> arbol;

  public List<Integer> caminoAHojaMasLejana() {
    if (this.arbol == null || this.arbol.isEmpty())
      return new LinkedList<Integer>();
    if (this.arbol.isLeaf()) {
      return new LinkedList<Integer>();
    }
    List<Integer> camino = new LinkedList<Integer>();
    List<Integer> lista = new LinkedList<Integer>();
    lista.add(this.arbol.getData());

  }

  private static void caminoAHojaMasLejanaRec(GeneralTree<Integer> nodo, List<Integer> lista, List<Integer> camino) {

  }

}
