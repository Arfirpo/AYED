package TP3.Ejercicio7;

import java.util.LinkedList;
import java.util.List;

import TP3.Ejercicio1y2.GeneralTree;

public class Caminos {
  private GeneralTree<Integer> arbol;

  public Caminos() {
    this.arbol = new GeneralTree<Integer>();
  }

  public Caminos(GeneralTree<Integer> ab) {
    this.arbol = ab;
  }

  public void setArbol(GeneralTree<Integer> arbol) {
    this.arbol = arbol;
  }

  public GeneralTree<Integer> getArbol() {
    return arbol;
  }

  public List<Integer> caminoAHojaMasLejana() {
    List<Integer> camino = new LinkedList<Integer>();
    if (this.arbol == null || this.arbol.isEmpty())
      return camino;

    if (this.arbol.isLeaf()) {
      camino.add(this.arbol.getData());
      return camino;
    }
    List<Integer> lista = new LinkedList<Integer>();
    caminoAHojaMasLejanaRec(arbol, lista, camino);
    return camino;
  }

  private static void caminoAHojaMasLejanaRec(GeneralTree<Integer> nodo, List<Integer> camAct,
      List<Integer> maxCamino) {

    camAct.addLast(nodo.getData());

    if (nodo.isLeaf()) {
      if (camAct.size() > maxCamino.size()) {
        maxCamino.clear();
        maxCamino.addAll(camAct);
      }
    }

    List<GeneralTree<Integer>> children = nodo.getChildren();
    for (GeneralTree<Integer> child : children) {
      caminoAHojaMasLejanaRec(child, camAct, maxCamino);
      camAct.remove(camAct.size() - 1);
    }
  }

}
