package TP3.Ejercicio7;

import java.util.LinkedList;
import java.util.List;

import TP3.Ejercicio1y2.GeneralTree;

public class Caminos {
  private GeneralTree<Integer> arbol;

  public List<Integer> caminoAHojaMasLejana() {
    if (this.arbol == null || this.arbol.isEmpty())
      return new LinkedList<Integer>();

    List<Integer> resultado = new LinkedList<Integer>();

    if (this.arbol.isLeaf()) {
      resultado.add(this.arbol.getData());
      return resultado;
    }
    return caminoAHojaMasLejanaRec(this.arbol, resultado);
  }

  private List<Integer> caminoAHojaMasLejanaRec(GeneralTree<Integer> nodo, List<Integer> resultado) {
    if (nodo == null || nodo.isEmpty())
      return null;
    return resultado;
  }

}
